package refactor_classes_ver_1.domain;

import lombok.Data;
import refactor_classes_ver_1.weapon.Weapon;

@Data
public class Player {
    private int health;
    private Weapon weapon;
}
