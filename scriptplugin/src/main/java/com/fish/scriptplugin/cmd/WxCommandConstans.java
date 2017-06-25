package com.fish.scriptplugin.cmd;

/**
 * 微信脚本命令
 * created by Pumpkin at 17/3/7
 */
public class WxCommandConstans {
    public final static String baseConfig = "{\n" +
            "     \"packetName\": \"com.tecent.com\",\n" +
            "\t \"launchUI\": \"com.tencent.mm.ui.LauncherUI\",\n" +
            "     \"currentUIList\":[\n" +
            "     {\"name\":\"微信界面\", \"views\":[{\"text\":\"微信\"}]},\n" +
            "     {\"name\":\"更多功能界面\", \"views\":[{\"text\":\"发起群聊\"},{\"text\":\"添加朋友\"},{\"text\":\"扫一扫\"}]},\n" +
            "\t {\"name\":\"登陆注册界面\", \"views\":[{\"text\":\"登录\"},{\"text\":\"注册\"}]},\n" +
            "\t {\"name\":\"手机登陆界面\", \"views\":[{\"text\":\"+86\"},{\"text\":\"登录\"}]},\n" +
            "\t {\"name\":\"其他登陆界面\", \"views\":[{\"text\":\"账号\"},{\"text\":\"登录\"}]}\n" +
            "     ],\n" +
            "\n" +
            "     \"gotoUIList\": [\n" +
            "     {\"name\": \"通讯录\", \"pathList\":[\"微信界面\"], \"view\":{\"text\":\"通讯录\"},\"sleep\":1000},\n" +
            "     {\"name\":\"更多功能界面\",\"pathList\":[\"微信界面\"], \"view\":{\"conentDescription\":\"更多功能按钮\"},\"sleep\":1000},\n" +
            "     {\"name\":\"添加好友界面\",\"pathList\":[\"更多功能界面\"], \"view\":{\"text\":\"添加朋友\"},\"sleep\":1000},\n" +
            "     {\"name\":\"搜索好友的界面\",\"pathList\":[\"添加好友界面\"], \"view\":{\"text\":\"微信号/QQ号/手机号\"},\"sleep\":1000},\n" +
            "     {\"name\":\"新的朋友界面\",\"pathList\":[\"通讯录\"], \"view\":{\"text\":\"新的朋友\"},\"sleep\":1000},\n" +
            "     {\"name\":\"发现界面\",\"pathList\":[\"微信界面\"],\"view\":{\"text\":\"发现\"},\"sleep\":1000},\n" +
            "     {\"name\":\"朋友圈界面\",\"pathList\":[\"发现界面\"],\"view\":{\"text\":\"朋友圈\"},\"sleep\":3000},\n" +
            "     {\"name\":\"漂流瓶\",\"pathList\":[\"发现界面\"],\"view\":{\"text\":\"漂流瓶\"},\"sleep\":5000},\n" +
            "     {\"name\":\"我的界面\",\"pathList\":[\"微信界面\"],\"view\":{\"text\":\"我\"},\"sleep\":1000},\n" +
            "     {\"name\":\"设置界面\",\"pathList\":[\"我的界面\"],\"view\":{\"text\":\"设置\"},\"sleep\":1000},\n" +
            "     {\"name\":\"通用界面\",\"pathList\":[\"设置界面\"],\"view\":{\"text\":\"通用\"},\"sleep\":1000},\n" +
            "     {\"name\":\"功能界面\",\"pathList\":[\"通用界面\"],\"view\":{\"text\":\"功能\"},\"sleep\":1000},\n" +
            "     {\"name\":\"群发助手界面\",\"pathList\":[\"功能界面\"],\"view\":{\"text\":\"群发助手\"},\"sleep\":1000},\n" +
            "\t {\"name\":\"退出界面\",\"pathList\":[\"设置界面\"],\"view\":{\"text\":\"退出\"},\"sleep\":1000},\n" +
            "\t {\"name\":\"退出账号确认界面\",\"pathList\":[\"退出界面\"],\"view\":{\"text\":\"退出当前帐号\"},\"sleep\":1000},\n" +
            "\t {\"name\":\"更多界面\",\"pathList\":[\"最后退出界面\"],\"view\":{\"text\":\"更多\"},\"sleep\":1000},\n" +
            "\t {\"name\":\"最后退出界面\",\"pathList\":[\"退出账号确认界面\"],\"view\":{\"text\":\"退出\"},\"sleep\":10000},\n" +
            "{\"name\":\"手机登陆界面\",\"pathList\":[{\"pathList\":[\"登陆注册界面\"],\"view\":{\"text\":\"登录\"}},{\"pathList\":[\"更多界面\"],\"view\":{\"text\":\"切换帐号\"}}],\"sleep\":1000,\"flag\":\"multiPath\"},\n" +
            "\t {\"name\":\"其他登陆界面\",\"pathList\":[\"登陆注册界面\",\"手机登陆界面\"],\"view\":{\"text\":\"使用其他方式登陆\"},\"sleep\":1000}\n" +
            "     ]\n" +
            "}\n" +
            "\n";

