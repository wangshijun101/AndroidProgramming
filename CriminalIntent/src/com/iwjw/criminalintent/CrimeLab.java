package com.iwjw.criminalintent;

import android.content.Context;
import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by flying on 9/22/2015 0022.
 */
@Data
public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<>();
        for(int i = 0;i<100;i++){
            Crime c = new Crime();
            c.setmTitle("Crime #" + i);
            c.setmSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public Crime getCrime(UUID id){
        for(Crime c : mCrimes){
            if(c.getmId().equals(id))
                return c;
        }
        return null;
    }
}
