package com.jiakun.fresh.pojo;

/**
 * Created by jiakun on 17-5-1.
 */
public class BookingRecordInfo {
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
     * 缓存时效表更新时效，更新表时使用
     */
    private int updateDiff;
    /**
     * 缓存时效表，插入时效，插入表时使用
     */
    private int insertExpire;
    /**
     * 低值下限.更新表时使用
     */
    private int lowLimit;

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

    public int getUpdateDiff() {
        return updateDiff;
    }

    public void setUpdateDiff(int updateDiff) {
        this.updateDiff = updateDiff;
    }

    public int getInsertExpire() {
        return insertExpire;
    }

    public void setInsertExpire(int insertExpire) {
        this.insertExpire = insertExpire;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(int lowLimit) {
        this.lowLimit = lowLimit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookingRecordInfo{");
        sb.append("depCode='").append(depCode).append('\'');
        sb.append(", arrCode='").append(arrCode).append('\'');
        sb.append(", pcc='").append(pcc).append('\'');
        sb.append(", gdsType='").append(gdsType).append('\'');
        sb.append(", bookingNum=").append(bookingNum);
        sb.append(", successNum=").append(successNum);
        sb.append(", successRate=").append(successRate);
        sb.append(", updateDiff=").append(updateDiff);
        sb.append(", insertExpire=").append(insertExpire);
        sb.append(", lowLimit=").append(lowLimit);
        sb.append('}');
        return sb.toString();
    }
}
