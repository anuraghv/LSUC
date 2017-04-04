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

import com.lsuc.lsuc.Mailinglabel;


/**
 * ServiceImpl object for domain model class Mailinglabel.
 *
 * @see Mailinglabel
 */
@Service("LSUC.MailinglabelService")
public class MailinglabelServiceImpl implements MailinglabelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailinglabelServiceImpl.class);


    @Autowired
    @Qualifier("LSUC.MailinglabelDao")
    private WMGenericDao<Mailinglabel, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Mailinglabel, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Mailinglabel create(Mailinglabel mailinglabel) {
        LOGGER.debug("Creating a new Mailinglabel with information: {}", mailinglabel);
        Mailinglabel mailinglabelCreated = this.wmGenericDao.create(mailinglabel);
        return mailinglabelCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Mailinglabel getById(Integer mailinglabelId) throws EntityNotFoundException {
        LOGGER.debug("Finding Mailinglabel by id: {}", mailinglabelId);
        Mailinglabel mailinglabel = this.wmGenericDao.findById(mailinglabelId);
        if (mailinglabel == null){
            LOGGER.debug("No Mailinglabel found with id: {}", mailinglabelId);
            throw new EntityNotFoundException(String.valueOf(mailinglabelId));
        }
        return mailinglabel;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Mailinglabel findById(Integer mailinglabelId) {
        LOGGER.debug("Finding Mailinglabel by id: {}", mailinglabelId);
        return this.wmGenericDao.findById(mailinglabelId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Mailinglabel getByPersonFk(Integer personFk) {
        Map<String, Object> personFkMap = new HashMap<>();
        personFkMap.put("personFk", personFk);

        LOGGER.debug("Finding Mailinglabel by unique keys: {}", personFkMap);
        Mailinglabel mailinglabel = this.wmGenericDao.findByUniqueKey(personFkMap);

        if (mailinglabel == null){
            LOGGER.debug("No Mailinglabel found with given unique key values: {}", personFkMap);
            throw new EntityNotFoundException(String.valueOf(personFkMap));
        }

        return mailinglabel;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Mailinglabel update(Mailinglabel mailinglabel) throws EntityNotFoundException {
        LOGGER.debug("Updating Mailinglabel with information: {}", mailinglabel);
        this.wmGenericDao.update(mailinglabel);

        Integer mailinglabelId = mailinglabel.getPk();

        return this.wmGenericDao.findById(mailinglabelId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Mailinglabel delete(Integer mailinglabelId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Mailinglabel with id: {}", mailinglabelId);
        Mailinglabel deleted = this.wmGenericDao.findById(mailinglabelId);
        if (deleted == null) {
            LOGGER.debug("No Mailinglabel found with id: {}", mailinglabelId);
            throw new EntityNotFoundException(String.valueOf(mailinglabelId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Mailinglabel> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Mailinglabels");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Mailinglabel> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Mailinglabels");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Mailinglabel to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

