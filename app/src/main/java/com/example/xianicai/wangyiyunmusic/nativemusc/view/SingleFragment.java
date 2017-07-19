package com.example.xianicai.wangyiyunmusic.nativemusc.view;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.xianicai.wangyiyunmusic.R;
import com.example.xianicai.wangyiyunmusic.base.BaseFragment;
import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;
import com.example.xianicai.wangyiyunmusic.nativemusc.presenter.NativeMusicPresenter;
import com.example.xianicai.wangyiyunmusic.nativemusc.view.adapter.SingleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Zhanglibin on 2017/7/19.
 */

public class SingleFragment extends BaseFragment implements SingleView {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private List<MusicBean> mMusicBeanList;
    private SingleAdapter mSingleAdapter;

    public static SingleFragment newInstance() {
        SingleFragment fragment = new SingleFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_single;
    }

    @Override
    protected void initView(View view) {
        mMusicBeanList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSingleAdapter = new SingleAdapter(getActivity(), mMusicBeanList);
        mRecyclerView.setAdapter(mSingleAdapter);

        NativeMusicPresenter presenter = new NativeMusicPresenter();
        presenter.bindView(this);
        presenter.getNativeMusic(getActivity());

    }

    @Override
    public void getNativeMusic(List<MusicBean> musicBeanList) {
        mMusicBeanList.clear();
        musicBeanList.addAll(musicBeanList);
        mSingleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMsg(String str) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void cancelLoadingDialog() {

    }
}
