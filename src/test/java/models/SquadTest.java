package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void squadTest(){
        Squad squad = new Squad("Thor", 10, "sexism");
        Hero marvel = new Hero("Thor", 23, "fighting", "light");
        Squad.add(marvel);
        assertTrue(Squad.getMembers().contains(squad));
    }

    @Test
    public void squadFunction() {
        Squad squad = new Squad("Thor", 10, "Machine learning");
        assertTrue(Squad.getMembers().contains(squad));
    }

}