package com.gdou.domain;

/**
 * 用户实体类，用于封装返回的数据
 */
public class User {
    private Integer userid;

    private String username;

    private String password;

    private String email;

    private Integer admin;

    private String idcardnumber;

    private String idcardname;

    private String phone;

    private String type;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getIdcardnumber() {
        return idcardnumber;
    }

    public void setIdcardnumber(String idcardnumber) {
        this.idcardnumber = idcardnumber == null ? null : idcardnumber.trim();
    }

    public String getIdcardname() {
        return idcardname;
    }

    public void setIdcardname(String idcardname) {
        this.idcardname = idcardname == null ? null : idcardname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}