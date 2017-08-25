package com.sourongindex.consultant.domain;

import java.io.Serializable;
import java.util.Date;

public class ConsultantVO implements Serializable {
    private Integer consultantid;

    private String name;

    private String phone;

    private String company;

    private String consultantpic;

    private String remarks;

    private Integer state;

    private String jobtitle;

    private Date createtime;

    private Date lasttime;

    private static final long serialVersionUID = 1L;

    public Integer getConsultantid() {
        return consultantid;
    }

    public void setConsultantid(Integer consultantid) {
        this.consultantid = consultantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getConsultantpic() {
        return consultantpic;
    }

    public void setConsultantpic(String consultantpic) {
        this.consultantpic = consultantpic == null ? null : consultantpic.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle == null ? null : jobtitle.trim();
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
        sb.append(", consultantid=").append(consultantid);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", company=").append(company);
        sb.append(", consultantpic=").append(consultantpic);
        sb.append(", remarks=").append(remarks);
        sb.append(", state=").append(state);
        sb.append(", jobtitle=").append(jobtitle);
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
        ConsultantVO other = (ConsultantVO) that;
        return (this.getConsultantid() == null ? other.getConsultantid() == null : this.getConsultantid().equals(other.getConsultantid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getConsultantpic() == null ? other.getConsultantpic() == null : this.getConsultantpic().equals(other.getConsultantpic()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getJobtitle() == null ? other.getJobtitle() == null : this.getJobtitle().equals(other.getJobtitle()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLasttime() == null ? other.getLasttime() == null : this.getLasttime().equals(other.getLasttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getConsultantid() == null) ? 0 : getConsultantid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getConsultantpic() == null) ? 0 : getConsultantpic().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getJobtitle() == null) ? 0 : getJobtitle().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLasttime() == null) ? 0 : getLasttime().hashCode());
        return result;
    }
}