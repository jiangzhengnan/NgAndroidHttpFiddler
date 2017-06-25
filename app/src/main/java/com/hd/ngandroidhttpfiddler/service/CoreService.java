package com.hd.ngandroidhttpfiddler.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.ng.ngcommon.util.LogUtils;


public class CoreService extends Service {
    public static final String ACTION = "service.CoreService";
    public static final int MSG_TYPE_REFRESH_HARLOG = 0x1;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d("抓包核心服务onBind");
        return null;
    }

    @Override
    public void onCreate() {
        LogUtils.d("抓包核心服务开启");
        super.onCreate();
        //初始化
       // initAll();
    }
//
//    private void initAll() {
//        Timer timer = new Timer();
//        long delay = 0;
//        timer.scheduleAtFixedRate(coreTask, delay, 10000);
//    }
//
//    Handler coreHandler  = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case MSG_TYPE_REFRESH_HARLOG:
//                    EventBus.getDefault().post(new MessageEvent(null, EventConfig.REFRESH_HAR_LOG));
//                    break;
//            }
//
//        }
//    };
//
//    TimerTask coreTask = new TimerTask() {
//        @Override
//        public void run() {
//            Message message = new Message();
//            message.what = MSG_TYPE_REFRESH_HARLOG;
//            coreHandler.sendMessage(message);
//        }
//    };

}
