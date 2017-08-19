package com.sourong.poster.domain;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class PosterVO implements Serializable {
    private Integer posterid;
    
    @Length(max=25,min=1)
    @NotEmpty
    private String postertitle;

    private String posterurl;

    private String qrcode;

    private Date createtime;

    private Date changetime;

    private static final long serialVersionUID = 1L;

    public Integer getPosterid() {
        return posterid;
    }

    public void setPosterid(Integer posterid) {
        this.posterid = posterid;
    }

    public String getPostertitle() {
        return postertitle;
    }

    public void setPostertitle(String postertitle) {
        this.postertitle = postertitle == null ? null : postertitle.trim();
    }

    public String getPosterurl() {
        return posterurl;
    }

    public void setPosterurl(String posterurl) {
        this.posterurl = posterurl == null ? null : posterurl.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
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
        sb.append(", posterid=").append(posterid);
        sb.append(", postertitle=").append(postertitle);
        sb.append(", posterurl=").append(posterurl);
        sb.append(", qrcode=").append(qrcode);
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
        PosterVO other = (PosterVO) that;
        return (this.getPosterid() == null ? other.getPosterid() == null : this.getPosterid().equals(other.getPosterid()))
            && (this.getPostertitle() == null ? other.getPostertitle() == null : this.getPostertitle().equals(other.getPostertitle()))
            && (this.getPosterurl() == null ? other.getPosterurl() == null : this.getPosterurl().equals(other.getPosterurl()))
            && (this.getQrcode() == null ? other.getQrcode() == null : this.getQrcode().equals(other.getQrcode()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getChangetime() == null ? other.getChangetime() == null : this.getChangetime().equals(other.getChangetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPosterid() == null) ? 0 : getPosterid().hashCode());
        result = prime * result + ((getPostertitle() == null) ? 0 : getPostertitle().hashCode());
        result = prime * result + ((getPosterurl() == null) ? 0 : getPosterurl().hashCode());
        result = prime * result + ((getQrcode() == null) ? 0 : getQrcode().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getChangetime() == null) ? 0 : getChangetime().hashCode());
        return result;
    }
}