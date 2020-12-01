package models;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HeroTest {

    @Test
    public void instantiateClass(){
        assertTrue(true);
    }

    @Test
    public void functionalityTest(){
        Hero king = new Hero("Glory", 25, "Beauty", "Pride");
        assertTrue(Hero.getAll().contains(king));
    }}