package com.eljabali.ramzi.javatutorial.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.workday.postman.Postman;
import com.workday.postman.annotations.Parceled;

@Parceled
public class Topic implements Parcelable {
    public Topic() {}

    String title;
    String description;
    String lesson;

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static final Creator<Topic> CREATOR = Postman.getCreator(Topic.class);

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Postman.writeToParcel(this, dest);
    }
}
