module percobaan.percobaan {
    requires javafx.controls;
    requires javafx.fxml;


    opens percobaan.percobaan to javafx.fxml;
    exports percobaan.percobaan;
}