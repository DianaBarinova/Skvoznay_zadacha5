package com.example.skvoznay_zadacha5;

import com.example.skvoznay_zadacha5.Work.WorkFile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main  {

    public static void main(String[] args) throws FileNotFoundException {
        WorkFile workFile=new WorkFile();
        workFile.Read("input.zip");
        workFile.write("out.txt");
    }
}