package violet.utils;

import java.sql.*;

/**
 * 连接数据库的工具类。虽然没什么用，我就是要写。
 * 还未控制事务
 * @author Winter Yuan
 * @version 1.0
 * @organization AtoVio
 */
public class JDBCUtil {

    /*
    连接的数据库驱动
     */
    private final String driver;
    /*
    连接的url
     */
    private final String url;
    /*
    登录数据库的用户名
     */
    private final String username;
    /*
    登录密码
     */
    private final String password;

    public JDBCUtil(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * 获取数据库连接对象
     *
     * @return 数据库连接对象
     * @throws ClassNotFoundException 驱动加载失败的异常
     * @throws SQLException           数据库连接失败的异常
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName(driver);
        // 获取连接
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭资源
     *
     * @param rs  结果集对象
     * @param st  数据库操作对象
     * @param con 数据库连接对象
     * @throws SQLException 资源关闭异常
     */
    public static void close(ResultSet rs, Statement st, Connection con) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
