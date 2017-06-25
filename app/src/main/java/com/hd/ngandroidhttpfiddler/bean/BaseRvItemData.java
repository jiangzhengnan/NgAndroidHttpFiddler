package com.hd.ngandroidhttpfiddler.bean;/**
 * Created by ${Pumpkin} on 17/5/1.
 */

/**
 * created by Pumpkin at 17/5/1
 */
public class BaseRvItemData<T> {
    T itemData;
    Integer itmeType;

    public BaseRvItemData(T itemData, Integer itmeType) {
        this.itemData = itemData;
        this.itmeType = itmeType;
    }

    public T getItemData() {
        return itemData;
    }

    public void setItemData(T itemData) {
        this.itemData = itemData;
    }

    public Integer getItmeType() {
        return itmeType;
    }

    public void setItmeType(Integer itmeType) {
        this.itmeType = itmeType;
    }

    @Override
    public String toString() {
        return "BaseRvItemData{" +
                "itemData=" + itemData +
                ", itmeType=" + itmeType +
                '}';
    }
}
