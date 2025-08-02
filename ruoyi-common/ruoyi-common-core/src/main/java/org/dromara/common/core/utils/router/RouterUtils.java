package org.dromara.common.core.utils.router;

import org.dromara.common.core.utils.StringUtils;

public class RouterUtils {
    /**
     * vue路由转换器
     * @param path
     * @return
     */
    public static String fixRouterPath(String path) {
        String s = StringUtils.removeStart(path, "/");
        return s.replace("/", ":")+":";
    }
}
