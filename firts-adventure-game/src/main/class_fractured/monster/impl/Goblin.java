package class_fractured.monster.impl;

import class_fractured.monster.Monster;
import lombok.Data;

@Data
public class Goblin implements Monster {
    private String name = "Goblin";
    private int hp = 20;
    private int attack = 6;
}
