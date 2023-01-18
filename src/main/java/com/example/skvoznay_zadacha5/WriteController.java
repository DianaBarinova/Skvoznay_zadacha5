package com.example.skvoznay_zadacha5;

import com.example.skvoznay_zadacha5.Work.Archiver.Archiver;
import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WriteController implements Initializable {

    String outFile;
    @FXML
    private Button zip;
    @FXML
    private Text  textFile;
    @FXML
    private Button closeButton;

    @FXML
    void zipFile(ActionEvent event) {
Archiver zip=new Zip();
outFile=zip.archiveFile(outFile);
textFile.setText(outFile);
    }
DataSingleton data=DataSingleton.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        outFile= data.getFileName();
        textFile.setText(data.getFileName());
    }

    @FXML
    void close(ActionEvent event) throws IOException {
        Stage stage=(Stage) textFile.getScene().getWindow();
        Parent root= FXMLLoader.load((getClass().getResource("readwrite.fxml")));
        stage.setScene(new Scene(root));
    }


}
