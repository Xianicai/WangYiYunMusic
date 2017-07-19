package com.example.xianicai.wangyiyunmusic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xianicai.wangyiyunmusic.R;
import com.example.xianicai.wangyiyunmusic.utils.StringUtil;

/**
 * Created by Zhanglibin on 2017/7/18.
 */

public class CommonActionBar extends LinearLayout {

    private int mRightImage;
    private String mTitle;
    private int mLeftImage;

    private SetActionbarClickListener mActionbarClickListener;
    private ImageView mMImageLeft;
    private TextView mTvTitle;
    private ImageView mImageLeft;
    private ImageView mImageRight;

    public void setActionbarClickListener(SetActionbarClickListener actionbarClickListener) {
        mActionbarClickListener = actionbarClickListener;
    }

    public CommonActionBar(Context context) {
        this(context, null);
    }

    public CommonActionBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonActionBar);
        mRightImage = typedArray.getResourceId(R.styleable.CommonActionBar_imageLeft, 0);
        mTitle = typedArray.getString(R.styleable.CommonActionBar_title);
        mLeftImage = typedArray.getResourceId(R.styleable.CommonActionBar_imageLeft, 0);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.common_action_bar, this);
        mImageLeft = (ImageView) findViewById(R.id.image_left);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mImageRight = (ImageView) findViewById(R.id.image_right);
        if (mRightImage == 0) {
            mImageRight.setImageResource(R.mipmap.actionbar_more);
        } else {
            mImageRight.setImageResource(mRightImage);
        }
        if (mLeftImage == 0) {
            mImageLeft.setImageResource(R.mipmap.icon_back);
        } else {
            mImageLeft.setImageResource(mLeftImage);
        }
        mTvTitle.setText(mTitle);
        mImageRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mActionbarClickListener != null) {
                    mActionbarClickListener.onRightClickListener();
                }
            }
        });
        mImageLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mActionbarClickListener != null) {
                    mActionbarClickListener.onLeftClickListener();
                }
            }
        });
    }

    public void setRightImage(int rightImage) {
        mImageRight.setImageResource(rightImage);
    }

    public void setImageLeft(int leftImage) {
        mImageLeft.setImageResource(leftImage);
    }

    public void setTitle(String title) {
        if (StringUtil.isNotEmpty(title)) {
            mTvTitle.setText(title);
        }
    }

    public interface SetActionbarClickListener {
        void onRightClickListener();

        void onLeftClickListener();
    }
}
