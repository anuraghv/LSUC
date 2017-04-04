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

import com.lsuc.lsuc.Organizationalunitaddress;


/**
 * ServiceImpl object for domain model class Organizationalunitaddress.
 *
 * @see Organizationalunitaddress
 */
@Service("LSUC.OrganizationalunitaddressService")
public class OrganizationalunitaddressServiceImpl implements OrganizationalunitaddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationalunitaddressServiceImpl.class);


    @Autowired
    @Qualifier("LSUC.OrganizationalunitaddressDao")
    private WMGenericDao<Organizationalunitaddress, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Organizationalunitaddress, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Organizationalunitaddress create(Organizationalunitaddress organizationalunitaddress) {
        LOGGER.debug("Creating a new Organizationalunitaddress with information: {}", organizationalunitaddress);
        Organizationalunitaddress organizationalunitaddressCreated = this.wmGenericDao.create(organizationalunitaddress);
        return organizationalunitaddressCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Organizationalunitaddress getById(Integer organizationalunitaddressId) throws EntityNotFoundException {
        LOGGER.debug("Finding Organizationalunitaddress by id: {}", organizationalunitaddressId);
        Organizationalunitaddress organizationalunitaddress = this.wmGenericDao.findById(organizationalunitaddressId);
        if (organizationalunitaddress == null){
            LOGGER.debug("No Organizationalunitaddress found with id: {}", organizationalunitaddressId);
            throw new EntityNotFoundException(String.valueOf(organizationalunitaddressId));
        }
        return organizationalunitaddress;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Organizationalunitaddress findById(Integer organizationalunitaddressId) {
        LOGGER.debug("Finding Organizationalunitaddress by id: {}", organizationalunitaddressId);
        return this.wmGenericDao.findById(organizationalunitaddressId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Organizationalunitaddress getByOrganizationalunitFkAndAddressTypeFk(int organizationalunitFk, Integer addressTypeFk) {
        Map<String, Object> organizationalunitFkAndAddressTypeFkMap = new HashMap<>();
        organizationalunitFkAndAddressTypeFkMap.put("organizationalunitFk", organizationalunitFk);
        organizationalunitFkAndAddressTypeFkMap.put("addressTypeFk", addressTypeFk);

        LOGGER.debug("Finding Organizationalunitaddress by unique keys: {}", organizationalunitFkAndAddressTypeFkMap);
        Organizationalunitaddress organizationalunitaddress = this.wmGenericDao.findByUniqueKey(organizationalunitFkAndAddressTypeFkMap);

        if (organizationalunitaddress == null){
            LOGGER.debug("No Organizationalunitaddress found with given unique key values: {}", organizationalunitFkAndAddressTypeFkMap);
            throw new EntityNotFoundException(String.valueOf(organizationalunitFkAndAddressTypeFkMap));
        }

        return organizationalunitaddress;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Organizationalunitaddress update(Organizationalunitaddress organizationalunitaddress) throws EntityNotFoundException {
        LOGGER.debug("Updating Organizationalunitaddress with information: {}", organizationalunitaddress);
        this.wmGenericDao.update(organizationalunitaddress);

        Integer organizationalunitaddressId = organizationalunitaddress.getPk();

        return this.wmGenericDao.findById(organizationalunitaddressId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Organizationalunitaddress delete(Integer organizationalunitaddressId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Organizationalunitaddress with id: {}", organizationalunitaddressId);
        Organizationalunitaddress deleted = this.wmGenericDao.findById(organizationalunitaddressId);
        if (deleted == null) {
            LOGGER.debug("No Organizationalunitaddress found with id: {}", organizationalunitaddressId);
            throw new EntityNotFoundException(String.valueOf(organizationalunitaddressId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Organizationalunitaddress> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Organizationalunitaddresses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Organizationalunitaddress> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Organizationalunitaddresses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Organizationalunitaddress to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

