package com.spu.dong.spu.activity.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.spu.dong.spu.activity.activity.MyFocusActivity;

import java.io.Serializable;

public class MyQuestion  implements Parcelable{


    public String title;
    public String content;
    public String bitmap;

    public MyQuestion(String title,String content,String bitmap){
        this.title = title;
        this.content = content;
        this.bitmap = bitmap;

    }

    protected MyQuestion(Parcel in) {
        title = in.readString();
        content = in.readString();
        bitmap = in.readString();
    }

    public static final Creator<MyQuestion> CREATOR = new Creator<MyQuestion>() {
        @Override
        public MyQuestion createFromParcel(Parcel in) {
            return new MyQuestion(in);
        }

        @Override
        public MyQuestion[] newArray(int size) {
            return new MyQuestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(bitmap);
    }
}
