module com.example.labpractice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.labpractice to javafx.fxml;
    exports com.example.labpractice;
    exports com.example.labpractice.javaSwingExamples;
    opens com.example.labpractice.javaSwingExamples to javafx.fxml;
}