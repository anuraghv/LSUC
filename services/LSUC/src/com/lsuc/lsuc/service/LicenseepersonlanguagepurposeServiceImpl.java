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

import com.lsuc.lsuc.Licenseepersonlanguagepurpose;


/**
 * ServiceImpl object for domain model class Licenseepersonlanguagepurpose.
 *
 * @see Licenseepersonlanguagepurpose
 */
@Service("LSUC.LicenseepersonlanguagepurposeService")
public class LicenseepersonlanguagepurposeServiceImpl implements LicenseepersonlanguagepurposeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LicenseepersonlanguagepurposeServiceImpl.class);


    @Autowired
    @Qualifier("LSUC.LicenseepersonlanguagepurposeDao")
    private WMGenericDao<Licenseepersonlanguagepurpose, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Licenseepersonlanguagepurpose, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Licenseepersonlanguagepurpose create(Licenseepersonlanguagepurpose licenseepersonlanguagepurpose) {
        LOGGER.debug("Creating a new Licenseepersonlanguagepurpose with information: {}", licenseepersonlanguagepurpose);
        Licenseepersonlanguagepurpose licenseepersonlanguagepurposeCreated = this.wmGenericDao.create(licenseepersonlanguagepurpose);
        return licenseepersonlanguagepurposeCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Licenseepersonlanguagepurpose getById(Integer licenseepersonlanguagepurposeId) throws EntityNotFoundException {
        LOGGER.debug("Finding Licenseepersonlanguagepurpose by id: {}", licenseepersonlanguagepurposeId);
        Licenseepersonlanguagepurpose licenseepersonlanguagepurpose = this.wmGenericDao.findById(licenseepersonlanguagepurposeId);
        if (licenseepersonlanguagepurpose == null){
            LOGGER.debug("No Licenseepersonlanguagepurpose found with id: {}", licenseepersonlanguagepurposeId);
            throw new EntityNotFoundException(String.valueOf(licenseepersonlanguagepurposeId));
        }
        return licenseepersonlanguagepurpose;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Licenseepersonlanguagepurpose findById(Integer licenseepersonlanguagepurposeId) {
        LOGGER.debug("Finding Licenseepersonlanguagepurpose by id: {}", licenseepersonlanguagepurposeId);
        return this.wmGenericDao.findById(licenseepersonlanguagepurposeId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Licenseepersonlanguagepurpose getByLicenseeFkAndPersonLanguageFkAndLanguagePurposeFk(Integer licenseeFk, Integer personLanguageFk, Integer languagePurposeFk) {
        Map<String, Object> licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap = new HashMap<>();
        licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap.put("licenseeFk", licenseeFk);
        licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap.put("personLanguageFk", personLanguageFk);
        licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap.put("languagePurposeFk", languagePurposeFk);

        LOGGER.debug("Finding Licenseepersonlanguagepurpose by unique keys: {}", licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap);
        Licenseepersonlanguagepurpose licenseepersonlanguagepurpose = this.wmGenericDao.findByUniqueKey(licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap);

        if (licenseepersonlanguagepurpose == null){
            LOGGER.debug("No Licenseepersonlanguagepurpose found with given unique key values: {}", licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap);
            throw new EntityNotFoundException(String.valueOf(licenseeFkAndPersonLanguageFkAndLanguagePurposeFkMap));
        }

        return licenseepersonlanguagepurpose;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Licenseepersonlanguagepurpose update(Licenseepersonlanguagepurpose licenseepersonlanguagepurpose) throws EntityNotFoundException {
        LOGGER.debug("Updating Licenseepersonlanguagepurpose with information: {}", licenseepersonlanguagepurpose);
        this.wmGenericDao.update(licenseepersonlanguagepurpose);

        Integer licenseepersonlanguagepurposeId = licenseepersonlanguagepurpose.getPk();

        return this.wmGenericDao.findById(licenseepersonlanguagepurposeId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Licenseepersonlanguagepurpose delete(Integer licenseepersonlanguagepurposeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Licenseepersonlanguagepurpose with id: {}", licenseepersonlanguagepurposeId);
        Licenseepersonlanguagepurpose deleted = this.wmGenericDao.findById(licenseepersonlanguagepurposeId);
        if (deleted == null) {
            LOGGER.debug("No Licenseepersonlanguagepurpose found with id: {}", licenseepersonlanguagepurposeId);
            throw new EntityNotFoundException(String.valueOf(licenseepersonlanguagepurposeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Licenseepersonlanguagepurpose> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Licenseepersonlanguagepurposes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licenseepersonlanguagepurpose> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Licenseepersonlanguagepurposes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Licenseepersonlanguagepurpose to {} format", exportType);
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

