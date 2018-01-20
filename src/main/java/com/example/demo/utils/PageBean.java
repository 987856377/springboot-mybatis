package com.example.demo.utils;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by daier on 2018/1/20.
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class PageBean<T> implements Serializable {
    private static final long seriaVersionUID = 1L;
//    当前页
    private int pageNum;

//    页面总数
    private int pages;

//    每页的记录数
    private int pageSize;

//    总记录数
    private long total;

//    结果集
    List<T> list;

//    是否是第一页
    private boolean isFirstPage = false;
//    是否最后一页
    private boolean isLastPage = false;

    public PageBean(){

    }

    public PageBean(List<T> list){
        if (list instanceof Page){
            Page page = (Page)list;
            this.pageNum =  page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
            this.total = page.getTotal();
            this.list = page;
        }
        else if (list instanceof Collection){
            this.pageNum = 1;
            this.pageSize = list.size();
            this.pages = 1;
            this.list = list;
            this.total = list.size();
        }
        if (list instanceof Collection){
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageBean{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", navigatepageNums=");
        sb.append('}');
        return sb.toString();
    }
}
