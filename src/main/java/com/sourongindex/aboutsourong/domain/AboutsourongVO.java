package com.sourongindex.aboutsourong.domain;

import java.io.Serializable;
import java.util.Date;

public class AboutsourongVO implements Serializable {
    private Integer sourongid;

    private String picname;

    private String title;

    private String specificdescribe;

    private Date createtime;

    private Date lasttime;

    private static final long serialVersionUID = 1L;

    public Integer getSourongid() {
        return sourongid;
    }

    public void setSourongid(Integer sourongid) {
        this.sourongid = sourongid;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname == null ? null : picname.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSpecificdescribe() {
        return specificdescribe;
    }

    public void setSpecificdescribe(String specificdescribe) {
        this.specificdescribe = specificdescribe == null ? null : specificdescribe.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sourongid=").append(sourongid);
        sb.append(", picname=").append(picname);
        sb.append(", title=").append(title);
        sb.append(", specificdescribe=").append(specificdescribe);
        sb.append(", createtime=").append(createtime);
        sb.append(", lasttime=").append(lasttime);
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
        AboutsourongVO other = (AboutsourongVO) that;
        return (this.getSourongid() == null ? other.getSourongid() == null : this.getSourongid().equals(other.getSourongid()))
            && (this.getPicname() == null ? other.getPicname() == null : this.getPicname().equals(other.getPicname()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSpecificdescribe() == null ? other.getSpecificdescribe() == null : this.getSpecificdescribe().equals(other.getSpecificdescribe()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLasttime() == null ? other.getLasttime() == null : this.getLasttime().equals(other.getLasttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSourongid() == null) ? 0 : getSourongid().hashCode());
        result = prime * result + ((getPicname() == null) ? 0 : getPicname().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSpecificdescribe() == null) ? 0 : getSpecificdescribe().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLasttime() == null) ? 0 : getLasttime().hashCode());
        return result;
    }
}