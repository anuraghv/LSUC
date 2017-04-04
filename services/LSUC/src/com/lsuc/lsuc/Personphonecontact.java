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
 * Personphonecontact generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PERSONPHONECONTACT`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`PERSON_FK`", "`PHONE_PURPOSE_FK`", "`PHONE_TYPE_FK`"})})
public class Personphonecontact implements Serializable {

    private Integer pk;
    private Integer personFk;
    private Integer phonePurposeFk;
    private Character isDisplayedOnDirectory;
    private Character isPreferred;
    private String contactNumber;
    private String extension;
    private Integer phoneTypeFk;
    private Person person;
    private Phonepurpose phonepurpose;
    private Phonetype phonetype;

    @Id
    @Column(name = "`PK`", nullable = false, scale = 0, precision = 10)
    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    @Column(name = "`PERSON_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getPersonFk() {
        return this.personFk;
    }

    public void setPersonFk(Integer personFk) {
        this.personFk = personFk;
    }

    @Column(name = "`PHONE_PURPOSE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getPhonePurposeFk() {
        return this.phonePurposeFk;
    }

    public void setPhonePurposeFk(Integer phonePurposeFk) {
        this.phonePurposeFk = phonePurposeFk;
    }

    @Column(name = "`IS_DISPLAYED_ON_DIRECTORY`", nullable = true, length = 1)
    public Character getIsDisplayedOnDirectory() {
        return this.isDisplayedOnDirectory;
    }

    public void setIsDisplayedOnDirectory(Character isDisplayedOnDirectory) {
        this.isDisplayedOnDirectory = isDisplayedOnDirectory;
    }

    @Column(name = "`IS_PREFERRED`", nullable = true, length = 1)
    public Character getIsPreferred() {
        return this.isPreferred;
    }

    public void setIsPreferred(Character isPreferred) {
        this.isPreferred = isPreferred;
    }

    @Column(name = "`CONTACT_NUMBER`", nullable = true, length = 40)
    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name = "`EXTENSION`", nullable = true, length = 10)
    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Column(name = "`PHONE_TYPE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getPhoneTypeFk() {
        return this.phoneTypeFk;
    }

    public void setPhoneTypeFk(Integer phoneTypeFk) {
        this.phoneTypeFk = phoneTypeFk;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PERSON_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        if(person != null) {
            this.personFk = person.getPk();
        }

        this.person = person;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PHONE_PURPOSE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Phonepurpose getPhonepurpose() {
        return this.phonepurpose;
    }

    public void setPhonepurpose(Phonepurpose phonepurpose) {
        if(phonepurpose != null) {
            this.phonePurposeFk = phonepurpose.getPk();
        }

        this.phonepurpose = phonepurpose;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PHONE_TYPE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Phonetype getPhonetype() {
        return this.phonetype;
    }

    public void setPhonetype(Phonetype phonetype) {
        if(phonetype != null) {
            this.phoneTypeFk = phonetype.getPk();
        }

        this.phonetype = phonetype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personphonecontact)) return false;
        final Personphonecontact personphonecontact = (Personphonecontact) o;
        return Objects.equals(getPk(), personphonecontact.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

