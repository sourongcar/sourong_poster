package com.sourongindex.companyinfom.domain;

import java.io.Serializable;
import java.util.Date;

public class CompanyinfomVO implements Serializable {
    private Integer companyid;

    private String companyname;

    private String servicephone;

    private String servicetime;

    private String companyaddress;

    private String companylogo;

    private String companyqr;

    private Date createtime;

    private Date lasttime;

    private String detailaddress;

    private static final long serialVersionUID = 1L;

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getServicephone() {
        return servicephone;
    }

    public void setServicephone(String servicephone) {
        this.servicephone = servicephone == null ? null : servicephone.trim();
    }

    public String getServicetime() {
        return servicetime;
    }

    public void setServicetime(String servicetime) {
        this.servicetime = servicetime == null ? null : servicetime.trim();
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress == null ? null : companyaddress.trim();
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo == null ? null : companylogo.trim();
    }

    public String getCompanyqr() {
        return companyqr;
    }

    public void setCompanyqr(String companyqr) {
        this.companyqr = companyqr == null ? null : companyqr.trim();
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

    public String getDetailaddress() {
        return detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress == null ? null : detailaddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", companyid=").append(companyid);
        sb.append(", companyname=").append(companyname);
        sb.append(", servicephone=").append(servicephone);
        sb.append(", servicetime=").append(servicetime);
        sb.append(", companyaddress=").append(companyaddress);
        sb.append(", companylogo=").append(companylogo);
        sb.append(", companyqr=").append(companyqr);
        sb.append(", createtime=").append(createtime);
        sb.append(", lasttime=").append(lasttime);
        sb.append(", detailaddress=").append(detailaddress);
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
        CompanyinfomVO other = (CompanyinfomVO) that;
        return (this.getCompanyid() == null ? other.getCompanyid() == null : this.getCompanyid().equals(other.getCompanyid()))
            && (this.getCompanyname() == null ? other.getCompanyname() == null : this.getCompanyname().equals(other.getCompanyname()))
            && (this.getServicephone() == null ? other.getServicephone() == null : this.getServicephone().equals(other.getServicephone()))
            && (this.getServicetime() == null ? other.getServicetime() == null : this.getServicetime().equals(other.getServicetime()))
            && (this.getCompanyaddress() == null ? other.getCompanyaddress() == null : this.getCompanyaddress().equals(other.getCompanyaddress()))
            && (this.getCompanylogo() == null ? other.getCompanylogo() == null : this.getCompanylogo().equals(other.getCompanylogo()))
            && (this.getCompanyqr() == null ? other.getCompanyqr() == null : this.getCompanyqr().equals(other.getCompanyqr()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLasttime() == null ? other.getLasttime() == null : this.getLasttime().equals(other.getLasttime()))
            && (this.getDetailaddress() == null ? other.getDetailaddress() == null : this.getDetailaddress().equals(other.getDetailaddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCompanyid() == null) ? 0 : getCompanyid().hashCode());
        result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
        result = prime * result + ((getServicephone() == null) ? 0 : getServicephone().hashCode());
        result = prime * result + ((getServicetime() == null) ? 0 : getServicetime().hashCode());
        result = prime * result + ((getCompanyaddress() == null) ? 0 : getCompanyaddress().hashCode());
        result = prime * result + ((getCompanylogo() == null) ? 0 : getCompanylogo().hashCode());
        result = prime * result + ((getCompanyqr() == null) ? 0 : getCompanyqr().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLasttime() == null) ? 0 : getLasttime().hashCode());
        result = prime * result + ((getDetailaddress() == null) ? 0 : getDetailaddress().hashCode());
        return result;
    }
}