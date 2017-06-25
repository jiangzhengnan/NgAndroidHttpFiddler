package com.hd.ngandroidhttpfiddler.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.bean.QsApp;
import com.hd.ngandroidhttpfiddler.common.EventConfig;
import com.hd.ngandroidhttpfiddler.controller.ResultManager;
import com.hd.ngandroidhttpfiddler.utils.NetUtils;
import com.jaredrummler.android.processes.AndroidProcesses;
import com.jaredrummler.android.processes.models.AndroidAppProcess;
import com.jaredrummler.android.processes.models.Stat;
import com.jaredrummler.android.processes.models.Statm;
import com.ng.ngcommon.bean.event.MessageEvent;
import com.ng.ngcommon.ui.activity.BaseActivity;
import com.ng.ngcommon.util.DensityUtils;
import com.ng.ngcommon.util.LogUtils;
import com.ng.ngcommon.util.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static android.R.attr.name;
import static android.icu.lang.UCharacter.JoiningGroup.E;


public class ReverseTracingActivity extends BaseActivity {

    @Bind(R.id.btn_back_rt)
    ImageButton btn_back_rt;

    String port;

    @Bind(R.id.tv_startrt)
    TextView tv_startrt;

    @Bind(R.id.ic_circle3)
    ImageView ic_circle3;
    @Bind(R.id.ic_circle2)
    ImageView ic_circle2;
    @Bind(R.id.ic_circle1)
    ImageView ic_circle1;

    @Bind(R.id.iv_smail_clound1)
    ImageView iv_smail_clound1;
    @Bind(R.id.iv_smail_clound2)
    ImageView iv_smail_clound2;


    @Bind(R.id.rl_start)
    RelativeLayout rl_start;

