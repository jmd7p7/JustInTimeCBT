package com.jmd2479.justintimecbt;

import java.security.InvalidParameterException;

/**
 * Created by Jonathan on 11/8/2015.
 */
public class Rationalization extends ListItem {
    public Rationalization(int rationalizationId, String rationalization){
        super(rationalizationId, rationalization);
    }

    public Rationalization(String rationalization, int parentId) throws InvalidParameterException{
            super(rationalization, parentId);
    }
}
