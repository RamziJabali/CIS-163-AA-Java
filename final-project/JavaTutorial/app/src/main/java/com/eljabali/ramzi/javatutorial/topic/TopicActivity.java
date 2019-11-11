package com.eljabali.ramzi.javatutorial.topic;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.eljabali.ramzi.javatutorial.R;
import com.eljabali.ramzi.javatutorial.models.Topic;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicActivity extends AppCompatActivity {

    private static final String TOPIC_TO_SHOW = "topic-to-show";

    public static Bundle getArgumentsForLaunch(Topic topicToShow) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TOPIC_TO_SHOW, topicToShow);
        return bundle;
    }

    @BindView(R.id.tv_lesson)
    TextView tv_lesson;

    @BindView(R.id.iv_topic_pic)
    ImageView iv_topic_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        showBackButton();
        ButterKnife.bind(this);
        showTopicDetails();
    }

    private void showBackButton() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    private Topic getTopicFromArguments() {
        return getIntent().getExtras().getParcelable(TOPIC_TO_SHOW);
    }

    private void showTopicDetails() {
        final Topic topicToShow = getTopicFromArguments();
        getSupportActionBar().setTitle(topicToShow.getTitle());
        tv_lesson.setText(topicToShow.getLesson());
        // TODO: Show image
    }
}
