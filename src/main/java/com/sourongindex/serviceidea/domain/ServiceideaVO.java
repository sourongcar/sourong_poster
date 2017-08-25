package com.sourongindex.serviceidea.domain;

import java.io.Serializable;
import java.util.Date;

public class ServiceideaVO implements Serializable {
    private Integer serviceideaid;

    private String picname;

    private String ideadescribe;

    private Date createtime;

    private Date lasttime;

    private static final long serialVersionUID = 1L;

    public Integer getServiceideaid() {
        return serviceideaid;
    }

    public void setServiceideaid(Integer serviceideaid) {
        this.serviceideaid = serviceideaid;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname == null ? null : picname.trim();
    }

    public String getIdeadescribe() {
        return ideadescribe;
    }

    public void setIdeadescribe(String ideadescribe) {
        this.ideadescribe = ideadescribe == null ? null : ideadescribe.trim();
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
        sb.append(", serviceideaid=").append(serviceideaid);
        sb.append(", picname=").append(picname);
        sb.append(", ideadescribe=").append(ideadescribe);
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
        ServiceideaVO other = (ServiceideaVO) that;
        return (this.getServiceideaid() == null ? other.getServiceideaid() == null : this.getServiceideaid().equals(other.getServiceideaid()))
            && (this.getPicname() == null ? other.getPicname() == null : this.getPicname().equals(other.getPicname()))
            && (this.getIdeadescribe() == null ? other.getIdeadescribe() == null : this.getIdeadescribe().equals(other.getIdeadescribe()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLasttime() == null ? other.getLasttime() == null : this.getLasttime().equals(other.getLasttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getServiceideaid() == null) ? 0 : getServiceideaid().hashCode());
        result = prime * result + ((getPicname() == null) ? 0 : getPicname().hashCode());
        result = prime * result + ((getIdeadescribe() == null) ? 0 : getIdeadescribe().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLasttime() == null) ? 0 : getLasttime().hashCode());
        return result;
    }
}