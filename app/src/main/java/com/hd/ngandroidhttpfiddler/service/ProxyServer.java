package com.hd.ngandroidhttpfiddler.service;

import android.content.Context;
import android.util.Log;

import com.hd.ngandroidhttpfiddler.bean.HarDate;
import com.hd.ngandroidhttpfiddler.controller.HarManager;
import com.ng.ngcommon.util.LogUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单测试代码
 */

public class ProxyServer {

    private ServerSocket serverSocket = null;

    /**
     * 默认所有都是阻塞accept 阻塞 inputStream.read也是阻塞的
     * @return
     */
    public boolean start(final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(8888);

                    do {
                        final Socket s = serverSocket.accept();
                        Runnable socketMsgRunale = new Runnable() {
                            @Override
                            public void run() {
                                InputStream inputStream = null;
                                try {

                                    inputStream = s.getInputStream();

                                    do {
                                        byte[] buffer = new byte[2048];
                                        int nlen = inputStream.read(buffer);
                                        if (nlen == 0 || nlen == -1) {
                                            break;
                                        }
                                        String requestStr = new String(buffer, 0, nlen);

                                        Log.d("nangua", "start: " + requestStr);
                                        String request = "start: " + requestStr;
                                        HarDate harDate = new HarDate();
                                        harDate.setPort(s.getPort() + "");

                                        String url = getIndex(grep(request, "start:", false), 2);

                                        String userAgentStr = grep(request, "User-Agent:", false);
                                        String userAgent = userAgentStr == "" ? "" : userAgentStr.substring(0, userAgentStr.length() - 1);

                                        String host = getIndex(grep(request, "Host:", false), 1);
                                        String Connection = getIndex(grep(request, "Connection:", false), 1);
                                        String AcceptEncoding = getIndex(grep(request, "Accept-Encoding:", false), 1);

                                        String contentLength = getIndex(grep(request, "Content-Length:", false) ,1);
                                        if (contentLength != "") {
                                            long bytes = Long.parseLong(contentLength);

                                            harDate.setBytes(bytes);
                                        }

                                        harDate.setUrl(url);
                                        harDate.setUserAgent(userAgent);
                                        harDate.setHost(host);
                                        harDate.setConnection(Connection);
                                        harDate.setAcceptEncoding(AcceptEncoding);
                                        harDate.setRequestBody(getLastLine(request));
                                        HarManager.getInstance().addEntries(harDate);
                                        handlePakcetFiter(new String(buffer, 0, nlen));
                                    } while (true);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        };

                        new Thread(socketMsgRunale).start();
                    } while (true);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        return true;
    }

    /**
     * 处理恶意软件
     *
     * @param msg
     */
    void handlePakcetFiter(String msg) {
        if (msg.contains("58shangwang.com")) {
        }
    }


    private static String grep(String srcString, String finStr, boolean isPrecise) {
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
        return "";
    }

    private static String getLastLine(String srcString) {

        String[] spitString = srcString.split("\n");
        return spitString[spitString.length - 1];
    }

    private static String getIndex(String srcString, int index) {
        String[] arr = srcString.split("\\s+");
        if (index >= arr.length) {
            index = arr.length - 1;
        }
        return arr[index];
    }
}
