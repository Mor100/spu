package com.spu.dong.spu.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {

    public String title;
    public String time;
    public String contenturl;
    public String imageurl;
    public boolean flag = false;

    public News(String title,String time,String contenturl,String imageurl){
        this.title = title;
        this.time = time;
        this.contenturl = contenturl;
        this.imageurl = imageurl;

    }

    protected News(Parcel in) {
        title = in.readString();
        time = in.readString();
        contenturl = in.readString();
        imageurl = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(time);
        parcel.writeString(contenturl);
        parcel.writeString(imageurl);
    }
}
