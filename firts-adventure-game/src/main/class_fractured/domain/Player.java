package class_fractured.domain;

import class_fractured.Weapon.Weapon;
import lombok.Data;

@Data
public class Player {
    private int health;
    private Weapon weapon;
}
