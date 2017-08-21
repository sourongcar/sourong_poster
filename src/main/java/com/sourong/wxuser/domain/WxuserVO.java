package com.sourong.wxuser.domain;

import java.io.Serializable;
import java.util.Date;

public class WxuserVO implements Serializable {
    private Integer userid;

    private String openid;

    private String nickname;

    private String userphoto;

    private String userphone;

    private String username;

    private Integer referrerid;

    private Integer role;

    private Integer isdisplay;

    private Date createtime;

    private Date changetime;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getReferrerid() {
        return referrerid;
    }

    public void setReferrerid(Integer referrerid) {
        this.referrerid = referrerid;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Integer isdisplay) {
        this.isdisplay = isdisplay;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChangetime() {
        return changetime;
    }

    public void setChangetime(Date changetime) {
        this.changetime = changetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", openid=").append(openid);
        sb.append(", nickname=").append(nickname);
        sb.append(", userphoto=").append(userphoto);
        sb.append(", userphone=").append(userphone);
        sb.append(", username=").append(username);
        sb.append(", referrerid=").append(referrerid);
        sb.append(", role=").append(role);
        sb.append(", isdisplay=").append(isdisplay);
        sb.append(", createtime=").append(createtime);
        sb.append(", changetime=").append(changetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WxuserVO other = (WxuserVO) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getUserphoto() == null ? other.getUserphoto() == null : this.getUserphoto().equals(other.getUserphoto()))
            && (this.getUserphone() == null ? other.getUserphone() == null : this.getUserphone().equals(other.getUserphone()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getReferrerid() == null ? other.getReferrerid() == null : this.getReferrerid().equals(other.getReferrerid()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getIsdisplay() == null ? other.getIsdisplay() == null : this.getIsdisplay().equals(other.getIsdisplay()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getChangetime() == null ? other.getChangetime() == null : this.getChangetime().equals(other.getChangetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getUserphoto() == null) ? 0 : getUserphoto().hashCode());
        result = prime * result + ((getUserphone() == null) ? 0 : getUserphone().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getReferrerid() == null) ? 0 : getReferrerid().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getIsdisplay() == null) ? 0 : getIsdisplay().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getChangetime() == null) ? 0 : getChangetime().hashCode());
        return result;
    }
}