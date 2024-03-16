package leetcode;

import java.sql.*;

public class test2 {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.创建连接
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/wzsxy","root","123456");
        return connection;
    }

    public static void closeAll(ResultSet resultSet,Statement statement,Connection connection) throws SQLException {
        if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }
    }

}

