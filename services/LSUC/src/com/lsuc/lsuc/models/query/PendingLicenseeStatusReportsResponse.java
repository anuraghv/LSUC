/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class PendingLicenseeStatusReportsResponse implements Serializable {

    @ColumnAlias("name")
    private String name;
    @ColumnAlias("licNum")
    private String licNum;
    @ColumnAlias("LicType")
    private String licType;
    @ColumnAlias("LicDate")
    private java.util.Date licDate;
    @ColumnAlias("NewClass")
    private String newClass;
    @ColumnAlias("NewPracticeGroup")
    private String newPracticeGroup;
    @ColumnAlias("New_Effective_from_Date")
    private java.util.Date newEffectiveFromDate;
    @ColumnAlias("New_Effective_to_Date")
    private java.util.Date newEffectiveToDate;
    @ColumnAlias("Old_Effective_From_Date")
    private java.util.Date oldEffectiveFromDate;
    @ColumnAlias("Old_Effective_to_Date")
    private java.util.Date oldEffectiveToDate;
    @ColumnAlias("Created_Date")
    private java.util.Date createdDate;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicNum() {
        return this.licNum;
    }

    public void setLicNum(String licNum) {
        this.licNum = licNum;
    }

    public String getLicType() {
        return this.licType;
    }

    public void setLicType(String licType) {
        this.licType = licType;
    }

    public java.util.Date getLicDate() {
        return this.licDate;
    }

    public void setLicDate(java.util.Date licDate) {
        this.licDate = licDate;
    }

    public String getNewClass() {
        return this.newClass;
    }

    public void setNewClass(String newClass) {
        this.newClass = newClass;
    }

    public String getNewPracticeGroup() {
        return this.newPracticeGroup;
    }

    public void setNewPracticeGroup(String newPracticeGroup) {
        this.newPracticeGroup = newPracticeGroup;
    }

    public java.util.Date getNewEffectiveFromDate() {
        return this.newEffectiveFromDate;
    }

    public void setNewEffectiveFromDate(java.util.Date newEffectiveFromDate) {
        this.newEffectiveFromDate = newEffectiveFromDate;
    }

    public java.util.Date getNewEffectiveToDate() {
        return this.newEffectiveToDate;
    }

    public void setNewEffectiveToDate(java.util.Date newEffectiveToDate) {
        this.newEffectiveToDate = newEffectiveToDate;
    }

    public java.util.Date getOldEffectiveFromDate() {
        return this.oldEffectiveFromDate;
    }

    public void setOldEffectiveFromDate(java.util.Date oldEffectiveFromDate) {
        this.oldEffectiveFromDate = oldEffectiveFromDate;
    }

    public java.util.Date getOldEffectiveToDate() {
        return this.oldEffectiveToDate;
    }

    public void setOldEffectiveToDate(java.util.Date oldEffectiveToDate) {
        this.oldEffectiveToDate = oldEffectiveToDate;
    }

    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PendingLicenseeStatusReportsResponse)) return false;
        final PendingLicenseeStatusReportsResponse pendingLicenseeStatusReportsResponse = (PendingLicenseeStatusReportsResponse) o;
        return Objects.equals(getName(), pendingLicenseeStatusReportsResponse.getName()) &&
                Objects.equals(getLicNum(), pendingLicenseeStatusReportsResponse.getLicNum()) &&
                Objects.equals(getLicType(), pendingLicenseeStatusReportsResponse.getLicType()) &&
                Objects.equals(getLicDate(), pendingLicenseeStatusReportsResponse.getLicDate()) &&
                Objects.equals(getNewClass(), pendingLicenseeStatusReportsResponse.getNewClass()) &&
                Objects.equals(getNewPracticeGroup(), pendingLicenseeStatusReportsResponse.getNewPracticeGroup()) &&
                Objects.equals(getNewEffectiveFromDate(), pendingLicenseeStatusReportsResponse.getNewEffectiveFromDate()) &&
                Objects.equals(getNewEffectiveToDate(), pendingLicenseeStatusReportsResponse.getNewEffectiveToDate()) &&
                Objects.equals(getOldEffectiveFromDate(), pendingLicenseeStatusReportsResponse.getOldEffectiveFromDate()) &&
                Objects.equals(getOldEffectiveToDate(), pendingLicenseeStatusReportsResponse.getOldEffectiveToDate()) &&
                Objects.equals(getCreatedDate(), pendingLicenseeStatusReportsResponse.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),
                getLicNum(),
                getLicType(),
                getLicDate(),
                getNewClass(),
                getNewPracticeGroup(),
                getNewEffectiveFromDate(),
                getNewEffectiveToDate(),
                getOldEffectiveFromDate(),
                getOldEffectiveToDate(),
                getCreatedDate());
    }
}
