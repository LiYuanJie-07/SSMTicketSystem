package com.gdou.domain;

import java.util.List;

/**
 * 将Menu以一定格式返回给页面
 */
public class MenuList {
    private String menuname;

    private List<Menu> child;

    public MenuList(String menuname, List<Menu> child) {
        this.menuname = menuname;
        this.child = child;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "menuname='" + menuname + '\'' +
                ", child=" + child +
                '}';
    }
}
