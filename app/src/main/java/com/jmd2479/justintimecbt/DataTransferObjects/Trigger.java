package com.jmd2479.justintimecbt.DataTransferObjects;

import java.security.InvalidParameterException;

/**
 * Created by Jonathan on 10/11/2015.
 */
public class Trigger extends ListItem{

    public Trigger(int triggerId, String trigger){
        super(triggerId, trigger);
    }

    public Trigger(String trigger, int parentId) throws InvalidParameterException {
        super(trigger, parentId);
    }
}
