/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Interfaces.Interface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Louise Nielsen
 */
public class Exercises implements Interface {

    public final static String FILENAME = "Cats.txt";

    public static ArrayList<Cat> cats = new ArrayList<>();
    public static ArrayList<Person> persons = new ArrayList<>();

    Cat oMalley = new Cat("O'mally", 15, "Red", false);
    Cat kitty = new Cat("Kitty", 5, "Black", false);
    Cat bones = new Cat("Bones", 1, "White", true);
    Cat skittle = new Cat("Skittle", 12, "Black and red", false);
    Cat erika = new Cat("Erika", 16, "Red", false);
    Cat tommy = new Cat("Tommy", 17, "White", false);

    public static void main(String[] args) {

        Exercises main = new Exercises();
        System.out.println("The name of the cat(s) that is sick: " + main.isCatSick());
//        main.removeSickCat();
        System.out.println("The name of the oldest cat: " + main.getOldestCat());
        System.out.println("Tommy's cat: " + main.getPersonsCat());
        System.out.println("Names of the cats: " + main.catNamesList());
        main.setCatName("Lisa");
        System.out.println("Names of the cats: " + main.catNamesList());

        System.out.println("Cat that is now sick:" + main.setCatHealh(true));
        System.out.println(main.getCatsFromFile(FILENAME));
//        main.addCatToFile(file);
//        System.out.println(main.writeCatsFromFileToList(file));
    }

    public Exercises() {
        addCatsToArray();
        addPersonArray();
    }

    public final void addCatsToArray() {
        cats.add(oMalley);
        cats.add(kitty);
        cats.add(bones);
        cats.add(skittle);
        cats.add(erika);
        cats.add(tommy);
    }

    public final void addPersonArray() {
        persons.add(new Person("Emilie", oMalley));
        persons.add(new Person("Thomas", kitty));
        persons.add(new Person("Sally", bones));
        persons.add(new Person("Simon", skittle));
    }

    @Override
    public String isCatSick() {
        String name = "";

        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).isSick()) {
                name = cats.get(i).getName();
            }
        }
        return name;
    }

    @Override
    public void removeSickCat() {
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).isSick()) {
                cats.remove(i);
                --i;
            }
        }
    }

    @Override
    public String getOldestCat() {
        String name = "";
        int max = 0;

        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getAge() > max) {
                name = cats.get(i).getName();
                max = cats.get(i).getAge();
            }
        }

        return name;
    }

    @Override
    public String getPersonsCat() {
        Cat cat = null;
        String name = "Thomas";
        String catName = "";

        for (int i = 0; i < persons.size(); i++) {
            if (name.equals(persons.get(i).getName())) {
                cat = persons.get(i).getPersonsCat();
                catName = cat.getName();
            }
        }

        return catName;
    }

    @Override
    public ArrayList<String> catNamesList() {
        ArrayList<String> newList = new ArrayList();
        for (int i = 0; i < cats.size(); i++) {
            newList.add(cats.get(i).getName());
        }

        return newList;
    }

    @Override
    public void setCatName(String name) {
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getAge() == 5) {
                cats.get(i).setName(name);
            }
        }
    }

    @Override
    public String setCatHealh(boolean isSick) {
        String name = "";
        System.out.println(erika.isSick());
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getAge() > 15 && !"White".equals(cats.get(i).getColor())) {
                cats.get(i).setIsSick(isSick);
                name = cats.get(i).getName();
            }
        }
        System.out.println(erika.isSick());
        return name;
    }

    @Override
    public String getCatsFromFile(String filename) {
        String content = "";
        String newLine;

        try {
            FileReader fileReader = new FileReader(filename);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((newLine = bufferedReader.readLine()) != null) {
                    content += newLine + "\n";
                }
            }

            return content;

        } catch (FileNotFoundException ex) {
            return ex.toString();
        } catch (IOException ex) {
            return ex.toString();
        }
    }

    @Override
    public void addCatToFile(String filename) {
        Cat cat = new Cat("Micka", 8, "Black", true);

        try {
            try (FileWriter fileWriter = new FileWriter(filename, true)) {
                fileWriter.write("\n" + cat.toString() + ";");
            }
        } catch (IOException ex) {
            ex.toString();
        }
    }

    @Override
    public ArrayList<String> writeCatsFromFileToList(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        String strLine = "";
        ArrayList<String> listOfCats = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(filename);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while (strLine != null) {
                    strLine = bufferedReader.readLine();
                    stringBuilder.append(strLine);
                    listOfCats.add(strLine);
                }
                System.out.println(Arrays.toString(listOfCats.toArray()));
            }
        } catch (FileNotFoundException ex) {
            ex.toString();
        } catch (IOException ex) {
            ex.toString();
        }

        return listOfCats;
    }
}
