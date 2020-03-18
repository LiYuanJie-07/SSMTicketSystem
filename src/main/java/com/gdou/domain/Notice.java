package com.gdou.domain;

import java.io.Serializable;

/**
 * 公告实体类
 */
public class Notice implements Serializable {
    private Integer noticeid;

    private String noticetitle;

    private String noticetime;

    private String noticetext;

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticetitle() {
        return noticetitle;
    }

    public void setNoticetitle(String noticetitle) {
        this.noticetitle = noticetitle == null ? null : noticetitle.trim();
    }

    public String getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(String noticetime) {
        this.noticetime = noticetime;
    }

    public String getNoticetext() {
        return noticetext;
    }

    public void setNoticetext(String noticetext) {
        this.noticetext = noticetext == null ? null : noticetext.trim();
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeid=" + noticeid +
                ", noticetitle='" + noticetitle + '\'' +
                ", noticetime='" + noticetime + '\'' +
                ", noticetext='" + noticetext + '\'' +
                '}';
    }
}