package com.jmd2479.justintimecbt;

import java.util.List;

/**
 * Created by Jonathan on 10/12/2015.
 */
public abstract class ListItem {
    private int id;
    private String name;
    private int parentId;
    private int therapistId;

    public ListItem(int id, String name, int parentId, int therapistId){
        this.name = name;
        this.id = id;
        this.parentId = parentId;
        this.therapistId = therapistId;
    }

    public ListItem(int id, String name){
        this.name = name;
        this.id = id;
        this.parentId = -1;
        this.therapistId = -1;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public int getParentId(){return this.parentId;}
    public int getTherapistId(){return this.therapistId;}
}
