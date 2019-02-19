package com.yuchai.maintain.targetmaintain.entity;

import java.util.List;
import java.util.Map;

/**
 * 分页信息+分页内容
 */
public class PageData {
    //分页信息
    private PageInfo pageInfo;
    //下拉列表
    private Map<String,List> selectLists;
    //当页的数据内容
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
