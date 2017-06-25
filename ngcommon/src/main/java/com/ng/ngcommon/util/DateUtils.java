package com.ng.ngcommon.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangzn on 16/12/5.
 */

public class DateUtils {

    public static String dateFormat(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return formatter.format(date);
    }

    public static String dateFormat24(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        return formatter.format(date);
    }


    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());
    }
}
