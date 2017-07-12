package com.example.xianicai.wangyiyunmusic.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.xianicai.wangyiyunmusic.R;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Zhanglibin on 2017/7/12.
 */

public class PicassoImageView extends android.support.v7.widget.AppCompatImageView {

    private int mArrayResourceId;
    private Context mCon;

    public PicassoImageView(Context context) {
        this(context, null);
    }

    public PicassoImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PicassoImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCon = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PicassoImageView);
        mArrayResourceId = array.getResourceId(R.styleable.PicassoImageView_placeholderImage, 0);
        array.recycle();
        if (mArrayResourceId != 0) {
            setImageResource(mArrayResourceId);
        }
    }

    public void setImage(String url) {
        if (mArrayResourceId != 0) {
            Picasso.with(mCon).load(url)
                    .placeholder(mArrayResourceId)
                    .fit()
                    .centerCrop()
                    .into(this);
        }

    }
}
