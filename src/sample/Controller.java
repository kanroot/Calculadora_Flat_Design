package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Controller {


    @FXML
    private Button btC;

    @FXML
    private Button btDel;

    @FXML
    private Button bt9;

    @FXML
    private Button bt8;

    @FXML
    private Button bt7;

    @FXML
    private Button btDivision;

    @FXML
    private Button btPercentage;

    @FXML
    private Button bt2;

    @FXML
    private Button bt1;

    @FXML
    private Button btsubtraction;

    @FXML
    private Button bt6;

    @FXML
    private Button bt5;

    @FXML
    private Button bt4;

    @FXML
    private Button btMulti;

    @FXML
    private Button bt3;

    @FXML
    private Button btAdittion;

    @FXML
    private Button bt0;

    @FXML
    private Button btpPoint;

    @FXML
    private Button btANS;

    @FXML
    private Button btEqual;

    @FXML
    private TextField textFielNumbers;

    @FXML
    private TextArea textArea;

    private boolean operationOn = false;
    private double lastOperation = 0;

    @FXML
    void addValue(ActionEvent event) {

        textFielNumbers.setText(textFielNumbers.getText() + ((Button)event.getSource()).getText() );
        operationOn = true;
    }

    @FXML
    void addOperation(ActionEvent event) {
        if (operationOn) {
            textFielNumbers.setText(textFielNumbers.getText() + ((Button)event.getSource()).getText());
            operationOn = false;
        }
    }

    public void cleanScreen(){
        textFielNumbers.setText("");
        operationOn = true;
    }

    public void deleteValue(){
        if(!(textFielNumbers.getText().length() == 0)) {
            //agarra el texto completo para ponerlo
            // luego selecciona mediante la función substring la posición de partida con el 0 y la posición final
            // se obtiene mediante la obtención total de caracteres y su largo menos 1
            textFielNumbers.setText(textFielNumbers.getText().substring(0, textFielNumbers.getText().length() - 1));
        }
    }

    public void makeOperation(){
        String operation5 = textFielNumbers.getText();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");
        try {

            Object operation = engine.eval(textFielNumbers.getText());
            textFielNumbers.setText("" + operation);
            textArea.setText(operation5 + " = " + textFielNumbers.getText() + "\n" + textArea.getText());
            lastOperation = Double.parseDouble(textFielNumbers.getText());

        } catch (ScriptException  e)
        {
            textFielNumbers.setText("NaN");
        }
    }

    public void getLastResult(){

        textFielNumbers.setText(textFielNumbers.getText() + lastOperation);

    }

}
