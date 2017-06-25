package com.hd.ngandroidhttpfiddler.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class PermissionUtil {
    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
            Manifest.permission.WAKE_LOCK,
            Manifest.permission.PACKAGE_USAGE_STATS
    };


    /**
     * Checks if the app has permission to write to device storage
     * If the app does not has permission then the user will be prompted to
     * grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        for (int i = 0;i<PERMISSIONS_STORAGE.length;i++) {
            toShenqing(i,activity);
        }
    }

    private static  void toShenqing(int index,Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity,
                PERMISSIONS_STORAGE[index]);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    index);
        }
    }
}
