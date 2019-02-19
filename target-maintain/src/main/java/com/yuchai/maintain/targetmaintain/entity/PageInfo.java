package com.yuchai.maintain.targetmaintain.entity;

public class PageInfo {
    private Integer pageNum;
    private Integer totalNum;
    private Integer curPage;
    private Integer pageSize;

    public Integer getPageNum() {
        if(pageNum!=null){
            return pageNum;
        }else{
            if(totalNum!=null&&pageSize!=null&&pageSize>0){
            return (totalNum%pageSize)>0?(totalNum/pageSize)+1:(totalNum/pageSize);
            }else{
                return 0;
            }
        }
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
