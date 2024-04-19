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

    private String nextPosition1;
    private String nextPosition2;
    private String nextPosition3;
    private String nextPosition4;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        ui.createUI(choiceHandler);
        story.defaultSetup();
        visibilityManager.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start":
                    visibilityManager.titleToTown();
                    story.townGate();
                    break;
                case "c1": story.selectPosition(nextPosition1);
                    break;
                case "c2": story.selectPosition(nextPosition2);
                    break;
                case "c3": story.selectPosition(nextPosition3);
                    break;
                case "c4": story.selectPosition(nextPosition4);
                    break;
            }
        }
    }
}
