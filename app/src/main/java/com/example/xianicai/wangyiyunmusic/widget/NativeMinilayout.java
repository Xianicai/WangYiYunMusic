package com.example.xianicai.wangyiyunmusic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xianicai.wangyiyunmusic.R;

/**
 * Created by Zhanglibin on 2017/3/30.
 */

public class NativeMinilayout extends RelativeLayout {

    private RelativeLayout mMinilayout;
    private ImageView mMiniLeftImge;
    private TextView mMiniName;
    private int mLeftImge;
    private String mName;
    private View mBottomView;
    private boolean mShowBottomView;
    private String mMiniNumber;
    private TextView mTvNumber;

    public void setSetMiniClickListener(SetMiniClickListener setMiniClickListener) {
        mSetMiniClickListener = setMiniClickListener;
    }

    private SetMiniClickListener mSetMiniClickListener;

    public NativeMinilayout(Context context) {
        this(context, null);
    }

    public NativeMinilayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NativeMinilayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NativeMinilayout);
        mLeftImge = typedArray.getResourceId(R.styleable.NativeMinilayout_miniLeftImge, 0);
        mName = typedArray.getString(R.styleable.NativeMinilayout_miniName);
        mMiniNumber = typedArray.getString(R.styleable.NativeMinilayout_miniNumber);
        mShowBottomView = typedArray.getBoolean(R.styleable.NativeMinilayout_showBottomView, true);
        typedArray.recycle();
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.native_mini_layout, this);
        mMinilayout = (RelativeLayout) findViewById(R.id.minilayout);
        mMiniLeftImge = (ImageView) findViewById(R.id.img_left);
        mMiniName = (TextView) findViewById(R.id.tv_miniName);
        mTvNumber = (TextView) findViewById(R.id.tv_number);
        mBottomView = (View) findViewById(R.id.bottom_view);
        mMiniLeftImge.setImageResource(mLeftImge);
        mMiniName.setText(mName);
        mTvNumber.setText("(0)");
        if (mShowBottomView) {
            mBottomView.setVisibility(VISIBLE);
        } else {
            mBottomView.setVisibility(GONE);
        }
        mMinilayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSetMiniClickListener != null) {
                    mSetMiniClickListener.onMiniClickListener(view);
                }
            }
        });
    }

    public interface SetMiniClickListener {
        void onMiniClickListener(View view);
    }

    public void setMiniLeftImge(int imge) {
        mMiniLeftImge.setImageResource(imge);
    }

    public void setMiniName(String name) {
        mMiniName.setText(name);
    }
    public void setMiniNumber(String number) {
        mTvNumber.setText("("+number+")");
    }
    public void showBottomView(Boolean show) {
        if (show) {
            mBottomView.setVisibility(VISIBLE);
        } else {
            mBottomView.setVisibility(GONE);
        }
    }
}
