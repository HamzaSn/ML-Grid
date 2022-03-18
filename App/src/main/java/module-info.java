module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires RCaller;
    requires javafx.base;
    requires org.apache.poi.ooxml;


    opens App to javafx.fxml;
    exports App;
    exports App.Controllers;
    opens App.Controllers to javafx.fxml;
    exports R;
    opens R to javafx.fxml;
    exports App.Models;
    opens App.Models to javafx.fxml;
}