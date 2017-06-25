package com.hd.ngandroidhttpfiddler.ui.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.adapter.QsAdapter;
import com.hd.ngandroidhttpfiddler.bean.BaseRvItemData;
import com.hd.ngandroidhttpfiddler.bean.QsApp;
import com.hd.ngandroidhttpfiddler.common.Config;
import com.hd.ngandroidhttpfiddler.controller.ResultManager;
import com.ng.ngcommon.ui.fragment.BaseFragment;
import com.ng.ngcommon.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.hd.ngandroidhttpfiddler.R.id.rv_qs;
import static com.hd.ngandroidhttpfiddler.R.id.spfresh_frag3;

/**
 * created by Pumpkin at 17/3/14
 */
public class Tab3Fragment extends BaseFragment {
    
    @Bind(R.id.spfresh_frag3)
    SwipeRefreshLayout spfresh_frag3;
    @Bind(R.id.rv_frag3)
    RecyclerView rv_frag3;

    QsAdapter qsRvAdapter;

    private   List<BaseRvItemData> listApps = new ArrayList<>();

    private   List<QsApp> qsAppList = new ArrayList<>();


    @Override
    protected void initViewsAndEvents(View view) {
        rv_frag3.setLayoutManager(new LinearLayoutManager(getContext()));

        //设置刷新球球
        spfresh_frag3.setColorSchemeResources(R.color.themeColor, R.color.themeColor, R.color.themeColor,
                R.color.themeColor);
        spfresh_frag3.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshDate();
            }
        });

        qsRvAdapter = new QsAdapter(listApps, getContext());
        rv_frag3.setAdapter(qsRvAdapter);
    }

    //刷新资料
    public void refreshDate() {
        listApps.clear();

        spfresh_frag3.setRefreshing(false);

        qsAppList = ResultManager.getInstance().getQsAppList();
        LogUtils.d("qsAppList:" + qsAppList.size() + qsAppList.toString());
        for (QsApp qsApp:qsAppList) {
            LogUtils.d("Tab3添加的数据:" + qsApp.toString());
            listApps.add(new BaseRvItemData(qsApp,Config.TYPE_FLOW_ITEM));
        }

        qsRvAdapter.notifyDataSetChanged();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_tab3;
    }

    @Override
    protected void onClick(View view) {
        
    }
}
