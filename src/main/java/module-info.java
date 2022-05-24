module com.multifx.multifx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.multifx.multifx to javafx.fxml;
    exports com.multifx.multifx;
}