package refactor_classes_ver_1.weapon.impl;

import lombok.Data;
import refactor_classes_ver_1.weapon.Weapon;

@Data
public class LongSword implements Weapon {
    private String name = "Long Sword";
    private int damage = 7;
}
