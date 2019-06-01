package com.spu.dong.spu.activity.cache;

import com.spu.dong.spu.activity.model.MyQuestion;
import com.spu.dong.spu.activity.model.MyQuestionFocus;
import com.spu.dong.spu.activity.model.News;
import com.spu.dong.spu.activity.model.Nows;
import com.spu.dong.spu.activity.model.TipOffBeans;

import java.util.ArrayList;

public class LocationCache {


    private static LocationCache locationCache;

    private LocationCache(){

    }
    private ArrayList<News> newsList = new ArrayList<>();
    public static LocationCache getLocationCache() {

        if(locationCache == null){
            synchronized (LocationCache.class){
                if(locationCache == null){
                    locationCache = new LocationCache();
                }
            }
        }
        return locationCache;
    }

    public ArrayList<News> getList() {
        return newsList;
    }

    public void setList(ArrayList<News> list) {
        this.newsList = list;
    }

    private ArrayList<News> textList;

    public ArrayList<News> getTextList() {
        return textList;
    }

    public void setTextList(ArrayList<News> textList) {
        this.textList = textList;
    }

    private ArrayList<News> ningList;
    public void setNingList(ArrayList<News> ningList) {
        this.ningList = ningList;
    }

    public ArrayList<News> getNingList() {
        return ningList;
    }

    private ArrayList<News> powerList;
    public void setPowerList(ArrayList<News> powerList) {
        this.powerList = powerList;
    }

    public ArrayList<News> getPowerList() {
        return powerList;
    }

    private ArrayList<Nows> nowsList;
    public void setNowsList(ArrayList<Nows> nowsList) {
        this.nowsList = nowsList;
    }

    public ArrayList<Nows> getNowsList() {
        return nowsList;
    }

    private ArrayList<TipOffBeans> tipList;
    public void setTipList(ArrayList<TipOffBeans> tipList) {
        this.tipList = tipList;
    }

    public ArrayList<TipOffBeans> getTipList() {
        return tipList;
    }

    private ArrayList<TipOffBeans> topLife;
    public void setTopLife(ArrayList<TipOffBeans> topLife) {
        this.topLife = topLife;
    }

    public ArrayList<TipOffBeans> getTopLife() {
        return topLife;
    }

    private ArrayList<MyQuestion> questionList = new ArrayList<>();
    public ArrayList<MyQuestion> getMyQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<MyQuestion> questionList) {
        this.questionList = questionList;
    }
    private ArrayList<MyQuestionFocus> questionListFocus = new ArrayList<>();


    public ArrayList<MyQuestionFocus> getQuestionListFocus() {
        return questionListFocus;
    }

    public void setQuestionListFocus(ArrayList<MyQuestionFocus> questionListFocus) {
        this.questionListFocus = questionListFocus;
    }
}
