package com.czh.DIYMyBatis.resource;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件
 * @author zhCoding
 * @Description:
 * @create 13:51
 */
public class Resources {

    /**
     * 根据传入的路径获取字节流
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }

}
