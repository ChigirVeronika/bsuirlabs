package by.bsuir.sum.dao;
import java.sql.*;

/**
 * Created by Вероника on 12.04.2015.
 */
public class DBConnection {
    private static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/students";
    private static String user = "root";//Username of database
    private static String pass = "7804";//Password of database

    public static Connection connect() throws  SQLException {

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error: "+cnfe.getMessage());
        }catch(InstantiationException ie){
            System.err.println("Error: "+ie.getMessage());
        }catch(IllegalAccessException iae){
            System.err.println("Error: "+iae.getMessage());
        }
        conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn !=null && !conn.isClosed())
            return conn;
        connect();
        return conn;

    }
}
