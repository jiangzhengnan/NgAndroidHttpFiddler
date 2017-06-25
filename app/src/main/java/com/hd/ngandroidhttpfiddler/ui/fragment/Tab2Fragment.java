package com.hd.ngandroidhttpfiddler.ui.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.hd.ngandroidhttpfiddler.FlowController;
import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.adapter.Tab2RvAdapter;
import com.hd.ngandroidhttpfiddler.bean.AppTrafficModel;
import com.hd.ngandroidhttpfiddler.bean.BaseRvItemData;
import com.hd.ngandroidhttpfiddler.bean.HarDate;
import com.hd.ngandroidhttpfiddler.common.Config;
import com.ng.ngcommon.ui.fragment.BaseFragment;
import com.ng.ngcommon.util.LogUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

import static android.net.TrafficStats.UNSUPPORTED;

/**
 * created by Pumpkin at 17/3/14
 */
public class Tab2Fragment extends BaseFragment {
    @Bind(R.id.rv_frag2)
    RecyclerView rv_frag2;
    Tab2RvAdapter tab2RvAdapter;
    @Bind(R.id.spfresh_frag2)
    SwipeRefreshLayout spfresh_frag2;
    private volatile List<BaseRvItemData> listApps = new ArrayList<>();

    private volatile List<BaseRvItemData> eachApps = new ArrayList<>();

    @Override
    protected void initViewsAndEvents(View view) {

        //设置刷新球球
        spfresh_frag2.setColorSchemeResources(R.color.themeColor, R.color.themeColor, R.color.themeColor,
                R.color.themeColor);
        spfresh_frag2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listApps.clear();
                eachApps.clear();
                listApps.add(new BaseRvItemData(null, Config.TYPE_FLOW_RADAR));
                trafficMonitor();
                listApps.addAll(eachApps);

                uiHandler.sendEmptyMessage(0);

            }
        });
        rv_frag2.setItemAnimator(new DefaultItemAnimator());
        rv_frag2.setLayoutManager(new LinearLayoutManager(getContext()));

        tab2RvAdapter = new Tab2RvAdapter(listApps, getContext());
        rv_frag2.setAdapter(tab2RvAdapter);

        listApps.add(new BaseRvItemData(null, Config.TYPE_FLOW_RADAR));


        //开启定时器去轮询监控,30秒一次
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 3 * 10 * 1000;
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            listApps.clear();
            eachApps.clear();
            listApps.add(new BaseRvItemData(null, Config.TYPE_FLOW_RADAR));
            trafficMonitor();
            listApps.addAll(eachApps);

            uiHandler.sendEmptyMessage(0);
        }
    };

    Handler uiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            tab2RvAdapter.notifyDataSetChanged();
            spfresh_frag2.setRefreshing(false);
        }
    };

    /**
     * 遍历有联网权限的应用程序的流量记录
     */
    private void trafficMonitor() {
        if (getActivity() == null) {
            return;
        }
        PackageManager pm = getActivity().getPackageManager();
        List<PackageInfo> packinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES | PackageManager.GET_PERMISSIONS);
        for (PackageInfo info : packinfos) {

            String[] premissions = info.requestedPermissions;
            if (premissions != null && premissions.length > 0) {
                for (String premission : premissions) {
                    if ("android.permission.INTERNET".equals(premission)) {
                        // System.out.println(info.packageName+"访问网络");
                        int uid = info.applicationInfo.uid;
                        long rx = TrafficStats.getUidRxBytes(uid);
                        long tx = TrafficStats.getUidTxBytes(uid);

                        AppTrafficModel appTrafficModel = new AppTrafficModel();

                        //   LogUtils.d("app名字:" + pm.getApplicationLabel(info.applicationInfo) +
                        //         "  得到的uid:" + uid);


                        appTrafficModel.setAppInfo(info.applicationInfo);
                        appTrafficModel.setDownload(rx);
                        appTrafficModel.setUpload(tx);

                        FlowController.getInstance().setTotalBytes(TrafficStats.getTotalTxBytes());
                        FlowController.getInstance().setTotalPackets(TrafficStats.getTotalTxPackets());


                        eachApps.add(new BaseRvItemData(appTrafficModel, Config.TYPE_FLOW_ITEM));
//                        /** 获取手机指定 UID 对应的应程序用通过所有网络方式接收的字节流量总数(包括 wifi) */
//                        LogUtils.d(TrafficStats.getUidRxBytes(uid) + "");
//                        /** 获取手机指定 UID 对应的应用程序通过所有网络方式发送的字节流量总数(包括 wifi) */
//                        LogUtils.d(TrafficStats.getUidTxBytes(uid) + "");
//
//                        LogUtils.d(getRcvTraffic(uid) +"");
                    }
                }
            }
        }


        //按流量排序
        Collections.sort(eachApps, new Comparator<BaseRvItemData>() {
            @Override
            public int compare(BaseRvItemData o1, BaseRvItemData o2) {
                long o1all = ((AppTrafficModel) o1.getItemData()).getDownload() + ((AppTrafficModel) o1.getItemData()).getUpload();
                long o2all = ((AppTrafficModel) o2.getItemData()).getDownload() + ((AppTrafficModel) o2.getItemData()).getUpload();

                if (o1all<o2all) {
                    return 1;
                }

                if (o1all>o2all) {
                    return -1;
                }

                if (o1all==o2all) {
                    return 0;
                }
                return 0;
            }

        });

