package com.example.xianicai.wangyiyunmusic.nativemusc.presenter;

import android.content.Context;

import com.example.xianicai.wangyiyunmusic.base.basemvp.BasePresenterImpl;
import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;
import com.example.xianicai.wangyiyunmusic.nativemusc.model.impl.ImplNativeMusicModel;
import com.example.xianicai.wangyiyunmusic.nativemusc.view.SingleView;
import com.example.xianicai.wangyiyunmusic.utils.ListUtil;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/7/19.
 */

public class NativeMusicPresenter extends BasePresenterImpl<SingleView> {

    private final ImplNativeMusicModel mImplNativeMusicModel;

    public NativeMusicPresenter() {
        mImplNativeMusicModel = new ImplNativeMusicModel();
    }

    public void getNativeMusic(Context context) {
        List<MusicBean> nativeMusic = mImplNativeMusicModel.getNativeMusic(context);
        if (ListUtil.isNotEmpty(nativeMusic)) {
            getView().getNativeMusic(nativeMusic);
        }
    }
}
