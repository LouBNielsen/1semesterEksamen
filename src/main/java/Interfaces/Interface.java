/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Cat;
import java.util.ArrayList;

/**
 *
 * @author Louise Nielsen
 */
public interface Interface {

    /**
     * *
     * @return The name of the cat(s) that is sick.
     */
    public String isCatSick();

    /**
     * If a cat from the ArrayList of Cats is sick, remove the cat from the
     * ArrayList
     */
    public void removeSickCat();

    /**
     * @return The name of the oldest cat from the ArrayList of Cats
     */
    public String getOldestCat();

    /**
     * @return the name of the cat that is owned by the person named Thomas,
     * from the ArrayList of Persons
     */
    public String getPersonsCat();

    /**
     * @return a new ArrayList of Strings, only containing the names of the cats
     * from the ArrayList of Cats
     */
    public ArrayList<String> catNamesList();

    /**
     * @param name Is the Cats new name. If the cat's age is 5, then change the
     * name to a new cat name
     */
    public void setCatName(String name);

    /**
     * @param isSick Should be set to true, when calling the method.
     * @return The name of the cat that is now sick. If the cat is over 15 years
     * old and if the cat's color is not white, then the cat's health should be
     * set as sick.
     */
    public String setCatHealh(boolean isSick);

    /**
     * @param filename The name of the file to be read
     * @return The file content as a String
     */
    public String getCatsFromFile(String filename);

    /**
     * @param filename The name of the file to be read Create a new Cat and
     * write it to the file
     */
    public void addCatToFile(String filename);

    /**
     *
     * @param filename The name of the file to be read The file content should
     * be read as a String Append the content of the file to a new ArrayList of
     * Strings
     * @return the new ArrayList of Strings with the content from the file
     */
    public ArrayList<String> writeCatsFromFileToList(String filename);

}
