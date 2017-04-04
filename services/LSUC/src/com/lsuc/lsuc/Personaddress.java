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
 * Personaddress generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PERSONADDRESS`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`PERSON_FK`", "`ADDRESSTYPE_FK`"})})
public class Personaddress implements Serializable {

    private Integer pk;
    private Integer personFk;
    private Integer addresstypeFk;
    private Character isDisplayedOnDirectory;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String addressLine6;
    private String city;
    private Integer provinceFk;
    private String postalCode;
    private Integer countryFk;
    private Integer geographicAreaFk;
    private Addresstype addresstype;
    private Country country;
    private Geographicarea geographicarea;
    private Person person;
    private Province province;

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

    @Column(name = "`ADDRESSTYPE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getAddresstypeFk() {
        return this.addresstypeFk;
    }

    public void setAddresstypeFk(Integer addresstypeFk) {
        this.addresstypeFk = addresstypeFk;
    }

    @Column(name = "`IS_DISPLAYED_ON_DIRECTORY`", nullable = true, length = 1)
    public Character getIsDisplayedOnDirectory() {
        return this.isDisplayedOnDirectory;
    }

    public void setIsDisplayedOnDirectory(Character isDisplayedOnDirectory) {
        this.isDisplayedOnDirectory = isDisplayedOnDirectory;
    }

    @Column(name = "`ADDRESS_LINE_1`", nullable = true, length = 50)
    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name = "`ADDRESS_LINE_2`", nullable = true, length = 50)
    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(name = "`ADDRESS_LINE_3`", nullable = true, length = 50)
    public String getAddressLine3() {
        return this.addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    @Column(name = "`ADDRESS_LINE_4`", nullable = true, length = 50)
    public String getAddressLine4() {
        return this.addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    @Column(name = "`ADDRESS_LINE_5`", nullable = true, length = 50)
    public String getAddressLine5() {
        return this.addressLine5;
    }

    public void setAddressLine5(String addressLine5) {
        this.addressLine5 = addressLine5;
    }

    @Column(name = "`ADDRESS_LINE_6`", nullable = true, length = 50)
    public String getAddressLine6() {
        return this.addressLine6;
    }

    public void setAddressLine6(String addressLine6) {
        this.addressLine6 = addressLine6;
    }

    @Column(name = "`CITY`", nullable = true, length = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "`PROVINCE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getProvinceFk() {
        return this.provinceFk;
    }

    public void setProvinceFk(Integer provinceFk) {
        this.provinceFk = provinceFk;
    }

    @Column(name = "`POSTAL_CODE`", nullable = true, length = 10)
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "`COUNTRY_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getCountryFk() {
        return this.countryFk;
    }

    public void setCountryFk(Integer countryFk) {
        this.countryFk = countryFk;
    }

    @Column(name = "`GEOGRAPHIC_AREA_FK_`", nullable = true, scale = 0, precision = 10)
    public Integer getGeographicAreaFk() {
        return this.geographicAreaFk;
    }

    public void setGeographicAreaFk(Integer geographicAreaFk) {
        this.geographicAreaFk = geographicAreaFk;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ADDRESSTYPE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Addresstype getAddresstype() {
        return this.addresstype;
    }

    public void setAddresstype(Addresstype addresstype) {
        if(addresstype != null) {
            this.addresstypeFk = addresstype.getPk();
        }

        this.addresstype = addresstype;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`COUNTRY_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        if(country != null) {
            this.countryFk = country.getPk();
        }

        this.country = country;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`GEOGRAPHIC_AREA_FK_`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Geographicarea getGeographicarea() {
        return this.geographicarea;
    }

    public void setGeographicarea(Geographicarea geographicarea) {
        if(geographicarea != null) {
            this.geographicAreaFk = geographicarea.getPk();
        }

        this.geographicarea = geographicarea;
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
    @JoinColumn(name = "`PROVINCE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Province getProvince() {
        return this.province;
    }

    public void setProvince(Province province) {
        if(province != null) {
            this.provinceFk = province.getPk();
        }

        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personaddress)) return false;
        final Personaddress personaddress = (Personaddress) o;
        return Objects.equals(getPk(), personaddress.getPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk());
    }
}

