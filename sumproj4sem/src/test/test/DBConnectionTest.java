package test;

import by.bsuir.sum.dao.DBConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Вероника on 14.05.2015.
 */
public class DBConnectionTest {
    @Test
    public void testConnect() throws SQLException {
        Connection c;
        String url = "jdbc:mysql://localhost:3306/students";
        String user = "root";//Username of database
        String pass = "7804";//Password of database

        DBConnection dbc = new DBConnection();

        //assertTrue(dbc.getConnection()==c);



    }
}
