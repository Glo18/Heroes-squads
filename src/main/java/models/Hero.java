package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weaknesses;
    private static List<Hero> instances = new ArrayList<>();

    public Hero(String name, int age, String power, String weaknesses)  {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weaknesses = weaknesses;
        instances.add(this);

    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public String getPower() {

        return power;
    }

    public String getWeaknesses() {

        return weaknesses;
    }

    public static List<Hero> getAll() {
        return instances;
    }

    public static List<Hero> addHero() {
        Hero aqua = new Hero("Aquaman", 40, "Ability to communicate with creatures", "kryptonite");
        Hero iron = new Hero("Ironman", 44, "Supersonic flight Energy", "Ego-Centric");
        Hero king = new Hero("Wakanda",36,"Vibranium", "Nerdy");
        instances.add(aqua);
        instances.add(iron);
        instances.add(king);
        return instances;
    }
}