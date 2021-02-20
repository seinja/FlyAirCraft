package com.example.flyaircraft;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.background_song);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(.5f, .5f);
        mediaPlayer.seekTo(0);
        mediaPlayer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }


}