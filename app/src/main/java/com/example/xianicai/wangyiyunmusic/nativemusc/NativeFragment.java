package com.example.xianicai.wangyiyunmusic.nativemusc;

import android.view.View;

import com.example.xianicai.wangyiyunmusic.R;
import com.example.xianicai.wangyiyunmusic.base.BaseFragment;
import com.example.xianicai.wangyiyunmusic.utils.MusicUtil;
import com.example.xianicai.wangyiyunmusic.widget.NativeMinilayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/7/13.
 */

public class NativeFragment extends BaseFragment implements NativeMinilayout.SetMiniClickListener {
    @BindView(R.id.tv_native)
    NativeMinilayout mTvNative;
    @BindView(R.id.tv_lately)
    NativeMinilayout mTvLately;
    @BindView(R.id.tv_download)
    NativeMinilayout mTvDownload;
    @BindView(R.id.tv_receiver)
    NativeMinilayout mTvReceiver;
    @BindView(R.id.tv_collect)
    NativeMinilayout mTvCollect;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.tv_like)
    NativeMinilayout mTvLike;

    public static NativeFragment newInstance() {
        NativeFragment fragment = new NativeFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_native;
    }

    @Override
    protected void initView(View view) {
        List<MusicBean> musicBeanList = MusicUtil.getMusicData(getActivity());
        mTvNative.setMiniNumber(musicBeanList.size() + "");
        mTvNative.setSetMiniClickListener(new NativeMinilayout.SetMiniClickListener() {
            @Override
            public void onMiniClickListener(View view) {
                NativeActivity.toNativeActivity(getActivity());

            }
        });
    }


    @Override
    public void onMiniClickListener(View view) {
        switch (view.getId()) {
            case R.id.tv_native:
                break;
            case R.id.tv_lately:
                break;
            case R.id.tv_download:
                break;
            case R.id.tv_receiver:
                break;
            case R.id.tv_collect:
                break;
            case R.id.view:
                break;
            case R.id.tv_like:
                break;
        }
    }
}
