# RuoYi-Vue-Plus-Excel
> 🌐 **Multilingual Versions**  
> 🇯🇵 [中文](../README.md)  
> 🇺🇸 [日本語](RuoYi-Vue-Plus-Excel-ja.md)

Based on [RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus), this project is upgraded to enable **zero-code Excel export**, focusing on improving data export efficiency in real business scenarios. It supports dynamic headers, export with query conditions, pagination export, and custom data processing.

## 🌟 Highlights

- ✅ No coding required, export with configuration only  
- ✅ Dynamic header export (export fields based on selected columns)  
- ✅ Export with query conditions (export what you query)  
- ✅ Support for current page / all pages / specified page export  
- ✅ Support custom data processing (dictionary translation, field formatting, etc.)  
- ✅ Prebuilt frontend components for quick integration  

## 📦 Usage

### 1. Configure Export Button in Menu

On the `Menu Configuration` page, add an export button:

- **Export Method**: `list` (the corresponding backend method)  
- **Full Entity Class Name**: e.g., `org.dromara.demo.domain.TestDemo`

### 2. Frontend Usage

Simply import the prebuilt export component and pass the export parameters ([link](https://github.com/MG-amazing/plus-ui-excel)).

### 3. One-Click Export

Click the configured button to export the Excel file instantly.

## 🧩 Advanced Features

| Feature                     | Description |
|----------------------------|-------------|
| Dynamic Header Export      | Control export fields via `columns` |
| Query-Based Export         | Syncs with query conditions on the page |
| Pagination Export          | Export current page or all data |
| Dictionary Customization   | Format data via a `customize` method |
| Custom File Name           | Set exported filename and sheet name |

## 📚 Background

This project is based on [RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus):

> Dromara RuoYi-Vue-Plus is an upgraded and fully restructured version of RuoYi-Vue, designed for distributed and multi-tenant scenarios. It is more powerful and extensible, open-source, free, and suitable for commercial use.

Recommended to use with the official frontend project:

- 🌐 Frontend Project: [plus-ui](https://gitee.com/JavaLionLi/plus-ui)  
- 🌐 Documentation: [plus-doc](https://plus-doc.dromara.org)

## 🔗 Project Links

- GitHub Backend: [MG-amazing/RuoYi-Vue-Plus-Excel](https://github.com/MG-amazing/RuoYi-Vue-Plus-Excel)  
- GitHub Frontend: [MG-amazing/plus-ui-excel](https://github.com/MG-amazing/plus-ui-excel)

## 📝 License

This project is open-sourced under the MIT license. It is free for commercial use as long as the license file is retained.