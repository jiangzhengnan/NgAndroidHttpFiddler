package com.hd.ngandroidhttpfiddler.ui.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.hd.ngandroidhttpfiddler.BuildConfig;
import com.hd.ngandroidhttpfiddler.R;
import com.ng.ngcommon.bean.event.MessageEvent;
import com.ng.ngcommon.ui.activity.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class SetingActivity extends BaseActivity {
    @Bind(R.id.btn_back_setting)
    ImageButton btn_back_setting;

    @Bind(R.id.btn_find_ac)
    Button btn_find_ac;

    @Bind(R.id.btn_find_permission)
    Button btn_find_permission;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_setting;
    }

    @OnClick({R.id.btn_back_setting,R.id.btn_find_ac,R.id.btn_find_permission})
    @Override
    protected void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_back_setting:
                onBackPressed();
                break;
            case R.id.btn_find_ac:
                  intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btn_find_permission:
                  intent = new Intent();
                break;
        }
    }

    @Override
    protected void initViewsAndEvents() {

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
