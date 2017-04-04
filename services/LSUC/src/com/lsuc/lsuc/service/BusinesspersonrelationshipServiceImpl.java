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
import com.wavemaker.runtime.file.model.Downloadable;

import com.lsuc.lsuc.Businesspersonrelationship;


/**
 * ServiceImpl object for domain model class Businesspersonrelationship.
 *
 * @see Businesspersonrelationship
 */
@Service("LSUC.BusinesspersonrelationshipService")
public class BusinesspersonrelationshipServiceImpl implements BusinesspersonrelationshipService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinesspersonrelationshipServiceImpl.class);


    @Autowired
    @Qualifier("LSUC.BusinesspersonrelationshipDao")
    private WMGenericDao<Businesspersonrelationship, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Businesspersonrelationship, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Businesspersonrelationship create(Businesspersonrelationship businesspersonrelationship) {
        LOGGER.debug("Creating a new Businesspersonrelationship with information: {}", businesspersonrelationship);
        Businesspersonrelationship businesspersonrelationshipCreated = this.wmGenericDao.create(businesspersonrelationship);
        return businesspersonrelationshipCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Businesspersonrelationship getById(Integer businesspersonrelationshipId) throws EntityNotFoundException {
        LOGGER.debug("Finding Businesspersonrelationship by id: {}", businesspersonrelationshipId);
        Businesspersonrelationship businesspersonrelationship = this.wmGenericDao.findById(businesspersonrelationshipId);
        if (businesspersonrelationship == null){
            LOGGER.debug("No Businesspersonrelationship found with id: {}", businesspersonrelationshipId);
            throw new EntityNotFoundException(String.valueOf(businesspersonrelationshipId));
        }
        return businesspersonrelationship;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Businesspersonrelationship findById(Integer businesspersonrelationshipId) {
        LOGGER.debug("Finding Businesspersonrelationship by id: {}", businesspersonrelationshipId);
        return this.wmGenericDao.findById(businesspersonrelationshipId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Businesspersonrelationship getByBusinessPersonFkAndBusinessPersonRelationshipTypeFk(Integer businessPersonFk, Integer businessPersonRelationshipTypeFk) {
        Map<String, Object> businessPersonFkAndBusinessPersonRelationshipTypeFkMap = new HashMap<>();
        businessPersonFkAndBusinessPersonRelationshipTypeFkMap.put("businessPersonFk", businessPersonFk);
        businessPersonFkAndBusinessPersonRelationshipTypeFkMap.put("businessPersonRelationshipTypeFk", businessPersonRelationshipTypeFk);

        LOGGER.debug("Finding Businesspersonrelationship by unique keys: {}", businessPersonFkAndBusinessPersonRelationshipTypeFkMap);
        Businesspersonrelationship businesspersonrelationship = this.wmGenericDao.findByUniqueKey(businessPersonFkAndBusinessPersonRelationshipTypeFkMap);

        if (businesspersonrelationship == null){
            LOGGER.debug("No Businesspersonrelationship found with given unique key values: {}", businessPersonFkAndBusinessPersonRelationshipTypeFkMap);
            throw new EntityNotFoundException(String.valueOf(businessPersonFkAndBusinessPersonRelationshipTypeFkMap));
        }

        return businesspersonrelationship;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Businesspersonrelationship update(Businesspersonrelationship businesspersonrelationship) throws EntityNotFoundException {
        LOGGER.debug("Updating Businesspersonrelationship with information: {}", businesspersonrelationship);
        this.wmGenericDao.update(businesspersonrelationship);

        Integer businesspersonrelationshipId = businesspersonrelationship.getPk();

        return this.wmGenericDao.findById(businesspersonrelationshipId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Businesspersonrelationship delete(Integer businesspersonrelationshipId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Businesspersonrelationship with id: {}", businesspersonrelationshipId);
        Businesspersonrelationship deleted = this.wmGenericDao.findById(businesspersonrelationshipId);
        if (deleted == null) {
            LOGGER.debug("No Businesspersonrelationship found with id: {}", businesspersonrelationshipId);
            throw new EntityNotFoundException(String.valueOf(businesspersonrelationshipId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Businesspersonrelationship> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Businesspersonrelationships");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Businesspersonrelationship> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Businesspersonrelationships");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Businesspersonrelationship to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

