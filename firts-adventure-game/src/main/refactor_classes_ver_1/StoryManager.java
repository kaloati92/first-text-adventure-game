package refactor_classes_ver_1;

public class StoryManager {
    private UIManager uiManager;
    private GameState gameState;

    public StoryManager(UIManager uiManager, GameState gameState) {
        this.uiManager = uiManager;
        this.gameState = gameState;
    }

    public void defaultSetup() {
        gameState.reset();
        uiManager.showTitleScreen();
    }

    public void selectPosition(String position) {
        switch (position) {
            case "start":
                startGame();
                break;
            case "c1":
                processChoice1();
                break;
            case "c2":
                processChoice2();
                break;
            case "c3":
                processChoice3();
                break;
            case "c4":
                processChoice4();
                break;
        }
    }

    private void startGame() {
        gameState.setPlayerPosition("townGate");
        updateUIBasedOnState();
        uiManager.showGameScreen();
    }

    private void updateUIBasedOnState() {
        uiManager.updatePlayerHealth(gameState.getPlayer().getHealth());
        uiManager.updatePlayerWeapon(gameState.getPlayer().getWeapon().getName());
    }

    // Metódusok a választások kezelésére:
    private void processChoice1() { /* Implementáció */ }
    private void processChoice2() { /* Implementáció */ }
    private void processChoice3() { /* Implementáció */ }
    private void processChoice4() { /* Implementáció */ }
}

