/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Cat;
import Entity.Person;
import java.util.ArrayList;

/**
 *
 * @author Louise Nielsen
 */
public interface Interface {

    /**
     * Exercice: Return the names of the cats who are sick
     * @param cats The list of Cats
     * @return The cat names as a String
     */
    public String getNameOfSickCats(ArrayList<Cat> cats);

    /**
     * Exercise: If a cat is sick, remove the cat from the ArrayList of Cats
     * @param cats The list of cats
     * @return A boolean telling if a cat has been removed
     */
    public boolean removeSickCat(ArrayList<Cat> cats);

    /**
     * Exercise: Return the name of the oldest cat
     * @param cats The list of cats
     * @return The name as a String
     */
    public String getOldestCat(ArrayList<Cat> cats);

    /**
     * Exercise: Find the name of the cat owned by a person
     * @param persons The list of persons
     * @param name The name of the person
     * @return The name of the cat that is owned by the person as a String
     */
    public String getPersonsCat(ArrayList<Person> persons, String name);

    /**
     * Exercise: Get only the names of the cats from the ArrayList of Cats and put the names into a new ArrayList
     * @param cats The list of cats
     * @return An ArrayList of Strings
     */
    public ArrayList<String> catNamesList(ArrayList<Cat> cats);

    /**
     * Exercise: If a cat is 5 years old, then it should be possible to change that cats name
     * @param cats The list of cats
     * @param name The new name of the cat
     */
    public void setCatName(ArrayList<Cat> cats, String name);

    /**
     * Exercise: If the cat is older that 15 years and the cats color is not white, 
     * then it should be possible to set the cats health as sick
     * @param cats The list of cats
     * @param isSick Should be set to true, when calling the method, to set the cats health as sick
     * @return The name of the cat, that is now sick, as a String 
     */
    public String setCatHealh(ArrayList<Cat> cats, boolean isSick);

    /**
     * Exercise: Read the file 'Cats.txt'
     * @param filename The name of the file to be read
     * @return The file content as a String
     */
    public String readCatFile(String filename);

    /**
     * Exercise: Create a new cat and add/write it to the file as a String
     * @param cat The new cat
     * @param filename The name of the file to be written to
     */
    public void addCatToFile(Cat cat, String filename);

    /**
     * Exercise: Create a new ArrayList of Cats, read the file 'Cats.txt' content as a String and split it, 
     * so that is is possible to create a new cat object from the content
     * @param filename The name of the file to be read
     * @return The new ArrayList of Cats containing the new cats from the file
     */
    public ArrayList<Cat> writeCatsFromFileToList(String filename);

}
