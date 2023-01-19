package com.example.skvoznay_zadacha5;

import com.example.skvoznay_zadacha5.Work.Archiver.Archiver;
import com.example.skvoznay_zadacha5.Work.Archiver.Zip;
import com.example.skvoznay_zadacha5.Work.WorkFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private Button ChoiceButton;

    @FXML
    private MenuItem Englishmenu;

    @FXML
    private Button ParseFileButton;

    @FXML
    private MenuItem RussMenu;

    @FXML
    private Button WrireButton;

    @FXML
    private TextField inputFileName;

    @FXML
    private TextArea Primer;
    @FXML
    private TextArea otvet;
    @FXML
    private AnchorPane pane;





    File inFile;
    WorkFile workFile=new WorkFile();

    @FXML
    void chooseFile(ActionEvent event) throws GeneralSecurityException, IOException, ParserConfigurationException, SAXException {
FileChooser fc= new FileChooser();
inFile = fc.showOpenDialog(null);
ChoiceButton.setText(inFile.getName());
workFile.Read(inFile.getName());
Primer.setText(workFile.getDecision());
    }

    @FXML
    void ChooseRuss(ActionEvent event) {

    }


    @FXML
    void ParseFile(ActionEvent event) throws GeneralSecurityException, IOException, ParserConfigurationException, SAXException {
        workFile.parse();
        otvet.setText(workFile.getResult());

    }

    DataSingleton data=DataSingleton.getInstance();
    @FXML
    void Writte(ActionEvent event) throws ParserConfigurationException, IOException, TransformerException {
        workFile.write(inputFileName.getText());
         data.setFileName(inputFileName.getText());
Stage stage=(Stage) inputFileName.getScene().getWindow();
  Parent root=FXMLLoader.load((getClass().getResource("writeWindow.fxml")));
        Scene scene=new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style2.css").toExternalForm());
        stage.setScene(scene);

}




    @FXML
    void chooseEnglish(ActionEvent event) {

    }


}

