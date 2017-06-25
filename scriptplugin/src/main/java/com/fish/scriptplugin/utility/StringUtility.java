package com.fish.scriptplugin.utility;


import android.util.Log;

import com.fish.scriptplugin.cmd.WxCommandFunctionsConstans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于字符串处理,这种封装都是针对业务代码
 * Created by xjm on 2017/2/24.
 */

public class StringUtility {
    private static String TAG = "nangua";

    //插入新的json脚本命令方法
    public static String addCommandInActions(String oldCommand, String needInsertCommand) {
        JSONObject rawObj = null;
        try {
            rawObj = new JSONObject(oldCommand);

            JSONArray cmdArray = rawObj.getJSONArray("cmd");

            JSONObject rawActionsObj = cmdArray.getJSONObject(0);
            JSONArray rawActionsArray = rawActionsObj.getJSONArray("actions");
            //Log.d("nangua", "得到的命令数组:" + rawActionsArray);

            JSONObject needaddObj = new JSONObject(needInsertCommand);
            JSONArray needaddArray = needaddObj.getJSONArray("actions");
            //Log.d("nangua", "待合并数组:" + needaddArray);

            //rawActionsArray.addAll(needaddArray);
            rawActionsArray = new JSONArray(joinJSONArry(rawActionsArray, needaddArray));
            //Log.d("nangua", "合并之后:" + rawActionsArray);

            rawActionsObj.put("actions", rawActionsArray);
            //Log.d("nangua", "put替换操作之后的rawActionsObj：" + rawActionsObj.toString());

            cmdArray.put(0, rawActionsObj);
            //Log.d("nangua", "替换操作之后的cmdArray:" + cmdArray.toString());

            rawObj.put("cmd", cmdArray);
            Log.d("nangua", "addCommandInActions操作之后的命令:" + rawObj.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rawObj.toString();
    }


    public static String joinJSONArry(JSONArray jsonArray1, JSONArray jsonArray2) {
        StringBuffer buffer = new StringBuffer();
        String bufferString = "";
        JSONObject obj;
        try {
            int len = jsonArray1.length();
            for (int i = 0; i < len; i++) {
                obj = (JSONObject) jsonArray1.get(i);
                if (i == len - 1)
                    buffer.append(obj.toString()).append(",");
                else
                    buffer.append(obj.toString()).append(",");
            }
            len = jsonArray2.length();
            for (int i = 0; i < len; i++) {
                obj = (JSONObject) jsonArray2.get(i);
                if (i == len - 1)
                    buffer.append(obj.toString()).append("");
                else
                    buffer.append(obj.toString()).append(",");
            }

            buffer.insert(0, "[").append("]");
            bufferString = buffer.toString();
            System.out.println("我输出的字符串到底哟没有++++++++++++++++++++++++"
                    + bufferString);

        } catch (Exception e) {
            // TODO: handle exception  
        }
        return bufferString;

    }

    public static String replaceArray(String rawString, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            rawString = rawString.replace(entry.getKey(), entry.getValue().toString());
        }

        return rawString;
    }

    public static String replaceWxEditPersonalData(String rawString, String name, int sex, String area,
                                                   String sign, String consignee, String phonenum,
                                                   String areainfo, String detailaddress, String postalcode) {

        HashMap<String, Object> replaceMap = new HashMap<>();
        if (name.length() > 0) {
            rawString = addCommandInActions(rawString, WxCommandFunctionsConstans.editpersonaldataCmd_NickName);
            replaceMap.put("@昵称", name);
            rawString = replaceArray(rawString, replaceMap);
        }

        if (sex != 0) {
            rawString = addCommandInActions(rawString, WxCommandFunctionsConstans.editpersonaldataCmd_Sex);
            if (sex == 1) {
                replaceMap.put("@性别", "男");
            } else if (sex == 2) {
                replaceMap.put("@性别", "女");
            }
            rawString = replaceArray(rawString, replaceMap);
        }

        if (sign.length() > 0) {
            rawString = addCommandInActions(rawString, WxCommandFunctionsConstans.editpersonaldataCmd_Sign);
            replaceMap.put("@个性签名", sign);
            rawString = replaceArray(rawString, replaceMap);
        }

        if (detailaddress.length() > 0) {
            rawString = addCommandInActions(rawString, WxCommandFunctionsConstans.editpersonaldataCmd_Area);
        }

        if (area.length() > 0) {
            Log.d("nangua", "area:" + area);
            rawString = addCommandInActions(rawString, WxCommandFunctionsConstans.editpersonaldataCmd_MyAddress);
            replaceMap.put("@我的地址", area);
            if (consignee.length() > 0) {
                replaceMap.put("@收货人", "无");
            }

            if (phonenum.length() > 0) {
                replaceMap.put("@手机号码", phonenum);
            } else {
                replaceMap.put("@手机号码", 0);
            }

            if (areainfo.length() > 0) {
                //@地区信息省
                String[] areainfos = areainfo.split(",");

                for (int i = 0; i < areainfos.length; i++) {
                    Log.d(TAG, "areainfos" + i + " " + areainfos[i]);
                }

                if (areainfos.length == 3) {
                    replaceMap.put("@地区信息省", areainfos[0]);
                    replaceMap.put("@地区信息市", areainfos[1]);
                    replaceMap.put("@地区信息区", areainfos[2]);
                }
            }

            if (postalcode.length() > 0) {
                replaceMap.put("@邮政编码", postalcode);
            } else {
                replaceMap.put("@邮政编码", 100000);
            }

            rawString = replaceArray(rawString, replaceMap);
        }


        rawString = addCommandInActions(rawString, WxCommandFunctionsConstans.clickBackCommand);

        return rawString;

    }

    public static String replaceWxSendGroupMsg(String rawString, String grouptxt, int groupnum) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        if (grouptxt.length() > 0) {
            replaceMap.put("@群发消息文字", grouptxt);
        }

        if (groupnum != 0) {
            replaceMap.put("@群发消息数量", groupnum);
            replaceMap.put("@下一步按钮", "下一步(" + groupnum + ")");
        }
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxSendFriendCircleVideo(String rawString, String dsc) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        if (dsc.length() > 0) {
            replaceMap.put("@描述文字", dsc);
        }
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxSendFriendPictures(String rawString, String dsc, int num) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        if (dsc.length() > 0) {
            replaceMap.put("@描述文字", dsc);
        }

        if (num != 0) {
            replaceMap.put("@图片数量", num);
            replaceMap.put("@完成按钮", "完成(" + num + "/9)");
        }
        return replaceArray(rawString, replaceMap);
    }

