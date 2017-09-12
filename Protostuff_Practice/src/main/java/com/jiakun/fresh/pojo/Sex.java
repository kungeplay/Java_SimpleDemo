package com.jiakun.fresh.pojo;

public enum Sex {
    GIRLE("G","女孩"),
    MALE("M","男人"),
    FEAMLE("F","女人"),
    CHILD("C","儿童");
    private String code;
    private String zhCode;

    Sex(String code, String zhCode) {
        this.code = code;
        this.zhCode = zhCode;
    }
}
