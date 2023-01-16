module com.example.skvoznay_zadacha5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javaluator;


    opens com.example.skvoznay_zadacha5 to javafx.fxml;
    exports com.example.skvoznay_zadacha5;
    exports com.example.skvoznay_zadacha5.Work;
    opens com.example.skvoznay_zadacha5.Work to javafx.fxml;
}