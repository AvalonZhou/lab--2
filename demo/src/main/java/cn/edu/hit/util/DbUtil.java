package cn.edu.hit.util;

import java.sql.*;

public class DbUtil {
    private static Connection con;
    private static final String URL = "jdbc:postgresql://localhost:5432/hgd";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";

    private static Connection createConnection()
    {
        // 使用反射将数据库驱动类加载到JVM
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    public static  Connection getConnection()
    {
        try
        {
            if(con == null || con.isClosed())
            {
                con = createConnection();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();

        }
        return con;
    }
    public static void close(ResultSet rs, PreparedStatement ps, Connection con)
    {
        try
        {
            if(!rs.isClosed())
            {
                rs.close();
            }

            if(!ps.isClosed())
            {
                ps.close();
            }
            if(!con.isClosed())
            {
                con.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static void close(PreparedStatement ps, Connection con) {
        try
        {
            if(!ps.isClosed())
            {
                ps.close();
            }
            if(!con.isClosed())
            {
                con.close();
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
}
