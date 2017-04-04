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

import com.lsuc.lsuc.Organizationalunit;
import com.lsuc.lsuc.Organizationalunitaddress;


/**
 * ServiceImpl object for domain model class Organizationalunit.
 *
 * @see Organizationalunit
 */
@Service("LSUC.OrganizationalunitService")
public class OrganizationalunitServiceImpl implements OrganizationalunitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationalunitServiceImpl.class);

    @Autowired
	@Qualifier("LSUC.OrganizationalunitaddressService")
	private OrganizationalunitaddressService organizationalunitaddressService;

    @Autowired
    @Qualifier("LSUC.OrganizationalunitDao")
    private WMGenericDao<Organizationalunit, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Organizationalunit, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Organizationalunit create(Organizationalunit organizationalunit) {
        LOGGER.debug("Creating a new Organizationalunit with information: {}", organizationalunit);
        Organizationalunit organizationalunitCreated = this.wmGenericDao.create(organizationalunit);
        if(organizationalunitCreated.getOrganizationalunitaddresses() != null) {
            for(Organizationalunitaddress organizationalunitaddresse : organizationalunitCreated.getOrganizationalunitaddresses()) {
                organizationalunitaddresse.setOrganizationalunit(organizationalunitCreated);
                LOGGER.debug("Creating a new child Organizationalunitaddress with information: {}", organizationalunitaddresse);
                organizationalunitaddressService.create(organizationalunitaddresse);
            }
        }
        return organizationalunitCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Organizationalunit getById(Integer organizationalunitId) throws EntityNotFoundException {
        LOGGER.debug("Finding Organizationalunit by id: {}", organizationalunitId);
        Organizationalunit organizationalunit = this.wmGenericDao.findById(organizationalunitId);
        if (organizationalunit == null){
            LOGGER.debug("No Organizationalunit found with id: {}", organizationalunitId);
            throw new EntityNotFoundException(String.valueOf(organizationalunitId));
        }
        return organizationalunit;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Organizationalunit findById(Integer organizationalunitId) {
        LOGGER.debug("Finding Organizationalunit by id: {}", organizationalunitId);
        return this.wmGenericDao.findById(organizationalunitId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Organizationalunit getByBusinessFkAndOrganizationalunitNumber(int businessFk, String organizationalunitNumber) {
        Map<String, Object> businessFkAndOrganizationalunitNumberMap = new HashMap<>();
        businessFkAndOrganizationalunitNumberMap.put("businessFk", businessFk);
        businessFkAndOrganizationalunitNumberMap.put("organizationalunitNumber", organizationalunitNumber);

        LOGGER.debug("Finding Organizationalunit by unique keys: {}", businessFkAndOrganizationalunitNumberMap);
        Organizationalunit organizationalunit = this.wmGenericDao.findByUniqueKey(businessFkAndOrganizationalunitNumberMap);

        if (organizationalunit == null){
            LOGGER.debug("No Organizationalunit found with given unique key values: {}", businessFkAndOrganizationalunitNumberMap);
            throw new EntityNotFoundException(String.valueOf(businessFkAndOrganizationalunitNumberMap));
        }

        return organizationalunit;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Organizationalunit update(Organizationalunit organizationalunit) throws EntityNotFoundException {
        LOGGER.debug("Updating Organizationalunit with information: {}", organizationalunit);
        this.wmGenericDao.update(organizationalunit);

        Integer organizationalunitId = organizationalunit.getPk();

        return this.wmGenericDao.findById(organizationalunitId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Organizationalunit delete(Integer organizationalunitId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Organizationalunit with id: {}", organizationalunitId);
        Organizationalunit deleted = this.wmGenericDao.findById(organizationalunitId);
        if (deleted == null) {
            LOGGER.debug("No Organizationalunit found with id: {}", organizationalunitId);
            throw new EntityNotFoundException(String.valueOf(organizationalunitId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Organizationalunit> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Organizationalunits");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Organizationalunit> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Organizationalunits");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Organizationalunit to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Organizationalunitaddress> findAssociatedOrganizationalunitaddresses(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated organizationalunitaddresses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("organizationalunit.pk = '" + pk + "'");

        return organizationalunitaddressService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OrganizationalunitaddressService instance
	 */
	protected void setOrganizationalunitaddressService(OrganizationalunitaddressService service) {
        this.organizationalunitaddressService = service;
    }

}

