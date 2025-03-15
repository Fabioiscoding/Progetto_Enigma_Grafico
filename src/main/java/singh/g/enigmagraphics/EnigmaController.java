package singh.g.enigmagraphics;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class EnigmaController {
    @FXML
    public ChoiceBox<Character> ChoiceBoxRiflettore;
    @FXML
    public Button ButtonPlusR;
    @FXML
    public Label TextIndexRiflettore;
    @FXML
    public Button ButtonMinusR;

    @FXML
    public ChoiceBox<String> ChoiceBoxRotore3;
    @FXML
    public Button ButtonPlus3;
    @FXML
    public Label TextIndexRotore3;
    @FXML
    public Button ButtonMinus3;

    @FXML
    public ChoiceBox<String> ChoiceBoxRotore2;
    @FXML
    public Button ButtonPlus2;
    @FXML
    public Label TextIndexRotore2;
    @FXML
    public Button ButtonMinus2;

    @FXML
    public ChoiceBox<String> ChoiceBoxRotore1;
    @FXML
    public Button ButtonPlus1;
    @FXML
    public Label TextIndexRotore1;
    @FXML
    public Button ButtonMinus1;

    @FXML
    private GridPane gridButtons;

    private Button[] buttons;

    @FXML
    void initialize(){
        buttons = new Button[27];
        char lettera = 'A';
        gridButtons.setVgap(10);
        gridButtons.setHgap(10);
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
        ChoiceBoxRiflettore.getItems().addAll('A','B','C');
        ChoiceBoxRotore1.getItems().addAll("I","II","III","IV","V");
        ChoiceBoxRotore2.getItems().addAll("I","II","III","IV","V");
        ChoiceBoxRotore3.getItems().addAll("I","II","III","IV","V");
        ChoiceBoxRiflettore.getSelectionModel().select(1);
        ChoiceBoxRotore3.getSelectionModel().selectFirst();
        ChoiceBoxRotore2.getSelectionModel().selectFirst();
        ChoiceBoxRotore1.getSelectionModel().selectFirst();
    }

    @FXML
    public void onKeyPressed(KeyEvent event){
        if (event.getCode().isLetterKey()){
            int pos = event.getCode().getChar().charAt(0) - 'A';
            buttons[pos].fire();
            buttons[pos].requestFocus();
        }
    }
}