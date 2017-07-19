package com.example.xianicai.wangyiyunmusic.nativemusc.model;

import android.content.Context;

import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/7/19.
 */

public interface NativeMusicModel {
    List<MusicBean> getNativeMusic(Context context);
}
