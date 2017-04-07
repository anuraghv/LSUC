/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Lawyer generated by WaveMaker Studio.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "`LAWYER`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`LICENSEE_FK`"})})
public class Lawyer implements Serializable {

    private Integer pk;
    private Integer licenseeFk;
    private Licensee licensee;

    @Id
    @Column(name = "`PK`", nullable = false, scale = 0, precision = 10)
    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @Column(name = "`LICENSEE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getLicenseeFk() {
        return this.licenseeFk;
    }

    public void setLicenseeFk(Integer licenseeFk) {
        this.licenseeFk = licenseeFk;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`LICENSEE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Licensee getLicensee() {
        return this.licensee;
    }

    public void setLicensee(Licensee licensee) {
        if(licensee != null) {
            this.licenseeFk = licensee.getPk();
        }

        this.licensee = licensee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lawyer)) return false;
        final Lawyer lawyer = (Lawyer) o;
        return Objects.equals(getPk(), lawyer.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

