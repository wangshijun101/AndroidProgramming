package com.iwjw.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by flying on 9/23/2015 0023.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}