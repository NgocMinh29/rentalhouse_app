module com.mycompany.mavenprojecttest {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.mavenprojecttest to javafx.fxml;
    exports com.mycompany.mavenprojecttest;
}
