package com.eljabali.ramzi.javatutorial.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eljabali.ramzi.javatutorial.R;
import com.eljabali.ramzi.javatutorial.models.Topic;

import java.util.List;

public class TopicRecyclerViewAdapter extends RecyclerView.Adapter<TopicItemViewHolder>{

    private final List<Topic> topicList;
    private final TopicRecyclerViewAdapterListener listener;

    public TopicRecyclerViewAdapter(List <Topic> topicList, TopicRecyclerViewAdapterListener listener){//constructor
        this.topicList = topicList;//data list of topics
        this.listener = listener;
    }

    @NonNull
    @Override
    public TopicItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {//given position return the item viewHolder type
        View viewHolder = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_topic, parent, false);
        return new TopicItemViewHolder(viewHolder);//only returning only TopicItemViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull TopicItemViewHolder topicItemViewHolder, int position) {//we map the data at the position with TopicItemViewHolder type
        final Topic topicAtPosition = topicList.get(position);//topic at position is being given the topic list index position
        topicItemViewHolder.tv_topic_name.setText(topicAtPosition.getTitle());//sets the text of the viewHolder's title to the topic at positions title
        topicItemViewHolder.tv_description.setText(topicAtPosition.getDescription());
        topicItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.topicWasClicked(topicAtPosition);
            }
        });
        //TODO: Add image
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }
}
