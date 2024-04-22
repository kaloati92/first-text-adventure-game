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
    int silverRing;

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

        if(silverRing < 1){
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
        game.setNextPosition4("");}
        else {
            ending();
        }
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

        game.setNextPosition1("fight");
        game.setNextPosition2("crossroad");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void fight() {
        ui.getMainTextArea().setText(enemy.getMonster().getName() +
                ": " + enemy.getMonster().getHp() + "\n\nWhat do you do?");

        ui.getChoice1().setText("Fight!");
        ui.getChoice2().setText("Run!");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("playerAttack");
        game.setNextPosition2("crossroad");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void playerAttack() {
        int playerDamage = new java.util.Random().nextInt(
                player.getWeapon().getDamage());

        ui.getMainTextArea().setText(
                "You attacked the " + enemy.getMonster().getName() +
                        " and gave " + playerDamage + " damage!");

        enemy.getMonster().setHp(enemy.getMonster().getHp() - playerDamage);

        ui.getChoice1().setText(">");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        if (enemy.getMonster().getHp() > 0) {
            game.setNextPosition1("monsterAttack");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        } else {
            game.setNextPosition1("win");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        }
    }


    public void monsterAttack() {
        int monsterDamage = new java.util.Random().nextInt(
                enemy.getMonster().getAttack());

        ui.getMainTextArea().setText(
                "The " + enemy.getMonster().getName() + " attacked you and gave "
                        + monsterDamage + " damage!");

        player.setHealth(player.getHealth() - monsterDamage);
        ui.getHpNumberLabel().setText("" + player.getHealth());

        ui.getChoice1().setText(">");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        if (player.getHealth() > 0) {
            game.setNextPosition1("fight");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        } else {
            game.setNextPosition1("lose");
            game.setNextPosition2("");
            game.setNextPosition3("");
            game.setNextPosition4("");
        }
    }

    public void win() {

        ui.getMainTextArea().setText("You killed a" +
                enemy.getMonster().getName() + "." +
                "\nThe monster dropped a ring!" +
                "\n\n(You obtained a Silver Ring)");

        silverRing++;

        ui.getChoice1().setText("Go east");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("crossRoad");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void lose() {
        ui.getMainTextArea().setText("You are dead!\n\n<Game Over>");

        ui.getChoice1().setText("To the title screen");
        ui.getChoice2().setText("");
        ui.getChoice3().setText("");
        ui.getChoice4().setText("");

        game.setNextPosition1("toTitle");
        game.setNextPosition2("");
        game.setNextPosition3("");
        game.setNextPosition4("");
    }

    public void ending() {
        ui.getMainTextArea().setText("Guard: Oh you killed that " +
                enemy.getMonster().getName() + "!" +
                "\\nThank you.\\nWelcome to the town\\n\\n<THE END>");

        ui.getChoice1().setVisible(false);
        ui.getChoice2().setVisible(false);
        ui.getChoice3().setVisible(false);
        ui.getChoice4().setVisible(false);
    }
    public void toTitle(){
        defaultSetup();
    }
}
