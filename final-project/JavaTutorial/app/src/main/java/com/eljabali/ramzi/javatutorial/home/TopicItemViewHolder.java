package com.eljabali.ramzi.javatutorial.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eljabali.ramzi.javatutorial.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_topic_name)
    TextView tv_topic_name;

    @BindView(R.id.tv_description)
    TextView tv_description;

    @BindView(R.id.iv_topic_pic)
    ImageView iv_topic_pic;

    public TopicItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
