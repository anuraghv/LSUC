/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

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
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.lsuc.lsuc.Paralegal;


/**
 * ServiceImpl object for domain model class Paralegal.
 *
 * @see Paralegal
 */
@Service("LSUC.ParalegalService")
public class ParalegalServiceImpl implements ParalegalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParalegalServiceImpl.class);


    @Autowired
    @Qualifier("LSUC.ParalegalDao")
    private WMGenericDao<Paralegal, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Paralegal, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Paralegal create(Paralegal paralegal) {
        LOGGER.debug("Creating a new Paralegal with information: {}", paralegal);
        Paralegal paralegalCreated = this.wmGenericDao.create(paralegal);
        return paralegalCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Paralegal getById(Integer paralegalId) throws EntityNotFoundException {
        LOGGER.debug("Finding Paralegal by id: {}", paralegalId);
        Paralegal paralegal = this.wmGenericDao.findById(paralegalId);
        if (paralegal == null){
            LOGGER.debug("No Paralegal found with id: {}", paralegalId);
            throw new EntityNotFoundException(String.valueOf(paralegalId));
        }
        return paralegal;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Paralegal findById(Integer paralegalId) {
        LOGGER.debug("Finding Paralegal by id: {}", paralegalId);
        return this.wmGenericDao.findById(paralegalId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Paralegal getByLicenseeFk(Integer licenseeFk) {
        Map<String, Object> licenseeFkMap = new HashMap<>();
        licenseeFkMap.put("licenseeFk", licenseeFk);

        LOGGER.debug("Finding Paralegal by unique keys: {}", licenseeFkMap);
        Paralegal paralegal = this.wmGenericDao.findByUniqueKey(licenseeFkMap);

        if (paralegal == null){
            LOGGER.debug("No Paralegal found with given unique key values: {}", licenseeFkMap);
            throw new EntityNotFoundException(String.valueOf(licenseeFkMap));
        }

        return paralegal;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Paralegal update(Paralegal paralegal) throws EntityNotFoundException {
        LOGGER.debug("Updating Paralegal with information: {}", paralegal);
        this.wmGenericDao.update(paralegal);

        Integer paralegalId = paralegal.getPk();

        return this.wmGenericDao.findById(paralegalId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Paralegal delete(Integer paralegalId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Paralegal with id: {}", paralegalId);
        Paralegal deleted = this.wmGenericDao.findById(paralegalId);
        if (deleted == null) {
            LOGGER.debug("No Paralegal found with id: {}", paralegalId);
            throw new EntityNotFoundException(String.valueOf(paralegalId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Paralegal> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Paralegals");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Paralegal> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Paralegals");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Paralegal to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

