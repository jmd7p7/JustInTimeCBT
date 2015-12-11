package com.jmd2479.justintimecbt.DataTransferObjects;

import java.security.InvalidParameterException;

/**
 * Created by Jonathan on 11/29/2015.
 */
public class LocicalResponse extends ListItem {
    public LocicalResponse(int LocicalResponseId, String LocicalResponse) {
        super(LocicalResponseId, LocicalResponse);
    }

    public LocicalResponse(String LocicalResponse, int parentId) throws InvalidParameterException {
        super(LocicalResponse, parentId);
    }
}
