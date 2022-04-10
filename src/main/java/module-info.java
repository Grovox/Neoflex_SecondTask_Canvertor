module com.example.secondtask {
    requires javafx.controls;
    requires javafx.fxml;


    opens SecondTask to javafx.fxml;
    exports SecondTask;
}