/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Addresstype generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ADDRESSTYPE`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`CODE`"})})
public class Addresstype implements Serializable {

    private Integer pk;
    private String code;
    private String shortNameEnglish;
    private String shortNameFrench;
    private String longNameEnglish;
    private String longNameFrench;
    private Character isActive;
    private Character isDefault;
    private Integer displaySequenceEnglish;
    private Integer displaySequenceFrench;
    private List<PersonaddressAud> personaddressAuds;
    private List<Businessaddress> businessaddresses;
    private List<Organizationalunitaddress> organizationalunitaddresses;
    private List<Personaddress> personaddresses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PK`", nullable = false, scale = 0, precision = 10)
    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @Column(name = "`CODE`", nullable = false, length = 10)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "`SHORT_NAME_ENGLISH`", nullable = true, length = 50)
    public String getShortNameEnglish() {
        return this.shortNameEnglish;
    }

    public void setShortNameEnglish(String shortNameEnglish) {
        this.shortNameEnglish = shortNameEnglish;
    }

    @Column(name = "`SHORT_NAME_FRENCH`", nullable = true, length = 50)
    public String getShortNameFrench() {
        return this.shortNameFrench;
    }

    public void setShortNameFrench(String shortNameFrench) {
        this.shortNameFrench = shortNameFrench;
    }

    @Column(name = "`LONG_NAME_ENGLISH`", nullable = true, length = 1000)
    public String getLongNameEnglish() {
        return this.longNameEnglish;
    }

    public void setLongNameEnglish(String longNameEnglish) {
        this.longNameEnglish = longNameEnglish;
    }

    @Column(name = "`LONG_NAME_FRENCH`", nullable = true, length = 1000)
    public String getLongNameFrench() {
        return this.longNameFrench;
    }

    public void setLongNameFrench(String longNameFrench) {
        this.longNameFrench = longNameFrench;
    }

    @Column(name = "`IS_ACTIVE`", nullable = true, length = 1)
    public Character getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @Column(name = "`IS_DEFAULT`", nullable = true, length = 1)
    public Character getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Character isDefault) {
        this.isDefault = isDefault;
    }

    @Column(name = "`DISPLAY_SEQUENCE_ENGLISH`", nullable = true, scale = 0, precision = 10)
    public Integer getDisplaySequenceEnglish() {
        return this.displaySequenceEnglish;
    }

    public void setDisplaySequenceEnglish(Integer displaySequenceEnglish) {
        this.displaySequenceEnglish = displaySequenceEnglish;
    }

    @Column(name = "`DISPLAY_SEQUENCE_FRENCH`", nullable = true, scale = 0, precision = 10)
    public Integer getDisplaySequenceFrench() {
        return this.displaySequenceFrench;
    }

    public void setDisplaySequenceFrench(Integer displaySequenceFrench) {
        this.displaySequenceFrench = displaySequenceFrench;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "addresstype")
    public List<PersonaddressAud> getPersonaddressAuds() {
        return this.personaddressAuds;
    }

    public void setPersonaddressAuds(List<PersonaddressAud> personaddressAuds) {
        this.personaddressAuds = personaddressAuds;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "addresstype")
    public List<Businessaddress> getBusinessaddresses() {
        return this.businessaddresses;
    }

    public void setBusinessaddresses(List<Businessaddress> businessaddresses) {
        this.businessaddresses = businessaddresses;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "addresstype")
    public List<Organizationalunitaddress> getOrganizationalunitaddresses() {
        return this.organizationalunitaddresses;
    }

    public void setOrganizationalunitaddresses(List<Organizationalunitaddress> organizationalunitaddresses) {
        this.organizationalunitaddresses = organizationalunitaddresses;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "addresstype")
    public List<Personaddress> getPersonaddresses() {
        return this.personaddresses;
    }

    public void setPersonaddresses(List<Personaddress> personaddresses) {
        this.personaddresses = personaddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Addresstype)) return false;
        final Addresstype addresstype = (Addresstype) o;
        return Objects.equals(getPk(), addresstype.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

