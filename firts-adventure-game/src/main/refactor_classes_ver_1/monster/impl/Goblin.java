package refactor_classes_ver_1.monster.impl;

import lombok.Data;
import refactor_classes_ver_1.monster.Monster;

@Data
public class Goblin implements Monster {
    private String name = "Goblin";
    private int hp = 20;
    private int attack = 6;
}
