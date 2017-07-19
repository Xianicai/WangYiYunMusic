package com.example.xianicai.wangyiyunmusic.nativemusc.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xianicai.wangyiyunmusic.R;
import com.example.xianicai.wangyiyunmusic.nativemusc.MusicBean;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/7/19.
 */

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.SingleAdapterVH> {
    private Context mContext;
    private List<MusicBean> mMusicBeanList;

    public SingleAdapter(Context context, List<MusicBean> mMusicBeanList) {
        mContext = context;
        this.mMusicBeanList = mMusicBeanList;
    }

    @Override
    public SingleAdapterVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_single_fragment, parent, false);
        return new SingleAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(SingleAdapterVH holder, int position) {
        MusicBean musicBean = mMusicBeanList.get(position);
        holder.mTvName.setText(musicBean.getTitle());
        holder.mTvAuthor.setText(musicBean.getArtist());
    }

    @Override
    public int getItemCount() {
        return mMusicBeanList.size();
    }

    class SingleAdapterVH extends RecyclerView.ViewHolder {


        private final TextView mTvName;
        private final TextView mTvAuthor;
        private final ImageView mImageMore;

        public SingleAdapterVH(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
            mImageMore = (ImageView) itemView.findViewById(R.id.image_more);
        }
    }

}
