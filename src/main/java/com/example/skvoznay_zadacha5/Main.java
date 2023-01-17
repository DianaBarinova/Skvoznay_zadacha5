package com.example.skvoznay_zadacha5;

import com.example.skvoznay_zadacha5.Work.WorkFile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main  {

    public static void main(String[] args) throws IOException, GeneralSecurityException, ParserConfigurationException, SAXException, TransformerException {
        WorkFile workFile=new WorkFile();
        workFile.Read("innnn.json");
        workFile.write("ot.txt");
    }
}