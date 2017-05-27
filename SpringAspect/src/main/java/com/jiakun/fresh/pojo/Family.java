package com.jiakun.fresh.pojo;

/**
 * Created by jiakun on 17-5-23.
 */
public class Family {
    private Adult adult;
    private Child child;

    public Family(Adult adult, Child child) {
        this.adult = adult;
        this.child = child;
    }

    public Adult getAdult() {
        return adult;
    }

    public void setAdult(Adult adult) {
        this.adult = adult;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
