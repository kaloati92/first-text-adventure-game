package refactor_classes_ver_1.monster.impl;

import lombok.Data;
import refactor_classes_ver_1.monster.Monster;

@Data
public class Orc implements Monster {
    private String name = "Orc";
    private int hp = 30;
    private int attack = 8;
}
