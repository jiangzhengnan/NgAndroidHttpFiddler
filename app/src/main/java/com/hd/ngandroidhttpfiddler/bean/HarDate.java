package com.hd.ngandroidhttpfiddler.bean;


import java.io.Serializable;

public class HarDate implements Serializable{
    //请求url
    private String url;
    //远程服务器端口号
    private String port;

    //请求次数
    private Integer times = 1;

    //请求字节大小
    private long bytes;

    //请求头
    private String userAgent;
    private String host;
    private String Connection;
    private String AcceptEncoding;

    //请求体
    private String requestBody;

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConnection() {
        return Connection;
    }

    public void setConnection(String connection) {
        Connection = connection;
    }

    public String getAcceptEncoding() {
        return AcceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        AcceptEncoding = acceptEncoding;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public void addTimes() {
        this.times++;
    }

    public void addBytes(long bytes) {
        this.bytes+= bytes;
    }

    public long getBytes() {
        return bytes;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "HarDate{" +
                "url='" + url + '\'' +
                ", port='" + port + '\'' +
                ", times=" + times +
                ", bytes=" + bytes +
                ", userAgent='" + userAgent + '\'' +
                ", host='" + host + '\'' +
                ", Connection='" + Connection + '\'' +
                ", AcceptEncoding='" + AcceptEncoding + '\'' +
                ", requestBody='" + requestBody + '\'' +
                '}';
    }
}
