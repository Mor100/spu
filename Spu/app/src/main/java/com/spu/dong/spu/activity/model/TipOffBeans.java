package com.spu.dong.spu.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TipOffBeans implements  Parcelable{

    public String title;
    public String phone;
    public String content;
    public String imageurl;
    public String time;
    public String brownum;
    public String contenturl;
    public boolean flag = false;

    public TipOffBeans(String title,String phone,String content,String imageurl,String time,String brownum,String contenturl){
        this.title = title;
        this.phone = phone;
        this.content = content;
        this.imageurl = imageurl;
        this.time = time;
        this.brownum = brownum;
        this.contenturl = contenturl;

    }

    protected TipOffBeans(Parcel in) {
        title = in.readString();
        phone = in.readString();
        content = in.readString();
        imageurl = in.readString();
        time = in.readString();
        brownum = in.readString();
        contenturl = in.readString();
        flag = in.readByte() != 0;
    }

    public static final Creator<TipOffBeans> CREATOR = new Creator<TipOffBeans>() {
        @Override
        public TipOffBeans createFromParcel(Parcel in) {
            return new TipOffBeans(in);
        }

        @Override
        public TipOffBeans[] newArray(int size) {
            return new TipOffBeans[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(phone);
        parcel.writeString(content);
        parcel.writeString(imageurl);
        parcel.writeString(time);
        parcel.writeString(brownum);
        parcel.writeString(contenturl);
        parcel.writeByte((byte) (flag ? 1 : 0));
    }
}
