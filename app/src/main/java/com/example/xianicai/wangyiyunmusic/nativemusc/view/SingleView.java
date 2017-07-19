package com.example.xianicai.wangyiyunmusic.nativemusc.view;

import com.example.xianicai.wangyiyunmusic.base.basemvp.BaseView;
import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/7/19.
 */

public interface SingleView extends BaseView {
    void getNativeMusic(List<MusicBean>musicBeanList);
}
