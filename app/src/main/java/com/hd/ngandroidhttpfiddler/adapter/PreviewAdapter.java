package com.hd.ngandroidhttpfiddler.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.bean.HarDate;
import com.hd.ngandroidhttpfiddler.controller.HarManager;
import com.hd.ngandroidhttpfiddler.ui.activity.HarDetailActivity;
import com.hd.ngandroidhttpfiddler.utils.TextUtils;
import com.ng.ngcommon.util.LogUtils;

import java.util.List;


public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.MyViewHolder> {
    Context context;

    private static List<HarDate> harDateList;


    public PreviewAdapter(Context context) {
        this.context = context;
        harDateList = HarManager.getInstance().getHarDateList();
    }

    public void refreshDate() {
        this.harDateList = HarManager.getInstance().getHarDateList();
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_preview, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final HarDate harDate = harDateList.get(position);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("点击跳转!");
                Intent intent = new Intent(context, HarDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("harDate", harDate);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        if (harDate.getHost()==""){
            holder.tv.setText("未获取到host");
        } else {
            holder.tv.setText(harDate.getHost());
        }

        holder.tv_times.setText(harDateList.get(position).getTimes() + "");

        holder.iconView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_request));

        holder.detailTextView.setText(TextUtils.bytes2kb(harDate.getBytes()));

        holder.ll_item_bg.setBackgroundColor(HarManager.getInstance().getDangerousDegree(context,harDate));

    }


    @Override
    public int getItemCount() {
        return harDateList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_item_bg;
        TextView tv;
        TextView detailTextView;
        View rootView;
        ImageView iconView;
        TextView tv_times;

        public MyViewHolder(View view) {
            super(view);
            ll_item_bg = (LinearLayout) view.findViewById(R.id.ll_item_bg);
            tv_times = (TextView) view.findViewById(R.id.tv_times);
            tv = (TextView) view.findViewById(R.id.tv_url);
            detailTextView = (TextView) view.findViewById(R.id.tv_detail);
            rootView = view;
            iconView = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }


}