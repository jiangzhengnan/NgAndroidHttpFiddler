package com.hd.ngandroidhttpfiddler.bean;

import android.graphics.drawable.Drawable;

public class QsApp {
    private Drawable icon;
    private String name;
    private String packgeName;

    public QsApp(Drawable icon, String name, String packgeName) {
        this.icon = icon;
        this.name = name;
        this.packgeName = packgeName;
    }

    public String getPackgeName() {
        return packgeName;
    }

    public void setPackgeName(String packgeName) {
        this.packgeName = packgeName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QsApp{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", packgeName='" + packgeName + '\'' +
                '}';
    }
}
