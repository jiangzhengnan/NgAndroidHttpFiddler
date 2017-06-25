package com.hd.ngandroidhttpfiddler.ui.fragment;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.adapter.PreviewAdapter;
import com.hd.ngandroidhttpfiddler.app.SysApplication;
import com.hd.ngandroidhttpfiddler.controller.HarManager;
import com.hd.ngandroidhttpfiddler.ui.activity.ReverseTracingActivity;
import com.hd.ngandroidhttpfiddler.utils.DialogUtil;
import com.hd.ngandroidhttpfiddler.utils.NetUtils;
import com.hd.ngandroidhttpfiddler.view.RecycleViewDivider;
import com.jaredrummler.android.processes.AndroidProcesses;
import com.jaredrummler.android.processes.models.AndroidAppProcess;
import com.ng.ngcommon.ui.fragment.BaseFragment;
import com.ng.ngcommon.util.DateUtils;
import com.ng.ngcommon.util.LogUtils;
import com.ng.ngcommon.util.ToastUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by jiangzn on 16/11/23.
 */

public class Tab1Fragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.rv_tab1frag)
    RecyclerView rv_tab1frag;
    PreviewAdapter previewAdapter;
    //List<HarEntry> harEntryList = new ArrayList<>();
    Boolean isHiddenHID = false;

    //清空
    @Bind(R.id.fab_clear)
    FloatingActionButton fab_clear;
    //次数排序
    @Bind(R.id.fab_timessort)
    FloatingActionButton fab_timessort;
    //大小排序
    @Bind(R.id.fab_sizesort)
    FloatingActionButton fab_sizesort;

    @Bind(R.id.tv_refreshtime_frag1)
    TextView tv_refreshtime_frag1;

    @Override
    protected void initViewsAndEvents(View view) {

        rv_tab1frag.addItemDecoration(new RecycleViewDivider(getActivity(), RecycleViewDivider.VERTICAL_LIST));
        rv_tab1frag.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_tab1frag.setAdapter(previewAdapter = new PreviewAdapter(getContext()));

        refreshHandler.sendEmptyMessage(1);
        Timer timer = new Timer();
        timer.schedule(refreshTimer, 0, 10000);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_tab1;
    }

    public static String readFile(String filePathAndName) {
        String fileContent = "";
        try {
            File f = new File(filePathAndName);
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "UTF-8");
                BufferedReader reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent += line;
                }
                read.close();
            }
        } catch (Exception e) {
            System.out.println("读取文件内容操作出错");
            e.printStackTrace();
        }
        return fileContent;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.fab_clear, R.id.fab_timessort, R.id.fab_sizesort})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_clear:
                HarManager.getInstance().clearHarDate();
                previewAdapter.refreshDate();

                break;
            case R.id.fab_timessort:
                ToastUtils.showToast(getContext(), "按次数排序");
                HarManager.getInstance().setNowSortWay(HarManager.SORT_BY_TIMES);
                previewAdapter.refreshDate();

                break;
            case R.id.fab_sizesort:
                ToastUtils.showToast(getContext(), "按大小排序");
                HarManager.getInstance().setNowSortWay(HarManager.SORT_BY_SIZE);
                previewAdapter.refreshDate();
                break;
        }
    }

    Handler refreshHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (getContext() != null) {
                DialogUtil.toggleLoadingDialog(getContext());
                tv_refreshtime_frag1.setText("刷新时间:" + DateUtils.getNowDate());
                previewAdapter.refreshDate();
                DialogUtil.removeLoadingDialog();
            }
        }
    };

    TimerTask refreshTimer = new TimerTask() {
        @Override
        public void run() {
            refreshHandler.sendEmptyMessage(1);
        }
    };

}