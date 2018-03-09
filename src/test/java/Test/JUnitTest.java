/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Cat;
import Entity.Exercises;
import Entity.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
    public final String FILENAME = "Cats.txt";
    public final String TESTDATA = "TestData.txt";
    public final String TESTDATACATNAMES = "TestDataCatNames.txt";

    ArrayList<Cat> cats = new ArrayList();
    ArrayList<Person> persons = new ArrayList<>();

    Cat oMalley = new Cat("O'mally", 15, "Red", false);
    Cat kitty = new Cat("Kitty", 5, "Black", false);
    Cat bones = new Cat("Bones", 1, "White", true);
    Cat skittle = new Cat("Skittle", 12, "Black and red", false);
    Cat erika = new Cat("Erika", 16, "Red", false);
    Cat tommy = new Cat("Tommy", 17, "White", false);
    Cat kia = new Cat("Kia", 7, "Red", true);

    @Before
    public void setUp() {
        addCatsToArray();
        addPersonArray();
    }

    @Test
    public void getNameOfSickCats() {
        assertAll("Cat is sick",
                () -> assertEquals("[Bones, Kia]", instance.getNameOfSickCats(cats)),
                () -> assertNotEquals("[Bones]", instance.getNameOfSickCats(cats))
        );
    }

    @Test
    public void removeSickCat() {
        assertTrue(instance.removeSickCat(cats));
    }

    @Test
    public void getOldestCat() {
        assertAll("If cats array is not empty",
                () -> {
                    if (!cats.isEmpty()) {
                        assertAll("Oldest cat",
                                () -> assertEquals("Tommy", instance.getOldestCat(cats)),
                                () -> assertNotEquals("Erika", instance.getOldestCat(cats))
                        );
                    }
                }
        );
    }

    @Test
    public void getPersonsCat() {
        assertAll("Persons cat",
                () -> assertEquals("Kitty", instance.getPersonsCat(persons, "Thomas")),
                () -> assertNotEquals("Sally", instance.getPersonsCat(persons, "Thomas")),
                () -> assertEquals("Bones", instance.getPersonsCat(persons, "Sally")),
                () -> assertNotEquals("Skittle", instance.getPersonsCat(persons, "Emilie"))
        );
    }

    @Test
    public void setCatHealth() {
        assertThat("Erika", is(equalTo(instance.setCatHealh(cats, true))));
    }

    @Test
    public void setCatName() {
        ArrayList<String> catNamesBefore = instance.catNamesList(cats);
        instance.setCatName(cats, "Lisa");
        ArrayList<String> catNamesAfter = instance.catNamesList(cats);

        assertNotEquals(catNamesBefore, catNamesAfter);
    }

    @Test
    public void readCatFile() {

        try {
            String data = instance.readCatFile(FILENAME);

            int minExpected = 87;
            int actual = data.length();

            assertTrue("True that: ", minExpected <= actual);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void dataDrivenReadCatFile() {

        ArrayList<Integer> testData = dataDrivenReadFile(TESTDATA);
        int minExpected = 0;

        for (Integer i : testData) {
            minExpected = i;
        }

        try {
            String data = instance.readCatFile(FILENAME);
            int actual = data.length();

            assertTrue("True that all the numbers from the file is less that the actual file length: ", minExpected <= actual);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void dataDrivenTestDataFileEndsWith() {
        int lastValue = 87;
        ArrayList<Integer> data = dataDrivenReadFile(TESTDATA);

        assertThat(lastValue, is(equalTo(data.size())));
    }

    @Test
    public void dataDrivenReadCatNames() {
        for (int i = 0; i < cats.size(); i++) {
            assertNotEquals(cats.get(i).getName(), dataDrivenReadCatNamesFile(TESTDATACATNAMES).get(i));
        }
    }

    //***Helper method***
    public ArrayList<Integer> dataDrivenReadFile(String filename) {
        String newLine;
        ArrayList<Integer> data = new ArrayList();

        try {
            FileReader fileReader = new FileReader(filename);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((newLine = bufferedReader.readLine()) != null) {
                    String[] strNumbers = newLine.split(",");
                    for (String strNumber : strNumbers) {
                        data.add(Integer.parseInt(strNumber));
                    }
                }
            }
            return data;
        } catch (FileNotFoundException ex) {
            ex.toString();
        } catch (IOException ex) {
            ex.toString();
        }

        return data;
    }

    //***Helper method***
    public ArrayList<String> dataDrivenReadCatNamesFile(String filename) {
        String newLine;
        ArrayList<String> data = new ArrayList();

        try {
            FileReader fileReader = new FileReader(filename);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((newLine = bufferedReader.readLine()) != null) {
                    String[] strNumbers = newLine.split(",");
                    for (String strNumber : strNumbers) {
                        data.add(strNumber);
                    }
                }
            }
            return data;
        } catch (FileNotFoundException ex) {
            ex.toString();
        } catch (IOException ex) {
            ex.toString();
        }

        return data;
    }

    public final void addCatsToArray() {
        cats.add(oMalley);
        cats.add(kitty);
        cats.add(bones);
        cats.add(skittle);
        cats.add(erika);
        cats.add(tommy);
        cats.add(kia);
    }

    public final void addPersonArray() {
        persons.add(new Person("Emilie", oMalley));
        persons.add(new Person("Thomas", kitty));
        persons.add(new Person("Sally", bones));
        persons.add(new Person("Simon", skittle));
    }
}
