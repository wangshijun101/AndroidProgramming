package com.iwjw.criminalintent;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * Created by flying on 9/15/2015 0015.
 */
@Data
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;


    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
