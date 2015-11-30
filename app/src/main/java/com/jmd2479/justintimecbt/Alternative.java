package com.jmd2479.justintimecbt;

import com.jmd2479.justintimecbt.ListItem;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class Alternative extends ListItem {
    public Alternative(int alternativeId, String alternative) {
        super(alternativeId, alternative);
    }

    public Alternative(String alternative, int parentId) throws InvalidParameterException {
        super(alternative, parentId);
    }
}
