package com.hd.ngandroidhttpfiddler.controller;

import android.content.Context;
import android.graphics.Color;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.bean.HarDate;
import com.ng.ngcommon.util.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Har信息管理器
 * 按大小排序
 * 按次数排序
 * 使用色卡来区分严重程度
 */
public class HarManager {
    //使用一个hashmap队列保存所有请求
    private volatile static  List<HarDate> harDateList;

    //懒汉，线程安全
    private static HarManager instance;

    public static final int SORT_BY_TIMES = 0x1;

    public static final int SORT_BY_SIZE = 0x2;

    //排序方式
    private static int nowSortWay = SORT_BY_TIMES;

    public void setNowSortWay(int nowSortWay) {
        HarManager.nowSortWay = nowSortWay;
        reSort();
    }

    private void reSort() {
        //重新排序
        switch (nowSortWay) {
            case SORT_BY_TIMES:
                Collections.sort(harDateList, new Comparator<HarDate>() {
                    @Override
                    public int compare(HarDate o1, HarDate o2) {
                        return o1.getTimes() < o2.getTimes() ? 1 : -1;
                    }
                });
                break;
            case SORT_BY_SIZE:
                Collections.sort(harDateList, new Comparator<HarDate>() {
                    @Override
                    public int compare(HarDate o1, HarDate o2) {
                        return o1.getBytes() < o2.getBytes() ? 1 : -1;
                    }
                });

                break;
        }
    }

    private HarManager() {
    }

    public static synchronized HarManager getInstance() {
        if (instance == null) {
            instance = new HarManager();
            harDateList = new ArrayList<>();
            maxTimes = 0;
            maxBytes = 0;
        }
        return instance;
    }

    public List<HarDate> getHarDateList() {
        return harDateList;
    }

    public void setHarDateList(List<HarDate> harDateList) {
        HarManager.harDateList = harDateList;
    }

    public void clearHarDate() {
        harDateList.clear();
    }

    public void addEntries(HarDate harDate) {
        if (harDateList.size() == 0) {
            harDateList.add(harDate);
        } else {
            for (int i = 0; i < harDateList.size(); i++) {

                if (harDateList.get(i).getHost().equals(harDate.getHost())) {
                    harDateList.get(i).addTimes();
                    harDateList.get(i).addBytes(harDate.getBytes());

                    //设置最大次数和最大比特数
                    if (harDateList.get(i).getTimes() > maxTimes) {
                        maxTimes = harDateList.get(i).getTimes();
                    }
                    if (harDateList.get(i).getBytes() > maxBytes) {
                        maxBytes = harDateList.get(i).getBytes();
                    }

                    if (harDateList.get(i).getRequestBody() == "" && harDate.getRequestBody() != "") {
                        harDateList.get(i).setRequestBody(harDate.getRequestBody());
                    }
                    reSort();
                    return;
                }
            }
            harDateList.add(harDate);
        }

        reSort();
    }



    private static long maxTimes;
    private static long maxBytes;

    //危险度颜色返回值方法
    public int getDangerousDegree(Context context, HarDate harDate) {
        switch (nowSortWay) {
            case SORT_BY_SIZE:
                long tempSize = harDate.getBytes();
                long division = maxBytes / 6;
                //根据大小排
                if (tempSize == 0) {
                    return context.getResources().getColor(R.color.white);
                }
                if (tempSize <= division) {
                    return context.getResources().getColor(R.color.dangerous_color6);
                }
                if (tempSize <= division * 2) {
                    return context.getResources().getColor(R.color.dangerous_color5);
                }
                if (tempSize <= division * 3) {
                    return context.getResources().getColor(R.color.dangerous_color4);
                }
                if (tempSize <= division * 4) {
                    return context.getResources().getColor(R.color.dangerous_color3);
                }
                if (tempSize <= division * 5) {
                    return context.getResources().getColor(R.color.dangerous_color2);
                }
                if (tempSize > division * 5) {
                    return context.getResources().getColor(R.color.dangerous_color1);
                }
                break;
            case SORT_BY_TIMES:
                //根据次数排
                double timeTimes = harDate.getTimes();
                double tempMaxTimes = maxTimes;
                double tDivision = tempMaxTimes / 6;
                if (timeTimes == 0) {
                    return context.getResources().getColor(R.color.white);
                }
                if (timeTimes <= tDivision) {
                    return context.getResources().getColor(R.color.dangerous_color6);
                }
                if (timeTimes <= tDivision * 2) {
                    return context.getResources().getColor(R.color.dangerous_color5);
                }
                if (timeTimes <= tDivision * 3) {
                    return context.getResources().getColor(R.color.dangerous_color4);
                }
                if (timeTimes <= tDivision * 4) {
                    return context.getResources().getColor(R.color.dangerous_color3);
                }
                if (timeTimes <= tDivision * 5) {
                    return context.getResources().getColor(R.color.dangerous_color2);
                }
                if (timeTimes > tDivision * 5) {
                    return context.getResources().getColor(R.color.dangerous_color1);
                }
                break;
        }
        return context.getResources().getColor(R.color.white);
    }


}
