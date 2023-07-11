package com.neu.edu.datasource;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 通过代码的方式使用连接池
 *      1.创建连接池
 *      2.配置连接池
 *      3.获取连接对象
 */
public class DataSource {
    public static void main(String[] args) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // 配置驱动
        druidDataSource.setUsername("root"); // 配置用户名
        druidDataSource.setPassword("!@#mysql"); // 配置密码
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/dbexp"); // 配置连接字符串

        // 配置连接池的参数
        druidDataSource.setMaxActive(10); // 最大连接数
        druidDataSource.setInitialSize(3); // 初始化连接数
        druidDataSource.setMaxWait(2000); // 最大等待时间
        druidDataSource.setMinIdle(3); // 最小空闲连接数

        for(int i = 0; i<11; i++){
            Connection conn = druidDataSource.getConnection();
            System.out.println(conn);
            // 直接运行会报错，因为连接池中只有10个连接，但是我们获取了11个连接。
            // 解决办法：将连接对象还回连接池。
            if(i == 5){
                conn.close();
            }
        }

    }
}
