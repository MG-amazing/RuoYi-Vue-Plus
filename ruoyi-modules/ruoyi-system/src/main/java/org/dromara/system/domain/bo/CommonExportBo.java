package org.dromara.system.domain.bo;

import lombok.Data;
import org.dromara.system.domain.ELTableProp;

import java.util.List;

@Data
public class CommonExportBo {
    /**
     * 实体类地址全路径
     */
    private String entityName;
    /**
     * 分页方法名称
     */
    private String functionName;
    /**
     * 分页方法参数
     */
    private String searchBo;
    /**
     * 是否是动态表头
     */
    private String isDynamic;
    /**
     * 原始param
     */
    private Object form;
    /**
     * 文件名字
     */
    private String fileName;
    /**
     * 导出状态 true 为本页 false 为所有
     */
    private boolean type =true;
    /**
     * 自定义方法
     */
    private String customize;
    /**
     * el参数
     */
    private List<ELTableProp> columns;



}
