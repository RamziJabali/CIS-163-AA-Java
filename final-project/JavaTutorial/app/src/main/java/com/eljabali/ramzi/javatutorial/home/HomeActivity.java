package com.eljabali.ramzi.javatutorial.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eljabali.ramzi.javatutorial.R;
import com.eljabali.ramzi.javatutorial.models.Topic;
import com.eljabali.ramzi.javatutorial.topic.TopicActivity;
import com.eljabali.ramzi.javatutorial.utilities.GsonUtil;
import com.eljabali.ramzi.javatutorial.utilities.ResourceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements TopicRecyclerViewAdapterListener {

    @BindView(R.id.rv_topic_list)
    RecyclerView rv_topic_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);//set layout to activity
        ButterKnife.bind(this);//binding views through butterKnife
        setupRecyclerView();//created a recyclerView

        TopicRecyclerViewAdapter adapter = new TopicRecyclerViewAdapter(getTopicsFromJson(), this);//tied the recycler view to the adapter
        rv_topic_list.setAdapter(adapter);//
    }

    private void setupRecyclerView() {
        rv_topic_list.setHasFixedSize(true);
        rv_topic_list.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Topic> getTopicsFromJson() {
        String lessonText = ResourceUtil.getRawString(this, R.raw.topics);
        return GsonUtil.getModelsFromJsonString(lessonText, Topic.class); // becomes an object of gun.class
    }

    @Override
    public void topicWasClicked(Topic topicClickedOn) {
        Intent myIntent = new Intent(HomeActivity.this, TopicActivity.class);
        myIntent.putExtras(TopicActivity.getArgumentsForLaunch(topicClickedOn));
        startActivity(myIntent);
    }
}
