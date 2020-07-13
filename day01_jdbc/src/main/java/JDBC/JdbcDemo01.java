package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.获取驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

//        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection coo=DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","123");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm=coo.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet rs=pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        coo.close();
    }
}
