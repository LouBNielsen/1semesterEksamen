/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Interfaces.CatInterface;

/**
 *
 * @author Louise Nielsen
 */
public class Cat implements CatInterface {

    private String name;
    private int age;
    private String color;
    private boolean isSick;

    public Cat(String name, int age, String color, boolean isSick) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.isSick = isSick;
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean isSick() {
        return isSick;
    }

    @Override
    public void setIsSick(boolean isSick) {
        this.isSick = isSick;
    }

    @Override
    public String toString() {
        return "Cat: " + name + ", " + age + ", " + color;
    }

}
