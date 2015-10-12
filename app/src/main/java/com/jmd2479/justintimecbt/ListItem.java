package com.jmd2479.justintimecbt;

/**
 * Created by Jonathan on 10/12/2015.
 */
public abstract class ListItem {
    int id;
    String name;
    public ListItem(int id, String name){
        this.name = name;
        this.id = id;
    }
}
