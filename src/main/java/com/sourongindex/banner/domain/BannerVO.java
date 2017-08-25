package com.sourongindex.banner.domain;

import java.io.Serializable;
import java.util.Date;

public class BannerVO implements Serializable {
    private Integer bannerid;

    private String picname;

    private String picintro;

    private Date createtime;

    private Date lasttime;

    private static final long serialVersionUID = 1L;

    public Integer getBannerid() {
        return bannerid;
    }

    public void setBannerid(Integer bannerid) {
        this.bannerid = bannerid;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname == null ? null : picname.trim();
    }

    public String getPicintro() {
        return picintro;
    }

    public void setPicintro(String picintro) {
        this.picintro = picintro == null ? null : picintro.trim();
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
        sb.append(", bannerid=").append(bannerid);
        sb.append(", picname=").append(picname);
        sb.append(", picintro=").append(picintro);
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
        BannerVO other = (BannerVO) that;
        return (this.getBannerid() == null ? other.getBannerid() == null : this.getBannerid().equals(other.getBannerid()))
            && (this.getPicname() == null ? other.getPicname() == null : this.getPicname().equals(other.getPicname()))
            && (this.getPicintro() == null ? other.getPicintro() == null : this.getPicintro().equals(other.getPicintro()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLasttime() == null ? other.getLasttime() == null : this.getLasttime().equals(other.getLasttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBannerid() == null) ? 0 : getBannerid().hashCode());
        result = prime * result + ((getPicname() == null) ? 0 : getPicname().hashCode());
        result = prime * result + ((getPicintro() == null) ? 0 : getPicintro().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLasttime() == null) ? 0 : getLasttime().hashCode());
        return result;
    }
}