/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Louise Nielsen
 */
public interface CatInterface {

    public void setName(String name);

    public String getName();

    public void setAge(int age);

    public int getAge();

    public void setColor(String color);

    public String getColor();
    
    public boolean isSick();
    
    public void setIsSick(boolean isSick);
}
