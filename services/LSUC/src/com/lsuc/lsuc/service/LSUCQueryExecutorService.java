/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.lsuc.lsuc.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.lsuc.lsuc.models.query.*;

public interface LSUCQueryExecutorService {

    Integer executeUpdateStatus(UpdateStatusRequest updateStatusRequest);

    Integer executeApproveEditRecord(ApproveEditRecordRequest approveEditRecordRequest);

    Integer executeApprovedNewRecord(ApprovedNewRecordRequest approvedNewRecordRequest);

    Page<GetStatusChangeDetailsResponse> executeGetStatusChangeDetails(Integer personId, Pageable pageable);

    Downloadable exportGetStatusChangeDetails(ExportType exportType, Integer personId, Pageable pageable);

    Page<ExpirationStatusResponse> executeExpirationStatus(Pageable pageable);

    Downloadable exportExpirationStatus(ExportType exportType, Pageable pageable);

}


