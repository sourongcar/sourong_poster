package com.sourong.reservation.domain;

import java.io.Serializable;
import java.util.Date;

public class ReservationVO implements Serializable {
    private Integer reservationid;

    private Integer userid;

    private String username;

    private String userphone;

    private String reservationresult;

    private Integer disposal;

    private Date registertime;

    private Date changetime;

    private static final long serialVersionUID = 1L;

    public Integer getReservationid() {
        return reservationid;
    }

    public void setReservationid(Integer reservationid) {
        this.reservationid = reservationid;
    }

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

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getReservationresult() {
        return reservationresult;
    }

    public void setReservationresult(String reservationresult) {
        this.reservationresult = reservationresult == null ? null : reservationresult.trim();
    }

    public Integer getDisposal() {
        return disposal;
    }

    public void setDisposal(Integer disposal) {
        this.disposal = disposal;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
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
        sb.append(", reservationid=").append(reservationid);
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", userphone=").append(userphone);
        sb.append(", reservationresult=").append(reservationresult);
        sb.append(", disposal=").append(disposal);
        sb.append(", registertime=").append(registertime);
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
        ReservationVO other = (ReservationVO) that;
        return (this.getReservationid() == null ? other.getReservationid() == null : this.getReservationid().equals(other.getReservationid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserphone() == null ? other.getUserphone() == null : this.getUserphone().equals(other.getUserphone()))
            && (this.getReservationresult() == null ? other.getReservationresult() == null : this.getReservationresult().equals(other.getReservationresult()))
            && (this.getDisposal() == null ? other.getDisposal() == null : this.getDisposal().equals(other.getDisposal()))
            && (this.getRegistertime() == null ? other.getRegistertime() == null : this.getRegistertime().equals(other.getRegistertime()))
            && (this.getChangetime() == null ? other.getChangetime() == null : this.getChangetime().equals(other.getChangetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReservationid() == null) ? 0 : getReservationid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserphone() == null) ? 0 : getUserphone().hashCode());
        result = prime * result + ((getReservationresult() == null) ? 0 : getReservationresult().hashCode());
        result = prime * result + ((getDisposal() == null) ? 0 : getDisposal().hashCode());
        result = prime * result + ((getRegistertime() == null) ? 0 : getRegistertime().hashCode());
        result = prime * result + ((getChangetime() == null) ? 0 : getChangetime().hashCode());
        return result;
    }
}