    //手机号账号切换json
    public final static String changeWxAccountByPhone = "{\n" +
            "    \"name\": \"手机号账号切换\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"手机登陆界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"你的手机号码\",\n" +
            "                        \"className\": \"android.widget.EditText\"\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@手机号\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"密码\"\n" +
            "                    },\n" +
            "                    \"action\": \"getNextNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@密码\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"登录\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 10000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //微信号账号切换json
    public final static String changeWxAccountByWxJsonCmd = "{\n" +
            "    \"name\": \"其他账号账号切换\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"手机登陆界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"使用其他方式登录\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"QQ号/微信号/Email\",\n" +
            "                        \"className\": \"android.widget.EditText\"\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@微信号\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"密   码\"\n" +
            "                    },\n" +
            "                    \"action\": \"getNextNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@密码\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"登录\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 10000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //自动通过好友请求json
    public final static String adoptFriendRequestJsonCmd = "{\n" +
            "    \"name\": \"通过好友请求\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"通讯录\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": 1,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"朋友推荐\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"新的朋友\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"朋友推荐\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"新的朋友\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"startIndex\": 0,\n" +
            "                    \"maxloopnum\": 1000,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"needclick\",\n" +
            "                                    \"action\": \"getChildNode\",\n" +
            "                                    \"data\": 1\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"needclick\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"isSwitch\": true,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"findthis\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.Button\",\n" +
            "                                                        \"text\": \"通过验证\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"找到通过验证按钮\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"找到通过验证按钮\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"完成\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 3000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"conentDescription\": \"返回\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"conentDescription\": \"返回\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"getChildNode\",\n" +
            "                                                    \"data\": 1\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"longClick\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"删除\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"action\": \"stopLoop\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //加好友json
    public final static String addFriendJsonCmd =
            "{\n" +
                    "    \"name\": \"加好友\",\n" +
                    "    \"cmd\": [\n" +
                    "        {\n" +
                    "            \"ui\": \"添加好友界面\",\n" +
                    "            \"actions\": [\n" +
                    "                {\n" +
                    "                    \"view\": {\n" +
                    "                        \"text\": \"微信号/QQ号/手机号\"\n" +
                    "                    },\n" +
                    "                    \"action\": \"xyClick\",\n" +
                    "                    \"sleep\": 2000\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"view\": {\n" +
                    "                        \"focusInput\": true\n" +
                    "                    },\n" +
                    "                    \"action\": \"input\",\n" +
                    "                    \"data\": \"@微信号\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"view\": {\n" +
                    "                        \"text\": \"搜索:@微信号\"\n" +
                    "                    },\n" +
                    "                    \"action\": \"click\",\n" +
                    "                    \"sleep\": 2000\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"view\": {\n" +
                    "                        \"text\": \"添加到通讯录\"\n" +
                    "                    },\n" +
                    "                    \"action\": \"click\",\n" +
                    "                    \"sleep\": \"5000\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"view\": {\n" +
                    "                        \"focusInput\": true\n" +
                    "                    },\n" +
                    "                    \"action\": \"input\",\n" +
                    "                    \"data\": \"@问候语\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"view\": {\n" +
                    "                        \"text\": \"为朋友设置备注\"\n" +
                    "                    },\n" +
                    "                    \"action\": \"getNextNode\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"action\": \"input\",\n" +
                    "                    \"data\": \"@备注\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"view\": {\n" +
                    "                        \"text\": \"发送\"\n" +
                    "                    },\n" +
                    "                    \"action\": \"click\"\n" +
                    "                }\n" +
                    "            ]\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";

