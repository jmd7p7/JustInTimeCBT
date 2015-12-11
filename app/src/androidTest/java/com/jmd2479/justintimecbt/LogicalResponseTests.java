package com.jmd2479.justintimecbt;

import com.jmd2479.justintimecbt.Data.JITDatabaseAdapter;
import com.jmd2479.justintimecbt.DataTransferObjects.ListItem;
import com.jmd2479.justintimecbt.DataTransferObjects.LocicalResponse;

import java.util.ArrayList;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class LogicalResponseTests extends android.test.AndroidTestCase {

    public void testGetLogicalResponsesByRationalizationId() {
        //arrange
        ArrayList<ListItem> logicalResponses;
        JITDatabaseAdapter dbAdapter = new JITDatabaseAdapter(getContext());
        dbAdapter.deleteAllLogicalResponses();
        dbAdapter.insertLogicalResponseByRationalizationId(new LocicalResponse("Don't do it!", 3));

        //act
        logicalResponses = dbAdapter.getLogicalResponsesByRationalizationId(3);

        //assert
        assertEquals("Don't do it!", logicalResponses.get(0).getName());
    }
}
