module com.jociel.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires java.sql;
    requires java.security.jgss;
    requires jbcrypt;


    opens com.joao.estoque to javafx.fxml;
    opens com.joao.estoque.controller to javafx.fxml;
    opens com.joao.estoque.model to javafx.base;

    exports com.joao.estoque;
}