package com.example.share.unit.pagehelper;

import com.github.pagehelper.Page;

import java.util.List;

public class PageBean {

    public PageBean(Page page) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.data = page.getResult();
    }

    private int pageNum;    //当前页码

    private int pageSize;   //页码大小

    private long total;     //数据长度

    private List data;      //数据

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
