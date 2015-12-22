package by.bsuir.sum.controller;

import by.bsuir.sum.dao.DBConnection;
import by.bsuir.sum.util.PrintList;
import by.bsuir.sum.start.Main2;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class BeginController implements Initializable {

    static int ID=0;

    @FXML AnchorPane MyAnchorPane;
    @FXML Pane paneRegistration;
    @FXML Pane paneSingin;
    @FXML Button btnRegister;
    @FXML TextField textfieldName;
    @FXML PasswordField textfieldPassword;
    @FXML TextField textfieldLastName;
    @FXML TextField textfieldEmail;
    @FXML HBox taskbar;
    @FXML Button btnPrintList;
    @FXML Button btnLink;
    @FXML Button btnSingIn;
    @FXML TextArea textareaPrintList;

    @FXML Pane LongPane;
    @FXML Button btnMAINRegistration;
    @FXML Button btnMAINSingIn;
    @FXML GridPane gridpPrintList;
    @FXML TabPane tpUserMenu;

    @FXML TextField textfieldEmailSINGIN;
    @FXML TextField textfieldPasswordSINGIN;

    @FXML Button btnReturn;

//    static String tranzName;
//    static String tranzSurname;
//    static String tranzEmail;
//    static String tranzPassword;

    @FXML
    //URL url, ResourceBundle rb
    public void initialize(URL url, ResourceBundle resourceBundle){
        //powderblue
        //
        //MyAnchorPane.setStyle("-fx-background-color: lightsteelblue;");

        LongPane.setVisible(true);//вход или регистрация
        paneRegistration.setVisible(false);
        gridpPrintList.setVisible(false);
        paneSingin.setVisible(false);
        btnPrintList.setVisible(false);
        btnLink.setVisible(false);


        //две первые кнопки
        btnMAINRegistration.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnMAINRegistration.setVisible(false);
                btnMAINSingIn.setVisible(false);
                paneRegistration.setVisible(true);
                gridpPrintList.setVisible(true);
                btnPrintList.setVisible(true);
                //todo
//                try{
//                    new Main2();
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                //todo
            }
        });
        btnMAINSingIn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnMAINRegistration.setVisible(false);
                btnMAINSingIn.setVisible(false);
                paneSingin.setVisible(true);
                gridpPrintList.setVisible(true);
                btnPrintList.setVisible(true);
            }
        });

        btnReturn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnMAINRegistration.setVisible(true);
                btnMAINSingIn.setVisible(true);
                paneSingin.setVisible(false);
                paneRegistration.setVisible(false);
                gridpPrintList.setVisible(false);
                btnPrintList.setVisible(false);
            }
        });


        //регистрация
        btnRegister.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String nameNow = textfieldName.getText();
                String lastnameNow = textfieldLastName.getText();
                String emailNow = textfieldEmail.getText();
                String passwordNow = textfieldPassword.getText();

                Connection c ;
                Statement stmt = null;
                try{
                    c = DBConnection.connect();
                    stmt = c.createStatement();
                    String sql = "INSERT INTO info(name, lastname, email, password) VALUES ('"+nameNow+"','"+lastnameNow+"','"+emailNow+"','"+passwordNow+"')";
                    stmt.executeUpdate(sql);
                    System.out.println(" SUCCESS!\n");

                    sql = "SELECT id, email, password FROM info";
                    ResultSet rs = stmt.executeQuery(sql);

                    //Extract data from result set
                    while(rs.next()){
                        String email = rs.getString("email");
                        String password =rs.getString("password");
                        int letid = rs.getInt("id");

                        if((email.equals(emailNow)) && (password.equals(passwordNow))){
                            ID=letid;
                        }

                    }

                    paneRegistration.setVisible(false);
                    //Schedule the Visibility for 1000ms
                    Timeline timeline = new Timeline();
                    timeline.getKeyFrames().add(
                            new KeyFrame(Duration.millis(2000000000),//change way!!!
                                    new KeyValue(paneRegistration.visibleProperty(), true)));
                    timeline.play();
                    //show menu
                    LongPane.setVisible(false);
                    try{
                        new Main2();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Error on Building Data");
                }
            }
        });
        //БД ПРОВЕРЕНА
        btnSingIn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String emailNow = textfieldEmailSINGIN.getText();System.out.println(emailNow);
                String passwordNow = textfieldPasswordSINGIN.getText();System.out.println(passwordNow);

                boolean flag=false;
                Connection conn = null;
                Statement stmt = null;
                try{
                    //Register JDBC driver
                    conn = DBConnection.connect();
                    stmt = conn.createStatement();
                    String sql = "SELECT id, name, lastname, email, password FROM info";
                    ResultSet rs = stmt.executeQuery(sql);

                    //Extract data from result set
                    while(rs.next()){
                        String email = rs.getString("email");System.out.println(email);
                        String password =rs.getString("password");System.out.println(password);
                        int letid = rs.getInt("id");System.out.println(letid);

                        if((email.equals(emailNow)) && (password.equals(passwordNow))){
                            flag=true;
                            ID=letid;
                        }
                    }

                    if(flag==true){
                        LongPane.setVisible(false);
                        try{
                            new Main2();

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    else{
                        paneSingin.setVisible(false);
                        paneRegistration.setVisible(true);
                    }

                    //Clean-up environment
                    rs.close();
                    stmt.close();
                    conn.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e){
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }
            }
        });
        btnPrintList.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                PrintList.allPrint(textareaPrintList);
            }
        });
    }
}
