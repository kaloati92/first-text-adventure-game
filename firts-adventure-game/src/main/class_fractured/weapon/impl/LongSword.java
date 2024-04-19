package class_fractured.weapon.impl;

import class_fractured.weapon.Weapon;
import lombok.Data;

@Data
public class LongSword implements Weapon {
    private String name = "Long Sword";
    private int damage = 7;
}
