package refactor_classes_ver_1.weapon.impl;

import lombok.Data;
import refactor_classes_ver_1.weapon.Weapon;

@Data
public class Knife implements Weapon {
    private String name = "Knife";
    private int damage = 3;
}
