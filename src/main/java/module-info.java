module com.example.skvoznay_zadacha5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javaluator;
    requires java.xml;
    requires com.google.gson;


    opens com.example.skvoznay_zadacha5 to javafx.fxml;
    exports com.example.skvoznay_zadacha5;
    exports com.example.skvoznay_zadacha5.Work;
    opens com.example.skvoznay_zadacha5.Work to javafx.fxml;
    exports com.example.skvoznay_zadacha5.Work.Encryptor;
    opens com.example.skvoznay_zadacha5.Work.Encryptor to javafx.fxml;
    exports com.example.skvoznay_zadacha5.Work.Calculator;
    opens com.example.skvoznay_zadacha5.Work.Calculator to javafx.fxml;
}