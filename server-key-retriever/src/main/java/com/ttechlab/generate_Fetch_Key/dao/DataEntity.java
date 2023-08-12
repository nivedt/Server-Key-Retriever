package com.ttechlab.generate_Fetch_Key.dao;

//import javax.persistence.Entity;
import lombok.Data;

@Data
//@Entity
public class DataEntity {
	
	private long id;
    private String name;
    private int age;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString method

    @Override
    public String toString() {
        return "DataEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

