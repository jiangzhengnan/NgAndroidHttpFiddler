package com.fish.scriptplugin.parse;

import android.util.Log;

import com.fish.scriptplugin.ICommandParse;
import com.fish.scriptplugin.cmd.WxCommandConstans;
import com.fish.scriptplugin.entity.PluginInfo;
import com.fish.scriptplugin.utility.StringUtility;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xjm on 2017/2/24.
 */

public class WxCommandParse implements ICommandParse {
    private final String packetName = "com.tencet.mm";

    @Override
    public boolean isEqualPacket(String packetName) {
        if (this.packetName.equals(packetName)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 解析执行的命令
     *
     * @param cmd     需要执行的命令
     * @param extData 扩展数据
     * @return
     */
    @Override
    public String parse(String cmd, String extData) {
        Log.d("nangua", "parse:" + cmd + "  extData:" + extData);

        if (cmd.equals("添加好友")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseAddFriend(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }  else if (cmd.equals("微信号账号切换")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseChangeWxAccountByWx(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("手机号账号切换")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseChangeWxAccountByPhone(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("发朋友圈图文")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendFriendPictures(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("发朋友圈纯文字")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendFriendTxt(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("发朋友圈视频文字")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendFriendCircleVideo(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("朋友圈遍历点赞")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parsePraiseFirendCircle(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("朋友圈遍历点赞评论")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parsePraiseCommentsFirendCircle(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //消息群发好友部分
        } else if (cmd.equals("消息群发_好友_纯文字_全选")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendGroupFriendsTxtAll(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if (cmd.equals("消息群发_好友_纯文字_索引")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendGroupFriendsTxtIndex(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("消息群发_好友_图片_全选")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendGroupFriendsImgAll(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("消息群发_好友_图片_索引")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendGroupFriendsImgIndex(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //消息群发群组部分,索引和全选的区别在于结束位置是设定的还是1000
        } else if (cmd.equals("消息群发_群组_纯文字_索引")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendGroupGroupsTxtIndex(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("消息群发_群组_图片_索引")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSendGroupGroupsImgIndex(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //消息群发部分
        } else if (cmd.equals("编辑个人资料")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseEditPersonalData(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("扫二维码加群")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseAddGroupByScaleQr(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("群内加好友")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseAddFriendInGroup(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("附近的人打招呼")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseSayHelloNearlby(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("漂流瓶捡瓶子")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseAutoPickBottle(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("漂流瓶丢瓶子")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseAutoThrowBottle(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("漂流瓶丢瓶子捡瓶子")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseAutoPickThrowBottle(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if (cmd.equals("摇一摇")) {
            try {
                JSONObject js = new JSONObject(extData);
                return parseWxShake(js);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (cmd.equals("通过好友请求")) {
            try {
                JSONObject js = new JSONObject(extData);
                return WxCommandConstans.adoptFriendRequestJsonCmd;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    //得到插件信息
    public static PluginInfo getPluginInfo() {
        return new PluginInfo(getBasicConfig(), WxCommandParse.class.getName());
    }

    //群发好友纯文字全选
    private String parseSendGroupFriendsTxtAll(JSONObject extData) {
        String sendGroupFriendsTxtAll = "";
        String txt = "";
        try {
            if (extData.has("txt")) {
                txt = extData.getString("txt");
            }
            sendGroupFriendsTxtAll = getSendGroupFriendsTxtAllCommandJsonCmd(txt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendGroupFriendsTxtAll;
    }

    private String getSendGroupFriendsTxtAllCommandJsonCmd(String txt) {
        String cmd = WxCommandConstans.sendGroupFriendsTxtAllCmd;
        cmd = StringUtility.
                replaceSendGroupFriendsTxtAll(cmd, txt);
        return cmd;
    }

    //群发好友纯文字索引
    private String parseSendGroupFriendsTxtIndex(JSONObject extData) {
        String sendGroupFriendsTxtIndex = "";
        String txt = "";
        int startIndex = 0;
        int endIndex = 0;
        try {
            if (extData.has("startIndex")) {
                startIndex = extData.getInt("startIndex");
            }
            if (extData.has("endIndex")) {
                endIndex = extData.getInt("endIndex");
            }
            if (extData.has("txt")) {
                txt = extData.getString("txt");
            }
            sendGroupFriendsTxtIndex = getSendGroupFriendsTxtIndexCommandJsonCmd(txt,startIndex,endIndex);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendGroupFriendsTxtIndex;
    }

    private String getSendGroupFriendsTxtIndexCommandJsonCmd(String txt, int startIndex, int endIndex) {
        String cmd = WxCommandConstans.sendGroupFriendsTxtIndexCmd;
        cmd = StringUtility.
                replaceSendGroupFriendsTxtIndex(cmd, txt,startIndex,endIndex);
        return cmd;
    }

    //群发好友图片全选,图片默认只能选一张,所以不需要传入参数
    private String parseSendGroupFriendsImgAll(JSONObject extData) {
        String cmd = WxCommandConstans.sendGroupFriendsImgAllCmd;
        return cmd;
    }

    //群发好友图片索引 startIndex endIndex
    private String parseSendGroupFriendsImgIndex(JSONObject extData) {
        String sendGroupFriendsImgIndexCommand = "";
        int startIndex = 0;
        int endIndex = 0;
        try {
            if (extData.has("startIndex")) {
                startIndex = extData.getInt("startIndex");
            }
            if (extData.has("endIndex")) {
                endIndex = extData.getInt("endIndex");
            }
            sendGroupFriendsImgIndexCommand = getSendGroupFriendsImgIndexCommandJsonCmd(startIndex, endIndex);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendGroupFriendsImgIndexCommand;
    }

    private String getSendGroupFriendsImgIndexCommandJsonCmd(int startIndex, int endIndex) {
        String cmd = WxCommandConstans.sendGroupFriendsImgIndexCmd;
        cmd = StringUtility.
                replaceSendGroupFriendsImgIndex(cmd, startIndex, endIndex);
        return cmd;
    }


    //群发群组纯文字索引
    private String parseSendGroupGroupsTxtIndex(JSONObject extData) {
        String sendGroupGroupsTxtIndexCommand = "";
        int startIndex = 0;
        int endIndex = 0;
        String txt = "";
        try {
            if (extData.has("startIndex")) {
                startIndex = extData.getInt("startIndex");
            }
            if (extData.has("endIndex")) {
                endIndex = extData.getInt("endIndex");
            }
            if (extData.has("txt")) {
                txt = extData.getString("txt");
            }
            sendGroupGroupsTxtIndexCommand = getSendGroupGroupsTxtIndexCommandJsonCmd(startIndex, endIndex, txt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendGroupGroupsTxtIndexCommand;
    }

    private String getSendGroupGroupsTxtIndexCommandJsonCmd(int startIndex, int endIndex, String txt) {
        String cmd = WxCommandConstans.sendGroupGroupsTxtIndexCmd;
        cmd = StringUtility.
                replaceSendGroupGroupsTxtIndex(cmd, startIndex, endIndex, txt);
        return cmd;
    }

    //群发群组图片索引
    private String parseSendGroupGroupsImgIndex(JSONObject extData) {
        String sendGroupGroupsImgIndexCommand = "";
        int startIndex = 0;
        int endIndex = 0;
        int imgNum = 0;
        try {
            if (extData.has("startIndex")) {
                startIndex = extData.getInt("startIndex");
            }
            if (extData.has("endIndex")) {
                endIndex = extData.getInt("endIndex");
            }
            if (extData.has("imgNum")) {
                imgNum = extData.getInt("imgNum");
            }
            sendGroupGroupsImgIndexCommand = getsendGroupGroupsImgIndexCommandJsonCmd(startIndex, endIndex, imgNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendGroupGroupsImgIndexCommand;
    }

    private String getsendGroupGroupsImgIndexCommandJsonCmd(int startIndex, int endIndex, int imgNum) {
        String cmd = WxCommandConstans.sendGroupGroupsImgIndexCmd;
        cmd = StringUtility.
                replaceSendGroupGroupsImgIndex(cmd, startIndex, endIndex, imgNum);
        return cmd;
    }


    private String parseChangeWxAccountByPhone(JSONObject extData) {
        String changeWxAccountByPhoneCommand = "";
        String account = "";
        String password = "";
        try {
            if (extData.has("account")) {
                account = extData.getString("account");
            }
            if (extData.has("password")) {
                password = extData.getString("password");
            }
            changeWxAccountByPhoneCommand = getChangeWxAccountByPhoneCommandJsonCmd(account, password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return changeWxAccountByPhoneCommand;
    }

    private String getChangeWxAccountByPhoneCommandJsonCmd(String account, String password) {
        String cmd = WxCommandConstans.changeWxAccountByPhone;
        cmd = StringUtility.
                replaceChangeWxAccountByPhone(cmd, account, password);
        return cmd;
    }

    private String parseChangeWxAccountByWx(JSONObject extData) {
        Log.d("nangua", "拿到命令2" + extData);
        String changeWxAccountByWxCommand = "";
        String account = "";
        String password = "";
        try {
            if (extData.has("account")) {
                account = extData.getString("account");
            }
            if (extData.has("password")) {
                password = extData.getString("password");
            }
            changeWxAccountByWxCommand = getChangeWxAccountByWxCommandJsonCmd(account, password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return changeWxAccountByWxCommand;
    }

    private String getChangeWxAccountByWxCommandJsonCmd(String account, String password) {
        String cmd = WxCommandConstans.changeWxAccountByWxJsonCmd;
        cmd = StringUtility.
                replaceChangeWxAccountByWx(cmd, account, password);
        Log.d("nangua", "拿到命令3" + cmd);

        return cmd;
    }

    private String parseWxShake(JSONObject extData) {
        String wxShake = "";
        int shakenum = 0;
        String applytext = "";
        try {
            if (extData.has("shakenum")) {
                shakenum = extData.getInt("shakenum");
            }
            if (extData.has("applytext")) {
                applytext = extData.getString("applytext");
            }
            wxShake = getWxShakeCommandJsonCmd(shakenum, applytext);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return wxShake;
    }

    private String getWxShakeCommandJsonCmd(int shakenum, String applytext) {
        String cmd = WxCommandConstans.wxShakeJsonCmd;
        cmd = StringUtility.
                replaceWxShake(cmd, shakenum, applytext);
        return cmd;
    }

    private String parseAutoPickThrowBottle(JSONObject extData) {
        String autoPickThrowBottleCommand = "";

        int thrownum = 0;
        String throwapplytext = "";
        int driftnum = 0;
        String driftapplytext = "";
        try {
            if (extData.has("thrownum")) {
                thrownum = extData.getInt("thrownum");
            }
            if (extData.has("throwapplytext")) {
                throwapplytext = extData.getString("throwapplytext");
            }
            if (extData.has("driftnum")) {
                driftnum = extData.getInt("driftnum");
            }
            if (extData.has("driftapplytext")) {
                driftapplytext = extData.getString("driftapplytext");
            }
            autoPickThrowBottleCommand = getAutoPickThrowBottleCommandJsonCmd(thrownum, throwapplytext, driftnum, driftapplytext);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return autoPickThrowBottleCommand;
    }

    private String getAutoPickThrowBottleCommandJsonCmd(int thrownum, String throwapplytext, int driftnum, String driftapplytext) {
        String cmd = WxCommandConstans.autoPickThrowBottleCmd;
        cmd = StringUtility.
                replaceWxAutoPickThrowBottle(cmd, thrownum, throwapplytext, driftnum, driftapplytext);
        return cmd;
    }

    private static String parseAutoPickBottle(JSONObject extData) {
        String autoPickBottleCommand = "";
        int picknum = 0;
        String applytext = "";
        try {
            if (extData.has("picknum")) {
                picknum = extData.getInt("picknum");
            }
            if (extData.has("applytext")) {
                applytext = extData.getString("applytext");
            }
            autoPickBottleCommand = getAutoPickBottleCommandJsonCmd(picknum, applytext);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return autoPickBottleCommand;
    }

    private static String getAutoPickBottleCommandJsonCmd(int picknum, String applytext) {
        String cmd = WxCommandConstans.autoPickBottle;
        cmd = StringUtility.
                replaceWxAutoPickBottle(cmd, picknum, applytext);
        return cmd;
    }

    private String parseAutoThrowBottle(JSONObject extData) {
        String autoThrowBottle = "";
        int driftnum = 0;
        String applytext = "";
        try {
            if (extData.has("driftnum")) {
                driftnum = extData.getInt("driftnum");
            }
            if (extData.has("applytext")) {
                applytext = extData.getString("applytext");
            }
            autoThrowBottle = getAutoThrowBottleCommandJsonCmd(driftnum, applytext);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return autoThrowBottle;
    }

    private String getAutoThrowBottleCommandJsonCmd(int driftnum, String applytext) {
        String cmd = WxCommandConstans.autoThrowBottleJsonCmd;
        cmd = StringUtility.
                replaceWxAutoThrowBottle(cmd, driftnum, applytext);
        return cmd;

    }

    private static String parseSayHelloNearlby(JSONObject extData) {
        String sayHelloNearlby = "";
        int peopleNum = 0;
        String applyText = "";
        int sexFlag = 0;
        int autoAgree = 0;
        try {
            if (extData.has("peopleNum")) {
                peopleNum = extData.getInt("peopleNum");
            }
            if (extData.has("applyText")) {
                applyText = extData.getString("applyText");
            }
            if (extData.has("sexFlag")) {
                sexFlag = extData.getInt("sexFlag");
            }
            if (extData.has("autoAgree")) {
                autoAgree = extData.getInt("autoAgree");
            }
            sayHelloNearlby = getSayHelloNearlbyCommandJsonCmd(peopleNum, applyText,sexFlag,autoAgree);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sayHelloNearlby;
    }

    private static String getSayHelloNearlbyCommandJsonCmd(int peoplenum, String applytext, int sexFlag, int autoAgree) {

        String cmd = WxCommandConstans.sayHelloNearlbyJsonCmd;
        cmd = StringUtility.
                replaceWxSayHelloNearlby(cmd, peoplenum, applytext,sexFlag,autoAgree);
        return cmd;
    }


    private static String parseAddFriendInGroup(JSONObject extData) {

        String addFriendInGroup = "";
        int groupindex = 0;
        int fromnum = 0;
        int tonum = 0;
        String applytext = "";
        try {
            if (extData.has("groupindex")) {
                groupindex = extData.getInt("groupindex");
            }
            if (extData.has("fromnum")) {
                fromnum = extData.getInt("fromnum");
            }
            if (extData.has("tonum")) {
                tonum = extData.getInt("tonum");
            }
            if (extData.has("applytext")) {
                applytext = extData.getString("applytext");
            }
            addFriendInGroup = getAddFriendInGroupCommandJsonCmd(groupindex, fromnum, tonum, applytext);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return addFriendInGroup;
    }

    private static String getAddFriendInGroupCommandJsonCmd(int groupindex, int fromnum, int tonum, String applytext) {

        String cmd = WxCommandConstans.addFriendInGroupJsonCmd;
        cmd = StringUtility.
                replaceWxAddFriendInGroup(cmd, groupindex, fromnum, tonum, applytext);
        return cmd;
    }

    private static String parseAddGroupByScaleQr(JSONObject extData) {
        String addGroupByScaleQr = "";
        int imgnum = 0;
        try {
            if (extData.has("imgnum")) {
                imgnum = extData.getInt("imgnum");
            }
            addGroupByScaleQr = getAddGroupByScaleQrCommandJsonCmd(imgnum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return addGroupByScaleQr;
    }


    private static String getAddGroupByScaleQrCommandJsonCmd(int imgnum) {
        String cmd = WxCommandConstans.addGroupByScaleQrJsonCmd;
        cmd = StringUtility.
                replaceWxaddGroupByScaleQr(cmd, imgnum);
        return cmd;
    }

    private static String parseEditPersonalData(JSONObject extData) {
        String editPersonalData = "";
        String name = "";
        Integer sex = 0;
        String area = "";
        String sign = "";
        String consignee = "";
        String phonenum = "";
        String areainfo = "";
        String detailaddress = "";
        String postalcode= "";
        try {
            if (extData.has("name")) {
                name = extData.getString("name");
            }
            if (extData.has("sex")) {
                sex = extData.getInt("sex");
            }
            if (extData.has("area")) {
                area = extData.getString("area");
            }
            if (extData.has("sign")) {
                sign = extData.getString("sign");
            }
            if (extData.has("consignee")) {
                consignee = extData.getString("consignee");
            }
            if (extData.has("phonenum")) {
                phonenum = extData.getString("phonenum");
            }
            if (extData.has("areainfo")) {
                areainfo = extData.getString("areainfo");
            }
            if (extData.has("detailaddress")) {
                detailaddress = extData.getString("detailaddress");
            }
            if (extData.has("postalcode")) {
                postalcode = extData.getString("postalcode");
            }
            editPersonalData = getEditPersonalDataCommandJsonCmd(name, sex, area, sign, consignee, phonenum, areainfo, detailaddress,postalcode);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return editPersonalData;
    }

    private static String getEditPersonalDataCommandJsonCmd(String name, int sex, String area,
                                                            String sign, String consignee, String phonenum,
                                                            String areainfo, String detailaddress, String postalcode) {
        String cmd = WxCommandConstans.editpersonaldataCmd;
        cmd = StringUtility.
                replaceWxEditPersonalData(cmd, name, sex, area, sign, consignee, phonenum, areainfo, detailaddress,postalcode);
        return cmd;
    }


    private static String parseSendFriendCircleVideo(JSONObject extData) {
        String sendFriendCircleVideo = "";
        String dsc = "";

        try {
            if (extData.has("dsc")) {
                dsc = extData.getString("dsc");
            }
            sendFriendCircleVideo = getSendFriendCircleVideoCommandJsonCmd(dsc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendFriendCircleVideo;
    }

    private static String getSendFriendCircleVideoCommandJsonCmd(String dsc) {
        String cmd = WxCommandConstans.sendFriendCircleVideoCmd;
        cmd = StringUtility.replaceWxSendFriendCircleVideo(cmd, dsc);
        return cmd;
    }


    private static String parsePraiseFirendCircle(JSONObject extData) {
        String sendFriendTxtCommand = "";
        int num = 0;
        try {
            if (extData.has("num")) {
                num = extData.getInt("num");
            }
            sendFriendTxtCommand = getPraiseFirendCircleCmd(num);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendFriendTxtCommand;
    }

    private static String getPraiseFirendCircleCmd(int num) {
        String cmd = WxCommandConstans.praiseFriendCircle;
        cmd = StringUtility.replaceWxPraiseFirendCircle(cmd, num);
        return cmd;
    }

    private String parsePraiseCommentsFirendCircle(JSONObject extData) {
        String sendFriendTxtCommand = "";
        int num = 0;
        String comments = "";
        try {
            if (extData.has("num")) {
                num = extData.getInt("num");
            }
            if (extData.has("comments")) {
                comments = extData.getString("comments");
            }
            sendFriendTxtCommand = getPraiseCommentsFirendCircleCmd(num, comments);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendFriendTxtCommand;
    }

    private static String getPraiseCommentsFirendCircleCmd(int num, String comments) {
        String cmd = WxCommandConstans.pariseCommentsFriendCircle;
        cmd = StringUtility.replaceWxPraiseCommentsFirendCircle(cmd, num, comments);
        return cmd;
    }

    private static String parseSendFriendTxt(JSONObject extData) {
        String sendFriendTxtCommand = "";
        String txt = "";
        int num = 0;
        try {
            if (extData.has("txt")) {
                txt = extData.getString("txt");
            }
            sendFriendTxtCommand = getSendFriendTxtJsonCmd(txt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendFriendTxtCommand;
    }

    private static String getSendFriendTxtJsonCmd(String txt) {
        String cmd = WxCommandConstans.sendFriendCircleTxtCmd;
        cmd = StringUtility.replaceWxSendFriendTxt(cmd, txt);
        return cmd;
    }

    private static String parseSendFriendPictures(JSONObject extData) {
        String sendFriendPicturesCommand = "";
        String dsc = "";
        int num = 0;
        try {
            if (extData.has("dsc")) {
                dsc = extData.getString("dsc");
            }
            if (extData.has("num")) {
                num = extData.getInt("num");
            }
            sendFriendPicturesCommand = getSendFriendPicturesJsonCmd(dsc, num);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sendFriendPicturesCommand;
    }

    private static String getSendFriendPicturesJsonCmd(String dsc, int num) {
        String cmd = WxCommandConstans.sendFriendCirclePicturesCmd;
        cmd = StringUtility.replaceWxSendFriendPictures(cmd, dsc, num);
        return cmd;
    }

    private static String parseAddFriend(JSONObject extData) {
        String addFriendCommand = "";
        String account = "";
        String remark = "";
        String hello = "";
        try {
            account = extData.getString("account");
            if (extData.has("hello")) {
                hello = extData.getString("hello");
            }

            if (extData.has("remark")) {
                remark = extData.getString("remark");
            }

            addFriendCommand = getAddFriendJsonCmd(account, hello, remark);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return addFriendCommand;
    }

    private static String getAddFriendJsonCmd(String account, String hello, String remark) {
        String cmd = WxCommandConstans.addFriendJsonCmd;
        cmd = StringUtility.replaceWxAddFriend(cmd, account, hello, remark);
        return cmd;
    }

    private static String getBasicConfig() {
        return WxCommandConstans.baseConfig;
    }
}
