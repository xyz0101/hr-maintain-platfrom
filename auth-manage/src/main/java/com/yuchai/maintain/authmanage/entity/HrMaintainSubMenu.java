package com.yuchai.maintain.authmanage.entity;

public class HrMaintainSubMenu {
    private Short subMenuId;

    private Short mainMenuId;

    private String subMenuDesc;

    private String subMenuUrl;

    public Short getSubMenuId() {
        return subMenuId;
    }

    public void setSubMenuId(Short subMenuId) {
        this.subMenuId = subMenuId;
    }

    public Short getMainMenuId() {
        return mainMenuId;
    }

    public void setMainMenuId(Short mainMenuId) {
        this.mainMenuId = mainMenuId;
    }

    public String getSubMenuDesc() {
        return subMenuDesc;
    }

    public void setSubMenuDesc(String subMenuDesc) {
        this.subMenuDesc = subMenuDesc == null ? null : subMenuDesc.trim();
    }

    public String getSubMenuUrl() {
        return subMenuUrl;
    }

    public void setSubMenuUrl(String subMenuUrl) {
        this.subMenuUrl = subMenuUrl == null ? null : subMenuUrl.trim();
    }
}