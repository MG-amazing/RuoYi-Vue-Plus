package org.dromara.demo.util;

public class ClassSourceChecker {

    /**
     * 判断一个类名是否来自项目代码（非依赖包）
     *
     * @param className 类的全限定名
     * @return true = 是项目代码，false = 第三方依赖 or 无法加载
     */
    public static String isProjectClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            String path = clazz.getProtectionDomain().getCodeSource().getLocation().getPath();

            // 判断是否来自 target/classes 或 build/classes
            return String.valueOf(path.contains("/target/classes") || path.contains("/build/classes"));
        } catch (ClassNotFoundException e) {
            // 类不存在，视为非项目类
            return "ClassNotFound,类不存在";

        } catch (NullPointerException e) {
            // 可能是内置类
            return "Null,可能为内置类";
        }
    }

    public static void main(String[] args) {
        System.out.println(isProjectClass("org.dromara.demo.domain.TestDemo")); // true
        System.out.println(isProjectClass("java.lang.String")); // false
        System.out.println(isProjectClass("org.apache.commons.lang3.StringUtils")); // false
    }
}
