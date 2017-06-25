package com.hd.ngandroidhttpfiddler;

/**
 * 流量数据控制器
 * created by Pumpkin at 17/5/9
 */
public class FlowController {
    //懒汉，线程安全
    private static FlowController instance;

    private FlowController() {
    }

    public static synchronized FlowController getInstance() {
        if (instance == null) {
            instance = new FlowController();
        }
        return instance;
    }

    private long totalBytes;
    private long totalPackets;

    public long getTotalPackets() {
        return totalPackets;
    }

    public void setTotalPackets(long totalPackets) {
        this.totalPackets = totalPackets;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(long totalBytes) {
        this.totalBytes = totalBytes;
    }

    @Override
    public String toString() {
        return "FlowController{" +
                "totalBytes=" + totalBytes +
                ", totalPackets=" + totalPackets +
                '}';
    }
}
