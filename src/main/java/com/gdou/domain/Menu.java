package com.gdou.domain;

import java.util.List;

/**
 * 菜单实体类
 */
public class Menu {
    private String menuname;

    private String menuurl;

    private List<Menu> child;

    public Menu(String menuname, String menuurl, List<Menu> child) {
        this.menuname = menuname;
        this.menuurl = menuurl;
        this.child = child;
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

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }
}
