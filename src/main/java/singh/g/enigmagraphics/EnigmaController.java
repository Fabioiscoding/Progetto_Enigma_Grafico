package singh.g.enigmagraphics;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;

public class EnigmaController {
    private static final int ROWS = 3;
    private static final int COLS = 9;
    private static final int CIRCLE_RADIUS = 20;
    private static final int SPACING = 25;
    @FXML
    GridPane gridLamp = new GridPane();
    char codifica;
    @FXML
    char l = 'A';
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

    PauseTransition pause = new PauseTransition(Duration.seconds(2));
    @FXML
    private Button[] buttons;
    @FXML
    private StackPane[][] lampArray = new StackPane[ROWS][COLS];

    @FXML
    public void initialize() {
        gridButtons.setVgap(10);
        gridButtons.setHgap(10);
        char lettera = 'A';

        ChoiceBoxRiflettore.getItems().addAll("A", "B", "C");
        ChoiceBoxRotore1.getItems().setAll("I", "II", "III", "IV", "V");
        ChoiceBoxRotore2.getItems().setAll("I", "II", "III", "IV", "V");
        ChoiceBoxRotore3.getItems().setAll("I", "II", "III", "IV", "V");

        ChoiceBoxRiflettore.getSelectionModel().select(1);
        ChoiceBoxRotore3.getSelectionModel().select(2);
        ChoiceBoxRotore2.getSelectionModel().select(1);
        ChoiceBoxRotore1.getSelectionModel().selectFirst();

        TextIndexRotore1.setText("A");
        TextIndexRotore2.setText("A");
        TextIndexRotore3.setText("A");
        TextIndexRiflettore.setText(ChoiceBoxRiflettore.getValue());

        Enigma = new Criptografia(
                ChoiceBoxRotore1.getSelectionModel().getSelectedIndex(),
                (int) (TextIndexRotore1.getText().toCharArray()[0] - lettera),
                ChoiceBoxRotore2.getSelectionModel().getSelectedIndex(),
                (int) (TextIndexRotore2.getText().toCharArray()[0] - lettera),
                ChoiceBoxRotore3.getSelectionModel().getSelectedIndex(),
                (int) (TextIndexRotore3.getText().toCharArray()[0] - lettera),
                ChoiceBoxRiflettore.getSelectionModel().getSelectedIndex()
        );

        gridLamp.setHgap(SPACING);
        gridLamp.setVgap(SPACING/2);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Circle circle = new Circle(CIRCLE_RADIUS);
                circle.setFill(Color.LIGHTGRAY);
                circle.setStroke(Color.BLACK);
                Label label = new Label(String.valueOf(lettera));
                StackPane stack = new StackPane(circle, label);
                lampArray[row][col] = stack;

                gridLamp.add(stack, col, row);

                lettera++;
                if (lettera > 'Z') break;
            }
        }


        buttons = new Button[27];
        lettera = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i * 9 + j] = new Button("" + lettera);
                buttons[i * 9 + j].setPrefWidth(600 / 10);
                char letteraC = lettera;
                buttons[i * 9 + j].setOnAction(e -> {
                    codifica = Enigma.codificaLettera(letteraC);
                    l = codifica;
                    System.out.println("Lettera codificata: " + codifica);
                    cambioColoreLamp(codifica);
                    indexRotori();
                });
                gridButtons.add(buttons[i * 9 + j], j, i);
                lettera++;
                if (lettera > 'Z') return;
            }
        }
    }

    @FXML
    protected void resetLamp(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (i*j != 16)
                    cambiaColoreLampo(i,j,Color.LIGHTGRAY);
            }
        }
    }

    @FXML
    protected void cambioColoreLamp(char chr){
        resetLamp();
        int pos = chr - 'A';
        int row = pos / COLS;
        int col = pos % COLS;
        cambiaColoreLampo(row, col, Color.YELLOW);
//        pause.setOnFinished(e -> resetLamp());
//        pause.play();
    }

    @FXML
    public void onKeyPressed(KeyEvent event) {
        if (event.getCode().isLetterKey()) {
            char letteraPremuta = event.getText().toUpperCase().charAt(0);
            int pos = letteraPremuta - 'A';
            buttons[pos].fire();
            buttons[pos].requestFocus();
        }
    }

    protected void indexRotori(){
        ArrayList<Integer> index = Enigma.indexRotori();
        TextIndexRotore1.setText(String.valueOf((char)('A' + index.get(0))));
        TextIndexRotore2.setText(String.valueOf((char)('A' + index.get(1))));
        TextIndexRotore3.setText(String.valueOf((char)('A' + index.get(2))));
    }

    public char letteraDopo(char l) {
        l += 1;
        if (l > 'Z')
            l = 'A';
        return l;
    }

    public char letteraPrima(char l) {
        l--;
        if (l < 'A')
            l = 'Z';
        return l;
    }

    char c;

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

    public void cambiaColoreLampo(int row, int col, Color color) {
        StackPane lampo = lampArray[row][col];
        Circle circle = (Circle) lampo.getChildren().get(0);
        circle.setFill(color);
    }
}