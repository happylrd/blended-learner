package io.happylrd.childishscorems.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import io.happylrd.childishscorems.R;
import io.happylrd.childishscorems.model.ActivityBean;
import io.happylrd.childishscorems.ui.ActDetailActivity;

public class ActivityBeanAdapter extends RecyclerView.Adapter<ActivityBeanAdapter.ViewHolder> {

    private Context mContext;

    private List<ActivityBean> mActivityBeanList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mCardView;
        private TextView mNameText;
        private TextView mScoreText;
        private TextView mDescText;
        private TextView mStartTimeText;
        private TextView mEndTimeText;
        private CheckBox mHasPassedCheck;

        public ViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView;
            mNameText = (TextView) itemView.findViewById(R.id.tv_name);
            mScoreText = (TextView) itemView.findViewById(R.id.tv_score);
            mDescText = (TextView) itemView.findViewById(R.id.tv_desc);
            mStartTimeText = (TextView) itemView.findViewById(R.id.tv_start_time);
            mEndTimeText = (TextView) itemView.findViewById(R.id.tv_end_time);
            mHasPassedCheck = (CheckBox) itemView.findViewById(R.id.cb_has_passed);
        }

        public void bindActivityBean(ActivityBean activityBean) {
            mNameText.setText(activityBean.getName());
            mScoreText.setText(activityBean.getScore());
            mDescText.setText(activityBean.getDesc());

            //TODO:
            mStartTimeText.setText(activityBean.getStartTime().toString());
            mEndTimeText.setText(activityBean.getEndTime().toString());
            mHasPassedCheck.setChecked(activityBean.getHasPassed());
        }
    }

    public ActivityBeanAdapter(List<ActivityBean> activityBeanList) {
        mActivityBeanList = activityBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_act, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                ActivityBean activityBean = mActivityBeanList.get(position);

                mContext.startActivity(ActDetailActivity
                        .newIntent(mContext, activityBean.getId()));
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ActivityBean activityBean = mActivityBeanList.get(position);
        holder.bindActivityBean(activityBean);
    }

    @Override
    public int getItemCount() {
        return mActivityBeanList.size();
    }
}
