package com.jiakun.fresh.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by jiakun on 17-5-4.
 */
@JacksonXmlRootElement(localName = "MarkupResult")
public class MarkupResult {
    @JacksonXmlProperty(localName = "Success")
    private boolean success;//true / false
    @JacksonXmlProperty(localName = "ErrorMsg")
    private String errorMsg;//错误信息提示
    @JacksonXmlProperty(localName = "LastUpdated")
    private String lastUpdated;//最后更新时间
    @JacksonXmlProperty(localName = "ExchangeRates")
    @JacksonXmlElementWrapper
    private List<ExchangeRate> exchangeRates;//汇率信息
    @JacksonXmlProperty(localName = "MarkupItems")
    @JacksonXmlElementWrapper
    private List<MarkupItem> markupItems;//Markup 信息

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public List<MarkupItem> getMarkupItems() {
        return markupItems;
    }

    public void setMarkupItems(List<MarkupItem> markupItems) {
        this.markupItems = markupItems;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MarkupResult{");
        sb.append("success=").append(success);
        sb.append(", errorMsg='").append(errorMsg).append('\'');
        sb.append(", lastUpdated='").append(lastUpdated).append('\'');
        sb.append(", exchangeRates=").append(exchangeRates);
        sb.append(", markupItems=").append(markupItems);
        sb.append('}');
        return sb.toString();
    }

    public static class ExchangeRate {
        @JacksonXmlProperty(localName = "From")
        private String from;//原始货币
        @JacksonXmlProperty(localName = "To")
        private String to;//目标货币
        @JacksonXmlProperty(localName = "Rate")
        private double rate;//汇率

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ExchangeRate{");
            sb.append("from='").append(from).append('\'');
            sb.append(", to='").append(to).append('\'');
            sb.append(", rate=").append(rate);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class MarkupItem {
        @JacksonXmlProperty(localName = "Id")
        private String id;//标识
        @JacksonXmlProperty(localName = "MarkupBy")
        private MarkupBy markupBy;//Unkown / Rate / Amount
        @JacksonXmlProperty(localName = "MarkupValue")
        private double markupValue;//Markup 数值
        @JacksonXmlProperty(localName = "MarkupDescription")
        private String markupDescription;//Markup 描述
        @JacksonXmlProperty(localName = "MarkupModes")
        @JacksonXmlElementWrapper
        private List<MarkupMode> markupModes;//Markup 信息
        @JacksonXmlProperty(localName = "MarkupId")//?不确定
        private String markupId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public MarkupBy getMarkupBy() {
            return markupBy;
        }

        public void setMarkupBy(MarkupBy markupBy) {
            this.markupBy = markupBy;
        }

        public double getMarkupValue() {
            return markupValue;
        }

        public void setMarkupValue(double markupValue) {
            this.markupValue = markupValue;
        }

        public String getMarkupDescription() {
            return markupDescription;
        }

        public void setMarkupDescription(String markupDescription) {
            this.markupDescription = markupDescription;
        }

        public List<MarkupMode> getMarkupModes() {
            return markupModes;
        }

        public void setMarkupModes(List<MarkupMode> markupModes) {
            this.markupModes = markupModes;
        }

        public String getMarkupId() {
            return markupId;
        }

        public void setMarkupId(String markupId) {
            this.markupId = markupId;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("MarkupItem{");
            sb.append("id='").append(id).append('\'');
            sb.append(", markupBy=").append(markupBy);
            sb.append(", markupValue=").append(markupValue);
            sb.append(", markupDescription='").append(markupDescription).append('\'');
            sb.append(", markupModes=").append(markupModes);
            sb.append(", markupId='").append(markupId).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class MarkupMode {
        @JacksonXmlProperty(localName = "Rank")
        private int rank;//计算次序
        @JacksonXmlProperty(localName = "MarkupBy")
        private MarkupBy markupBy;//Rate/Amount
        @JacksonXmlProperty(localName = "MarkupValue")
        private double markupValue;//Markup 数值

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public MarkupBy getMarkupBy() {
            return markupBy;
        }

        public void setMarkupBy(MarkupBy markupBy) {
            this.markupBy = markupBy;
        }

        public double getMarkupValue() {
            return markupValue;
        }

        public void setMarkupValue(double markupValue) {
            this.markupValue = markupValue;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("MarkupMode{");
            sb.append("rank=").append(rank);
            sb.append(", markupBy=").append(markupBy);
            sb.append(", markupValue=").append(markupValue);
            sb.append('}');
            return sb.toString();
        }
    }


    public enum MarkupBy {
        Unkown("没有返点"),
        Rate("按百分比计算"),
        Amount("按数值计算");
        private String desc;

        MarkupBy(String desc) {
            this.desc = desc;
        }
        public String getDesc(){
            return this.desc;
        }
    }
}


