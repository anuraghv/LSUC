/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VwLicenseeFilter generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VW_LICENSEE_FILTER`")
public class VwLicenseeFilter implements Serializable {

    private BigInteger rowNum;
    private int personFk;
    private String name;
    private String addressLine1;
    private String licenseeNumber;
    private Integer licenceTypeFk;
    private String city;
    private Integer provinceFk;
    private String postalCode;
    private Integer roleFk;
    private Integer classPk;
    private Integer practiceGroupPk;
    private Licencetype licencetype;
    private Province province;
    private Role role;
    private ClassEntity classEntity;
    private Practicegroup practicegroup;

    @Id
    @Column(name = "`ROW_NUM`", nullable = false, scale = 0, precision = 20)
    public BigInteger getRowNum() {
        return this.rowNum;
    }

    public void setRowNum(BigInteger rowNum) {
        this.rowNum = rowNum;
    }

    @Column(name = "`PERSON_FK`", nullable = false, scale = 0, precision = 10)
    public int getPersonFk() {
        return this.personFk;
    }

    public void setPersonFk(int personFk) {
        this.personFk = personFk;
    }

    @Column(name = "`NAME`", nullable = true, length = 201)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`ADDRESS_LINE_1`", nullable = true, length = 50)
    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name = "`LICENSEE_NUMBER`", nullable = true, length = 20)
    public String getLicenseeNumber() {
        return this.licenseeNumber;
    }

    public void setLicenseeNumber(String licenseeNumber) {
        this.licenseeNumber = licenseeNumber;
    }

    @Column(name = "`LICENCE_TYPE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getLicenceTypeFk() {
        return this.licenceTypeFk;
    }

    public void setLicenceTypeFk(Integer licenceTypeFk) {
        this.licenceTypeFk = licenceTypeFk;
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

    @Column(name = "`ROLE_FK`", nullable = true, scale = 0, precision = 10)
    public Integer getRoleFk() {
        return this.roleFk;
    }

    public void setRoleFk(Integer roleFk) {
        this.roleFk = roleFk;
    }

    @Column(name = "`CLASS_PK`", nullable = true, scale = 0, precision = 10)
    public Integer getClassPk() {
        return this.classPk;
    }

    public void setClassPk(Integer classPk) {
        this.classPk = classPk;
    }

    @Column(name = "`PRACTICE_GROUP_PK`", nullable = true, scale = 0, precision = 10)
    public Integer getPracticeGroupPk() {
        return this.practiceGroupPk;
    }

    public void setPracticeGroupPk(Integer practiceGroupPk) {
        this.practiceGroupPk = practiceGroupPk;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`LICENCE_TYPE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Licencetype getLicencetype() {
        return this.licencetype;
    }

    public void setLicencetype(Licencetype licencetype) {
        if(licencetype != null) {
            this.licenceTypeFk = licencetype.getPk();
        }

        this.licencetype = licencetype;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ROLE_FK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        if(role != null) {
            this.roleFk = role.getPk();
        }

        this.role = role;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`CLASS_PK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public ClassEntity getClassEntity() {
        return this.classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        if(classEntity != null) {
            this.classPk = classEntity.getPk();
        }

        this.classEntity = classEntity;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`PRACTICE_GROUP_PK`", referencedColumnName = "`PK`", insertable = false, updatable = false)
    public Practicegroup getPracticegroup() {
        return this.practicegroup;
    }

    public void setPracticegroup(Practicegroup practicegroup) {
        if(practicegroup != null) {
            this.practiceGroupPk = practicegroup.getPk();
        }

        this.practicegroup = practicegroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VwLicenseeFilter)) return false;
        final VwLicenseeFilter vwLicenseeFilter = (VwLicenseeFilter) o;
        return Objects.equals(getRowNum(), vwLicenseeFilter.getRowNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRowNum());
    }
}
