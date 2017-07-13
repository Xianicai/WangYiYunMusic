package com.example.xianicai.wangyiyunmusic;

import android.view.View;

import com.example.xianicai.wangyiyunmusic.base.BaseFragment;

/**
 * Created by Zhanglibin on 2017/7/13.
 */

public class NativeFragment extends BaseFragment {
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

    }
}
