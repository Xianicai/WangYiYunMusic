package com.example.xianicai.wangyiyunmusic.base.basemvp;

/**
 * Created by Zhanglibin on 2017/4/19.
 */

public interface BasePresenter <T extends BaseView> {
    void bindView(T view);

    T getView();

    void release();
}
