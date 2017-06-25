package com.hd.ngandroidhttpfiddler.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.hd.ngandroidhttpfiddler.R;

/**
 * Created by jiangzn on 16/12/7.
 */
public class DialogUtil {
    static AlertDialog loadingDialog;

    //移除加载框
    public static void removeLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    //出现加载框
    public static void toggleLoadingDialog(final Context context) {
        if (loadingDialog == null || !loadingDialog.isShowing()) {
            loadingDialog = new AlertDialog.Builder(context)
                    .setView(R.layout.layout_loding).show();
        }
    }



}
