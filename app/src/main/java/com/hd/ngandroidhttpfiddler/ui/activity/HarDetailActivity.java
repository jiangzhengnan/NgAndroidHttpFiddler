package com.hd.ngandroidhttpfiddler.ui.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.bean.HarDate;
import com.ng.ngcommon.bean.event.MessageEvent;
import com.ng.ngcommon.ui.activity.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * Har详情
 */
public class HarDetailActivity extends BaseActivity {

    @Bind(R.id.ll_detailLayout)
    LinearLayout linearLayout;

    @Bind(R.id.btn_back_detail)
    ImageButton btn_back_detail;

    @Bind(R.id.btn_reverse_tracing)
    Button btn_reverse_tracing;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_detail;
    }

    @OnClick({R.id.btn_back_detail,R.id.btn_reverse_tracing})
    @Override
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back_detail:
                onBackPressed();
                break;
            case R.id.btn_reverse_tracing:
                //逆向追踪
                Intent i = new Intent(HarDetailActivity.this,ReverseTracingActivity.class);
                i.putExtra("port",harDate.getPort());
                startActivity(i);
                break;
        }
    }

    @Override
    protected void initViewsAndEvents() {
        harDate = (HarDate) getIntent().getExtras().getSerializable("harDate");
        initHarLog();
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

    HarDate harDate;

    public void initHarLog() {
        addItem("请求概述");
        addItem("请求URL", harDate.getUrl());
        addItem("远程服务器端口号", harDate.getPort());

        addItem("请求次数", harDate.getTimes() + "");
        addItem("请求字节大小", harDate.getBytes() + "KB");
        addItem("请求头");

        addItem("userAgent", harDate.getUserAgent());
        addItem("host", harDate.getHost());
        addItem("Connection", harDate.getConnection());
        addItem("AcceptEncoding", harDate.getAcceptEncoding());
        addItem("请求体");
        addItem("requestBody", harDate.getRequestBody());

    }


    public void addItem(String title, final String value) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_detail, null);

        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        textView.setText(title);

        TextView valueTextView = (TextView) view.findViewById(R.id.tv_value);
        if (TextUtils.isEmpty(value)) {
            valueTextView.setText("");
        } else {
            valueTextView.setText(value.substring(0, value.length() > 50 ? 50 : value.length()));
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value != null && value.length() > 10) {
                    View textEntryView = LayoutInflater.from(HarDetailActivity.this).inflate(R.layout.alert_textview, null);
                    TextView edtInput = (TextView) textEntryView.findViewById(R.id.tv_content);
                    edtInput.setText(value);

                    AlertDialog.Builder builder = new AlertDialog.Builder(HarDetailActivity.this);
                    builder.setCancelable(true);
                    builder.setView(textEntryView);
                    builder.setPositiveButton("确认", null);
                    builder.show();
                }
            }
        });


        linearLayout.addView(view);
    }

    public void addItem(String cateName) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_cate, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_catetitle);
        textView.setText(cateName);
        linearLayout.addView(view);
    }

}
