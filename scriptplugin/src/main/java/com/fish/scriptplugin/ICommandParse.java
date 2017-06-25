package com.fish.scriptplugin;

import org.json.JSONObject;

/**
 * Created by xjm on 2017/2/24.
 */

public interface ICommandParse {

    boolean isEqualPacket(String packetName);

    /**
     * 解析执行的命令
     * @param cmd   需要执行的命令
     * @param extData   扩展数据
     * @return
     */
    String parse(String cmd, String extData);
}