//        /** 获取手机通过 2G/3G 接收的字节流量总数 */
//        LogUtils.d("获取手机通过 2G/3G 接收的字节流量总数:" + Formatter.formatFileSize(getContext(), TrafficStats.getMobileRxBytes()) + "");
//        /** 获取手机通过 2G/3G 接收的数据包总数 */
//        LogUtils.d("获取手机通过 2G/3G 接收的数据包总数:" + TrafficStats.getMobileRxPackets() + "");
//        /** 获取手机通过 2G/3G 发出的字节流量总数 */
//        LogUtils.d("获取手机通过 2G/3G 发出的字节流量总数:" + TrafficStats.getMobileTxBytes() + "");
//        /** 获取手机通过 2G/3G 发出的数据包总数 */
//        LogUtils.d("获取手机通过 2G/3G 发出的数据包总数:" + TrafficStats.getMobileTxPackets() + "");
//        /** 获取手机通过所有网络方式接收的字节流量总数(包括 wifi) */
//        LogUtils.d("获取手机通过所有网络方式接收的字节流量总数(包括 wifi):" + TrafficStats.getTotalRxBytes() + "");
//        /** 获取手机通过所有网络方式接收的数据包总数(包括 wifi) */
//        LogUtils.d("获取手机通过所有网络方式接收的数据包总数(包括 wifi):" + TrafficStats.getTotalRxPackets() + "");
//
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_tab2;
    }

    @Override
    protected void onClick(View view) {

    }

    /**
     * 获取下载流量 某个应用的网络流量数据保存在系统的/proc/uid_stat/$UID/tcp_rcv | tcp_snd文件中
     */
    public long getRcvTraffic(int uid) {
        long rcvTraffic = UNSUPPORTED; // 下载流量
        rcvTraffic = TrafficStats.getUidRxBytes(uid);
        if (rcvTraffic == UNSUPPORTED) { // 不支持的查询
            return UNSUPPORTED;
        }
        Log.i("test", rcvTraffic + "--1");
        RandomAccessFile rafRcv = null, rafSnd = null; // 用于访问数据记录文件
        String rcvPath = "/proc/uid_stat/" + uid + "/tcp_rcv";
        try {
            rafRcv = new RandomAccessFile(rcvPath, "r");
            rcvTraffic = Long.parseLong(rafRcv.readLine()); // 读取流量统计
        } catch (FileNotFoundException e) {
            LogUtils.d("FileNotFoundException: " + e.getMessage());
            rcvTraffic = UNSUPPORTED;
        } catch (IOException e) {
            LogUtils.d("IOException: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rafRcv != null)
                    rafRcv.close();
                if (rafSnd != null)
                    rafSnd.close();
            } catch (IOException e) {
                LogUtils.d("Close RandomAccessFile exception: " + e.getMessage());
            }
        }
        Log.i("test", rcvTraffic + "--2");
        return rcvTraffic;
    }

}
