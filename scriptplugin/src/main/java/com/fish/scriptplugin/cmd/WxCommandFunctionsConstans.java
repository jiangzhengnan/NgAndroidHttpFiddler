package com.fish.scriptplugin.cmd;/**
 * Created by ${Pumpkin} on 17/4/26.
 */

/**
 * 微信分步骤脚本命令
 * created by Pumpkin at 17/4/26
 */
public class WxCommandFunctionsConstans {

    //基本点击返回按钮命令
    public static String clickBackCommand = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"conentDescription\": \"返回\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //附近的人自动加好友部分
    public static String sayHelloNearlbyJsonCmd_AutoAddFriend = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"conentDescription\": \"更多\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"附近打招呼的人\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 5000\n" +
            "        },\n" +
            "        {\n" +
            "            \"isloop\": true,\n" +
            "            \"isSwitch\": true,\n" +
            "            \"viewList\": [\n" +
            "                {\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"findthis\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"查看更多\"\n" +
            "                            },\n" +
            "                            \"switchValue\": \"有查看更多按钮\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"caseList\": [\n" +
            "                {\n" +
            "                    \"caseValue\": \"有查看更多按钮\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": false,\n" +
            "                            \"action\": \"click\",\n" +
            "                            \"sleep\": 3000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"isloop\": true,\n" +
            "            \"startIndex\": 0,\n" +
            "            \"maxloopnum\": 1000,\n" +
            "            \"viewList\": [\n" +
            "                {\n" +
            "                    \"returnValue\": true,\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"operationClassName\": \"android.widget.LinearLayout\",\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            },\n" +
            "                            \"switchValue\": \"needclick\",\n" +
            "                            \"action\": \"toLastLoopByIndex\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"caseList\": [\n" +
            "                {\n" +
            "                    \"caseValue\": \"needclick\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": false,\n" +
            "                            \"action\": \"click\",\n" +
            "                            \"sleep\": 2000\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"isloop\": true,\n" +
            "                            \"isSwitch\": true,\n" +
            "                            \"viewList\": [\n" +
            "                                {\n" +
            "                                    \"actions\": [\n" +
            "                                        {\n" +
            "                                            \"fromRoot\": true,\n" +
            "                                            \"findthis\": true,\n" +
            "                                            \"view\": {\n" +
            "                                                \"className\": \"android.widget.Button\",\n" +
            "                                                \"text\": \"通过验证\"\n" +
            "                                            },\n" +
            "                                            \"switchValue\": \"找到通过验证按钮\"\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"caseList\": [\n" +
            "                                {\n" +
            "                                    \"caseValue\": \"找到通过验证按钮\",\n" +
            "                                    \"actions\": [\n" +
            "                                        {\n" +
            "                                            \"fromRoot\": false,\n" +
            "                                            \"view\": {\n" +
            "                                                \"className\": \"android.widget.Button\",\n" +
            "                                                \"text\": \"通过验证\"\n" +
            "                                            },\n" +
            "                                            \"action\": \"click\",\n" +
            "                                            \"sleep\": 1000\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"fromRoot\": true,\n" +
            "                                            \"view\": {\n" +
            "                                                \"text\": \"完成\"\n" +
            "                                            },\n" +
            "                                            \"action\": \"click\",\n" +
            "                                            \"sleep\": 3000\n" +
            "                                        },\n" +
            "                                        {\n" +
            "                                            \"fromRoot\": true,\n" +
            "                                            \"view\": {\n" +
            "                                                \"conentDescription\": \"返回\"\n" +
            "                                            },\n" +
            "                                            \"action\": \"click\",\n" +
            "                                            \"sleep\": 2000\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"caseValue\": \"default\",\n" +
            "                                    \"actions\": [\n" +
            "                                        {\n" +
            "                                            \"fromRoot\": true,\n" +
            "                                            \"view\": {\n" +
            "                                                \"conentDescription\": \"返回\"\n" +
            "                                            },\n" +
            "                                            \"action\": \"click\",\n" +
            "                                            \"sleep\": 2000\n" +
            "                                        }\n" +
            "                                    ]\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"caseValue\": \"default\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"findthis\": true,\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            }\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"fromRoot\": false,\n" +
            "                            \"action\": \"scroll\",\n" +
            "                            \"sleep\": 1000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"conentDescription\": \"返回\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"conentDescription\": \"返回\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //编辑个人资料的各模块脚本都需要在【个人信息界面执行】
    //编辑个人资料更换头像部分
    public static String editpersonaldataCmd_HeadPortrait = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"conentDescription\": \"查看头像\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 5000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"findthis\": true,\n" +
            "            \"view\": {\n" +
            "                \"className\": \"android.widget.GridView\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"multiple\": true,\n" +
            "            \"fromRoot\": false,\n" +
            "            \"view\": {\n" +
            "                \"className\": \"android.widget.ImageView\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"multiple\": true,\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"使用\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 10000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //编辑个人资料修改昵称部分
    public static String editpersonaldataCmd_NickName = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"昵称\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"focusInput\": true\n" +
            "            },\n" +
            "            \"action\": \"input\",\n" +
            "            \"data\": \"@昵称\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"保存\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //编辑个人资料修改我的地址部分
    public static String editpersonaldataCmd_MyAddress = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"我的地址\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"conentDescription\": \"新增地址\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 1000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"focusInput\": true,\n" +
            "                \"text\": \"姓名\"\n" +
            "            },\n" +
            "            \"action\": \"input\",\n" +
            "            \"data\": \"@收货人\",\n" +
            "            \"sleep\": 1000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"11位手机号\"\n" +
            "            },\n" +
            "            \"action\": \"input\",\n" +
            "            \"data\": \"@手机号码\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"地区信息\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"isloop\": true,\n" +
            "            \"maxloopnum\": 0,\n" +
            "            \"dontBreakInDefault\": true,\n" +
            "            \"viewList\": [\n" +
            "                {\n" +
            "                    \"returnValue\": true,\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            },\n" +
            "                            \"num\": -1,\n" +
            "                            \"action\": \"containChildByTextcontains\",\n" +
            "                            \"data\": \"@地区信息省\",\n" +
            "                            \"switchValue\": \"findprovince\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"caseList\": [\n" +
            "                {\n" +
            "                    \"caseValue\": \"findprovince\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": false,\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"@地区信息省\"\n" +
            "                            },\n" +
            "                            \"action\": \"click\",\n" +
            "                            \"sleep\": 1000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"caseValue\": \"default\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            },\n" +
            "                            \"action\": \"scroll\",\n" +
            "                            \"sleep\": 2000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"isloop\": true,\n" +
            "            \"maxloopnum\": 0,\n" +
            "            \"dontBreakInDefault\": true,\n" +
            "            \"viewList\": [\n" +
            "                {\n" +
            "                    \"returnValue\": true,\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            },\n" +
            "                            \"num\": -1,\n" +
            "                            \"action\": \"containChildByTextcontains\",\n" +
            "                            \"data\": \"@地区信息市\",\n" +
            "                            \"switchValue\": \"findprovince\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"caseList\": [\n" +
            "                {\n" +
            "                    \"caseValue\": \"findprovince\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": false,\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"@地区信息市\"\n" +
            "                            },\n" +
            "                            \"action\": \"click\",\n" +
            "                            \"sleep\": 1000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"caseValue\": \"default\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            },\n" +
            "                            \"action\": \"scroll\",\n" +
            "                            \"sleep\": 2000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"isloop\": true,\n" +
            "            \"maxloopnum\": 0,\n" +
            "            \"dontBreakInDefault\": true,\n" +
            "            \"viewList\": [\n" +
            "                {\n" +
            "                    \"returnValue\": true,\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            },\n" +
            "                            \"num\": -1,\n" +
            "                            \"action\": \"containChildByTextcontains\",\n" +
            "                            \"data\": \"@地区信息区\",\n" +
            "                            \"switchValue\": \"findprovince\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"caseList\": [\n" +
            "                {\n" +
            "                    \"caseValue\": \"findprovince\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": false,\n" +
            "                            \"view\": {\n" +
            "                                \"text\": \"@地区信息区\"\n" +
            "                            },\n" +
            "                            \"action\": \"click\",\n" +
            "                            \"sleep\": 1000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"caseValue\": \"default\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"fromRoot\": true,\n" +
            "                            \"view\": {\n" +
            "                                \"className\": \"android.widget.ListView\"\n" +
            "                            },\n" +
            "                            \"action\": \"scroll\",\n" +
            "                            \"sleep\": 2000\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"街道门牌信息\"\n" +
            "            },\n" +
            "            \"action\": \"input\",\n" +
            "            \"data\": \"@详细地址\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"邮政编码\"\n" +
            "            },\n" +
            "            \"action\": \"input\",\n" +
            "            \"data\": \"@邮政编码\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"保存\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 3000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"conentDescription\": \"返回\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //编辑个人资料修改性别部分
    public static String editpersonaldataCmd_Sex = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"性别\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"@性别\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //编辑个人资料修改地区部分，这里应该改成默认输入当前位置,所以这个默认要加进去
    public static String editpersonaldataCmd_Area = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"地区\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"className\": \"android.widget.ListView\"\n" +
            "            },\n" +
            "            \"action\": \"getChildNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    //编辑个人资料修改个性签名部分
    public static String editpersonaldataCmd_Sign = "{\n" +
            "    \"actions\": [\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"个性签名\"\n" +
            "            },\n" +
            "            \"action\": \"getParentNode\",\n" +
            "            \"data\": 1\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": false,\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 2000\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"focusInput\": true\n" +
            "            },\n" +
            "            \"action\": \"input\",\n" +
            "            \"data\": \"@个性签名\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"fromRoot\": true,\n" +
            "            \"view\": {\n" +
            "                \"text\": \"保存\"\n" +
            "            },\n" +
            "            \"action\": \"click\",\n" +
            "            \"sleep\": 3000\n" +
            "        }\n" +
            "    ]\n" +
            "}";

 }
