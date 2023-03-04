package com.JavaBean;

import java.util.List;

public class pagination<T> {
    private int pageCount;//页面总条数
    private int pagePageCount;//页面总页数
    private List<T> pageShow;//本页显示内容
    private int pageShowrow;//每页显示条数
    private int nowPageCount;//当前页码


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPagePageCount() {
        return pagePageCount;
    }

    public void setPagePageCount(int pagePageCount) {
        this.pagePageCount = pagePageCount;
    }

    public List<T> getPageShow() {
        return pageShow;
    }

    public void setPageShow(List<T> pageShow) {
        this.pageShow = pageShow;
    }

    public int getPageShowrow() {
        return pageShowrow;
    }

    public void setPageShowrow(int pageShowrow) {
        this.pageShowrow = pageShowrow;
    }

    public int getNowPageCount() {
        return nowPageCount;
    }

    public void setNowPageCount(int nowPageCount) {
        this.nowPageCount = nowPageCount;
    }

    @Override
    public String toString() {
        return "pagination{" +
                "pageCount=" + pageCount +
                ", pagePageCount=" + pagePageCount +
                ", pageShow=" + pageShow +
                ", pageShowrow=" + pageShowrow +
                ", nowPageCount=" + nowPageCount +
                '}';
    }
}
