package com.example.xianicai.wangyiyunmusic.nativemusc.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.xianicai.wangyiyunmusic.R;
import com.example.xianicai.wangyiyunmusic.base.BaseActivity;
import com.example.xianicai.wangyiyunmusic.widget.CommonActionBar;

import butterknife.BindView;

public class NativeActivity extends BaseActivity {

    @BindView(R.id.action_bar)
    CommonActionBar mActionBar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private String[] mTitles = new String[]{"歌曲", "歌手", "专辑", "文件夹"};

    @Override
    public int getlayoutId() {
        return R.layout.activity_native;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
//        给TabLayout添加标签
        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles[i]));
        }
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public Fragment getItem(int position) {
                        Fragment fragment = null;
                        switch (position) {
                            case 0:
                                fragment = SingleFragment.newInstance();
                                break;
                            case 1:
                                fragment = SingleFragment.newInstance();
                                break;
                            case 2:
                                fragment = SingleFragment.newInstance();
                                break;
                            case 3:
                                fragment = SingleFragment.newInstance();
                                break;
                        }
                        return fragment;
                    }

                    @Override
                    public int getCount() {
                        return mTitles.length;
                    }

                    @Override
                    public CharSequence getPageTitle(int position) {
                        return mTitles[position];
                    }

                };
        mViewpager.setAdapter(fragmentPagerAdapter);
        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewpager);
    }

    public static void toNativeActivity(Context context) {
        context.startActivity(new Intent(context, NativeActivity.class));
    }
}
