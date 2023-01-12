package li.西二task3;//这个代码就是用来创建一mysql,用于基础题和提升题
import li.lesson2.util.util.jbdcutils;
import sun.net.ConnectionResetException;
import java.sql.*;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class sqltask1 {//用于驱动的方法体
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    static {
        try {
            InputStream in =sqltask1.class.getClassLoader().getResourceAsStream("dp2.properties.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            //1.驱动只有加载一次
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    //释放连接资源
    public static void release(Connection coon,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(st!=null){
            try{
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(coon!=null){
            try{
                coon.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
