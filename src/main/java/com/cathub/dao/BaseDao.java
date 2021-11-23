package com.cathub.dao;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//基础的Dao，负责抽象通用的数据库操作
public class BaseDao {


    //数据库连接时必定需要的一些组件，不固定类型，仅仅作为字符串提示使用
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //1.编译时分析配置文件
    static {
        //使用反射获取解析类的解析器，获取解析类所在的地址，取得地址之后开始加载配置文件
        String PropertiesName= "db.properties";
        Properties properties=new Properties();
        InputStream is =BaseDao.class.getClassLoader().getResourceAsStream(PropertiesName);
        try {
            //加载配置文件，使用流方式
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //从配置文件中获取已经配置好的相关配置
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }


    //

}