    //微信摇一摇
    public final static String wxShakeJsonCmd = "{\n" +
            "    \"name\": \"摇一摇\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"发现界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"摇一摇\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"我知道了\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"第一次摇一摇\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"第一次摇一摇\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": \"@摇一摇次数\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": false,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"摇一摇\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"one\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"action\": \"shake\",\n" +
            "                                    \"sleep\": 10000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"isvague\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"的头像\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"one\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"action\": \"shake\",\n" +
            "                                    \"sleep\": 10000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"isvague\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"的头像\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"getParentNode\",\n" +
            "                                    \"data\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"打招呼\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.EditText\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"input\",\n" +
            "                                    \"data\": \"@申请验证语句\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发送\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 4000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //自动丢瓶子
    public final static String autoThrowBottleJsonCmd = "{\n" +
            "    \"name\": \"漂流瓶丢瓶子\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"漂流瓶\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": \"@丢瓶子次数\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"今天的瓶子已经用完啦。\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"isover\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"扔一个\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"文本语音切换\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"focusInput\": true\n" +
            "                                    },\n" +
            "                                    \"action\": \"input\",\n" +
            "                                    \"data\": \"@丢瓶子语句\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"扔出去\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"xyClick\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"isover\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"确定\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //附近的人打招呼
    public final static String sayHelloNearlbyJsonCmd = "{\n" +
            "    \"name\": \"附近的人打招呼\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"发现界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"附近的人\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"开始查看\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"第一次附近人\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"第一次附近人\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"下次不提示\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"确定\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"switchValue\": \"下次不提示\",\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"下次不提示\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"下次不提示\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"确定\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"查看附近的人\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"有人打招呼\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"有人打招呼\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"查看附近的人\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 10000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"更多\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"@性别选择\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"startIndex\": 0,\n" +
            "                    \"maxloopnum\": \"@打招呼人数\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"operationClassName\": \"android.widget.TextView\",\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"needclick\",\n" +
            "                                    \"action\": \"toLastLoopByIndex\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"needclick\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"isSwitch\": true,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"findthis\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"打招呼\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"需要打招呼\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"需要打招呼\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"打招呼\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"focusInput\": true\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"input\",\n" +
            "                                                    \"data\": \"@打招呼验证语句\"\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"发送\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 4000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"conentDescription\": \"返回\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"conentDescription\": \"返回\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"recordPageNumber\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //群内加好友
    public final static String addFriendInGroupJsonCmd = "{\n" +
            "    \"name\": \"群内加好友\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"通讯录\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"群聊\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.ListView\"\n" +
            "                    },\n" +
            "                    \"action\": \"saveItemCount\",\n" +
            "                    \"data\": \"单页群数\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": \"@第几个群\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"one\",\n" +
            "                                    \"action\": \"toLastLoop\",\n" +
            "                                    \"data\": \"单页群数\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"one\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 4000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"recordPageNumber\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"聊天信息\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"朋友推荐\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"containingNumbersGreaterThanData\",\n" +
            "                                    \"IntergerData\": 46,\n" +
            "                                    \"data\": \"聊天信息\",\n" +
            "                                    \"switchValue\": \"找到朋友推荐\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"找到朋友推荐\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"isSwitch\": false,\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"maxloopnum\": 1,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"findthis\": true,\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"查看全部群成员\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"找到查看全部群成员按钮\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"找到查看全部群成员按钮\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"action\": \"reduceNowLoopNum\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.GridView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"scrollToTop\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"startIndex\": \"@从多少个\",\n" +
            "                                    \"maxloopnum\": \"@到多少个\",\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": true,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"operationClassName\": \"android.widget.Button\",\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.GridView\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"点击指定好友\",\n" +
            "                                                    \"action\": \"toLastLoopGridInGridView\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"点击指定好友\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"isloop\": true,\n" +
            "                                                    \"isSwitch\": true,\n" +
            "                                                    \"viewList\": [\n" +
            "                                                        {\n" +
            "                                                            \"returnValue\": false,\n" +
            "                                                            \"actions\": [\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": false,\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 2000,\n" +
            "                                                                    \"switchValue\": \"needback\"\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"findthis\": true,\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"text\": \"添加到通讯录\"\n" +
            "                                                                    }\n" +
            "                                                                }\n" +
            "                                                            ]\n" +
            "                                                        }\n" +
            "                                                    ],\n" +
            "                                                    \"caseList\": [\n" +
            "                                                        {\n" +
            "                                                            \"caseValue\": \"default\",\n" +
            "                                                            \"actions\": [\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"text\": \"添加到通讯录\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 8000\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"focusInput\": true\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"input\",\n" +
            "                                                                    \"data\": \"@验证申请语句\"\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"text\": \"发送\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 5000\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"conentDescription\": \"返回\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 2000\n" +
            "                                                                }\n" +
            "                                                            ]\n" +
            "                                                        },\n" +
            "                                                        {\n" +
            "                                                            \"caseValue\": \"needback\",\n" +
            "                                                            \"actions\": [\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"conentDescription\": \"返回\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 2000\n" +
            "                                                                }\n" +
            "                                                            ]\n" +
            "                                                        }\n" +
            "                                                    ]\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.GridView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"recordPageNumber\"\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"action\": \"reduceNowLoopNum\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"startIndex\": \"@从多少个\",\n" +
            "                                    \"maxloopnum\":\"@到多少个\",\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": true,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"operationClassName\": \"android.widget.TextView\",\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"needclick\",\n" +
            "                                                    \"action\": \"toLastLoopGridInListView\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"needclick\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"isloop\": true,\n" +
            "                                                    \"isSwitch\": true,\n" +
            "                                                    \"viewList\": [\n" +
            "                                                        {\n" +
            "                                                            \"returnValue\": false,\n" +
            "                                                            \"actions\": [\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": false,\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 2000,\n" +
            "                                                                    \"switchValue\": \"needback\"\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"findthis\": true,\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"text\": \"添加到通讯录\"\n" +
            "                                                                    }\n" +
            "                                                                }\n" +
            "                                                            ]\n" +
            "                                                        }\n" +
            "                                                    ],\n" +
            "                                                    \"caseList\": [\n" +
            "                                                        {\n" +
            "                                                            \"caseValue\": \"default\",\n" +
            "                                                            \"actions\": [\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"text\": \"添加到通讯录\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 8000\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"focusInput\": true\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"input\",\n" +
            "                                                                    \"data\": \"@验证申请语句\"\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"text\": \"发送\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 5000\n" +
            "                                                                },\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"conentDescription\": \"返回\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 2000\n" +
            "                                                                }\n" +
            "                                                            ]\n" +
            "                                                        },\n" +
            "                                                        {\n" +
            "                                                            \"caseValue\": \"needback\",\n" +
            "                                                            \"actions\": [\n" +
            "                                                                {\n" +
            "                                                                    \"fromRoot\": true,\n" +
            "                                                                    \"view\": {\n" +
            "                                                                        \"conentDescription\": \"返回\"\n" +
            "                                                                    },\n" +
            "                                                                    \"action\": \"click\",\n" +
            "                                                                    \"sleep\": 2000\n" +
            "                                                                }\n" +
            "                                                            ]\n" +
            "                                                        }\n" +
            "                                                    ]\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"recordPageNumber\"\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"action\": \"reduceNowLoopNum\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //扫二维码加群
    public final static String addGroupByScaleQrJsonCmd = "{\n" +
            "    \"name\": \"扫二维码加群\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"发现界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"扫一扫\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"更多\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 500\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"从相册选取二维码\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"startIndex\": 1,\n" +
            "                    \"maxloopnum\": \"@到第几张二维码\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"isvague\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.GridView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"needclick\",\n" +
            "                                    \"action\": \"toLastLoopGridInGridView\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"needclick\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 7000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"action\": \"xyClickByColor\",\n" +
            "                                    \"data\": \"#04be02\",\n" +
            "                                    \"sleep\": 8000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"聊天信息\",\n" +
            "                                        \"className\": \"android.widget.TextView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"isSwitch\": true,\n" +
            "                                    \"dontBreakInDefault\": true,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": true,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"findthis\": true,\n" +
            "                                                    \"isvague\": true,\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"保存到通讯录\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"savetomaillist\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"savetomaillist\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"getParentNode\",\n" +
            "                                                    \"data\": 1\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"getChildNode\",\n" +
            "                                                    \"data\": 1\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"xyClick\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发现\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"getParentNode\",\n" +
            "                                    \"data\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"扫一扫\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"更多\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 500\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"从相册选取二维码\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.GridView\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //个人资料json
    public final static String editpersonaldataCmd = "{\n" +
            "    \"name\": \"编辑个人资料\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"我的界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"查看二维码\"\n" +
            "                    },\n" +
            "                    \"action\": \"getParentNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //发朋友圈文字json
    public final static String sendFriendCircleTxtCmd = "{\n" +
            "    \"name\": \"发朋友圈文字\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"朋友圈界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"更多功能按钮\"\n" +
            "                    },\n" +
            "                    \"action\": \"longClick\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"我知道了\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"第一次朋友圈纯发图文\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"第一次朋友圈纯发图文\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                     \"sleep\": 3000\n    " +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"focusInput\": true\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@朋友圈纯文字\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"发送\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";


