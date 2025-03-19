package singh.g.enigmagraphics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class EnigmaController{
    char c;

    @FXML
    private ChoiceBox<String> ChoiceBoxRiflettore;
    @FXML
    private Label TextIndexRiflettore;

    @FXML
    private ChoiceBox<String> ChoiceBoxRotore3;
    @FXML
    private Label TextIndexRotore3;

    @FXML
    private ChoiceBox<String> ChoiceBoxRotore2;
    @FXML
    private Label TextIndexRotore2;

    @FXML
    private ChoiceBox<String> ChoiceBoxRotore1;
    @FXML
    private Label TextIndexRotore1;

    @FXML
    private Criptografia Enigma;
    @FXML
    private GridPane gridButtons;

    private Button[] buttons;

    @FXML
    public void initialize(){
        buttons = new Button[27];
        char lettera = 'A';
        gridButtons.setVgap(10);
        gridButtons.setHgap(10);
        ChoiceBoxRiflettore.getItems().addAll("A","B","C");
        ChoiceBoxRotore1.getItems().setAll("I","II","III","IV","V");
        ChoiceBoxRotore2.getItems().setAll("I","II","III","IV","V");
        ChoiceBoxRotore3.getItems().setAll("I","II","III","IV","V");
        ChoiceBoxRiflettore.getSelectionModel().select(1);
        ChoiceBoxRotore3.getSelectionModel().select(2);
        ChoiceBoxRotore2.getSelectionModel().select(1);
        ChoiceBoxRotore1.getSelectionModel().selectFirst();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i * 9 + j] = new Button("" + lettera);
                buttons[i * 9 + j].setPrefWidth((double) 600 / 10);
                final char letteraF = lettera;
                buttons[i * 9 + j].setOnAction(e -> {
                    System.out.println("Ciao " + e.getSource());
                    System.out.println("Hai premuto la lettera " + letteraF);
                });
                gridButtons.add(buttons[i * 9 + j], j, i);
                lettera++;
                if (lettera > 'Z') return;
            }
        }
    }





    public char letteraDopo(char l){
        l += 1;
        if (l > 'Z')
            l = 'A';
        return l;
    }

    public char letteraPrima(char l){
        l--;
        if (l < 'A')
            l = 'Z';
        return l;
    }

    @FXML
    public void onKeyPressed(KeyEvent event){
        if (event.getCode().isLetterKey()){
            int pos = event.getCode().getChar().charAt(0) - 'A';
            buttons[pos].fire();
            buttons[pos].requestFocus();
        }
    }
    @FXML
    protected void OnButtonPlusRClick(ActionEvent actionEvent) {
        c = TextIndexRiflettore.getText().toCharArray()[0];
        c = letteraDopo(c);
        TextIndexRiflettore.setText(Character.toString(c));
    }
    @FXML
    protected void OnButtonMinusRClick(ActionEvent actionEvent) {
        c = TextIndexRiflettore.getText().toCharArray()[0];
        c = letteraPrima(c);
        TextIndexRiflettore.setText(Character.toString(c));
    }
    @FXML

    protected void OnButtonPlus3Click(ActionEvent actionEvent) {
        c = TextIndexRotore3.getText().toCharArray()[0];
        c = letteraDopo(c);
        TextIndexRotore3.setText(Character.toString(c));
    }
    @FXML

    protected void OnButtonMinus3Click(ActionEvent actionEvent) {
        c = TextIndexRotore3.getText().toCharArray()[0];
        c = letteraPrima(c);
        TextIndexRotore3.setText(Character.toString(c));
    }
    @FXML

    protected void OnButtonPlus2Click(ActionEvent actionEvent) {
        c = TextIndexRotore2.getText().toCharArray()[0];
        c = letteraDopo(c);
        TextIndexRotore2.setText(Character.toString(c));
    }
    @FXML

    protected void OnButtonMinus2Click(ActionEvent actionEvent) {
        c = TextIndexRotore2.getText().toCharArray()[0];
        c = letteraPrima(c);
        TextIndexRotore2.setText(Character.toString(c));
    }
    @FXML

    protected void OnButtonPlus1Click(ActionEvent actionEvent) {
        c = TextIndexRotore1.getText().toCharArray()[0];
        c = letteraDopo(c);
        TextIndexRotore1.setText(Character.toString(c));
    }
    @FXML

    protected void OnButtonMinus1Click(ActionEvent actionEvent) {
        c = TextIndexRotore1.getText().toCharArray()[0];
        c = letteraPrima(c);
        TextIndexRotore1.setText(Character.toString(c));
    }
}