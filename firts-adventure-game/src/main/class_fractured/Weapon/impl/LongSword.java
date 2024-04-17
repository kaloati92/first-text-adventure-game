package class_fractured.Weapon.impl;

import class_fractured.Weapon.Weapon;
import lombok.Data;

@Data
public class LongSword implements Weapon {
    private String name = "Long Sword";
    private int damage = 7;
}
