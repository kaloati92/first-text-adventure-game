package refactor_classes_ver_1;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UIManager {
    private JFrame window;
    private JPanel mainPanel;
    // További UI elemek...

    public UIManager(ActionListener choiceHandler) {
        createUI(choiceHandler);
    }

    private void createUI(ActionListener choiceHandler) {
        // UI komponensek létrehozása és inicializálása...
    }

    public void showTitleScreen() {
        // Title screen megjelenítése
    }
}
