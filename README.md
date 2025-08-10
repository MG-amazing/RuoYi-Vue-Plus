# RuoYi-Vue-Plus-Excel
> 🌐 **Multilingual Versions**  
> 🇯🇵 [日本語](./md/RuoYi-Vue-Plus-Excel-ja.md)  
> 🇺🇸 [English Version](./md/RuoYi-Vue-Plus-Excel-en.md)

基于 [RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus) 改造升级，实现 **零代码配置导出 Excel** 的能力，专注于提升实际业务中的数据导出效率，支持动态表头、查询条件导出、分页导出、自定义数据处理等功能。

## 📚 演示地址
演示地址 [https://mgamazing.asia/](https://mgamazing.asia/)

## 🌟 项目亮点

- ✅ 无需编码，仅通过配置即可导出
- ✅ 动态表头导出（根据勾选字段导出）
- ✅ 查询条件导出（查什么导出什么）
- ✅ 支持当前页导出 / 全部导出 / 指定页码导出
- ✅ 支持自定义数据处理（字典项翻译、字段格式转换等）
- ✅ 已封装前端组件，快速集成

## 📦 使用方式

### 1. 菜单配置按钮

在 `菜单配置` 页面添加一个导出按钮：

- **导出方法**填写：`list`（即对应的接口方法）
- **实体类全路径名称**填写：如 `org.dromara.demo.domain.TestDemo`

### 2. 前端使用方式

直接引入已封装好的导出组件，传入导出参数即可（[点击跳转](https://github.com/MG-amazing/plus-ui-excel)） 。

### 3. 一键导出

点击配置好的按钮，即可完成 Excel 文件导出。

## 🧩 高级功能说明

| 功能                     | 说明 |
|--------------------------|------|
| 动态表头导出             | 根据传入的 `columns` 控制导出字段 |
| 查询条件导出             | 与页面查询同步，导出当前所查数据 |
| 分页导出                 | 支持导出当前页或全量数据 |
| 字典项自定义转换         | 支持传入 `customize` 方法做格式处理 |
| 自定义文件名             | 设置导出文件名称、sheet 名称 |

## 📚 项目背景

本项目基于 [RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus)：

> Dromara RuoYi-Vue-Plus 是 RuoYi-Vue 的重写升级版本，面向分布式与多租户场景，完全重构，功能更强大、扩展性更强。开源、免费、可商用。

推荐配合官方前端项目使用：

- 🌐 前端项目：[plus-ui](https://gitee.com/JavaLionLi/plus-ui)
- 🌐 文档地址：[plus-doc](https://plus-doc.dromara.org)

## 🔗 项目地址

- GitHub后端：[MG-amazing/RuoYi-Vue-Plus-Excel](https://github.com/MG-amazing/RuoYi-Vue-Plus-Excel)
- GitHub前端：[MG-amazing/plus-ui-excel](https://github.com/MG-amazing/plus-ui-excel)

## 📝 License

本项目基于 MIT 协议开源，免费商用，保留协议文件即可。
