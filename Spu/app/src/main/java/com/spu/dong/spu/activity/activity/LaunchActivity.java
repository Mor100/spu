package com.spu.dong.spu.activity.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.spu.dong.spu.R;
import com.spu.dong.spu.activity.cache.LocationCache;
import com.spu.dong.spu.activity.flyn.Eyes;
import com.spu.dong.spu.activity.model.News;
import com.spu.dong.spu.activity.model.Nows;
import com.spu.dong.spu.activity.model.TipOffBeans;
import com.spu.dong.spu.activity.utils.UIUtils;

import java.util.ArrayList;

public class LaunchActivity extends AppCompatActivity {


    private LocationCache locationCache;
    private int[] mStatusColors = new int[]{
            R.color.colorRedDeep,
            R.color.status_color_grey,
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.splash));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(imageView,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(2*1000);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        Eyes.setStatusBarColor(this, UIUtils.getColor(mStatusColors[1]));
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            //结束后进入新的一页。
                startActivity( new Intent(LaunchActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        linearLayout.startAnimation(alphaAnimation);

        //初始化数据

        ArrayList<News> objects = new ArrayList<>();
        objects.add(new News("首届宁夏体育大集开启全民健身新体验","2018年08月07日 01:10:13","https://shimo.im/docs/6jUUk3POQIIyGghZ","https://images-cdn.shimo.im/KjwywHEKe6EkzEJ5/mxpp_1533575403841.png"));
        objects.add(new News("发挥宁夏特色旅游商品资源优势 提高市场转化率","2018年08月07日 01:06:29","https://shimo.im/docs/026yZNUrYls90wpr","https://images-cdn.shimo.im/6XrHUvb9YVYhTZGg/mxpp_1533575183473.jpg"));
        objects.add(new News("宁夏为法院领导监督案件审判列“正负清单”","2018年08月07日 01:03:42","https://shimo.im/docs/YEyoRwBAC2UXRzXL","https://images-cdn.shimo.im/dbRxruNUzJ8QIT0x/mxpp_1533575015092.jpg"));
        objects.add(new News("宁夏改革出口食品企业备案管理 西夏王酒业先拔头筹","2018年08月07日 01:01:18","https://shimo.im/docs/WMh2V03f7rIXTHdn","https://images-cdn.shimo.im/93g4sTTgKGYwP9Mc/mxpp_1533574871311.jpg"));
        objects.add(new News("宁夏出口食品备案企业快速增长","2018年08月07日 01:00:32","https://shimo.im/docs/Dwc1NATdblMC55qp","https://images-cdn.shimo.im/xDlOW8Ha9uEZFcuH/mxpp_1533574824504.jpg"));
        objects.add(new News("宁夏出口食品企业全面建立食品防护计划","2018年08月07日 00:58:44","https://shimo.im/docs/T88Ii9r6ZacDGKlj","https://images-cdn.shimo.im/r9bQt9mPGGoq2gwP/mxpp_1533574715821.jpg"));
        objects.add(new News("“好生态也能当饭吃”——解码宁夏吴忠市的“绿色发展账本“","2018年08月06日 11:03:53","https://shimo.im/docs/ADHpWfjrH4IUL7AM","https://images-cdn.shimo.im/hHJZUGwowjsVoDod/mxpp_1533482245051.jpg"));
        objects.add(new News("宁夏“互联网+教育”示范省（区）座谈会举行","2018年08月05日 23:39:11","https://shimo.im/docs/hs1frTz3kMIJe9SN","https://images-cdn.shimo.im/KG3UmZzWmH0BiAYA/mxpp_1533483104079.jpg"));
        objects.add(new News("【新焦点】刚刚，宁夏发布了一项“成绩单”！这些数据让你惊呼翻天巨变！","2018年08月05日 23:38:15","https://shimo.im/docs/hrwNorn6slQ2fNsv","https://images-cdn.shimo.im/dRhUjQ3U8oE77tae/mxpp_1533481804060.png"));
        objects.add(new News("宁夏将实施新一批战略性新兴产业专项","2018年08月05日 23:38:04","https://shimo.im/docs/LMK3bhUvNOsnS9mh","https://images-cdn.shimo.im/4Bwi7yzdEGY4b4gz/mxpp_1533482019664.png"));
        objects.add(new News("宁夏今年底将实现食品药品快速检测服务全覆盖","2018年08月05日 23:37:53","https://shimo.im/docs/E5QygbPai5UE47nu","https://images-cdn.shimo.im/pwOpEgye5VsrNb2V/mxpp_1533482184106.jpg"));
        objects.add(new News("我区为特殊人才职称评审开辟“绿色通道”","2018年08月05日 23:37:21","https://shimo.im/docs/vVwvTP6JP2QxN1mS","https://images-cdn.shimo.im/bifkTIziRME8Xhp4/mxpp_1533482508907.jpg"));
        objects.add(new News("宁夏获批成为我国首个“互联网+医疗健康”示范省区","2018年08月05日 23:37:04","https://shimo.im/docs/tmVTlQxrzFILGDVa","https://images-cdn.shimo.im/1UKlP8yJwuUJCzdr/mxpp_1533482643767.jpg"));
        objects.add(new News("宁夏：全区健康扶贫工作推进会召开","2018年08月05日 23:36:46","https://shimo.im/docs/Vw8htNsBjJ4zwo9x","https://images-cdn.shimo.im/hvO4J6BOQe0gezBN/mxpp_1533482755883.jpg"));

        locationCache = LocationCache.getLocationCache();
        locationCache.setList(objects);

        ArrayList<News> SextyList = new ArrayList<>();
        SextyList.add(new News("【宁夏60年】塞上江南赞","2018年08月07日 01:10:13","https://shimo.im/docs/Ax28hRtFS18NIr9L","https://images-cdn.shimo.im/rGnUrPiUuLQIXWaN/mxpp_1533485459053.png"));
        SextyList.add(new News("【宁夏60年】喜迎60大庆将举办两大旅游盛事","2018年08月07日 01:06:29","https://shimo.im/docs/TLbcUDkKQBE65xPU","https://images-cdn.shimo.im/MGM7tIRuw80oa3ZI/mxpp_1533485299659.jpg"));
        SextyList.add(new News("【宁夏60年】“塞上湖城”波光滟","2018年08月07日 01:03:42","https://shimo.im/docs/A05TomvJuF4fsr6X","http://www.people.com.cn/mediafile/pic/20180730/47/12430656240325290775.jpg"));
        SextyList.add(new News("【宁夏60年】宁夏公布60年经济发展“成绩单”","2018年08月07日 01:01:18","https://shimo.im/docs/ctVQDfEqrPA3fA13","https://images-cdn.shimo.im/6x41HYc4PbwEs6wn/mxpp_1533485059469.jpg"));
        SextyList.add(new News("【宁夏60年】包银高铁宁夏段环评获生态环境","2018年08月07日 01:00:32","https://shimo.im/docs/QmcIjhMfQdEijLhv","https://images-cdn.shimo.im/r01IM2B6H2MSUx9A/mxpp_1533484914828.jpg"));
        SextyList.add(new News("【宁夏60年】年均GDP增长9.4% 高于全国同期","2018年08月07日 00:58:44","https://shimo.im/docs/hd4ZCRjkfcoLAOm9","https://images-cdn.shimo.im/DrVnzxv5pCUKGe7f/mxpp_1533484680182.png"));
        SextyList.add(new News("【宁夏60年】一张图看懂宁夏60年经济发展变化","2018年08月06日 11:03:53","https://shimo.im/docs/fWvOLhEpN2Ek69Qe","https://images-cdn.shimo.im/1qOeXHGf5TkpggG1/mxpp_1533484497937.png"));
        SextyList.add(new News("【宁夏60年】114万人搬出“穷窝”走上致富路","2018年08月05日 23:39:11","https://shimo.im/docs/jYc4comB4FYTgPM4","https://images-cdn.shimo.im/OsO1SqxTJEAd3Vsc/mxpp_1533484383623.jpg"));
        SextyList.add(new News("【宁夏60年】六盘山下听雨声","2018年08月05日 23:38:15","https://shimo.im/docs/9topWTEsJ1IX773C","https://images-cdn.shimo.im/GRxl6i9iklMD9iFB/mxpp_1533482988273.png"));

        locationCache.setTextList(SextyList);

        ArrayList<News> zhongNingList = new ArrayList<>();
        zhongNingList.add(new News("中宁政务服务打通群众办事最后一公里","2018年08月07日 01:10:13","https://shimo.im/docs/afqnaQax3jI9Uzvz","https://images-cdn.shimo.im/ijzKKc1dJpkYBJdQ/mxpp_1533700019117.jpg"));
        zhongNingList.add(new News("余丁乡全力打造GAP菊花种植示范基地","2018年08月07日 01:06:29","https://shimo.im/docs/OUa61BV1DgcYq3Ry","https://images-cdn.shimo.im/z6z1sh5HckMyXxpx/mxpp_1533699859067.jpg"));
        zhongNingList.add(new News("丰安社区“四点半”学校解家长后顾之忧","2018年08月07日 01:03:42","https://shimo.im/docs/0ByMpI8j5IckdsPp","https://images-cdn.shimo.im/oqPbcYvGjhIe9hNo/mxpp_1533699727021.jpg"));
        zhongNingList.add(new News("科技局：我县兑现2017年度自治区科技型中小企业补助资金15万元","2018年08月07日 01:01:18","https://shimo.im/docs/AhyhT9xk17c7tyr7","https://images-cdn.shimo.im/2P46vOPU6lQQlbx4/mxpp_1533699612959.jpg"));
        zhongNingList.add(new News("宁中宁养殖小龙虾蹚出致富新路子","2018年08月07日 01:00:32","https://shimo.im/docs/zaJ030YMPWE6SJSL","https://images-cdn.shimo.im/iAykrhUmEzcCNpXr/mxpp_1533699531056.jpg"));
        zhongNingList.add(new News("【新发现】宁夏首个机器人警察在中宁上岗！猜猜“他”都能干哪些事？","2018年08月07日 00:58:44","https://shimo.im/docs/9R0eAZsxRMcQRJXs","https://images-cdn.shimo.im/tk9cKSsbzK8mLJTH/mxpp_1533699444361.jpg"));
        zhongNingList.add(new News("中宁县大战场镇特色产业助推脱贫攻坚","2018年08月06日 11:03:53","https://shimo.im/docs/GYz6FRnwfRQyxyhw","https://images-cdn.shimo.im/0cYoiUyq28EcoKF5/mxpp_1533699308995.jpg"));
        zhongNingList.add(new News("“中宁枸杞”标准规范带动全产业发展","2018年08月05日 23:39:11","https://shimo.im/docs/5Omdf6OhKNwRxKfL","https://images-cdn.shimo.im/8FrS4LDDvd0CGto2/mxpp_1533699248511.jpg"));
        zhongNingList.add(new News("中宁县农民工工资保障工作成效明显","2018年08月05日 23:38:15","https://shimo.im/docs/6Prg6Y8YCpYk2gBi","https://images-cdn.shimo.im/TIUdhlqBgbARVhCN/mxpp_1533699130888.jpg"));
        zhongNingList.add(new News("中宁供电开展高温天气农网工程安全管控","2018年08月05日 23:38:04","https://shimo.im/docs/vmJ3O7kPd0IhtOrZ","https://images-cdn.shimo.im/5e5m1Fpd4HYSGO0g/mxpp_1533699053205.jpg"));
        zhongNingList.add(new News("中宁县“双拥共建”用实际行动暖军心热民心","2018年08月05日 23:37:53","https://shimo.im/docs/1knC4wMzHxMFGAIn","https://images-cdn.shimo.im/kxJ6IxhIyjoIHtoK/mxpp_1533697910096.jpg"));
        zhongNingList.add(new News("中宁县喜迎宁夏60大庆职工艺术展演激情开唱","2018年08月05日 23:37:21","https://shimo.im/docs/J5VVrIxhIqEn3V3v","https://images-cdn.shimo.im/b7AwBh7eCUwp3EH5/mxpp_1533697633475.jpg"));
        zhongNingList.add(new News("宁夏中宁：小枸杞 大产业","2018年08月05日 23:37:04","https://shimo.im/docs/62sEnw6mbCQaPG5q","https://images-cdn.shimo.im/Am9CdaWoXpcswbtR/mxpp_1533694981354.jpg"));

        locationCache.setNingList(zhongNingList);

        ArrayList<News> powerList = new ArrayList<>();
        powerList.add(new News("关于做好我区高速铁路护路联防工作的实施意见","2018年08月07日 01:10:13","https://shimo.im/docs/z4iTPrhivh0H3bs1","NULL"));
        powerList.add(new News("2017年度自治区科学技术奖励的决定","2018年08月07日 01:06:29","https://shimo.im/docs/gWZKRXQF5t0hlnYb","NULL"));
        powerList.add(new News("关于全面推进宁夏金融业综合统计工作的意见","2018年08月07日 01:03:42","https://shimo.im/docs/N6zjLYUi58gzM7Gm","NULL"));
        powerList.add(new News("关于改革完善全科医生培养与使用激励机制实施方案的通知","2018年08月07日 01:01:18","https://shimo.im/docs/BV18ZOynPv4JqDOs","NULL"));
        powerList.add(new News("2018年第二季度全区政府网站抽查情况的通报","2018年08月07日 01:00:32","https://shimo.im/docs/xN6CTIbT7SEo3Vxu","NULL"));
        powerList.add(new News("开展涉及产权保护政府规章行政规范性文件清理工作的通知","2018年08月07日 00:58:44","https://shimo.im/docs/d2MeS4tAAUswIbNe","NULL"));
        powerList.add(new News("宁夏回族自治区生态保护红线","2018年08月06日 11:03:53","https://shimo.im/docs/H8V2Emhf1nA6VLWZ","NULL"));
        powerList.add(new News("关于印发首届中国国际进口博览会宁夏交易团工作方案的通知","2018年08月05日 23:39:11","https://shimo.im/docs/eUWJfPi2wB8MXVmu","NULL"));
        powerList.add(new News("关于印发宁夏回族自治区居民营养实施方案（2018年—2030年）的通知","2018年08月05日 23:38:15","https://shimo.im/docs/NBFFMTUbi6ohFCE1","NULL"));
        powerList.add(new News("关于开展全区政务新媒体基本情况调查摸底工作的通知","2018年08月05日 23:38:04","https://shimo.im/docs/1T2OCj9sgGYGjCHl","NULL"));
        powerList.add(new News("全区旅游市场“黑导”“黑社”“黑车”专项整治方案的通知","2018年08月05日 23:37:53","https://shimo.im/docs/DwH7NNCm5q0mfWUp","NULL"));
        powerList.add(new News("关于进一步做好证明事项清理工作的通知","2018年08月05日 23:37:21","https://shimo.im/docs/OioGGDzG7JsD84JQ","NULL"));
        powerList.add(new News("加强政务诚信建设有关工作的通知","2018年08月05日 23:37:04","https://shimo.im/docs/GgDqJ1snkEYpDjBT","NULL"));
        powerList.add(new News("关于2018年上半年工作大督查及考评激励的通报","2018年08月05日 23:36:46","https://shimo.im/docs/OZf8ixRyxYcFdPZo","NULL"));

        locationCache.setPowerList(powerList);

        ArrayList<Nows> nowsList = new ArrayList<>();
        nowsList.add(new Nows("违停","2018-08-02 18:10","已转办","宁夏公安厅交通管理局","1","西夏区兴州南街锦润绣府锦园，门口违停严重。消防车都进不来。我们一直在反应！效果不理想！","NULL","https://images-cdn.shimo.im/ACY4axPlMagDCHRw/mxpp_1533637621942.jpg"));
        nowsList.add(new Nows("违停","2018-08-02 18:10","已转办","宁夏公安厅交通管理局","1","西夏区兴州南街锦润绣府锦园，门口违停严重。消防车都进不来。我们一直在反应！效果不理想！","NULL","https://images-cdn.shimo.im/ACY4axPlMagDCHRw/mxpp_1533637621942.jpg"));
        nowsList.add(new Nows("飞车党","2018-08-07 01:10","已办结","宁夏公安厅交通管理局","1","清河街、湖滨街口和永康巷有大排量摩托车违法上路，摩托车噪声扰民。","2018年夏季，针对银川市摩托车事故高发、摩托车噪声扰民投诉增多等问题，为解决摩托车无牌无证、追逐飙车、非法改装等违法行为的乱象，银川交警分局在全市开展代号为“飓风”的打击摩托车交通违法行为专项行动，抽调精干警力成立“飓风行动队”，以大兵团作战方式，重点打击摩托车交通违法行为。今年银川交警加大查处力度，实行措施勤务，有效的打击了摩托车违法行为。您提出的清河街、湖滨街口和永康巷有大排量摩托车违法上路的情况，我们会安排警力依法查处，同时也感谢您对交通管理工作的理解和支持。","NULL"));
        nowsList.add(new Nows("18609526788非法催收","2018-08-08 11:10","已审核","NULL","0","借款人欠钱并不违法，我和18609526788没有合同关系，也没有债务关系，恶意骚扰联系人恐吓借款人，网贷公司涉嫌违法将我的信息倒卖18609526788催收，涉嫌违法，请有关部门对其严厉的批评和教育。","NULL","NULL"));
        nowsList.add(new Nows("宁夏新闻网站技术员对外出租网站目录让犯罪分子做赌博宣传！","2018-08-09 14:20","已审核","NULL","0","http://www.nxnews.net/宁夏新闻网站技术员对外出租网站目录让犯罪分子做赌博宣传！ http://www.nxnews.net/dc/593f/8670871.html 类似这样的链接服务器内发一大堆，目的是利用搜索引擎对政府新闻网站的信任，收录了排名，然后通过大量的词点击就跳转到一个赌博站。请严查！","NULL","NULL"));

        locationCache.setNowsList(nowsList);

        ArrayList<TipOffBeans> tipOffList = new ArrayList<>();
        tipOffList.add(new TipOffBeans("宁夏新闻","09515117020","宁夏广播电视台（英文简称NXTV）拥有广播、电视、报纸、有线电视网络、网站五大传播媒介，组建于2004年12月，为自治区政府直属事业单位，由宁夏回族自治区党委宣传部和新闻出版广电局共同管理。","https://images-cdn.shimo.im/k1fF39JDgUMeC4bx/d31b0ef41bd5ad6e6eed72e681cb39dbb6fd3ca1.jpg","","",""));
        tipOffList.add(new TipOffBeans("银川四道路试单行相当堵","","","https://images-cdn.shimo.im/5scDKrf3iAgo9BAu/mxpp_1533637826325.jpg","2018年08月07日 01:10:13","2457","https://shimo.im/docs/p23byXc0SgcLD3LM"));
        tipOffList.add(new TipOffBeans("举报投诉银川市西夏区公安分局 北京西路派出所不作为","","","","2018年08月07日 01:10:13","2335","https://shimo.im/docs/RVeU7JiPqQsJvhtN"));
        tipOffList.add(new TipOffBeans("步行街起火","","","https://images-cdn.shimo.im/PmmqnKjiJqEFN3Um/mxpp_1533637433580.jpg","2018年08月07日 01:10:13","2555","https://shimo.im/docs/Z8tImkvGvlcDYctq"));
        tipOffList.add(new TipOffBeans("步行街起火","","","https://images-cdn.shimo.im/PmmqnKjiJqEFN3Um/mxpp_1533637433580.jpg","2018年08月07日 01:10:13","2555","https://shimo.im/docs/Z8tImkvGvlcDYctq"));
        tipOffList.add(new TipOffBeans("投诉宁夏蓝海文化艺术品交易中心下属经纪商诈骗投资者","","","","2018年08月07日 01:00:32","1565","https://shimo.im/docs/OvapSb0Fdk0uwWjz"));
        tipOffList.add(new TipOffBeans("宁夏大学贴吧，有人恶意挑起民族矛盾","","","","2018年08月07日 00:58:44","1565","http://tieba.baidu.com/p/5298925464"));
        tipOffList.add(new TipOffBeans("举报非法游戏厅聚众赌博","","","","2018年08月06日 11:03:53","1785","https://shimo.im/docs/lJ4ds3aY1QIBq9uV"));
        tipOffList.add(new TipOffBeans("银川文化城“凤凰里”标识路牌被涂抹","","","https://images-cdn.shimo.im/k5NCVu9881kftQ4t/mxpp_1533637083277.jpg","2018年08月06日 11:03:53","1785","https://shimo.im/docs/N5NBx2BidksWJlta"));

        locationCache.setTipList(tipOffList);

        ArrayList<TipOffBeans> tipOffLifeList = new ArrayList<>();
        tipOffLifeList.add(new TipOffBeans("生活服务","09515117020","生活频道注重服务性，以经济生活、社会服务为主要内容，解决百姓生活难题，关注百姓衣食住行。","https://images-cdn.shimo.im/RHnesgldza0jOxJf/622762d0f703918fabc62bc6513d269759eec4a2.jpg","","",""));
        tipOffLifeList.add(new TipOffBeans("生活在“定时炸弹上”的江南水乡（B区）","","","https://images-cdn.shimo.im/fMPUyA4ltaEMZ8VD/mxpp_1533637332798.jpg","2018年08月07日 01:10:13","2555","https://shimo.im/docs/2hAA2BvXc24DwKqL"));
        tipOffLifeList.add(new TipOffBeans("洪湖水啊~浪呀么浪打浪","2018年08月07日 11:10:13","","https://images-cdn.shimo.im/d6SlxnYxcqobezLw/mxpp_1533637721094.jpg","2018年08月07日 11:10:13","2453","https://shimo.im/docs/wUXRzeP54fA9cTJz"));
        tipOffLifeList.add(new TipOffBeans("大雨","","","https://images-cdn.shimo.im/N1IS81wDWsMaI94Y/mxpp_1533637576048.jpg","2018年08月07日 07:15:13","2675","https://shimo.im/docs/sRVqfLpnGAcEPudc"));
        tipOffLifeList.add(new TipOffBeans("银川文联，你怎么如此“个性”","","","http://pic.nx001.com/data/attachment/forum/201505/25/113203il8chvhuu1z1uulh.jpg.thumb.jpg","2018年08月07日 01:10:13","2555","https://shimo.im/docs/DuxWBSvX6xgk0PZL"));
        tipOffLifeList.add(new TipOffBeans("宁夏新闻网站技术员对外出租网站目录让犯罪分子做赌博宣传！","","","","2018年08月07日 01:00:32","1565","https://shimo.im/docs/bjNbkWhMiZsHtzpy"));
        tipOffLifeList.add(new TipOffBeans("银行联网查询身份信息，身份证号是自己的，照片是别人的","","","","2018年08月07日 00:58:44","1565","https://shimo.im/docs/JwLE6y2V5TIN2nxa"));

        locationCache.setTopLife(tipOffLifeList);
    }
}
