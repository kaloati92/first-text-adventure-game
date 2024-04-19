package class_fractured.weapon.impl;

import class_fractured.weapon.Weapon;
import lombok.Data;

@Data
public class Knife implements Weapon {
    private String name = "Knife";
    private int damage = 3;
}
