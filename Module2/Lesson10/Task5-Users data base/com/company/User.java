package com.company;

import java.io.Serializable;

public class User implements Serializable{
    int id;
    String name;

    public User(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
