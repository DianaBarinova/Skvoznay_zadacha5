package com.example.skvoznay_zadacha5;

import com.example.skvoznay_zadacha5.Work.Archiver.Archiver;
import com.example.skvoznay_zadacha5.Work.Archiver.Jar;
import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import com.example.skvoznay_zadacha5.Work.Encryptor.Encryptor;
import com.example.skvoznay_zadacha5.Work.WorkFile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ResourceBundle;

public class Main extends Application {


  @Override
    public void start(Stage primaryStage) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("readwrite.fxml"));
      primaryStage.setTitle("File parse");
        Scene scene=new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);
    }
}

/*
public class Main{
    public static void main(String[] args) throws IOException, GeneralSecurityException, ParserConfigurationException, SAXException, TransformerException {
        WorkFile workFile=new WorkFile();
       workFile.Read("input.txt");
    }

}
*/

