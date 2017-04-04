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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Licenseepersonlanguagepurpose generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`LICENSEEPERSONLANGUAGEPURPOSE`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`LICENSEE_FK`", "`PERSON_LANGUAGE_FK`", "`LANGUAGE_PURPOSE_FK`"})})
public class Licenseepersonlanguagepurpose implements Serializable {

    private Integer pk;
    private Integer licenseeFk;
    private Integer personLanguageFk;
    private Integer languagePurposeFk;
    private Languagepurpose languagepurpose;
    private Licensee licensee;
    private Personlanguage personlanguage;

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

    @Column(name = "`PERSON_LANGUAGE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getPersonLanguageFk() {
        return this.personLanguageFk;
    }

    public void setPersonLanguageFk(Integer personLanguageFk) {
        this.personLanguageFk = personLanguageFk;
    }

    @Column(name = "`LANGUAGE_PURPOSE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getLanguagePurposeFk() {
        return this.languagePurposeFk;
    }

    public void setLanguagePurposeFk(Integer languagePurposeFk) {
        this.languagePurposeFk = languagePurposeFk;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`LANGUAGE_PURPOSE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Languagepurpose getLanguagepurpose() {
        return this.languagepurpose;
    }

    public void setLanguagepurpose(Languagepurpose languagepurpose) {
        if(languagepurpose != null) {
            this.languagePurposeFk = languagepurpose.getPk();
        }

        this.languagepurpose = languagepurpose;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PERSON_LANGUAGE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Personlanguage getPersonlanguage() {
        return this.personlanguage;
    }

    public void setPersonlanguage(Personlanguage personlanguage) {
        if(personlanguage != null) {
            this.personLanguageFk = personlanguage.getPk();
        }

        this.personlanguage = personlanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Licenseepersonlanguagepurpose)) return false;
        final Licenseepersonlanguagepurpose licenseepersonlanguagepurpose = (Licenseepersonlanguagepurpose) o;
        return Objects.equals(getPk(), licenseepersonlanguagepurpose.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

