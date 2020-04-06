package chapter8.serialization;

import java.io.Serializable;

public class Plant implements Serializable {

    private static final long serialVersionUID = 1L;
    private transient String name;
    private transient int age = 10;
    private static char type = 'C';

    {this.age = 14;}

    public Plant() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    public Plant(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public char getType() {
        return type;
    }

    public String toString() {
       return "Plant [name=" + name + ", age=" + age + ", type=" + type + "]";
    }

}
