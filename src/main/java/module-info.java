module com.example.skvoznay_zadacha5 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.skvoznay_zadacha5 to javafx.fxml;
    exports com.example.skvoznay_zadacha5;
}