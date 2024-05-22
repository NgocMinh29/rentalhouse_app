module com.mycompany.mavenprojecttest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.mavenprojecttest to javafx.fxml;
    exports com.mycompany.mavenprojecttest;
    
    requires java.mail;
    requires activation;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.poi.ooxml.schemas;
    
}
