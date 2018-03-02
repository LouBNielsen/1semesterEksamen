/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Interfaces.PersonInterface;
import java.util.ArrayList;

/**
 *
 * @author Louise Nielsen
 */
public class Person implements PersonInterface {

    private String name;
    private Cat cat;

    public Person(String name, Cat cat) {
        this.name = name;
        this.cat = cat;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Cat getPersonsCat() {
        return cat;
    }

    @Override
    public String toString() {
        return "Person: " + name + ", " + cat;
    }
    
    

}
