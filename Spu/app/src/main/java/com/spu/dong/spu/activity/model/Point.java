package com.spu.dong.spu.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable{

    private float x;
    private float y;
    public Point(float x,float y){
        this.x = x;
        this.y = y;
    }

    protected Point(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
    }

    public static final Creator<Point> CREATOR = new Creator<Point>() {
        @Override
        public Point createFromParcel(Parcel in) {
            return new Point(in);
        }

        @Override
        public Point[] newArray(int size) {
            return new Point[size];
        }
    };

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(x);
        parcel.writeFloat(y);
    }
}
