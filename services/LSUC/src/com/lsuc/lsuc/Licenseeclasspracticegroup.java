/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Licenseeclasspracticegroup generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`LICENSEECLASSPRACTICEGROUP`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`LICENSEE_FK`", "`EFFECTIVE_FROM_DATE`", "`EFFECTIVE_TO_DATE`", "`CLASS_PRACTICE_GROUP_FK`"})})
public class Licenseeclasspracticegroup implements Serializable {

    private Integer pk;
    private Integer licenseeFk;
    private Character isPrimary;
    private Date effectiveFromDate;
    private Date effectiveToDate;
    private Integer classPracticeGroupFk;
    private List<Licenseepracticeineligibilityreason> licenseepracticeineligibilityreasons;
    private Classpraticegroup classpraticegroup;
    private Licensee licensee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "`IS_PRIMARY`", nullable = true, length = 1)
    public Character getIsPrimary() {
        return this.isPrimary;
    }

    public void setIsPrimary(Character isPrimary) {
        this.isPrimary = isPrimary;
    }

    @Column(name = "`EFFECTIVE_FROM_DATE`", nullable = true)
    public Date getEffectiveFromDate() {
        return this.effectiveFromDate;
    }

    public void setEffectiveFromDate(Date effectiveFromDate) {
        this.effectiveFromDate = effectiveFromDate;
    }

    @Column(name = "`EFFECTIVE_TO_DATE`", nullable = true)
    public Date getEffectiveToDate() {
        return this.effectiveToDate;
    }

    public void setEffectiveToDate(Date effectiveToDate) {
        this.effectiveToDate = effectiveToDate;
    }

    @Column(name = "`CLASS_PRACTICE_GROUP_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getClassPracticeGroupFk() {
        return this.classPracticeGroupFk;
    }

    public void setClassPracticeGroupFk(Integer classPracticeGroupFk) {
        this.classPracticeGroupFk = classPracticeGroupFk;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "licenseeclasspracticegroup")
    public List<Licenseepracticeineligibilityreason> getLicenseepracticeineligibilityreasons() {
        return this.licenseepracticeineligibilityreasons;
    }

    public void setLicenseepracticeineligibilityreasons(List<Licenseepracticeineligibilityreason> licenseepracticeineligibilityreasons) {
        this.licenseepracticeineligibilityreasons = licenseepracticeineligibilityreasons;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`CLASS_PRACTICE_GROUP_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Classpraticegroup getClasspraticegroup() {
        return this.classpraticegroup;
    }

    public void setClasspraticegroup(Classpraticegroup classpraticegroup) {
        if(classpraticegroup != null) {
            this.classPracticeGroupFk = classpraticegroup.getPk();
        }

        this.classpraticegroup = classpraticegroup;
    }

    @ManyToOne(fetch = FetchType.EAGER)
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
        if (!(o instanceof Licenseeclasspracticegroup)) return false;
        final Licenseeclasspracticegroup licenseeclasspracticegroup = (Licenseeclasspracticegroup) o;
        return Objects.equals(getPk(), licenseeclasspracticegroup.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

