/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class LicenseeChangesChartResponse implements Serializable {

    @ColumnAlias("CREATED_BY")
    private String createdBy;
    @ColumnAlias("CHANGES_COUNT")
    private Integer changesCount;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getChangesCount() {
        return this.changesCount;
    }

    public void setChangesCount(Integer changesCount) {
        this.changesCount = changesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LicenseeChangesChartResponse)) return false;
        final LicenseeChangesChartResponse licenseeChangesChartResponse = (LicenseeChangesChartResponse) o;
        return Objects.equals(getCreatedBy(), licenseeChangesChartResponse.getCreatedBy()) &&
                Objects.equals(getChangesCount(), licenseeChangesChartResponse.getChangesCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreatedBy(),
                getChangesCount());
    }
}
