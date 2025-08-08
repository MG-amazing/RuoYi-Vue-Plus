
# RuoYi-Vue-Plus-Excel
> 🌐 **Multilingual Versions**  
>  [中文](../README.md)  
>  [English Version](RuoYi-Vue-Plus-Excel-en.md)

[RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus) をベースに改良・アップグレードされ、**コード不要でExcelをエクスポート**できる機能を実現しました。実際の業務におけるデータ出力効率の向上に特化しており、動的ヘッダー、検索条件の出力、ページごとの出力、カスタムデータ処理などをサポートしています。

## 🌟 プロジェクトの特長

- ✅ コーディング不要、設定のみでエクスポート可能  
- ✅ 動的ヘッダー出力（選択されたフィールドに基づいて出力）  
- ✅ 検索条件エクスポート（検索したデータをそのまま出力）  
- ✅ 現在のページ / 全体 / 指定ページの出力に対応  
- ✅ カスタムデータ処理対応（辞書変換、フォーマット変換など）  
- ✅ フロントエンドコンポーネントが用意されており、素早く統合可能  

## 📦 使用方法

### 1. メニューにエクスポートボタンを追加

「メニュー設定」ページでエクスポートボタンを追加：

- **エクスポートメソッド**：`list`（該当のAPIメソッド）  
- **エンティティのフルクラス名**：例 `org.dromara.demo.domain.TestDemo`

### 2. フロントエンドでの使用方法

あらかじめ用意されたエクスポートコンポーネントを直接導入し、パラメータを渡すだけで使用可能（[リンク](https://github.com/MG-amazing/plus-ui-excel)）。

### 3. ワンクリックエクスポート

設定したボタンをクリックすると、即座にExcelファイルをエクスポートできます。

## 🧩 高度な機能

| 機能                     | 説明 |
|--------------------------|------|
| 動的ヘッダー出力         | 渡された `columns` により出力フィールドを制御 |
| 検索条件エクスポート     | 現在の検索条件と連動してデータを出力 |
| ページごとの出力         | 現在ページまたは全データの出力が可能 |
| 辞書のカスタム変換       | `customize` メソッドを使ってフォーマット処理可能 |
| ファイル名のカスタマイズ | エクスポートファイル名やシート名を設定可能 |

## 📚 プロジェクト背景

本プロジェクトは [RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus) を基にしています：

> Dromara RuoYi-Vue-Plus は RuoYi-Vue を全面的に再構築したアップグレード版で、分散システムやマルチテナントシナリオに対応しています。より強力で拡張性が高く、オープンソース・無料・商用利用可能です。

公式フロントエンドと組み合わせての使用を推奨：

- 🌐 フロントエンドプロジェクト：[plus-ui](https://gitee.com/JavaLionLi/plus-ui)  
- 🌐 ドキュメント：[plus-doc](https://plus-doc.dromara.org)

## 🔗 プロジェクトリンク

- GitHub バックエンド：[MG-amazing/RuoYi-Vue-Plus-Excel](https://github.com/MG-amazing/RuoYi-Vue-Plus-Excel)  
- GitHub フロントエンド：[MG-amazing/plus-ui-excel](https://github.com/MG-amazing/plus-ui-excel)

## 📝 ライセンス

本プロジェクトは MIT ライセンスに基づいてオープンソース化されています。無料で商用利用が可能で、ライセンスファイルの保持のみ必要です。
