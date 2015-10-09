package com.iwjw.criminalintent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import org.apache.http.impl.cookie.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by flying on 9/16/2015 0016.
 */
public class CrimeFragment extends Fragment{
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private final String TAG = "CrimeFragment";
    public static final String EXTRA_CRIME_ID = "com.iwjw.criminalintent.crime_id";

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG,"onAttach method called");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //method 1
//        UUID crimeId =(UUID)getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        //method 2
        UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);

        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

        Log.d(TAG,"onCreate method called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime,container,false);
        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);

        mTitleField.setText(mCrime.getMTitle());
        mDateButton.setText(DateUtils.formatDate(mCrime.getMDate(), "yyyy-MM-dd HH:mm:ss"));
        mDateButton.setEnabled(false);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setMSolved(isChecked);
            }
        });

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mCrime.setMTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //modified set the change data to the list object;
                mCrime.setMTitle(s.toString());
            }
        });
        Log.d(TAG, "onCreateView method called");

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated method called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart method called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume method called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause method called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop method called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView method called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy method called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach method called");
    }

}