package com.fish.scriptplugin.cmd;

/**
 * 默默脚本命令
 * created by Pumpkin at 17/5/2
 */
public class MoMoCommandConstans {

    public final static String baseConfig = "{\n" +
            "     \"packetName\": \"com.immomo.momo\",\n" +
            "     \"launchUI\":\"com.immomo.momo.android.activity.WelcomeActivity\",\n" +
            "     \"currentUIList\":[\n" +
            "     {\"name\":\"初始界面\", \"views\":[{\"text\":\"注册\"}]},\n" +
            "     {\"name\":\"主页\", \"views\":[{\"text\":\"附近\"},{\"text\":\"直播\"}]}\n" +
            "     ],\n" +
            "\n" +
            "     \"gotoUIList\": [\n" +
            "     {\"name\": \"注册界面\", \"pathList\":[\"初始界面\"], \"view\":{\"text\":\"注册\"},\"sleep\":4000},\n" +
            "     {\"name\": \"更多界面\", \"pathList\":[\"主页\"], \"view\":{\"text\":\"更多\"},\"sleep\":1000}\n" +
            "     ]\n" +
            "}";

    public final static String registerJsonCmd = "{\n" +
            "    \"name\": \"注册\",\n" +
            "    \"cmd\": [\n" +
            "        {\n" +
            "            \"ui\": \"注册界面\",\n" +
            "            \"actions\": [\n" +
            "                {\n" +
            "                    \"findthis\": true,\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.EditText\"\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@昵称\",\n" +
            "                    \"sleep\": 2000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"下一步\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 4000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.ImageView\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"action\": \"goBackUI\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"拍照\",\n" +
            "                        \"className\": \"android.widget.Button\"\n" +
            "                    },\n" +
            "                    \"action\": \"getParentNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"getNextNode\",\n" +
            "                    \"data\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"确认\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"选择生日\"\n" +
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
            "                                        \"className\": \"android.widget.NumberPicker\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"是4.4版本\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"是4.4版本\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.DatePicker\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"getChildNode\",\n" +
            "                                    \"data\": 0\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"dontBreakInDefault\": true,\n" +
            "                                    \"maxloopnum\": 0,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": true,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.NumberPicker\"\n" +
            "                                                    },\n" +
            "                                                    \"num\": -1,\n" +
            "                                                    \"action\": \"containChildByTextcontains\",\n" +
            "                                                    \"data\": \"@生日年份\",\n" +
            "                                                    \"switchValue\": \"findyear\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"findyear\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"findthis\": true,\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"@生日年份\"\n" +
            "                                                    }\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.NumberPicker\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"完成\"\n" +
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
            "                                    \"view\": {\n" +
            "                                        \"text\": \"1990\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"dontBreakInDefault\": true,\n" +
            "                                    \"maxloopnum\": 0,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": true,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"num\": -1,\n" +
            "                                                    \"action\": \"containChildByTextcontains\",\n" +
            "                                                    \"data\": \"@生日年份\",\n" +
            "                                                    \"switchValue\": \"findyear\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"findyear\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"@生日年份\"\n" +
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
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"scroll\",\n" +
            "                                                    \"sleep\": 2000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
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
            "                    \"view\": {\n" +
            "                        \"text\": \"@性别\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 2000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"下一步\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"确认\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 5000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"findthis\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"输入手机号码\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"findthis\": true,\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.EditText\"\n" +
            "                    },\n" +
            "                    \"action\": \"getAndInputPhoneNum\",\n" +
            "                    \"sleep\": 7000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"findthis\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"输入密码，长度不小于6位\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.EditText\"\n" +
            "                    },\n" +
            "                    \"action\": \"input\",\n" +
            "                    \"data\": \"@密码\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"下一步\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 3000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"view\": {\n" +
            "                        \"text\": \"确认\"\n" +
            "                    },\n" +
            "                    \"action\": \"click\",\n" +
            "                    \"sleep\": 10000\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": true,\n" +
            "                    \"findthis\": true,\n" +
            "                    \"view\": {\n" +
            "                        \"className\": \"android.widget.EditText\"\n" +
            "                    }\n" +
            "                },\n" +
            "                {\n" +
            "                    \"fromRoot\": false,\n" +
            "                    \"action\": \"getAndInputVerificationv\",\n" +
            "                    \"sleep\": 7000\n" +
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
            "                                        \"text\": \"提示\"\n" +
            "                                    },\n" +
            "                                    \"switchValue\": \"已经注册过了\"\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"caseList\": [\n" +
            "                        {\n" +
            "                            \"caseValue\": \"已经注册过了\",\n" +
            "                            \"actions\": [\n" +
            "                                {\n" +
            "                                    \"fromRoot\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"登陆\"\n" +
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
            "                                    \"action\": \"goBackUI\",\n" +
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
            "                                                        \"text\": \"更多\"\n" +
            "                                                    },\n" +
            "                                                    \"switchValue\": \"找到了更多按钮\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"找到了更多按钮\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 3000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"default\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"action\": \"goBackUI\",\n" +
            "                                                    \"sleep\": 3000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"更多\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 1000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"isloop\": true,\n" +
            "                                    \"dontBreakInDefault\": true,\n" +
            "                                    \"maxloopnum\": 0,\n" +
            "                                    \"viewList\": [\n" +
            "                                        {\n" +
            "                                            \"returnValue\": true,\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": true,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"className\": \"android.widget.ListView\"\n" +
            "                                                    },\n" +
            "                                                    \"num\": -1,\n" +
            "                                                    \"action\": \"containChildByTextcontains\",\n" +
            "                                                    \"data\": \"设置\",\n" +
            "                                                    \"switchValue\": \"findSetup\"\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"caseList\": [\n" +
            "                                        {\n" +
            "                                            \"caseValue\": \"findSetup\",\n" +
            "                                            \"actions\": [\n" +
            "                                                {\n" +
            "                                                    \"fromRoot\": false,\n" +
            "                                                    \"view\": {\n" +
            "                                                        \"text\": \"设置\"\n" +
            "                                                    },\n" +
            "                                                    \"action\": \"click\",\n" +
            "                                                    \"sleep\": 3000\n" +
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
            "                                                    \"sleep\": 3000\n" +
            "                                                }\n" +
            "                                            ]\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"退出陌陌\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"findthis\": true,\n" +
            "                                    \"view\": {\n" +
            "                                        \"className\": \"android.widget.ListView\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"getChildNode\",\n" +
            "                                    \"data\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"fromRoot\": false,\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 2000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"view\": {\n" +
            "                                        \"text\": \"退出\"\n" +
            "                                    },\n" +
            "                                    \"action\": \"click\",\n" +
            "                                    \"sleep\": 5000\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"action\": \"goBackUI\",\n" +
            "                                    \"sleep\": 3000\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}\n";
}
