package by.bsuir.sum.controller;

import by.bsuir.sum.dao.DBConnection;
import by.bsuir.sum.util.PrintList;
import by.bsuir.sum.entity.Friend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import jfx.messagebox.MessageBox;


/**
 * Created by Вероника on 10.05.2015.
 */

public class MainLogicController implements Initializable {

    @FXML private TableView<Friend> tableFriends;
    private ObservableList<Friend> usersData = FXCollections.observableArrayList();

    @FXML private TableColumn<Friend, String> columnId;
    @FXML private TableColumn<Friend, String> columnName;
    @FXML private TableColumn<Friend, String> columnSurname;
    @FXML private TableColumn<Friend, String> columnFriend;

    @FXML AnchorPane MyAnchorPane;
    @FXML StackPane stackpContent;
    @FXML Button btnLoadPhoto;
    @FXML TextArea taGeneralInfomation;
    @FXML ImageView ivAvatar;
    @FXML TabPane tpUserMenu;

    @FXML TextField tfNumberOfFriendNow;
    @FXML Button btnAddToFriends;
    @FXML Button btnLoadUserPhotos;
    @FXML AnchorPane apForUserPhotos;
    @FXML ScrollPane spForUserPhotos;
    @FXML GridPane gpForUserPhotos;

    @FXML ScrollPane spContent;

    @FXML Tab tabTopics;

    @FXML SplitMenuButton smbMenu;
    @FXML MenuItem smbArt;
    @FXML MenuItem smbPoetry;
    @FXML MenuItem smbMusic;
    @FXML MenuItem smbNature;
    @FXML MenuItem smbScience;

    @FXML Button btnAddProfileInfo;

    @FXML Tab tabHelp;

    @FXML SplitMenuButton smbHelpMenu;
    @FXML MenuItem smbAddInfoToProfile;
    @FXML MenuItem smbLoadAvatar;
    @FXML MenuItem smbFriendList;
    @FXML MenuItem smbAddToFriend;
    @FXML MenuItem smbLoadPhotos;
    @FXML MenuItem smbChooseTopic;

    final int s=BeginController.ID;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        //stackpContent.getChildren().addAll(new Rectangle(100,100, Color.BLUE),new Rectangle(40,40, Color.RED),new Label("Go!"));

        //todo PROFILE
        PrintList.onePrint(s, taGeneralInfomation);

        btnLoadPhoto.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Image Filter","*.png","*.jpg","*.gif"));

                File selectedFile=fileChooser.showOpenDialog(null);
                if (selectedFile!=null){
                    Image tecUserImage = new Image("file:"+selectedFile.getPath());
                    ImageView tecUserIV = new ImageView(tecUserImage);
                    stackpContent.getChildren().add(tecUserIV);
                }
            }
        });

        btnAddProfileInfo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                MessageBox.show(new Stage(),
                        "Add information about your favorites\n\nMusic\nFilms\nBooks",
                        "Information dialog",
                        MessageBox.ICON_INFORMATION | MessageBox.OK | MessageBox.CANCEL);
            }
        });


        //todo FRIENDS
        initData();

        tableFriends.setEditable(true);
//        TableColumn emailCol = new TableColumn("friend");
//        emailCol.setCellValueFactory(new PropertyValueFactory<>("friends"));
//
//        emailCol.setCellFactory(TextFieldTableCell.<Friend>forTableColumn());
//        emailCol.setOnEditCommit(
//                (TableColumn.CellEditEvent<Friend, String> t) -> {
//                    ((Friend) t.getTableView().getItems().get(
//                            t.getTablePosition().getRow())
//                    ).setEmail(t.getNewValue());
//                });

        // устанавливаем тип и значение которое должно хранится в колонке
        columnId.setCellValueFactory(new PropertyValueFactory<Friend, String>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Friend, String>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<Friend, String>("surname"));
        columnFriend.setCellValueFactory(new PropertyValueFactory<Friend, String>("friend"));
        columnFriend.setVisible(false);


        tableFriends.setItems(usersData);
