package org.dromara.common.excel.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GetBeanByNameUtil {
    private final ApplicationContext context;

    public GetBeanByNameUtil(ApplicationContext context) {
        this.context = context;
    }

    /**
     * 根据 domain 类名字符串获取对应的 Controller Bean
     */
    public Object getControllerBean(String domainClassName) {
        try {
            // 取最后的类名，例如 TestDemo
            String simpleName = Class.forName(domainClassName).getSimpleName();

            // 拼接 Controller 名称，例如 testDemoController
            // 默认 bean 名为首字母小写的类名
            String serviceControllerBeanName = toLowerFirst(simpleName) + "Controller";

            // 获取 Bean
            return context.getBean(serviceControllerBeanName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 将类名首字母转小写（符合 Spring 默认命名规范）
    private String toLowerFirst(String name) {
        if (name == null || name.isEmpty()) return name;
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }
    public Class<?> getClassByName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}
