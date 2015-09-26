package com.iwjw.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by flying on 9/23/2015 0023.
 */
public class CrimeListFragment extends ListFragment{
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getMCrimes();
        ArrayAdapter<Crime> adapter =
                new ArrayAdapter<>(getActivity(),android.R.layout.simple_expandable_list_item_1,
                        mCrimes);
        setListAdapter(adapter);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_crimes, container, false);
//        return v;
//    }
}
