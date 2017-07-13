package com.example.xianicai.wangyiyunmusic;

import android.view.View;

import com.example.xianicai.wangyiyunmusic.base.BaseFragment;

/**
 * Created by Zhanglibin on 2017/7/13.
 */

public class TopicFragment extends BaseFragment {
    public static TopicFragment newInstance() {
        TopicFragment fragment = new TopicFragment();
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initView(View view) {

    }
}