    //发朋友圈纯文字
    public static String replaceWxSendFriendTxt(String rawString, String txt) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        if (txt.length() > 0) {
            replaceMap.put("@朋友圈纯文字", txt);
        }

        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxAddFriend(String rawString, String account, String hello, String remark) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        if (account.length() > 0) {
            replaceMap.put("@微信号", account);
        }

        if (hello.length() > 0) {
            replaceMap.put("@问候语", hello);
        }

        if (remark.length() > 0) {
            replaceMap.put("@备注", remark);
        }
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxaddGroupByScaleQr(String rawString, int imgnum) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        if (imgnum != 0) {
            replaceMap.put("@到第几张二维码", imgnum);
        }

        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxAddFriendInGroup(String rawString, int groupindex, int fromnum, int tonum, String applytext) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@第几个群", groupindex);
        replaceMap.put("@从多少个", fromnum);
        replaceMap.put("@到多少个", tonum);
        replaceMap.put("@验证申请语句", applytext);

        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxSayHelloNearlby(String rawString, int peoplenum, String applytext, int sexFlag, int autoAgree) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@打招呼人数", peoplenum);
        replaceMap.put("@打招呼验证语句", applytext);
        if (sexFlag == 1) {
            replaceMap.put("@性别选择", "只看男生");

        } else if (sexFlag == 2) {
            replaceMap.put("@性别选择", "只看女生");

        } else {
            replaceMap.put("@性别选择", "查看全部");

        }
        rawString = replaceArray(rawString, replaceMap);

