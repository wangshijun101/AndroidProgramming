package com.flying.HelloMoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by flying on 11/2/2015 0002.
 */
public class AudioPlayer {
    private MediaPlayer mediaPlayer;

    public void stop(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void play(Context c){
        stop();
        mediaPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mediaPlayer.start();

    }
}
