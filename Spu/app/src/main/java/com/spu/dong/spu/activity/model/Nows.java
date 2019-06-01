package com.spu.dong.spu.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Nows  implements Parcelable{

    public String title;
    public String time;
    public String dealflag;
    public String gov;
    public String topflag;
    public String ask;
    public String answer;
    public String imageurl;
    public boolean flag = false;

    public Nows(String title,String time,String dealflag,String gov,String topflag,String ask,String answer,String imageurl){
        this.title = title;
        this.time = time;
        this.dealflag = dealflag;
        this.gov = gov;
        this.topflag = topflag;
        this.ask = ask;
        this.answer = answer;
        this.imageurl = imageurl;

    }

    protected Nows(Parcel in) {
        title = in.readString();
        time = in.readString();
        dealflag = in.readString();
        gov = in.readString();
        topflag = in.readString();
        ask = in.readString();
        answer = in.readString();
        imageurl = in.readString();
    }

    public static final Creator<Nows> CREATOR = new Creator<Nows>() {
        @Override
        public Nows createFromParcel(Parcel in) {
            return new Nows(in);
        }

        @Override
        public Nows[] newArray(int size) {
            return new Nows[size];
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
        parcel.writeString(dealflag);
        parcel.writeString(gov);
        parcel.writeString(topflag);
        parcel.writeString(ask);
        parcel.writeString(answer);
        parcel.writeString(imageurl);
    }
}
