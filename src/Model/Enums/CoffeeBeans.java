package Model.Enums;

import java.util.Random;

public enum CoffeeBeans {
    ARABIACA("아라비아카"), ROBUSTA("로부스타");
    private final String name;
    CoffeeBeans(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }



}
