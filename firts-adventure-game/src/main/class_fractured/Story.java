package class_fractured;

import class_fractured.domain.Enemy;
import class_fractured.domain.Player;
import class_fractured.monster.impl.Goblin;
import class_fractured.weapon.impl.Knife;
import class_fractured.weapon.impl.LongSword;
import lombok.Data;

@Data
public class Story {
    private Game game;
    private UI ui;
    private VisibilityManager visibilityManager;
    private Player player = new Player();
    private Enemy enemy;

    public Story(Game game, UI ui, VisibilityManager visibilityManager) {

        this.game = game;
        this.ui = ui;
        this.visibilityManager = visibilityManager;
    }

    public void defaultSetup() {

        player.setHealth(10);
        ui.getHpNumberLabel().setText("" + player.getHealth());

        player.setWeapon(new Knife());
        ui.getWeaponLabelName().setText(player.getWeapon().getName());
    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "townGate":
                townGate();
                break;
            case "talkGuard":
                talkGuard();
                break;
            case "attackGuard":
                attackGuard();
                break;
            case "crossRoad":
                crossRoad();
                break;
            case "north":
                north();
                break;
            case "east":
                east();
                break;
            case "west":
                west();
                break;
        }
    }

    public void townGate() {
        ui.getMainTextArea().setText("You are at the gate of the town. " +
                "\nA guard standing in front of you. \n\nWhat do you do?");

        ui.getChoice1().setText("Talk to the guard.");
        ui.getChoice2().setText("Attack the guard.");
        ui.getChoice3().setText("Leave.");
        ui.getChoice4().setText("");

        game.setNextPosition1("talkGuard");
        game.setNextPosition2("attackGuard");
        game.setNextPosition3("crossRoad");
        game.setNextPosition4("");
    }

    public void talkGuard() {
        ui.getMainTextArea().setText("Guard: Hello stranger. " +
                "I have never seen your face. " +
                "I'm sorry but we cannot let a stranger enter our town.");

        ui.getChoice1().setText(">");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("townGate");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void attackGuard() {
        ui.getMainTextArea().setText("Guard: Hey don't be stupid!" +
                "\n\nThe guard fought back and hit you hard" +
                "\n(You receive 3 damage)");

        player.setHealth(player.getHealth() - 3);
        ui.getHpNumberLabel().setText("" + player.getHealth());

        ui.getChoice1().setText(">");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("townGate");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void crossRoad() {
        ui.getMainTextArea().setText("you re at a crossroad." +
                "\nIf you go south, you will go back to the town.");

        ui.getChoice1().setText("Go North");
        ui.getChoice2().setText("Go East");
        ui.getChoice3().setText("Go South");
        ui.getChoice4().setText("Go West");

        game.setNextPosition1("north");
        game.setNextPosition2("east");
        game.setNextPosition3("townGate");
        game.setNextPosition4("west");
    }

    public void north() {
        ui.getMainTextArea().setText("There is a river." +
                "\nYou drink the water and rest at the riverside." +
                "\n\n(Your HP is recovered by 2)");

        player.setHealth(player.getHealth() + 2);
        ui.getHpNumberLabel().setText("" + player.getHealth());

        ui.getChoice1().setText("Go South");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("crossRoad");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void east() {
        ui.getMainTextArea().setText("You walk into a forest and found a Long Sword." +
                "\n\n(You obtained a Long Sword)");

        player.setWeapon(new LongSword());
        ui.getWeaponLabelName().setText(player.getWeapon().getName());

        ui.getChoice1().setText("Go West");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("crossRoad");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void west() {
        enemy.setMonster(new Goblin());
        ui.getMainTextArea().setText("You encounter a "
                + enemy.getMonster().getName()
                + ".");

        ui.getChoice1().setText("Fight!");
        ui.getChoice2().setText("Run!");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("crossRoad");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void fight() {
//        ui.getMainTextArea().setText("MonsterHp " + monsterHp +
//                "\n\nWhat do you do?");

        ui.getChoice1().setText("Fight!");
        ui.getChoice2().setText("Run!");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("crossRoad");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void playerAttack() {

    }

    public void monsterAttack() {

    }

    public void win() {

    }

    public void lose() {

    }

    public void ending() {

    }
}
