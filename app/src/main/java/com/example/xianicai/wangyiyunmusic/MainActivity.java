package com.example.xianicai.wangyiyunmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xianicai.wangyiyunmusic.base.BaseActivity;
import com.example.xianicai.wangyiyunmusic.nativemusc.view.NativeFragment;
import com.example.xianicai.wangyiyunmusic.widget.PicassoImageView;
import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;
import com.example.xianicai.wangyiyunmusic.utils.ListUtil;
import com.example.xianicai.wangyiyunmusic.utils.MusicUtil;
import com.example.xianicai.wangyiyunmusic.utils.PlayUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout mAppbar;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.iv_menu)
    ImageView mIvMenu;
    @BindView(R.id.image_search)
    ImageView mImageSearch;
    @BindView(R.id.bar_music)
    ImageView mBarMusic;
    @BindView(R.id.bar_net)
    ImageView mBarNet;
    @BindView(R.id.bar_friends)
    ImageView mBarFriends;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.image_cover)
    PicassoImageView mImageCover;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_author)
    TextView mTvAuthor;
    @BindView(R.id.image_play)
    ImageView mImagePlay;
    @BindView(R.id.image_next)
    ImageView mImageNext;
    private MediaPlayer mPlayer = new MediaPlayer();
    private List<MusicBean> mMusicBeanList = new ArrayList<>();
    private int mMusicIndex = 0;
    private MusicBean mMusicBean;

    @Override
    public int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        FragmentPagerAdapter fragmentPagerAdapter =
                new FragmentPagerAdapter(getSupportFragmentManager()) {
                    @Override
                    public int getCount() {
                        return 3;
                    }

                    @Override
                    public Fragment getItem(int position) {
                        if (position == 0) {
                            return NativeFragment.newInstance();
                        } else if (position == 1) {
                            return NetFragment.newInstance();
                        } else {
                            return TopicFragment.newInstance();
                        }
                    }
                };
        mViewpager.setAdapter(fragmentPagerAdapter);
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    setBarSelected(mBarMusic);
                } else if (position == 1) {
                    setBarSelected(mBarNet);
                } else if (position == 2) {
                    setBarSelected(mBarFriends);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //查找本地音乐
        initPlayer();
    }

    private void initPlayer() {
        mMusicBeanList = MusicUtil.getMusicData(this);
        if (ListUtil.isNotEmpty(mMusicBeanList)) {
            mMusicBean = mMusicBeanList.get(mMusicIndex);
            mTvAuthor.setText(mMusicBean.getArtist());
            mTvName.setText(mMusicBean.getTitle());
            mImageCover.setLocalImage(mMusicBean.getCoverPath());

        }

    }


    @OnClick({R.id.nav_view, R.id.drawer_layout, R.id.iv_menu, R.id.bar_music, R.id.bar_net, R.id.bar_friends,
            R.id.image_cover, R.id.tv_name, R.id.tv_author, R.id.image_play, R.id.image_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bar_music:
                mViewpager.setCurrentItem(0);
                break;
            case R.id.bar_net:
                mViewpager.setCurrentItem(1);
                break;
            case R.id.bar_friends:
                mViewpager.setCurrentItem(2);
                break;
            case R.id.nav_view:
                break;
            case R.id.drawer_layout:

                break;
            case R.id.iv_menu:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.image_cover:
                break;
            case R.id.tv_name:
                break;
            case R.id.tv_author:
                break;
            case R.id.image_play:
                if (PlayUtil.playerState == PlayUtil.PLAYER_IS_STOP) {
                    PlayUtil.play(mPlayer, mMusicBean);
                    mImagePlay.setImageResource(R.mipmap.ic_play_bar_btn_pause);
                } else if (PlayUtil.playerState == PlayUtil.PLAYER_IS_PLAYING) {
                    PlayUtil.pause(mPlayer);
                    mImagePlay.setImageResource(R.mipmap.ic_play_bar_btn_play);
                }
                break;
            case R.id.image_next:
                playNext();
                break;
        }
    }

    /**
     * 下一曲
     */
    private void playNext() {
        mMusicBeanList = MusicUtil.getMusicData(this);
        if ((mMusicBeanList.size() - 1) == mMusicIndex) {
            mMusicIndex = 0;
        } else {
            mMusicIndex++;
        }
        if (ListUtil.isNotEmpty(mMusicBeanList)) {
            mMusicBean = mMusicBeanList.get(mMusicIndex);
            PlayUtil.play(mPlayer, mMusicBean);
            mTvAuthor.setText(mMusicBean.getArtist());
            mTvName.setText(mMusicBean.getTitle());
            mImageCover.setLocalImage(mMusicBean.getCoverPath());
            mImagePlay.setImageResource(R.mipmap.ic_play_bar_btn_pause);
        }
    }

    private void setBarSelected(ImageView view) {
        mBarMusic.setSelected(false);
        mBarNet.setSelected(false);
        mBarFriends.setSelected(false);
        view.setSelected(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
