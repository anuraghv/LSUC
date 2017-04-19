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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.hibernate.envers.Audited;

/**
 * Person generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PERSON`")
public class Person implements Serializable {

    private Integer pk;
    private String firstName;
    private String lastName;
    private String middleNames;
    private String commonlyReferredToName;
    private String mailingName;
    private Integer prefixFk;
    private Integer suffixFk;
    private Integer genderFk;
    private Date birthDate;
    private List<Licenseephotoidcard> licenseephotoidcardsForPersonFkVerified;
    private List<Licenseephotoidcard> licenseephotoidcardsForPersonFkIssued;
    private List<Personemailcontact> personemailcontacts;
    private Mailinglabel mailinglabel;
    private List<Personphonecontact> personphonecontacts;
    private List<Personsocialmediacontact> personsocialmediacontacts;
    private List<Personperson> personpersonsForPersonFkParent;
    private List<Personperson> personpersonsForPersonFkChild;
    private List<Licensee> licensees;
    private List<User> users;
    private Gender gender;
    private Prefix prefix;
    private Suffix suffix;
    private List<Businessperson> businesspersons;
    private List<Personothername> personothernames;
    private List<Personnameotherlanguage> personnameotherlanguages;
    private List<Personrole> personroles;
    private List<Personlanguage> personlanguages;
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

    @Audited
    @Column(name = "`FIRST_NAME`", nullable = true, length = 100)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Audited
    @Column(name = "`LAST_NAME`", nullable = true, length = 100)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "`MIDDLE_NAMES`", nullable = true, length = 100)
    public String getMiddleNames() {
        return this.middleNames;
    }

    public void setMiddleNames(String middleNames) {
        this.middleNames = middleNames;
    }

    @Audited
    @Column(name = "`COMMONLY_REFERRED_TO_NAME`", nullable = true, length = 100)
    public String getCommonlyReferredToName() {
        return this.commonlyReferredToName;
    }

    public void setCommonlyReferredToName(String commonlyReferredToName) {
        this.commonlyReferredToName = commonlyReferredToName;
    }

    @Audited
    @Column(name = "`MAILING_NAME_`", nullable = true, length = 100)
    public String getMailingName() {
        return this.mailingName;
    }

    public void setMailingName(String mailingName) {
        this.mailingName = mailingName;
    }

    @Column(name = "`PREFIX_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getPrefixFk() {
        return this.prefixFk;
    }

    public void setPrefixFk(Integer prefixFk) {
        this.prefixFk = prefixFk;
    }

    @Column(name = "`SUFFIX_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getSuffixFk() {
        return this.suffixFk;
    }

    public void setSuffixFk(Integer suffixFk) {
        this.suffixFk = suffixFk;
    }

    @Column(name = "`GENDER_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getGenderFk() {
        return this.genderFk;
    }

    public void setGenderFk(Integer genderFk) {
        this.genderFk = genderFk;
    }

    @Column(name = "`BIRTH_DATE`", nullable = true)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "personByPersonFkVerified")
    public List<Licenseephotoidcard> getLicenseephotoidcardsForPersonFkVerified() {
        return this.licenseephotoidcardsForPersonFkVerified;
    }

    public void setLicenseephotoidcardsForPersonFkVerified(List<Licenseephotoidcard> licenseephotoidcardsForPersonFkVerified) {
        this.licenseephotoidcardsForPersonFkVerified = licenseephotoidcardsForPersonFkVerified;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "personByPersonFkIssued")
    public List<Licenseephotoidcard> getLicenseephotoidcardsForPersonFkIssued() {
        return this.licenseephotoidcardsForPersonFkIssued;
    }

    public void setLicenseephotoidcardsForPersonFkIssued(List<Licenseephotoidcard> licenseephotoidcardsForPersonFkIssued) {
        this.licenseephotoidcardsForPersonFkIssued = licenseephotoidcardsForPersonFkIssued;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personemailcontact> getPersonemailcontacts() {
        return this.personemailcontacts;
    }

    public void setPersonemailcontacts(List<Personemailcontact> personemailcontacts) {
        this.personemailcontacts = personemailcontacts;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "person")
    public Mailinglabel getMailinglabel() {
        return this.mailinglabel;
    }

    public void setMailinglabel(Mailinglabel mailinglabel) {
        this.mailinglabel = mailinglabel;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personphonecontact> getPersonphonecontacts() {
        return this.personphonecontacts;
    }

    public void setPersonphonecontacts(List<Personphonecontact> personphonecontacts) {
        this.personphonecontacts = personphonecontacts;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personsocialmediacontact> getPersonsocialmediacontacts() {
        return this.personsocialmediacontacts;
    }

    public void setPersonsocialmediacontacts(List<Personsocialmediacontact> personsocialmediacontacts) {
        this.personsocialmediacontacts = personsocialmediacontacts;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "personByPersonFkParent")
    public List<Personperson> getPersonpersonsForPersonFkParent() {
        return this.personpersonsForPersonFkParent;
    }

    public void setPersonpersonsForPersonFkParent(List<Personperson> personpersonsForPersonFkParent) {
        this.personpersonsForPersonFkParent = personpersonsForPersonFkParent;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "personByPersonFkChild")
    public List<Personperson> getPersonpersonsForPersonFkChild() {
        return this.personpersonsForPersonFkChild;
    }

    public void setPersonpersonsForPersonFkChild(List<Personperson> personpersonsForPersonFkChild) {
        this.personpersonsForPersonFkChild = personpersonsForPersonFkChild;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Licensee> getLicensees() {
        return this.licensees;
    }

    public void setLicensees(List<Licensee> licensees) {
        this.licensees = licensees;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`GENDER_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        if(gender != null) {
            this.genderFk = gender.getPk();
        }

        this.gender = gender;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PREFIX_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Prefix getPrefix() {
        return this.prefix;
    }

    public void setPrefix(Prefix prefix) {
        if(prefix != null) {
            this.prefixFk = prefix.getPk();
        }

        this.prefix = prefix;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SUFFIX_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Suffix getSuffix() {
        return this.suffix;
    }

    public void setSuffix(Suffix suffix) {
        if(suffix != null) {
            this.suffixFk = suffix.getPk();
        }

        this.suffix = suffix;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Businessperson> getBusinesspersons() {
        return this.businesspersons;
    }

    public void setBusinesspersons(List<Businessperson> businesspersons) {
        this.businesspersons = businesspersons;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personothername> getPersonothernames() {
        return this.personothernames;
    }

    public void setPersonothernames(List<Personothername> personothernames) {
        this.personothernames = personothernames;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personnameotherlanguage> getPersonnameotherlanguages() {
        return this.personnameotherlanguages;
    }

    public void setPersonnameotherlanguages(List<Personnameotherlanguage> personnameotherlanguages) {
        this.personnameotherlanguages = personnameotherlanguages;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personrole> getPersonroles() {
        return this.personroles;
    }

    public void setPersonroles(List<Personrole> personroles) {
        this.personroles = personroles;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personlanguage> getPersonlanguages() {
        return this.personlanguages;
    }

    public void setPersonlanguages(List<Personlanguage> personlanguages) {
        this.personlanguages = personlanguages;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "person")
    public List<Personaddress> getPersonaddresses() {
        return this.personaddresses;
    }

    public void setPersonaddresses(List<Personaddress> personaddresses) {
        this.personaddresses = personaddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        final Person person = (Person) o;
        return Objects.equals(getPk(), person.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}