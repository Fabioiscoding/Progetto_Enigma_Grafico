module singh.g.enigmagraphics {
    requires javafx.controls;
    requires javafx.fxml;


    opens singh.g.enigmagraphics to javafx.fxml;
    exports singh.g.enigmagraphics;
}