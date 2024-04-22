package refactor_classes_ver_1;


import lombok.Data;
import refactor_classes_ver_1.domain.Player;
import refactor_classes_ver_1.weapon.impl.Knife;

import java.io.Serializable;

@Data
public class GameState implements Serializable {
    private Player player;
    private PlayerPosition playerPosition;
    private boolean gameInProgress;

    public GameState() {
        this.player = new Player();
        this.playerPosition = new PlayerPosition("Start");
        this.gameInProgress = false;
    }

    public void reset() {
        player.setHealth(100);
        player.setWeapon(new Knife());
        gameInProgress = true;
    }

}
