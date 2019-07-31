package com.mtl.common.tool.model;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class Page<T> {

    private int total;

    private List<T> list;

    public Page(List<T> list) {
        if (list instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page<T> page = (com.github.pagehelper.Page<T>) list;
            this.total = (int) page.getTotal();
            this.list = list;
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
