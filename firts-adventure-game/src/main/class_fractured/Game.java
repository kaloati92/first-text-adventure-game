package class_fractured;

import lombok.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class Game {

    private ChoiceHandler choiceHandler = new ChoiceHandler();
    private UI ui = new UI();
    VisibilityManager visibilityManager = new VisibilityManager(ui);
    Story story = new Story(this, ui, visibilityManager);

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        ui.createUI(choiceHandler);
        visibilityManager.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start":
                    visibilityManager.titleToTown();
                    break;
                case "c1":
                    break;
                case "c2":
                    break;
                case "c3":
                    break;
                case "c4":
                    break;
            }
        }
    }
}
