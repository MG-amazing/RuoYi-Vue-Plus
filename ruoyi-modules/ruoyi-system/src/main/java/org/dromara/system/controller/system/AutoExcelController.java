package org.dromara.system.controller.system;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dromara.common.excel.utils.GetBeanByNameUtil;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.system.domain.ELTableProp;
import org.dromara.system.domain.bo.CommonExportBo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/excel")
public class AutoExcelController {

    private final GetBeanByNameUtil getBeanByNameUtil;
    private final ObjectMapper objectMapper;

    public AutoExcelController(GetBeanByNameUtil getBeanByNameUtil, ObjectMapper objectMapper) {
        this.getBeanByNameUtil = getBeanByNameUtil;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/export")
    public ResponseEntity<?> AutoExportExcelController(@RequestBody CommonExportBo boForm) {
        try {

            Object controllerBean = getBeanByNameUtil.getControllerBean(boForm.getEntityName());
            Class<?> controllerClass = controllerBean.getClass();
            Class<?> boClass = Class.forName(boForm.getSearchBo());

            Method method = null;
            try {
                method = controllerClass.getDeclaredMethod(boForm.getFunctionName(), boClass, PageQuery.class);
                System.out.println(method);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Object form = boForm.getForm();
            Object formData = objectMapper.convertValue(form, boClass);
            Map<String, Object> map = (Map<String, Object>) form;
            PageQuery pageQuery = new PageQuery(Integer.valueOf((String) map.get("pageSize")) ,
                Integer .valueOf((String) map.get("pageNum")));
            Object result = method.invoke(controllerBean, formData, pageQuery);
            String resultStr = objectMapper.writeValueAsString(result);
            JsonNode rootNode = objectMapper.readTree(resultStr);
            JsonNode total = rootNode.path("total");
            JsonNode recordsArray = rootNode.path("rows");
            List<Map<String, Object>> resultList = objectMapper.convertValue(recordsArray, new TypeReference<>() {
            });
            byte[] excelData = exportToExcelByJson(resultList, boForm.getColumns(), boForm.getFileName());


            return ResponseEntity.ok(excelData);


        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("调用失败");
            throw new RuntimeException(e);
        }


    }

    public static byte[] exportToExcelByJson(List<Map<String, Object>> resultList, List<ELTableProp> headerList, String sheetName) throws Exception {
        // 创建新的工作簿
        try (Workbook workbook = new XSSFWorkbook()) {
            // 创建工作表
            Sheet sheet = workbook.createSheet(sheetName == null ? "Sheet1" : sheetName);

            // 创建表头行
            Row headerRow = sheet.createRow(0);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // 填充表头
            List<String> propNames = new ArrayList<>();
            int colIndex = 0;
            for (ELTableProp header : headerList) {
                if ("true".equals(header.getShow())) {
                    Cell cell = headerRow.createCell(colIndex);
                    cell.setCellValue(header.getLabel());
                    cell.setCellStyle(headerStyle);
                    propNames.add(header.getProp());
                    colIndex++;
                }
            }

            // 填充数据行
            if (resultList != null && !resultList.isEmpty()) {
                for (int i = 0; i < resultList.size(); i++) {
                    Row row = sheet.createRow(i + 1);
                    Map<String, Object> data = resultList.get(i);

                    for (int j = 0; j < propNames.size(); j++) {
                        Cell cell = row.createCell(j);
                        Object value = data.get(propNames.get(j));

                        if (value != null) {
                            if (value instanceof String) {
                                cell.setCellValue((String) value);
                            } else if (value instanceof Number) {
                                cell.setCellValue(((Number) value).doubleValue());
                            } else {
                                cell.setCellValue(value.toString());
                            }
                        } else {
                            cell.setCellValue("");
                        }
                    }
                }
            }

            // 自动调整列宽
            for (int i = 0; i < propNames.size(); i++) {
                sheet.autoSizeColumn(i);
            }

            // 将工作簿写入字节流
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                workbook.write(outputStream);
                return outputStream.toByteArray();
            }
        }
    }

}
