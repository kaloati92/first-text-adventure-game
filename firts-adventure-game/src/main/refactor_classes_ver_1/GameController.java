package refactor_classes_ver_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private UIManager uiManager;
    private StoryManager storyManager;

    public GameController() {
        uiManager = new UIManager(new ChoiceHandler());
        storyManager = new StoryManager(uiManager);
    }

    public void startGame() {
        storyManager.defaultSetup();
        uiManager.showTitleScreen();
    }

    private class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String choice = event.getActionCommand();
            storyManager.selectPosition(choice);
        }
    }
}
