/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.lsuc.lsuc.LicenseeAud;
import com.lsuc.lsuc.LicenseeAudId;


/**
 * ServiceImpl object for domain model class LicenseeAud.
 *
 * @see LicenseeAud
 */
@Service("LSUC.LicenseeAudService")
public class LicenseeAudServiceImpl implements LicenseeAudService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LicenseeAudServiceImpl.class);


    @Autowired
    @Qualifier("LSUC.LicenseeAudDao")
    private WMGenericDao<LicenseeAud, LicenseeAudId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<LicenseeAud, LicenseeAudId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public LicenseeAud create(LicenseeAud licenseeAud) {
        LOGGER.debug("Creating a new LicenseeAud with information: {}", licenseeAud);
        LicenseeAud licenseeAudCreated = this.wmGenericDao.create(licenseeAud);
        return licenseeAudCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public LicenseeAud getById(LicenseeAudId licenseeaudId) throws EntityNotFoundException {
        LOGGER.debug("Finding LicenseeAud by id: {}", licenseeaudId);
        LicenseeAud licenseeAud = this.wmGenericDao.findById(licenseeaudId);
        if (licenseeAud == null){
            LOGGER.debug("No LicenseeAud found with id: {}", licenseeaudId);
            throw new EntityNotFoundException(String.valueOf(licenseeaudId));
        }
        return licenseeAud;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public LicenseeAud findById(LicenseeAudId licenseeaudId) {
        LOGGER.debug("Finding LicenseeAud by id: {}", licenseeaudId);
        return this.wmGenericDao.findById(licenseeaudId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public LicenseeAud update(LicenseeAud licenseeAud) throws EntityNotFoundException {
        LOGGER.debug("Updating LicenseeAud with information: {}", licenseeAud);
        this.wmGenericDao.update(licenseeAud);

        LicenseeAudId licenseeaudId = new LicenseeAudId();
        licenseeaudId.setPk(licenseeAud.getPk());
        licenseeaudId.setRev(licenseeAud.getRev());

        return this.wmGenericDao.findById(licenseeaudId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public LicenseeAud delete(LicenseeAudId licenseeaudId) throws EntityNotFoundException {
        LOGGER.debug("Deleting LicenseeAud with id: {}", licenseeaudId);
        LicenseeAud deleted = this.wmGenericDao.findById(licenseeaudId);
        if (deleted == null) {
            LOGGER.debug("No LicenseeAud found with id: {}", licenseeaudId);
            throw new EntityNotFoundException(String.valueOf(licenseeaudId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<LicenseeAud> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all LicenseeAuds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<LicenseeAud> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all LicenseeAuds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table LicenseeAud to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

