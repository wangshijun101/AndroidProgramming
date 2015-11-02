package com.flying.HelloMoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by flying on 11/1/2015 0001.
 */
public class HelloMoonFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private AudioPlayer mPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);
        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mPlayer = new AudioPlayer();
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mPlayer.play(getActivity());
            }
        });
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
