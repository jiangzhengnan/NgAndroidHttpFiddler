package com.hd.ngandroidhttpfiddler.ui.activity;

import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.adapter.QsAdapter;
import com.hd.ngandroidhttpfiddler.adapter.Tab2RvAdapter;
import com.hd.ngandroidhttpfiddler.bean.AppTrafficModel;
import com.hd.ngandroidhttpfiddler.bean.BaseRvItemData;
import com.hd.ngandroidhttpfiddler.common.Config;
import com.jaredrummler.android.processes.AndroidProcesses;
import com.jaredrummler.android.processes.models.AndroidAppProcess;
import com.ng.ngcommon.bean.event.MessageEvent;
import com.ng.ngcommon.ui.activity.BaseActivity;
import com.ng.ngcommon.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class QueryRunningAppActivity extends BaseActivity {

    @Bind(R.id.btn_back_qs)
    ImageButton btn_back_qs;

    @Bind(R.id.spfresh_qs)
    SwipeRefreshLayout spfresh_qs;
    @Bind(R.id.rv_qs)
    RecyclerView rv_qs;

    QsAdapter qsRvAdapter;
    private volatile List<BaseRvItemData> listApps = new ArrayList<>();


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_queryrunningservice;
    }

    @OnClick({R.id.btn_back_qs})
    @Override
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back_qs:
                onBackPressed();
                break;
        }
    }

    @Override
    protected void initViewsAndEvents() {
        rv_qs.setLayoutManager(new LinearLayoutManager(this));
        //设置刷新球球
        spfresh_qs.setColorSchemeResources(R.color.themeColor, R.color.themeColor, R.color.themeColor,
                R.color.themeColor);
        spfresh_qs.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshDate();
            }
        });
        rv_qs.setItemAnimator(new DefaultItemAnimator());
        rv_qs.setLayoutManager(new LinearLayoutManager(this));

        qsRvAdapter = new QsAdapter(listApps, this);
        rv_qs.setAdapter(qsRvAdapter);
    }

    private void refreshDate() {
        listApps.clear();

        //得到运行时包名
        List<AndroidAppProcess> processes = AndroidProcesses.getRunningAppProcesses();
        for (AndroidAppProcess appProcess : processes) {
            try {
                appProcess.getPackageInfo(this, PackageManager.GET_ACTIVITIES);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        PackageManager pm = this.getPackageManager();
        List<PackageInfo> packinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES | PackageManager.GET_PERMISSIONS);
        for (PackageInfo info : packinfos) {
            listApps.add(new BaseRvItemData(info, Config.TYPE_FLOW_ITEM));
        }
        qsRvAdapter.notifyDataSetChanged();
        spfresh_qs.setRefreshing(false);
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected void onGetEvent(MessageEvent event) {

    }
}
