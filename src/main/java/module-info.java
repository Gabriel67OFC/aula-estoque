module com.joao.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;


    opens com.joao.estoque to javafx.fxml;
    opens com.joao.estoque.controller to javafx.fxml;
    opens com.joao.estoque.model to javafx.base;

    exports com.joao.estoque;
}