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

/**
 *
 * @author Louise Nielsen
 */
public class Exercises implements Interface {

    public final static String FILENAME = "Cats.txt";

    @Override
    public String getNameOfSickCats(ArrayList<Cat> cats) {
        ArrayList<String> newList = new ArrayList();
        String name = "";
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).isSick()) {
                newList.add(cats.get(i).getName());
            }
            name = newList.toString();
        }
        return name;
    }

    @Override
    public boolean removeSickCat(ArrayList<Cat> cats) {
        boolean removed = false;
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).isSick()) {
                cats.remove(i);
                removed = true;
                i--;
            }
        }
        return removed;
    }

    @Override
    public String getOldestCat(ArrayList<Cat> cats) {
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
    public String getPersonsCat(ArrayList<Person> persons, String name) {
        Cat cat;
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
    public ArrayList<String> catNamesList(ArrayList<Cat> cats) {
        ArrayList<String> newList = new ArrayList();
        for (int i = 0; i < cats.size(); i++) {
            newList.add(cats.get(i).getName());
        }

        return newList;
    }

    @Override
    public void setCatName(ArrayList<Cat> cats, String name) {
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getAge() == 5) {
                cats.get(i).setName(name);
            }
        }
    }

    @Override
    public String setCatHealh(ArrayList<Cat> cats, boolean isSick) {
        String name = "";
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getAge() > 15 && !"White".equals(cats.get(i).getColor())) {
                cats.get(i).setIsSick(isSick);
                name = cats.get(i).getName();
            }
        }
        return name;
    }

    @Override
    public String readCatFile(String filename) {
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
    public void addCatToFile(Cat cat, String filename) {
        cat = new Cat("Micka", 8, "Black", true);

        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            fileWriter.write("\n" + cat.toString());
        } catch (IOException ex) {
            ex.toString();
        }
    }

    @Override
    public ArrayList<Cat> writeCatsFromFileToList(String filename) {
        String newLine;
        ArrayList<Cat> catsArray = new ArrayList();

        try {
            FileReader fileReader = new FileReader(filename);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((newLine = bufferedReader.readLine()) != null) {
                    String[] cat = newLine.split(",");
                    catsArray.add(new Cat(cat[0], Integer.parseInt(cat[1]), cat[2]));
                }
            }
            return catsArray;
        } catch (FileNotFoundException ex) {
            ex.toString();
        } catch (IOException ex) {
            ex.toString();
        }

        return catsArray;
    }
}
