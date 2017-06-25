package com.hd.ngandroidhttpfiddler.adapter;/**
 * Created by ${Pumpkin} on 17/5/9.
 */

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hd.ngandroidhttpfiddler.FlowController;
import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.bean.AppTrafficModel;
import com.hd.ngandroidhttpfiddler.bean.BaseRvItemData;
import com.hd.ngandroidhttpfiddler.common.Config;
import com.hd.ngandroidhttpfiddler.controller.HarManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.hd.ngandroidhttpfiddler.R.id.tv_totolpakes;


/**
 * created by Pumpkin at 17/5/9
 */
public class Tab2RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private List<BaseRvItemData> listApps = new ArrayList<>();

    public Tab2RvAdapter(List<BaseRvItemData> listApps, Context context) {
        this.listApps = listApps;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Config.TYPE_FLOW_RADAR:

                view = LayoutInflater.from(context).
                        inflate(R.layout.layout_radaritem_tab2_fragment, parent, false);
                return new RadarViewHolder(view);
            case Config.TYPE_FLOW_ITEM:
                view = LayoutInflater.from(context).inflate(R.layout.layout_frag2_item, parent, false);
                return new Tab2ItemViewHolder(view);
            default:
                return null;
        }

    }

    static boolean hasSendRadar = false;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final BaseRvItemData baseRvItemData = listApps.get(position);
        switch (baseRvItemData.getItmeType()) {
            case Config.TYPE_FLOW_RADAR:

                RadarViewHolder radarViewHolder = (RadarViewHolder) holder;
                initRadarPath(radarViewHolder.radar_scan_img);
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putSerializable("holder", radarViewHolder);
                message.setData(bundle);
                if (!hasSendRadar) {
                    hasSendRadar = true;
                    pointChangedHandler.sendMessageDelayed(message, 3000);
                }
                radarViewHolder.tv_totolbytes.setText("实时字节流量:" + Formatter.formatFileSize(context, FlowController.getInstance().getTotalBytes()));
                radarViewHolder.tv_totolpakes.setText("实时数据包流量:" + Formatter.formatFileSize(context, FlowController.getInstance().getTotalPackets()));
                break;
            case Config.TYPE_FLOW_ITEM:
                PackageManager pm = context.getPackageManager();

                AppTrafficModel trafficModel = (AppTrafficModel) listApps.get(position).getItemData();
                Tab2ItemViewHolder tab2ItemViewHolder = (Tab2ItemViewHolder) holder;

                tab2ItemViewHolder.ivLauncher.setImageDrawable(trafficModel.getAppInfo().loadIcon(pm));

                tab2ItemViewHolder.tvName.setText((String) pm.getApplicationLabel(trafficModel.getAppInfo()));
                if (trafficModel.getDownload() == -1) {
                    tab2ItemViewHolder.tvDownload.setText("下行：0 B");
                } else {
                    tab2ItemViewHolder.tvDownload.setText("下行：" + Formatter.formatFileSize(context, trafficModel.getDownload()));
                }

                if (trafficModel.getUpload() == -1) {
                    tab2ItemViewHolder.tvUpload.setText("上行：0 B");
                } else {
                    tab2ItemViewHolder.tvUpload.setText("上行：" + Formatter.formatFileSize(context, trafficModel.getUpload()));
                }



                break;
        }


    }

    @Override
    public int getItemCount() {
        return listApps.size();
    }

    class Tab2ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView ivLauncher;
        TextView tvName;
        TextView tvDownload;
        TextView tvUpload;
        RelativeLayout rl_item_bg;


        public Tab2ItemViewHolder(View itemView) {
            super(itemView);
            rl_item_bg = (RelativeLayout) itemView.findViewById(R.id.rl_item_bg);
            ivLauncher = (ImageView) itemView.findViewById(R.id.iv_main_item_laucher);
            tvName = (TextView) itemView.findViewById(R.id.tv_main_item_name);
            tvDownload = (TextView) itemView.findViewById(R.id.tv_main_item_download);
            tvUpload = (TextView) itemView.findViewById(R.id.tv_main_item_upload);

        }
    }

    public class RadarViewHolder extends RecyclerView.ViewHolder implements Serializable {
        ImageView radar_scan_img;
        ImageView radar_point1;
        ImageView radar_point2;
        ImageView radar_point3;
        ImageView[] radar_points;

        TextView tv_totolbytes;
        TextView tv_totolpakes;

        public RadarViewHolder(View itemView) {
            super(itemView);
            radar_scan_img = (ImageView) itemView.findViewById(R.id.radar_scan_img);
            radar_point1 = (ImageView) itemView.findViewById(R.id.radar_point1);
            radar_point2 = (ImageView) itemView.findViewById(R.id.radar_point2);
            radar_point3 = (ImageView) itemView.findViewById(R.id.radar_point3);
            radar_points = new ImageView[]{radar_point1, radar_point2, radar_point3};

            tv_totolbytes = (TextView) itemView.findViewById(R.id.tv_totolbytes);
            tv_totolpakes = (TextView) itemView.findViewById(R.id.tv_totolpakes);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return listApps.get(position).getItmeType();
    }


    private void initRadarPath(ImageView radarLine) {
        PropertyValuesHolder rotate = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder
                (radarLine, rotate);
        //匀速
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(3000);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.start();
    }

    Handler pointChangedHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //每次随机一个
            RadarViewHolder radarViewHolder = (RadarViewHolder) msg.getData().getSerializable("holder");
            int num = (int) (Math.random() * 3);
            //LogUtils.d("随机选择的:" + num);
            for (int i = 0; i < radarViewHolder.radar_points.length; i++) {
                if (i == num) {
                    radarViewHolder.radar_points[i].setImageDrawable(context.getResources().getDrawable(R.drawable.rend_point_light));
                } else {
                    radarViewHolder.radar_points[i].setImageDrawable(context.getResources().getDrawable(R.drawable.rend_point_normal));
                }
            }

            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putSerializable("holder", radarViewHolder);
            message.setData(bundle);
            pointChangedHandler.sendMessageDelayed(message, 3000);
        }
    };

}