        if (autoAgree == 1) {
            rawString = addCommandInActions(rawString, WxCommandFunctionsConstans.sayHelloNearlbyJsonCmd_AutoAddFriend);
        }


        return rawString;
    }

    public static String replaceWxAutoThrowBottle(String rawString, int driftnum, String applytext) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@丢瓶子次数", driftnum);
        replaceMap.put("@丢瓶子语句", applytext);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxAutoPickBottle(String rawString, int picknum, String applytext) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@捡瓶子次数", picknum);
        replaceMap.put("@捡瓶子语句", applytext);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxShake(String rawString, int shakenum, String applytext) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@摇一摇次数", shakenum);
        replaceMap.put("@申请验证语句", applytext);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxPraiseFirendCircle(String rawString, int num) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@点赞次数", num);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceWxPraiseCommentsFirendCircle(String rawString, int num, String comments) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@点赞评论次数", num);
        replaceMap.put("@朋友圈评论文字", comments);
        return replaceArray(rawString, replaceMap);
    }


    public static String replaceWxAutoPickThrowBottle(String rawString, int thrownum, String throwapplytext, int driftnum, String driftapplytext) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@捡瓶子次数", driftnum);
        replaceMap.put("@捡瓶子语句", driftapplytext);
        replaceMap.put("@丢瓶子次数", thrownum);
        replaceMap.put("@丢瓶子语句", throwapplytext);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceChangeWxAccountByWx(String rawString, String account, String password) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@微信号", account);
        replaceMap.put("@密码", password);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceChangeWxAccountByPhone(String rawString, String account, String password) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@手机号", account);
        replaceMap.put("@密码", password);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceSendGroupFriendsTxtAll(String rawString, String txt) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@测试群发消息", txt);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceSendGroupFriendsTxtIndex(String rawString, String txt, int startIndex, int endIndex) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@测试群发消息", txt);
        replaceMap.put("@起始位置", startIndex);
        replaceMap.put("@结束位置", endIndex);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceSendGroupFriendsImgIndex(String rawString, int startIndex, int endIndex) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@起始位置", startIndex);
        replaceMap.put("@结束位置", endIndex);
        return replaceArray(rawString, replaceMap);
    }

    public static String replaceSendGroupGroupsTxtIndex(String rawString, int startIndex, int endIndex, String txt) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@起始位置", startIndex);
        replaceMap.put("@结束位置", endIndex);
        replaceMap.put("@测试群发消息", txt);
        return replaceArray(rawString, replaceMap);
    }

    //发送(9/9)
    public static String replaceSendGroupGroupsImgIndex(String rawString, int startIndex, int endIndex, int imgNum) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@起始位置", startIndex);
        replaceMap.put("@结束位置", endIndex);
        replaceMap.put("@图片数量", imgNum);
        replaceMap.put("@发送按钮", "发送(" + imgNum + "/" + 9 + ")");
        return replaceArray(rawString, replaceMap);
    }


    //月、日暂时先不搞
    public static String replaceMoMoRegister(String rawString, String nickName, Integer sex, Integer year, Integer month, Integer day, String pwd) {
        HashMap<String, Object> replaceMap = new HashMap<>();
        replaceMap.put("@昵称", nickName);
        replaceMap.put("@生日年份", year);
        //性别:1男2女
        if (sex == 1) {
            replaceMap.put("@性别","男");
        } else if (sex == 2) {
            replaceMap.put("@性别","女");
        }
        replaceMap.put("@密码", pwd);
        return replaceArray(rawString, replaceMap);
    }
}
