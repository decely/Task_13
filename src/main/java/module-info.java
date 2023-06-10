module com.example.task_13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task_13 to javafx.fxml;
    exports com.example.task_13;
}