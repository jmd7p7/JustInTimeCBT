package com.jmd2479.justintimecbt.DataTransferObjects;

import com.jmd2479.justintimecbt.DataTransferObjects.ListItem;

import java.security.InvalidParameterException;

/**
 * Created by Jonathan on 10/25/2015.
 */
public class Consequence extends ListItem {
        public Consequence(int ConsequenceId, String Consequence) {
            super(ConsequenceId, Consequence);
        }

        public Consequence(String consequence, int parentId) throws InvalidParameterException {
            super(consequence, parentId);
        }
}
