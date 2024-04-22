package class_fractured.monster.impl;

import class_fractured.monster.Monster;
import lombok.Data;

@Data
public class Orc implements Monster {
    private String name = "Orc";
    private int hp = 30;
    private int attack = 8;
}
