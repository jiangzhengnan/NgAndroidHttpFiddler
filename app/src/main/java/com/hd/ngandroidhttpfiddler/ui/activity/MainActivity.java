package com.hd.ngandroidhttpfiddler.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.security.KeyChain;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hd.ngandroidhttpfiddler.R;
import com.hd.ngandroidhttpfiddler.common.EventConfig;
import com.hd.ngandroidhttpfiddler.common.SharedPrefereConstants;
import com.hd.ngandroidhttpfiddler.ui.fragment.Tab1Fragment;
import com.hd.ngandroidhttpfiddler.ui.fragment.Tab2Fragment;
import com.hd.ngandroidhttpfiddler.ui.fragment.Tab3Fragment;
import com.hd.ngandroidhttpfiddler.utils.PermissionUtil;
import com.ng.ngcommon.bean.event.MessageEvent;
import com.ng.ngcommon.ui.activity.BaseFragmentActivity;
import com.ng.ngcommon.util.LogUtils;
import com.ng.ngcommon.util.PreferencesUtil;
import com.ng.ngcommon.util.RecycleBitmap;
import com.ng.ngcommon.view.NGHorizontalScrollCursor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentActivity implements
        NGHorizontalScrollCursor.onViewPagerChanggedListner {

    @Bind(R.id.sc_main)
    NGHorizontalScrollCursor sc_main;
    @Bind(R.id.tv_tag_main)
    TextView tv_tag_main;
    @Bind(R.id.rv_container)
    RelativeLayout rv_container;
    @Bind(R.id.btn_right_main)
    ImageView btn_right_main;
    FragmentPagerAdapter fPagerAdapter;
    private List<View> views;
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    private int[] radiobtnid = {R.id.ll_menu_tab1, R.id.ll_menu_tab2,
            R.id.ll_menu_tab3};
    private LinearLayout[] radiobtns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.btn_right_main})
    @Override
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_right_main:
                Intent i = new Intent(MainActivity.this,SetingActivity.class);
                startActivity(i);
                break;
        }
    }

    Tab1Fragment tab1Fragment;
    Tab3Fragment tab3Fragment;
    Tab2Fragment tab2Fragment;

    @Override
    protected void initViewsAndEvents() {

        PermissionUtil.verifyStoragePermissions(this);

        fragments = new ArrayList<>();
        //绑定按钮组件
        radiobtns = new LinearLayout[3];
        for (int i = 0; i < 3; i++) {
            final int j = i;
            radiobtns[i] = (LinearLayout) findViewById(radiobtnid[i]);
            radiobtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeTagView(j);
                }
            });
        }

        LayoutInflater inflater = LayoutInflater.from(this);

        // 添加滑动
        views = new ArrayList<>();
        views.add(inflater.inflate(R.layout.fragment_tab1, null));
        views.add(inflater.inflate(R.layout.fragment_tab2, null));
        views.add(inflater.inflate(R.layout.fragment_tab3, null));
        vp = (ViewPager) findViewById(R.id.main_viewPager);
        fPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragments.get(arg0);
            }
        };
        // 声明各个Tab的实例
        tab1Fragment = new Tab1Fragment();
        tab2Fragment = new Tab2Fragment();
        tab3Fragment = new Tab3Fragment();

        fragments.add(tab1Fragment);
        fragments.add(tab2Fragment);
        fragments.add(tab3Fragment);
        vp.setAdapter(fPagerAdapter);

        //设置游标
        sc_main.setcallback(MainActivity.this);
        sc_main.setViewPager(vp);

        //注意，设置Page 即缓存页面的个数，数过小时会出现fragment重复加载的问题
        vp.setOffscreenPageLimit(3);

        for (int i = 0; i < itemId.length; i++) {
            View v = findViewById(itemId[i]);
            v.setTag(i);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = Integer.parseInt(v.getTag() + "");
                    onChange(position, true);
                }
            });
        }

        for (int i = 0; i < itemImgId.length; i++) {
            View v = findViewById(itemImgId[i]);
            RecycleBitmap.loadLocalDrawable(this, v, img[i]);
        }

        vp.setCurrentItem(0);
        onChange(0, false);


        //WindowsUitlity.showPopupWindow(getApplicationContext(), "网络助手检测中...");

    }

    // 更换标签
    private void changeTagView(int change) {
        vp.setCurrentItem(change, true);
    }


    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void onGetEvent(MessageEvent event) {
        switch (event.getMessageType()) {
            case EventConfig.REFRESH_HAR_LOG:
                LogUtils.d("刷新");
                break;
            case EventConfig.REFRESH_RESULT:
                LogUtils.d("MainActivity: onGetEvent：刷新frag3数据");
                tab3Fragment.refreshDate();
                break;
        }
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    public void CheckPage(int position) {
        onChange(position, false);
        switch (position) {
            case 0:
                tv_tag_main.setText(getResources().getString(R.string.main_radiobtn_tab1));
                break;
            case 1:
                tv_tag_main.setText(getResources().getString(R.string.main_radiobtn_tab2));
                break;
            case 2:
                tv_tag_main.setText(getResources().getString(R.string.main_radiobtn_tab3));
                break;
        }
    }


    public void onChange(int position, boolean tag) {
        if (tag) {
            changeTagView(position);
        }
        for (int i = 0; i < itemId.length; i++) {
            if (i == position) {
                ((TextView) findViewById(itemTextId[i])).setTextColor(this
                        .getResources().getColor(R.color.main_tab_tv_color));
                ((ImageView) findViewById(itemImgId[i]))
                        .setImageResource(img_s[i]);
            } else {
                ((TextView) findViewById(itemTextId[i])).setTextColor(this
                        .getResources().getColor(R.color.word_9c));
                ((ImageView) findViewById(itemImgId[i]))
                        .setImageResource(img[i]);
            }
        }
    }

    private int[] img = new int[]{
            R.drawable.ic_tab1_normal
            , R.drawable.ic_tab2_normal
            , R.drawable.ic_tab3_normal
    };

    private int[] img_s = new int[]{
            R.drawable.ic_tab1_select
            , R.drawable.ic_tab2_select
            , R.drawable.ic_tab3_select
    };

    private int[] itemImgId = new int[]{
            R.id.iv_menu_tab1
            , R.id.iv_menu_tab2
            , R.id.iv_menu_tab3
    };

    private int[] itemTextId = new int[]{
            R.id.tv_menu_tab1
            , R.id.tv_menu_tab2
            , R.id.tv_menu_tab3
    };

    private int[] itemId = new int[]{R.id.ll_menu_tab1
            , R.id.ll_menu_tab2
            , R.id.ll_menu_tab3
    };


    public Set<String> disablePages = new HashSet<>();


}
