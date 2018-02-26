package com.jiakun.fresh.pojo;

import java.io.Serializable;

public class Stock implements Serializable{
    private static final long serialVersionUID = 18112112920264494L;
    private Stock stock;
    private Integer stockId;
    private String stockCode;
    private String stockName;

    public Stock() {
    }

    public Stock(Integer stockId, String stockCode, String stockName) {
        this.stockId = stockId;
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public Stock(String stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
