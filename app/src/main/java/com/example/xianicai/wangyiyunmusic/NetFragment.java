package com.example.xianicai.wangyiyunmusic;

import android.view.View;

import com.example.xianicai.wangyiyunmusic.base.BaseFragment;

/**
 * Created by Zhanglibin on 2017/7/13.
 */

public class NetFragment extends BaseFragment {
    public static NetFragment newInstance() {
        NetFragment fragment = new NetFragment();
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_net;
    }

    @Override
    protected void initView(View view) {

    }
}
