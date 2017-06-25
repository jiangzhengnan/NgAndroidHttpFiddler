package com.hd.ngandroidhttpfiddler.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hd.ngandroidhttpfiddler.R;


/**
 * 悬浮窗工具类
 * created by Pumpkin at 17/3/28
 */
public class WindowsUitlity {
    private static String TAG = WindowsUitlity.class.getSimpleName();
    private static WindowManager mWindowManager = null;
    private static LayoutParams params;
    public static Boolean isShown = false;
    private static View mView = null;

    /**
     * 显示弹出框
     *
     * @param context
     */
    @SuppressWarnings("WrongConstant")
    public static void showPopupWindow(final Context context, String showtxt) {
        if (isShown) {
            return;
        }
        isShown = true;
        // 获取WindowManager
        mWindowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        mView = setUpView(context, showtxt);

        params = new LayoutParams();
        // 类型，系统提示以及它总是出现在应用程序窗口之上。
        params.type = LayoutParams.TYPE_SYSTEM_ALERT |
                LayoutParams.TYPE_SYSTEM_OVERLAY;

        // 设置flag
        int flags = canTouchFlags;

        // | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
        params.flags = flags;
        // 不设置这个弹出框的透明遮罩显示为黑色
        params.format = PixelFormat.TRANSLUCENT;
        // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
        // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按
        // 不设置这个flag的话，home页的划屏会有问题
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.TOP;
        mWindowManager.addView(mView, params);
    }


    private static int canTouchFlags = LayoutParams.FLAG_NOT_FOCUSABLE
            | LayoutParams.FLAG_NOT_TOUCH_MODAL;

    private static int notTouchFlags = LayoutParams.FLAG_NOT_FOCUSABLE |
            LayoutParams.FLAG_NOT_TOUCHABLE;


    /**
     * 设置是否可响应点击事件
     *
     * @param isTouchable
     */
    public static void setTouchable(boolean isTouchable) {
        if (isTouchable) {
            params.flags = canTouchFlags;
        } else {
            params.flags = notTouchFlags;
        }
        mWindowManager.updateViewLayout(mView, params);

    }


    /**
     * 隐藏弹出框
     */
    public static void hidePopupWindow() {
        if (isShown && null != mView) {
            mWindowManager.removeView(mView);
            isShown = false;
        }
    }

    public static void setShowTxt(String txt) {
        try {
            TextView showTv = (TextView) mView.findViewById(R.id.tv_showinpop);
            showTv.setText(txt);
            mWindowManager.updateViewLayout(mView, params);
        } catch (Exception e) {
            Log.d(TAG, "setShowTxt: 更新悬浮框错误");
            e.printStackTrace();
            if (e.getMessage().contains("not attached to window manager")) {
                mWindowManager.addView(mView, params);
            }
        }
    }


    public static void setShowImg(Bitmap bitmap) {
        try {
            ImageView showImg = (ImageView) mView.findViewById(R.id.iv_showinpop);
            showImg.setImageBitmap(bitmap);
            mWindowManager.updateViewLayout(mView, params);
        } catch (Exception e) {
            Log.d(TAG, "setShowTxt: 更新悬浮框错误");
            e.printStackTrace();
            if (e.getMessage().contains("not attached to window manager")) {
                mWindowManager.addView(mView, params);
            }
        }
    }

    static RelativeLayout rl_drag_showinpop;

    private static View setUpView(final Context context, String showtxt) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_popwindow,
                null);

        TextView showTv = (TextView) view.findViewById(R.id.tv_showinpop);
        showTv.setText(showtxt);

        rl_drag_showinpop = (RelativeLayout) view.findViewById(R.id.rl_drag_showinpop);
        rl_drag_showinpop.setOnTouchListener(new View.OnTouchListener() {
            private float lastX; //上一次位置的X.Y坐标
            private float lastY;
            private float nowX;  //当前移动位置的X.Y坐标
            private float nowY;
            private float tranX; //悬浮窗移动位置的相对值
            private float tranY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean ret = false;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        // 获取按下时的X，Y坐标
                        lastX = event.getRawX();
                        lastY = event.getRawY();
                        ret = true;

                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 获取移动时的X，Y坐标
                        nowX = event.getRawX();
                        nowY = event.getRawY();
                        // 计算XY坐标偏移量
                        tranX = nowX - lastX;
                        tranY = nowY - lastY;
                        params.x += tranX;
                        params.y += tranY;

                        //更新悬浮窗位置
                        mWindowManager.updateViewLayout(mView, params);
                        //记录当前坐标作为下一次计算的上一次移动的位置坐标
                        lastX = nowX;
                        lastY = nowY;

                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return ret;
            }
        });

        return view;
    }
}
