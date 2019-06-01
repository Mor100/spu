package com.spu.dong.spu.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyQuestionFocus implements Parcelable {


    public String title;
    public String content;
    public String contenturl;
    public String answer;
    public String gov;
    public String flag;
    public String imagetrueurl;

    public MyQuestionFocus(String title, String content, String contenturl,String answer,String gov,String flag,String imagetrueurl){
        this.title = title;
        this.content = content;
        this.contenturl = contenturl;
        this.answer = answer;
        this.gov = gov;
        this.flag = flag;
        this.imagetrueurl = imagetrueurl;

    }

    protected MyQuestionFocus(Parcel in) {
        title = in.readString();
        content = in.readString();
        contenturl = in.readString();
        answer = in.readString();
        gov = in.readString();
        flag = in.readString();
        imagetrueurl = in.readString();
    }

    public static final Creator<MyQuestionFocus> CREATOR = new Creator<MyQuestionFocus>() {
        @Override
        public MyQuestionFocus createFromParcel(Parcel in) {
            return new MyQuestionFocus(in);
        }

        @Override
        public MyQuestionFocus[] newArray(int size) {
            return new MyQuestionFocus[size];
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
        parcel.writeString(contenturl);
        parcel.writeString(answer);
        parcel.writeString(gov);
        parcel.writeString(flag);
        parcel.writeString(imagetrueurl);
    }
}
