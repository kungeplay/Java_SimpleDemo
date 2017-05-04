package com.jiakun.fresh.pojo;

/**
 * Created by jiakun on 17-5-2.
 */
/**
 * 采购分销模式中的缓存时效表信息
 * Created by jiakun on 17-4-28.
 */
public class CacheExpireInfo {
    /**
     * 出发城市三字码
     */
    private String depCode;
    /**
     * 到达城市三字码
     */
    private String arrCode;
    /**
     * pcc
     */
    private String pcc;
    /**
     * gds类型
     */
    private String gdsType;
    /**
     * booking量
     */
    private int bookingNum;
    /**
     * booking成功量
     */
    private int successNum;

    /**
     * booking成功率
     */
    private double successRate;
    /**
     * 缓存时效
     */
    private int cacheTimeout;
    /**
     * 人工调整的缓存时效
     */
    private int manualTimeout;

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getArrCode() {
        return arrCode;
    }

    public void setArrCode(String arrCode) {
        this.arrCode = arrCode;
    }

    public String getPcc() {
        return pcc;
    }

    public void setPcc(String pcc) {
        this.pcc = pcc;
    }

    public String getGdsType() {
        return gdsType;
    }

    public void setGdsType(String gdsType) {
        this.gdsType = gdsType;
    }

    public int getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(int bookingNum) {
        this.bookingNum = bookingNum;
    }

    public int getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public int getCacheTimeout() {
        return cacheTimeout;
    }

    public void setCacheTimeout(int cacheTimeout) {
        this.cacheTimeout = cacheTimeout;
    }

    public int getManualTimeout() {
        return manualTimeout;
    }

    public void setManualTimeout(int manualTimeout) {
        this.manualTimeout = manualTimeout;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CacheExpireInfo{");
        sb.append("depCode='").append(depCode).append('\'');
        sb.append(", arrCode='").append(arrCode).append('\'');
        sb.append(", pcc='").append(pcc).append('\'');
        sb.append(", gdsType='").append(gdsType).append('\'');
        sb.append(", bookingNum=").append(bookingNum);
        sb.append(", successNum=").append(successNum);
        sb.append(", successRate=").append(successRate);
        sb.append(", cacheTimeout=").append(cacheTimeout);
        sb.append(", manualTimeout=").append(manualTimeout);
        sb.append('}');
        return sb.toString();
    }
}

