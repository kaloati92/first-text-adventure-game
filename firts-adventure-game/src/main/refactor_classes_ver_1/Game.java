package refactor_classes_ver_1;

public class Game {
    private GameController controller;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        controller = new GameController();
        controller.startGame();
    }

    public static void main(String[] args) {
        new Game();
    }
}
