package com.spu.dong.spu.activity.demo;

import android.animation.TypeEvaluator;
import android.util.Log;

    public class MyObjectEvaluator implements TypeEvaluator {



        @Override
        public String evaluate(float v, Object o, Object t1) {

            //
            String startRGB = (String) o;
            String endRGB = (String) t1;

            //把三个颜色分开 #ff0000 开始颜色
            int startRed = Integer.parseInt(startRGB.substring(1, 3), 16);
            int startGreen = Integer.parseInt(startRGB.substring(3, 5), 16);
            int startBlue = Integer.parseInt(startRGB.substring(5, 7), 16);

            //结束颜色
            int endRed = Integer.parseInt(endRGB.substring(1, 3), 16);
            int endGreen = Integer.parseInt(endRGB.substring(3, 5), 16);
            int endBlue = Integer.parseInt(endRGB.substring(5, 7), 16);

            // 差值
            int redInterpolation = Math.abs(endRed -startRed );
            int greenInterpolation = Math.abs(endGreen -startGreen );
            int blueInterpolation = Math.abs(endBlue -startBlue );

            int currentRed = startRed;
            int currentGreen = startGreen;
            int currentBlue = startBlue;
            //转十进制 最大255
            if(currentRed!= endRed){
                //根据 v 计算插值
                currentRed = getCurrent(startRed, endRed, v, redInterpolation);
            }
            if(currentGreen != endGreen){
                currentGreen = getCurrent(startGreen,endGreen,v,greenInterpolation);
            }
            if(currentBlue != endBlue){
                currentBlue = getCurrent(startBlue,endBlue,v,blueInterpolation);
            }
            //三个十进制数 转16进制
            String redhexString = getHexString(currentRed);
            String greenhexString = getHexString(currentGreen);
            String bluehexString = getHexString(currentBlue);



            Log.i("dongdong","#"+redhexString+greenhexString+bluehexString);
            return "#"+redhexString+greenhexString+bluehexString;
        }

        private String getHexString(int currentRed) {

            String s = Integer.toHexString(currentRed);
            if(s.length() == 1){
                s = "0"+s;
            }

            return s;
        }

        //初始值，结束值，插值器的值，差值。
        private int getCurrent(int startColor,int endColor,float v,float chaColor){

            int current;
            if(startColor > endColor){
                //开始大
                current = (int)(startColor - (v*chaColor));
            }else{
                //结束大
                current = (int)(startColor + (v*chaColor));
            }

            return current;
        }

}