//        tableFriends.getColumns().addAll(emailCol);
        btnAddToFriends.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //todo
                try {
                    int numberOfFriendsNow = Integer.parseInt(tfNumberOfFriendNow.getText());
                }catch (NumberFormatException nfe) {}
                //todo
                tableFriends.getItems();
            }
        });
        btnAddToFriends.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                usersData.add(new Friend(tfNumberOfFriendNow.getText()));
                tfNumberOfFriendNow.clear();
            }
        });


        //todo PHOTOS
        btnLoadUserPhotos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Image Filter","*.png","*.jpg","*.gif"));

                File selectedFile=fileChooser.showOpenDialog(null);

                if (selectedFile!=null){
                    Image tecUserImage = new Image("file:"+selectedFile.getPath());
                    ImageView tecUserIV = new ImageView(tecUserImage);
                    spForUserPhotos.setContent(tecUserIV);
                }
            }
        });
        //todo TOPICS
       /* String ss="";
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("text.txt"));
            ss = (String) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Label l = new Label(ss);
        spContent.setContent(l);
         */
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        smbArt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //https://www.google.by/search?q=modern+art&client=opera&hs=t4V&tbm=isch&tbo=u&source=univ&sa=X&ei=_ylTVabHHcX5ywP-9oBI&ved=0CBsQsAQ&biw=1366&bih=669
                webEngine.load("file:///C:/Users/Вероника/Desktop/для%20курсача/art%20modern%20-%20Поиск%20в%20Google.html");
                spContent.setContent(browser);
            }
        });
        smbPoetry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //http://rupoem.ru/fet/all.aspx
                webEngine.load("file:///C:/Users/Вероника/Desktop/для%20курсача/Все%20стихи.%20Афанасий%20Фет.html");
                spContent.setContent(browser);
            }
        });
        smbMusic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                webEngine.load("http://tunein.com/radio/Music-g1/");
                spContent.setContent(browser);
            }
        });
        smbNature.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //http://www.nature.com/nature/index.html
                webEngine.load("file:///C:/Users/Вероника/Desktop/для%20курсача/Journal%20home%20_%20Nature.html");
                spContent.setContent(browser);
            }
        });
        smbScience.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //http://www.sciencemag.org
                webEngine.load("file:///C:/Users/Вероника/Desktop/для%20курсача/Science.html");
                spContent.setContent(browser);
            }
        });

        //todo HELP
        smbAddInfoToProfile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                MessageBox.show(new Stage(),
                        "Go to Tab Profile and add information about your favorites\n\nMusic\nFilms\nBooks",
                        "Information dialog",
                        MessageBox.ICON_INFORMATION | MessageBox.OK | MessageBox.CANCEL);
            }
        });
        //
        smbFriendList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                MessageBox.show(new Stage(),
                        "Add information about your favorites\n\nMusic\nFilms\nBooks",
                        "Information dialog",
                        MessageBox.ICON_INFORMATION | MessageBox.OK | MessageBox.CANCEL);
            }
        });
        smbLoadAvatar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                MessageBox.show(new Stage(),
                        "Click Button \n",
                        "Information dialog",
                        MessageBox.ICON_INFORMATION | MessageBox.OK | MessageBox.CANCEL);
            }
        });
        smbAddToFriend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                MessageBox.show(new Stage(),
                        "Add information about your favorites\n\nMusic\nFilms\nBooks",
                        "Information dialog",
                        MessageBox.ICON_INFORMATION | MessageBox.OK | MessageBox.CANCEL);
            }
        });
        smbLoadPhotos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                MessageBox.show(new Stage(),
                        "Add information about your favorites\n\nMusic\nFilms\nBooks",
                        "Information dialog",
                        MessageBox.ICON_INFORMATION | MessageBox.OK | MessageBox.CANCEL);
            }
        });
        smbChooseTopic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                MessageBox.show(new Stage(),
                        "Add information about your favorites\n\nMusic\nFilms\nBooks",
                        "Information dialog",
                        MessageBox.ICON_INFORMATION | MessageBox.OK | MessageBox.CANCEL);
            }
        });


    }

    private void initData() {
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
                //Display values
                if(id==s){
                }
                else
                usersData.add(new Friend(String.valueOf(id), first, last,""));//ADDING!!!

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
        }//end try
    }

}