    @Bind(R.id.ll_showlayout)
    LinearLayout ll_showlayout;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_reversetracing;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.btn_back_rt, R.id.tv_startrt})
    @Override
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back_rt:
                onBackPressed();
                break;
            case R.id.tv_startrt:
                startRt();
        }
    }

    private void startRt() {
        ll_showlayout.removeAllViews();
        ToastUtils.showToast(this, "开始追踪");

        tv_startrt.setClickable(false);
        tv_startrt.setText("追踪中");

        startFindAnim(rl_start);

        addTxtByHandler("开始追踪", Color.BLACK);
        LogUtils.d("开始追踪");

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                try {
                    addTxtByHandler("通过端口号查找响应user中,这可能需要花费几分钟...", Color.BLACK);
                    String user = NetUtils.proc_net_tcp_get_user(port);
                    addTxtByHandler("查找user结果:" + user, Color.BLACK);

                    LogUtils.d("查找的user:" + user);

                    if (user.equals("0")) {
                        addTxtByHandler("查找user结果失败，退出追踪", Color.BLACK);
                        Thread.interrupted();
                        return;
                    }


                    addTxtByHandler("通过User查找Uid中...", Color.BLACK);
                    String uid = NetUtils.getUidByUser(user);
                    addTxtByHandler("通过得到指定程序的唯一标识Uid:" + uid, Color.BLACK);

                    LogUtils.d("查找的Uid:" + uid);


                    if (uid.equals("0")) {
                        addTxtByHandler("查找uid结果失败，退出追踪", Color.BLACK);
                        Thread.interrupted();
                        return;
                    }

                    PackageManager pm = ReverseTracingActivity.this.getPackageManager();
                    List<PackageInfo> packinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES | PackageManager.GET_PERMISSIONS);
                    for (PackageInfo info : packinfos) {
                        if (info.applicationInfo.uid == Integer.parseInt(uid)) {
                            LogUtils.d("该程序名为:" + pm.getApplicationLabel(info.applicationInfo));

                            Drawable drawable = info.applicationInfo.loadIcon(pm);
                            String name = pm.getApplicationLabel(info.applicationInfo).toString();
                            addTxtByHandler("该程序名为:" + name, Color.BLACK);
                            onSubmitResult(drawable,pm.getApplicationLabel(info.applicationInfo) + "", info.packageName);
                            break;
                        }
                    }

                    addTxtByHandler("获取成功，结束追踪", Color.BLACK);

                    onQueryFinish();

                } catch (Exception e) {
                    addTxtByHandler("获取失败", Color.BLACK);
                    onQueryFinish();
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private final int HANDLER_TYPE_CHANGETXT = 0x1;
    private final int HANDLER_TYPE_FINISH = 0x2;

    private final int HANDLER_TYPE_RESULT = 0x3;

    private void onSubmitResult(Drawable drawable, String name, String packeName) {
        LogUtils.d("onSubmitResult:" + name + " " + packeName);
        Message message = new Message();
        message.what = HANDLER_TYPE_RESULT;
        message.obj = drawable;
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("packeName", packeName);
        message.setData(bundle);
        rTHandler.sendMessage(message);
    }

    private void onQueryFinish() {
        Message message = new Message();
        message.what = HANDLER_TYPE_FINISH;
        rTHandler.sendMessage(message);
    }

    private void addTxtByHandler(String txt, int color) {
        Message msg = new Message();
        msg.what = HANDLER_TYPE_CHANGETXT;
        Bundle bundle = new Bundle();
        bundle.putString("txt", txt);
        bundle.putInt("color", color);
        msg.setData(bundle);
        rTHandler.sendMessage(msg);
    }

    Handler rTHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case HANDLER_TYPE_CHANGETXT:
                    String txt = msg.getData().getString("txt");
                    int color = msg.getData().getInt("color");

                    addTextView(txt, color);


                    break;
                case HANDLER_TYPE_FINISH:
                    tv_startrt.setClickable(true);
                    rl_start_Oa.cancel();
                    tv_startrt.setText("开始追踪");
                    // ToastUtils.showToast(ReverseTracingActivity.this, "追踪成功!");
                    break;

                case HANDLER_TYPE_RESULT:
                    Drawable icon = (Drawable) msg.obj;
                    String name = msg.getData().getString("name");
                    String packeName= msg.getData().getString("packeName");
                    ResultManager.getInstance().addQsApp(new QsApp(icon,name,packeName));

                    EventBus.getDefault().post(new MessageEvent("", EventConfig.REFRESH_RESULT));
                    break;
            }


        }
    };

    private void addTextView(String txt, int color) {
        Context context = ReverseTracingActivity.this;
        FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //tvParams.setMargins(DensityUtils.dip2px(context, 4),DensityUtils.dip2px(context, 4), DensityUtils.dip2px(context, 4),DensityUtils.dip2px(context, 4));

        TextView textView = new TextView(context);
        textView.setTextColor(color);
        textView.setText(txt);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setLayoutParams(tvParams);
        ll_showlayout.addView(textView);
    }

    @Override
    protected void initViewsAndEvents() {
        port = getIntent().getStringExtra("port");
        initPathAnim1(iv_smail_clound1);
        initPathAnim2(iv_smail_clound2);

        ic_circle1.setVisibility(View.VISIBLE);
        ic_circle2.setVisibility(View.VISIBLE);
        ic_circle3.setVisibility(View.VISIBLE);
        initlogoHolder1(ic_circle1);
        initlogoHolder2(ic_circle2);
        initlogoHolder3(ic_circle3);
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

    ObjectAnimator rl_start_Oa;

    private void startFindAnim(RelativeLayout rl_start) {
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                1.2f, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                1.2f, 1f);

        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("rotation", 360f, 0f);
        rl_start_Oa = ObjectAnimator.ofPropertyValuesHolder
                (rl_start, pvhY, pvhZ, rotate);
        rl_start_Oa.setDuration(5000);
        rl_start_Oa.setInterpolator(new LinearInterpolator());
        rl_start_Oa.setRepeatCount(-1);
        rl_start_Oa.start();
    }

    private void initPathAnim1(ImageView iv_smail_clound1) {
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                1.2f, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                1.2f, 1f);
        PropertyValuesHolder trsX = PropertyValuesHolder.ofFloat("translationX", 0f, -10f, 0f, 10f, 0f, 0f);
        PropertyValuesHolder trsY = PropertyValuesHolder.ofFloat("translationY", 0f, 0f, -10f, 0f, 10f, 0f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder
                (iv_smail_clound1, pvhY, pvhZ, trsX, trsY);
        objectAnimator.setDuration(8000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.start();
    }

    private void initPathAnim2(ImageView iv_smail_clound1) {
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0.8f, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0.8f, 1f);
        PropertyValuesHolder trsX = PropertyValuesHolder.ofFloat("translationX", 0f, -10f, 0f, 10f, 0f, 0f);
        PropertyValuesHolder trsY = PropertyValuesHolder.ofFloat("translationY", 0f, 0f, -10f, 0f, 10f, 0f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder
                (iv_smail_clound1, pvhY, pvhZ, trsX, trsY);
        objectAnimator.setDuration(4000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.start();
    }


    public void initlogoHolder1(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 0f,
                2f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 0f,
                2f);
        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("rotation", 360f, 0f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ, rotate);
        objectAnimator.setDuration(10000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setInterpolator(new AccelerateInterpolator(1.2f));

        objectAnimator.start();
    }

    public void initlogoHolder2(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 0f,
                2f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 0f,
                2f);
        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ, rotate);
        objectAnimator.setDuration(10000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setInterpolator(new AccelerateInterpolator(1.2f));

        objectAnimator.start();
    }

    public void initlogoHolder3(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 0f,
                2f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 0f,
                2f);
        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("rotation", 360f, 0f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ, rotate);
        objectAnimator.setDuration(10000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setInterpolator(new AccelerateInterpolator(1.2f));

        objectAnimator.start();
    }
}
