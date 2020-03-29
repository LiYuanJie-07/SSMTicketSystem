package com.gdou.domain;

import java.io.Serializable;

/**
 * 菜单实体类
 */
public class Menu implements Serializable {
    private Integer menuid;

    private Integer admin;

    private String menuname;

    private String menuurl;

    private Integer parentid;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuid=" + menuid +
                ", admin=" + admin +
                ", menuname='" + menuname + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}
