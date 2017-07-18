package com.example.xianicai.wangyiyunmusic.utils;

import android.media.MediaPlayer;

import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;

import java.io.IOException;

/**
 * Created by Zhanglibin on 2017/7/14.
 */

public class PlayUtil {
    public static final int PLAYER_IS_PLAYING = 1;
    public static final int PLAYER_IS_PAUSE = 2;
    public static final int PLAYER_IS_STOP = 3;
    public static int playerState = PLAYER_IS_STOP;

    /**
     * 开始播放音乐
     *
     * @param mPlayer 播放器
     * @param music   播放歌曲
     */
    public static void play(MediaPlayer mPlayer, MusicBean music) {
        try {
            mPlayer.reset();
            mPlayer.setDataSource(music.getPath());
            mPlayer.prepare();
            mPlayer.start();
            playerState = PLAYER_IS_PLAYING;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停播放音乐
     *
     * @param mPlayer 播放器
     */
    public static void pause(MediaPlayer mPlayer) {
        mPlayer.pause();
        playerState = PLAYER_IS_PAUSE;
    }

    /**
     * 继续播放音乐
     *
     * @param mPlayer 播放器
     */
    private void resume(MediaPlayer mPlayer) {

        mPlayer.start();
        playerState = PLAYER_IS_PLAYING;
    }

    /**
     * 停止播放音乐
     *
     * @param mPlayer 播放器
     */
    public static void stop(MediaPlayer mPlayer) {

        pause(mPlayer);
        mPlayer.reset();
        playerState = PLAYER_IS_STOP;
    }

    /**
     * 获取播放器状态
     */
    public static int getplayerState() {
        return playerState;
    }
}
