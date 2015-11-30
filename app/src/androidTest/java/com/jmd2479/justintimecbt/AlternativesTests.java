package com.jmd2479.justintimecbt;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class AlternativesTests extends android.test.AndroidTestCase {

    public void testGetAlternativesByBehaviorId(){
        //Arrange
        ArrayList<ListItem> alternatives;
        JITDatabaseAdapter dbAdapter = new JITDatabaseAdapter(getContext());
        dbAdapter.deleteAllAlternatives();
        dbAdapter.insertAlternativeByBehaviorId(new Alternative("Exercise", 1));

        //Act
        alternatives = dbAdapter.getAlternativesByBehaviorId(1);

        //Assert
        assertEquals("Exercise", alternatives.get(0).getName());
    }

    //Test Class Helper Methods

}
