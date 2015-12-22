package by.bsuir.sum.util;

import by.bsuir.sum.dao.DBConnection;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Вероника on 10.05.2015.
 */
public class PrintList {

    public static void onePrint(int oneID, TextArea myta){
        myta.clear();
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            String sql = "SELECT id, name, lastname, email FROM info";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String first = rs.getString("name");
                String last = rs.getString("lastname");
                String email = rs.getString("email");
                if(id==oneID){
                    myta.appendText("ID: " + id+"\n\n");
                    myta.appendText("FirstName: " + first+"\n\n");
                    myta.appendText("LastName: " + last+"\n\n");
                    myta.appendText("E-mail: " + email + "\n\n");
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public static void allPrint(TextArea myta){
        myta.clear();
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            conn = DBConnection.connect();
            stmt = conn.createStatement();
            String sql = "SELECT id, name, lastname, email FROM info";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String first = rs.getString("name");
                String last = rs.getString("lastname");
                String email = rs.getString("email");
                myta.appendText("ID: " + id);
                myta.appendText(", FirstName: " + first);
                myta.appendText(", LastName: " + last);
                myta.appendText(", E-mail: " + email + "\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public static void allPrintInTable(TextArea myta){

    }
}
