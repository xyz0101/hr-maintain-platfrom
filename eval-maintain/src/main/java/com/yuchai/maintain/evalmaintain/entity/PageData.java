package com.yuchai.maintain.evalmaintain.entity;

import java.util.List;
import java.util.Map;

public class PageData {
    private PageInfo pageInfo;
    private Map<String,List> selectLists;
    private List listData;

    public Map<String, List> getSelectLists() {
        return selectLists;
    }

    public void setSelectLists(Map<String, List> selectLists) {
        this.selectLists = selectLists;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List getListData() {
        return listData;
    }

    public void setListData(List listData) {
        this.listData = listData;
    }
}
