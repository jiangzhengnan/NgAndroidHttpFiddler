package com.hd.ngandroidhttpfiddler.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.ng.ngcommon.util.LogUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetUtils {

    /**
     * 通过远程IP和端口，获取对应的程序的APP，
     * 其实这样会有误差，没有本地IP和本地端口
     * * @param remoteIP
     * * @param remotePort
     * * @return
     */
    public static String getAppNameFromNet(String remotePort, Context context) throws Exception {

        String user = proc_net_tcp_get_user(remotePort);

        LogUtils.d("得到的user:" + user);
        String packetName = getPackgeNameByUser(user);
        LogUtils.d("得到的包名:" + packetName);

        return getAppNameByPacketName(packetName, context);
    }

    public static String getAppNameByPacketName(String packetName, Context context) {
        PackageManager pm = context.getPackageManager();
        String appName = "";
        try {
            ApplicationInfo info = pm.getApplicationInfo(packetName, PackageManager.GET_META_DATA);
            appName = pm.getApplicationLabel(info).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appName;
    }

    public static String getUidByInode(String Inode) throws Exception {
        String cmd = "cat /proc/net/tcp6";
        LogUtils.d("执行命令:" + cmd);
        String result = execCmd(cmd);
        LogUtils.d("执行ps命令: cmd:" + cmd + "结果:" + result);
        String findStr = grep(result, Inode, false);
        return getInodeFromProc_net_tcp6(findStr);
    }

    public static String getUidByUser(String User) throws Exception {
        String cmd = "cat /proc/net/tcp6";
        LogUtils.d("执行命令:" + cmd);
        String result = execCmd(cmd);
        LogUtils.d("执行ps命令: cmd:" + cmd + "结果:" + result);
        String findStr = grep(result, User, false);
        return getInodeFromProc_net_tcp6(findStr);
    }

    public static String getUserFromProc_net_tcp6(String srcString) {
        String[] arr = srcString.split("\\s+");
        return arr[6];
    }

    public static String getInodeFromProc_net_tcp6(String srcString) {
        String[] arr = srcString.split("\\s+");
        return arr[8];
    }

    public static String getPackgeNameByUser(String user) throws Exception {
        String cmd = "ps -p";
        LogUtils.d("执行命令:" + cmd);
        String result = execCmd(cmd);
        LogUtils.d("执行ps命令: cmd:" + cmd + "结果:" + result);
        String findStr = grep(result, user, false);
        return getPackgeName(findStr);
    }

    public static String getPackgeName(String srcString) {
        String[] arr = srcString.split("\\s+");
        return arr[8];
    }

    public static String proc_net_tcp_get_user(String remotePort) throws Exception {
        String cmd = "netstat -en";
        LogUtils.d("执行命令:" + cmd);
        //不支持管道，因为本身导入程序，所以我们必须自己处理查
        String result = execCmd(cmd);
        LogUtils.d(remotePort + "netstat -e命令: cmd:" + cmd + "结果:" + result);
        String findStr = grep(result, remotePort, false);
        LogUtils.d("netstat -e查找到的行: " + findStr);
        return getUser(findStr);
    }

    public static String proc_net_tcp_get_Inode(String remotePort) throws Exception {
        String cmd = "netstat -en";
        LogUtils.d("执行命令:" + cmd);
        //不支持管道，因为本身导入程序，所以我们必须自己处理查
        String result = execCmd(cmd);
        LogUtils.d(remotePort + cmd + "命令: cmd:" + cmd + "结果:" + result);
        String findStr = grep(result, remotePort, false);
        LogUtils.d(cmd + "查找到的行: " + findStr);
        return getInode(findStr);
    }

    public static String getInode(String srcString) {
        String[] arr = srcString.split("\\s+");
        return arr[7];
    }


    public static String getUser(String srcString) {
        String[] arr = srcString.split("\\s+");
        return arr[6];
    }

    public static String grep(String srcString, String finStr, boolean isPrecise) {
        String[] spitString = srcString.split("\n");
        for (int i = 0; i < spitString.length; i++) {
            //LogUtils.d("第" + i + "行: " + spitString[i]);

            if (isPrecise) {
                if (spitString[i].equals(finStr)) {
                    return spitString[i];
                }
            } else {
                //LogUtils.d("每一行的数据:" + spitString[i].toString());
                if (spitString[i].contains(finStr)) {
                    return spitString[i];
                }
            }
        }
        return null;
    }


    public static String execCmd(String cmd) throws IOException, InterruptedException {
        String result = "";
        BufferedReader myBufferReader = null;
        try {

            Process process = Runtime.getRuntime().exec(cmd);
            myBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            do {
                String readBuffer = myBufferReader.readLine();
                if (readBuffer != null) {
                    result += readBuffer;
                    result += "\r\n";
                } else {
                    break;
                }
            } while (true);

        } finally {
            try {
                myBufferReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
