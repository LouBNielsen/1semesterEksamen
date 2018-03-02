/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Cat;
import Entity.Exercises;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Louise Nielsen
 */
public class JUnitTest {

    Exercises instance = new Exercises();
    public final static String FILENAME = "Cats.txt";

    ArrayList<Cat> cats = new ArrayList();

    Cat oMalley = new Cat("O'mally", 15, "Red", false);
    Cat kitty = new Cat("Kitty", 5, "Black", false);
    Cat bones = new Cat("Bones", 1, "White", true);
    Cat skittle = new Cat("Skittle", 12, "Black and red", false);
    Cat erika = new Cat("Erika", 16, "Red", false);
    Cat tommy = new Cat("Tommy", 17, "White", false);

    @Before
    public void setUp() {
        addCatsToArray();
    }

    public final void addCatsToArray() {
        cats.add(oMalley);
        cats.add(kitty);
        cats.add(bones);
        cats.add(skittle);
        cats.add(erika);
        cats.add(tommy);
    }

    @Test
    public void readFile() {

        try {
            String data = instance.getCatsFromFile(FILENAME);

            int expected = 137;
            int actual = data.length();
            assertEquals(expected, actual);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


    @Test
    public void isCatSick() {
        assertAll("Cat is sick",
                () -> assertEquals("Bones", instance.isCatSick()),
                () -> assertNotEquals("Tommy", instance.isCatSick())
        );
    }

    @Test
    public void getOldestCat() {
        assertAll("If cats array is not empty",
                () -> {
                    if (!cats.isEmpty()) {
                        assertAll("Oldest cat",
                                () -> assertEquals("Tommy", instance.getOldestCat()),
                                () -> assertNotEquals("Erika", instance.getOldestCat())
                        );
                    }
                }
        );
    }

    @Test
    public void getPersonsCat() {
        assertAll("Tohmas' cat",
                () -> assertEquals("Kitty", instance.getPersonsCat()),
                () -> assertNotEquals("Sally", instance.getPersonsCat())
        );
    }

    @Test
    public void setCatHealth() {
        assertThat("Erika", is(equalTo(instance.setCatHealh(true))));
    }

}
