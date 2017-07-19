package com.example.xianicai.wangyiyunmusic.nativemusc.model.impl;

import android.content.Context;

import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;
import com.example.xianicai.wangyiyunmusic.nativemusc.model.NativeMusicModel;
import com.example.xianicai.wangyiyunmusic.utils.MusicUtil;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/7/19.
 */

public class ImplNativeMusicModel implements NativeMusicModel {
    @Override
    public List<MusicBean> getNativeMusic(Context context) {
        return MusicUtil.getMusicData(context);
    }
}
