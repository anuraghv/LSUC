/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LicenseeAud generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`LICENSEE_AUD`")
@IdClass(LicenseeAudId.class)
public class LicenseeAud implements Serializable {

    private Integer pk;
    private Integer rev;
    private Short revtype;
    private Date licenseDate;
    private Revinfo revinfo;

    @Id
    @Column(name = "`PK`", nullable = false, scale = 0, precision = 10)
    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @Id
    @Column(name = "`REV`", nullable = false, scale = 0, precision = 10)
    public Integer getRev() {
        return this.rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    @Column(name = "`REVTYPE`", nullable = true, scale = 0, precision = 5)
    public Short getRevtype() {
        return this.revtype;
    }

    public void setRevtype(Short revtype) {
        this.revtype = revtype;
    }

    @Column(name = "`LICENSE_DATE`", nullable = true)
    public Date getLicenseDate() {
        return this.licenseDate;
    }

    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`REV`", referencedColumnName = "`REV`", insertable = false, updatable = false)
    public Revinfo getRevinfo() {
        return this.revinfo;
    }

    public void setRevinfo(Revinfo revinfo) {
        if(revinfo != null) {
            this.rev = revinfo.getRev();
        }

        this.revinfo = revinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LicenseeAud)) return false;
        final LicenseeAud licenseeAud = (LicenseeAud) o;
        return Objects.equals(getPk(), licenseeAud.getPk()) &&
                Objects.equals(getRev(), licenseeAud.getRev());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(),
                getRev());
    }
}
