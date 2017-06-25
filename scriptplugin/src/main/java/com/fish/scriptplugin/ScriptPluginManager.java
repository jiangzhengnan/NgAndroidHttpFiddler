package com.fish.scriptplugin;

import com.fish.scriptplugin.entity.PluginInfo;
import com.fish.scriptplugin.parse.MoMoCommandParse;
import com.fish.scriptplugin.parse.WxCommandParse;

import java.util.HashMap;
import java.util.Map;

/**
 * 插件管理
 * 获取各个的插件类名
 * Created by xjm on 2017/2/27.
 */

public class ScriptPluginManager {
    private Map<String, PluginInfo>  pluginCommand = new HashMap<>();

    public ScriptPluginManager(){
        init();
    }

    /**
     * 初始化支持的功能，增加的新的功能需要在这里增加
     */
    private void  init(){
        pluginCommand.put("com.tencent.mm", WxCommandParse.getPluginInfo());
        pluginCommand.put("com.immomo.momo", MoMoCommandParse.getPluginInfo());


    }

    public String getPluginCommand(String name){
        String pluginClass = "";
        PluginInfo info = pluginCommand.get(name);
        return info.commandClass;
    }

    /**
     * 返回每个插件基本的配置，用于基本的加载
     * @param name
     * @return
     */
    public String getBasePlguinConfig(String name){
        String baseCmd = "";
        for(Map.Entry<String,PluginInfo> entry : pluginCommand.entrySet()){
            if(entry.getKey().equals(name)){
                return entry.getValue().baseInfo;
            }
        }
        return "";
    }

    /**
     * 返回所有基本配置
     * @return
     */
    public Map<String, String> getAllBasicConfig(){
        Map<String,String> basicMap = new HashMap<>();
        for(Map.Entry<String,PluginInfo> entry : pluginCommand.entrySet()){
            basicMap.put(entry.getKey(), entry.getValue().baseInfo);
        }
        return basicMap;
    }
}

