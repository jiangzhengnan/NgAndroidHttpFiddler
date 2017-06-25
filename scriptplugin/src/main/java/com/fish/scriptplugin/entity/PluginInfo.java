package com.fish.scriptplugin.entity;

/**
 * 插件信息描述
 * Created by xjm on 2017/2/27.
 */

public class PluginInfo {
    public String baseInfo;
    public String commandClass;

    public PluginInfo(String baseInfo, String commandClass){
        this.baseInfo = baseInfo;
        this.commandClass = commandClass;
    }
}
