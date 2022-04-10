package SecondTask;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button calculate;

    @FXML
    private Button clear;

    @FXML
    private TextField binary;

    @FXML
    private TextField decimal;

    @FXML
    private TextField hexadecimal;

    Convector convector;

    @FXML
    void initialize(){
        calculate.setOnAction(actionEvent -> {
            if((binary.getText().equals("") && decimal.getText().equals("") && hexadecimal.getText().equals(""))? false:true) {
                convector = new Convector(binary.getText(), decimal.getText(), hexadecimal.getText());
                if (convector.valuesTest()) {
                    binary.setText(convector.binaryConvector());
                    decimal.setText(convector.decimalConvector());
                    hexadecimal.setText(convector.hexadecimalConvector());
                } else {
                    binary.setText("error");
                    decimal.setText("error");
                    hexadecimal.setText("error");
                }
            }
        });

        clear.setOnAction(actionEvent -> {
            binary.clear();
            decimal.clear();
            hexadecimal.clear();
        });
    }

}