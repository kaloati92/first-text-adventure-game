package class_fractured;

import lombok.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class Game {

    private ChoiceHandler choiceHandler = new ChoiceHandler();
    private UI ui = new UI();
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        ui.createUI(choiceHandler);
    }

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();
        }
    }
}
