package class_fractured;

import class_fractured.Weapon.impl.Knife;
import class_fractured.domain.Player;
import lombok.Data;

@Data
public class Story {
    private Game game;
    private UI ui;
    private VisibilityManager visibilityManager;
    private Player player = new Player();
    public Story(Game game, UI ui, VisibilityManager visibilityManager){

        this.game = game;
        this.ui = ui;
        this.visibilityManager = visibilityManager;
    }
    public void defaultSetup(){

        player.setHealth(10);
        ui.getHpNumberLabel().setText("" + player.getHealth());

        player.setWeapon(new Knife());
        ui.getWeaponLabelName().setText(player.getWeapon().getName());
    }

}
