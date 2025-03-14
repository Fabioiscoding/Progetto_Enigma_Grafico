package singh.g.enigmagraphics;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class EnigmaController {
    @FXML
    private GridPane gridButtons;

    private Button buttons[];

    @FXML
    void initialize(){
        buttons = new Button[27];
        char lettera = 'A';
        gridButtons.setVgap(10);
        gridButtons.setHgap(10);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                buttons[i * 9 + j] = new Button("" + lettera);
                buttons[i * 9 + j].setPrefWidth(600 / 10);
                final char letteraF = lettera;
                buttons[i * 9 + j].setOnAction(e -> {
                    System.out.println("Ciao " + e.getSource());
                    System.out.println("Hai premuto la lettera " + letteraF);
                });
                gridButtons.add(buttons[i * 9 + j], j, i);
                lettera++;
                if (lettera == '[') return;
            }
        }
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