    //发朋友圈图片json
    public final static String sendFriendCirclePicturesCmd = "{\n" +
            "    \"name\": \"发朋友圈\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"朋友圈界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"更多功能按钮\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"从相册选择\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"我知道了\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"第一次发图片\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"第一次发图片\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"findthis\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.GridView\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"multiple\": true,\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.view.View\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000,\n" +
            "                    \"num\": \"@图片数量\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"@完成按钮\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"focusInput\": true\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@描述文字\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"发送\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //漂流瓶捡瓶子丢瓶子
    public final static String autoPickThrowBottleCmd = "{\n" +
            "    \"name\": \"漂流瓶捡瓶子丢瓶子\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"漂流瓶\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"捡一个\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 8000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": \"@捡瓶子次数\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"view\": {\n" +
            "                                \"conentDescription\": \"捡一个\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"view\": {\n" +
            "                                \"conentDescription\": \"捡到一个瓶子\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"今天的瓶子已经用完啦。\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"捡一个\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"捡到一个瓶子\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"回应\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.EditText\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"input\",\n" +
            "                                    \"data\": \"@捡瓶子语句\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发送\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发现\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"漂流瓶\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"确定\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": \"@丢瓶子次数\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"今天的瓶子已经用完啦。\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"isover\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"扔一个\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"文本语音切换\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"focusInput\": true\n" +
            "                                    },\n" +
            "                                    \"action\": \"input\",\n" +
            "                                    \"data\": \"@丢瓶子语句\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"扔出去\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"xyClick\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"isover\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"确定\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"action\": \"goBackUI\",\n" +
            "                    \"sleep\": 3000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //漂流瓶捡瓶子
    public final static String autoPickBottle = "{\n" +
            "    \"name\": \"漂流瓶捡瓶子\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"漂流瓶\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": \"@捡瓶子次数\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"捡一个\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 8000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"switchValue\": \"捡到一个瓶子\",\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"捡到一个瓶子\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"捡到一个瓶子\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"捡到一个瓶子\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"回应\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.EditText\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"input\",\n" +
            "                                    \"data\": \"@捡瓶子语句\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发送\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发现\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"漂流瓶\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"确定\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //朋友圈点赞评论
    public final static String pariseCommentsFriendCircle = "{\n" +
            "    \"name\": \"朋友圈遍历点赞评论\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"朋友圈界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"isvague\": true,\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"朋友圈封面，再点一次可以改封面\"\n" +
            "                    },\n" +
            "                    \"action\": \"getNextNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"saveText\",\n" +
            "                    \"data\": \"朋友圈用户名\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": @点赞评论次数,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": false,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"multiple\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"评论\"\n" +
            "                                    },\n" +
            "                                    \"num\": -1,\n" +
            "                                    \"action\": \"getParentNode\",\n" +
            "                                    \"switchValue\": \"notThumbsUpone\",\n" +
            "                                    \"data\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"containChildByTextcontains\",\n" +
            "                                    \"data\": \"@朋友圈用户名\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"notThumbsUpone\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"isSwitch\": true,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": false,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"saveCurrentNode\",\n" +
            "                                                    \"data\": \"评论按钮结点\",\n" +
            "                                                    \"switchValue\": \"two\"\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"conentDescription\": \"评论\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"data\": 1,\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"赞\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"loadNode\",\n" +
            "                                                    \"data\": \"@评论按钮结点\"\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"conentDescription\": \"评论\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"data\": 1,\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"评论\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"focusInput\": true\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"input\",\n" +
            "                                                    \"data\": \"@朋友圈评论文字\"\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"发送\",\n" +
            "                                                        \"className\": \"android.widget.Button\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"two\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"action\": \"reduceNowLoopNum\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"朋友圈\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                },\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "\t\t\t\t\t\"sleep\": 2000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t       {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //朋友圈点赞
    public final static String praiseFriendCircle = "{\n" +
            "    \"name\": \"朋友圈遍历点赞\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"朋友圈界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"isvague\": true,\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"朋友圈封面，再点一次可以改封面\"\n" +
            "                    },\n" +
            "                    \"action\": \"getNextNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"saveText\",\n" +
            "                    \"data\": \"朋友圈用户名\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": @点赞次数,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": false,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"multiple\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"评论\"\n" +
            "                                    },\n" +
            "                                    \"num\": -1,\n" +
            "                                    \"action\": \"getParentNode\",\n" +
            "                                    \"switchValue\": \"notThumbsUpone\",\n" +
            "                                    \"data\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"containChildByTextcontains\",\n" +
            "                                    \"data\": \"@朋友圈用户名\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"notThumbsUpone\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"isSwitch\": true,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": false,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"saveCurrentNode\",\n" +
            "                                                    \"data\": \"评论按钮结点\",\n" +
            "                                                    \"switchValue\": \"two\"\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"conentDescription\": \"评论\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"data\": 1,\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                },\n" +
            "                                                {\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"赞\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"two\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 1000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"action\": \"reduceNowLoopNum\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"朋友圈\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                },\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "\t\t\t\t\t\"sleep\": 2000\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t       {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //朋友圈发视频
    public final static String sendFriendCircleVideoCmd = "{\n" +
            "    \"name\": \"发朋友圈\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"朋友圈界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"更多功能按钮\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"从相册选择\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isvague\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"视频\",\n" +
            "                        \"className\": \"android.widget.ImageView\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"完成\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"maxloopnum\": 20,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"这一刻的想法...\"\n" +
            "                            }\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"focusInput\": true\n" +
            "                                    },\n" +
            "                                    \"action\": \"input\",\n" +
            "                                    \"data\": \"@描述文字\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发送\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //群发好友纯文字全选
    public final static String sendGroupFriendsTxtAllCmd = "{\n" +
            "    \"name\": \"群发好友纯文字全选\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"群发助手界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"开始群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"新建群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"全选\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isvague\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"下一步\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"focusInput\": true\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@测试群发消息\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"发送\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //群发好友纯文字索引
    public final static String sendGroupFriendsTxtIndexCmd = "{\n" +
            "    \"name\": \"群发好友纯文字索引\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"群发助手界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"开始群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"新建群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"startIndex\": \"@起始位置\",\n" +
            "                    \"maxloopnum\": \"@结束位置\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"isfailureExitLoop\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"operationClassName\": \"android.widget.CheckBox\",\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"needclick\",\n" +
            "                                    \"action\": \"toLastLoopByIndex\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"needclick\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.CheckBox\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"recordPageNumber\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isvague\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"下一步\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"focusInput\": true\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@测试群发消息\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"发送\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //群发好友图片全选
    public final static String sendGroupFriendsImgAllCmd = "{\n" +
            "    \"name\": \"群发好友图片全选\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"群发助手界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"开始群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"新建群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"全选\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isvague\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"下一步\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"更多功能按钮，已展开\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"相册\"\n" +
            "                    },\n" +
            "                    \"action\": \"getParentNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"findthis\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.GridView\"\n" +
            "                    },\n" +
            "                    \"action\": \"getChildNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"完成\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //群发好友图片索引
    public final static String sendGroupFriendsImgIndexCmd = "{\n" +
            "    \"name\": \"群发好友图片索引\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"群发助手界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"开始群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"新建群发\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"startIndex\": \"@起始位置\",\n" +
            "                    \"maxloopnum\": \"@结束位置\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"isfailureExitLoop\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"operationClassName\": \"android.widget.CheckBox\",\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"needclick\",\n" +
            "                                    \"action\": \"toLastLoopByIndex\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"needclick\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.CheckBox\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"recordPageNumber\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isvague\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"下一步\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 4000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"更多功能按钮，已展开\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"isSwitch\": true,\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"你可能要发送的照片：\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"出现你可能要发送的照片框\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"出现你可能要发送的照片框\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"action\": \"goBackUI\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"相册\"\n" +
            "                    },\n" +
            "                    \"action\": \"getParentNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"findthis\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.GridView\"\n" +
            "                    },\n" +
            "                    \"action\": \"getChildNode\",\n" +
            "                    \"data\": 0\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"完成\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";


    //群发群组纯文字索引
    public final static String sendGroupGroupsTxtIndexCmd = "{\n" +
            "    \"name\": \"群发群组纯文字索引\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"通讯录\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"群聊\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"startIndex\": \"@起始位置\",\n" +
            "                    \"maxloopnum\": \"@结束位置\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"needScrollEveryTime\": true,\n" +
            "                                    \"operationClassName\": \"android.widget.LinearLayout\",\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"needclick\",\n" +
            "                                    \"action\": \"toLastLoopByIndex\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"needclick\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.EditText\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"input\",\n" +
            "                                    \"data\": \"@测试群发消息\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"发送\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"通讯录\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"群聊\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"conentDescription\": \"返回\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //群发群组图片索引  发送(9/9)
    public final static String sendGroupGroupsImgIndexCmd = "{\n" +
            "    \"name\": \"群发群组按索引图片\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"通讯录\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"群聊\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 1000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"isloop\": true,\n" +
            "                    \"startIndex\": \"@起始位置\",\n" +
            "                    \"maxloopnum\": \"@结束位置\",\n" +
            "                    \"viewList\": [\n" +
            "                        {\n" +
            "                            \"returnValue\": true,\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"needScrollEveryTime\": true,\n" +
            "                                    \"operationClassName\": \"android.widget.LinearLayout\",\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"needclick\",\n" +
            "                                    \"action\": \"toLastLoopByIndex\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"needclick\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"更多功能按钮，已折叠\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"isSwitch\": true,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"findthis\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"你可能要发送的照片：\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"出现你可能要发送的照片框\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"出现你可能要发送的照片框\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"action\": \"goBackUI\",\n" +
            "                                                    \"sleep\": 3000\n" +
            "                                                } \n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"相册\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"getParentNode\",\n" +
            "                                    \"data\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.GridView\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"multiple\": true,\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.view.View\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000,\n" +
            "                                    \"num\": \"@图片数量\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"@发送按钮\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"conentDescription\": \"返回\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"通讯录\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"群聊\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"caseValue\": \"default\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"scroll\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
