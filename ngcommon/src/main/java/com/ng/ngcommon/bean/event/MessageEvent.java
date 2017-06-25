package com.ng.ngcommon.bean.event;

public class MessageEvent {
    private Object message;
    private Integer messageType;

    public MessageEvent(Object message,int messageType){
        this.message = message;
        this.messageType = messageType;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "message=" + message +
                ", messageType=" + messageType +
                '}';
    }
}
