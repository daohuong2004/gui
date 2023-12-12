module main_package.oop_gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens main_package.oop_gui to javafx.fxml;
    exports main_package.oop_gui;
    exports main_package.oop_gui.Controllers;
    opens main_package.oop_gui.Controllers to javafx.fxml;
}