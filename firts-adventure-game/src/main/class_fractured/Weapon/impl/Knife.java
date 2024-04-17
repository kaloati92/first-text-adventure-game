package class_fractured.Weapon.impl;

import class_fractured.Weapon.Weapon;
import lombok.Data;

@Data
public class Knife implements Weapon {
    private String name = "Knife";
    private int damage = 3;
}
