package com.example.xianicai.wangyiyunmusic.utils;

import android.media.MediaPlayer;

import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;

import java.io.IOException;

/**
 * Created by Zhanglibin on 2017/7/14.
 */

public class PlayUtil {
    public static void play(MediaPlayer mPlayer, MusicBean music) {
        try {
            mPlayer.reset();
            mPlayer.setDataSource(music.getPath());
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pause(MediaPlayer mPlayer) {
        mPlayer.pause();
    }
}
