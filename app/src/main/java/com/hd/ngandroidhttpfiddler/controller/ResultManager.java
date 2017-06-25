package com.hd.ngandroidhttpfiddler.controller;


import com.hd.ngandroidhttpfiddler.bean.QsApp;

import java.util.ArrayList;
import java.util.List;

public class ResultManager {
    private volatile static List<QsApp> qsAppList;

    private static ResultManager instance;

    private ResultManager() {
    }

    public static synchronized ResultManager getInstance() {
        if (instance == null) {
            instance = new ResultManager();
            qsAppList = new ArrayList<>();
        }
        return instance;
    }

    public    List<QsApp> getQsAppList() {
        return qsAppList;
    }

    public     void setQsAppList(List<QsApp> qsAppList) {
        ResultManager.qsAppList = qsAppList;
    }

    public static void addQsApp(QsApp qsApp) {
        //更新次数或者大小

        for (QsApp qsApp1:qsAppList) {
            if (qsApp1.getPackgeName().equals(qsApp.getPackgeName())) {
                return;
            }
        }
        qsAppList.add(qsApp);


    }
}
