package com.yuchai.maintain.authmanage.entity;

import java.util.List;

public class HrMaintainMainMenu {
    private Short mainMenuId;

    private String mainMenuDesc;

    private String defaultMainMenuUrl;

    private List<HrMaintainSubMenu> subMenuList;

    public List<HrMaintainSubMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<HrMaintainSubMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public Short getMainMenuId() {
        return mainMenuId;
    }

    public void setMainMenuId(Short mainMenuId) {
        this.mainMenuId = mainMenuId;
    }

    public String getMainMenuDesc() {
        return mainMenuDesc;
    }

    public void setMainMenuDesc(String mainMenuDesc) {
        this.mainMenuDesc = mainMenuDesc == null ? null : mainMenuDesc.trim();
    }

    public String getDefaultMainMenuUrl() {
        return defaultMainMenuUrl;
    }

    public void setDefaultMainMenuUrl(String defaultMainMenuUrl) {
        this.defaultMainMenuUrl = defaultMainMenuUrl == null ? null : defaultMainMenuUrl.trim();
    }
}