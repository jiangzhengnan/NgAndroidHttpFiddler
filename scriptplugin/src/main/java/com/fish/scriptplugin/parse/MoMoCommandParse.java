package com.fish.scriptplugin.parse;

import android.util.Log;

import com.fish.scriptplugin.ICommandParse;
import com.fish.scriptplugin.cmd.MoMoCommandConstans;
import com.fish.scriptplugin.cmd.WxCommandConstans;
import com.fish.scriptplugin.entity.PluginInfo;
import com.fish.scriptplugin.utility.StringUtility;

import org.json.JSONException;
import org.json.JSONObject;

import static android.R.attr.name;

/**
 * created by Pumpkin at 17/5/2
 */
public class MoMoCommandParse implements ICommandParse {
    private final String packetName = "com.immomo.momo";

    @Override
    public boolean isEqualPacket(String packetName) {
        if (this.packetName.equals(packetName)) {
            return true;
        } else {
            return false;
        }
    }

    //得到插件信息
    public static PluginInfo getPluginInfo() {
        return new PluginInfo(getBasicConfig(), MoMoCommandParse.class.getName());
    }


    private static String getBasicConfig() {
        return MoMoCommandConstans.baseConfig;
    }

    @Override
    public String parse(String cmd, String extData) {
        Log.d("nangua", "parse:" + cmd + "  extData:" + extData);
        switch (cmd) {
            case "注册":
                try {
                    JSONObject js = new JSONObject(extData);
                    return parseRegister(js);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            default:
                return "";
        }
    }

    //昵称， 性别， 年 月 日 手机号码， 密码
    private String parseRegister(JSONObject extData) {
        String registerData = "";

        String nickName = "";
        Integer sex = 0;
        Integer bornYear = 0;
        Integer month = 0;
        Integer day = 0;

        String pwd = "";
        try {
            if (extData.has("nickName")) {
                nickName = extData.getString("nickName");
            }
            if (extData.has("sex")) {
                sex = extData.getInt("sex");
            }
            if (extData.has("bornYear")) {
                bornYear = extData.getInt("bornYear");
            }
            if (extData.has("month")) {
                month = extData.getInt("month");
            }
            if (extData.has("day")) {
                day = extData.getInt("day");
            }
            if (extData.has("pwd")) {
                pwd = extData.getString("pwd");
            }
            registerData = getRegisterCommandJsonCmd(nickName, sex, bornYear, month, day, pwd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return registerData;
    }

    private String getRegisterCommandJsonCmd(String nickName, Integer sex, Integer year, Integer month, Integer day, String pwd) {
        String cmd = MoMoCommandConstans.registerJsonCmd;
        cmd = StringUtility.
                replaceMoMoRegister(cmd, nickName, sex, year, month, day,  pwd);
        return cmd;
    }

}
