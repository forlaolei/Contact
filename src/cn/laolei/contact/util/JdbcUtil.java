package cn.laolei.contact.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lailei
 * @date 2020/2/27 13:47
 *
 * 数据库配置
 */
public class JdbcUtil {
    static String url = null;
    static String userName = null;
    static String password = null;
    static String driverClass = null;

    static {
        Properties properties = new Properties();
        // 类路径读取文件
        InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");
        try {
            // 导入文件
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        userName = properties.getProperty("userName");
        password = properties.getProperty("password");
        driverClass = properties.getProperty("driverClass");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动程序出错！！！");
        }
    }

    public static Connection getConnect() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}