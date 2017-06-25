package com.hd.ngandroidhttpfiddler.app;

import android.app.Application;

import com.hd.ngandroidhttpfiddler.service.ProxyServer;

/**
 * Created by xuzhou on 2016/8/10.
 */
public class SysApplication extends Application {
    private ProxyServer ser;

    @Override
    public void onCreate() {
        super.onCreate();
        initProxy();
        // Gradle automatically generates proper variable as below.

    }

    private void initProxy() {
        ser = new ProxyServer();
        ser.start(this);
    }

}
