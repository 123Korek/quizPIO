module com.example.quizpio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quizpio to javafx.fxml;
    exports com.example.quizpio;
}