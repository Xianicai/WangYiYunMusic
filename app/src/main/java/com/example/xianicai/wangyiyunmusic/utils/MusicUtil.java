package com.example.xianicai.wangyiyunmusic.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.audiofx.AudioEffect;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhanglibin on 2017/7/14.
 */

public class MusicUtil {
    /**
     * 扫描系统里面的音频文件，返回一个list集合
     */
    public static List<MusicBean> getMusicData(Context context) {
        List<MusicBean> list = new ArrayList<MusicBean>();
        // 媒体库查询语句（写一个工具类MusicUtils）
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                MusicBean musicBean = new MusicBean();
                musicBean.setFileName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
                musicBean.setArtist(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
                musicBean.setPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                musicBean.setId(cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
                musicBean.setType(MusicBean.Type.LOCAL);
                musicBean.setTitle(cursor.getString((cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))));
                musicBean.setAlbum(cursor.getString((cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM))));
                musicBean.setDuration(cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)));
                long albumId = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                String coverPath = getCoverPath(context, albumId);
                musicBean.setCoverPath(coverPath);
                musicBean.setFileSize(cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE)));
                if (musicBean.getFileSize() > 1000 * 800) {
                    // 注释部分是切割标题，分离出歌曲名和歌手 （本地媒体库读取的歌曲信息不规范）
                    if (musicBean.getFileName().contains("-")) {
                        String[] str = musicBean.getFileName().split("-");
                        musicBean.setArtist(str[0]);
                        musicBean.setFileName(str[1]);
                    }
                    list.add(musicBean);
                }
            }
            // 释放资源
            cursor.close();
        }

        return list;
    }

    /**
     * 定义一个方法用来格式化获取到的时间
     */
    public static String formatTime(int time) {
        if (time / 1000 % 60 < 10) {
            return time / 1000 / 60 + ":0" + time / 1000 % 60;

        } else {
            return time / 1000 / 60 + ":" + time / 1000 % 60;
        }

    }


    public static boolean isAudioControlPanelAvailable(Context context) {
        return isIntentAvailable(context, new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL));
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().resolveActivity(intent, PackageManager.GET_RESOLVED_FILTER) != null;
    }

    private static String getCoverPath(Context context, long albumId) {
        String path = null;
        Cursor cursor = context.getContentResolver().query(
                Uri.parse("content://media/external/audio/albums/" + albumId),
                new String[]{"album_art"}, null, null, null);
        if (cursor != null) {
            if (cursor.moveToNext() && cursor.getColumnCount() > 0) {
                path = cursor.getString(0);
            }
            cursor.close();
        }
        return path;
    }

}
