package com.hd.ngandroidhttpfiddler.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.bean.AppTrafficModel;
import com.hd.ngandroidhttpfiddler.bean.BaseRvItemData;
import com.hd.ngandroidhttpfiddler.bean.QsApp;
import com.hd.ngandroidhttpfiddler.common.Config;
import com.ng.ngcommon.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class QsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private List<BaseRvItemData> listApps = new ArrayList<>();

    public QsAdapter(List<BaseRvItemData> listApps, Context context) {
        this.listApps = listApps;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Config.TYPE_FLOW_ITEM:
                view = LayoutInflater.from(context).inflate(R.layout.layout_qs_item, parent, false);
                return new QsItemViewHolder(view);
            default:
                return null;
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final BaseRvItemData baseRvItemData = listApps.get(position);
        switch (baseRvItemData.getItmeType()) {
            case Config.TYPE_FLOW_ITEM:
                QsApp qsApp = (QsApp) baseRvItemData.getItemData();
                LogUtils.d("onBindViewHolder" + " " + qsApp.toString());
                QsItemViewHolder qsItemViewHolder= (QsItemViewHolder) holder;
                qsItemViewHolder.tv_main_item_name_qs.setText(qsApp.getName());
                qsItemViewHolder.tv_main_item_packgename_qs.setText(qsApp.getPackgeName());
                qsItemViewHolder.iv_main_item_laucher_qs.setImageDrawable(qsApp.getIcon());
                break;
        }


    }

    @Override
    public int getItemCount() {
        return listApps.size();
    }

    class QsItemViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_main_item_laucher_qs;
        TextView tv_main_item_name_qs;
        TextView tv_main_item_packgename_qs;

        public QsItemViewHolder(View itemView) {
            super(itemView);
            tv_main_item_packgename_qs = (TextView) itemView.findViewById(R.id.tv_main_item_packgename_qs);
            tv_main_item_name_qs = (TextView) itemView.findViewById(R.id.tv_main_item_name_qs);
            iv_main_item_laucher_qs = (ImageView) itemView.findViewById(R.id.iv_main_item_laucher_qs);

        }
    }



    @Override
    public int getItemViewType(int position) {
        return listApps.get(position).getItmeType();
    }


}
