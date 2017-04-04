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

import com.lsuc.lsuc.Feecategory;
import com.lsuc.lsuc.Licensee;


/**
 * ServiceImpl object for domain model class Feecategory.
 *
 * @see Feecategory
 */
@Service("LSUC.FeecategoryService")
public class FeecategoryServiceImpl implements FeecategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeecategoryServiceImpl.class);

    @Autowired
	@Qualifier("LSUC.LicenseeService")
	private LicenseeService licenseeService;

    @Autowired
    @Qualifier("LSUC.FeecategoryDao")
    private WMGenericDao<Feecategory, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Feecategory, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Feecategory create(Feecategory feecategory) {
        LOGGER.debug("Creating a new Feecategory with information: {}", feecategory);
        Feecategory feecategoryCreated = this.wmGenericDao.create(feecategory);
        if(feecategoryCreated.getLicensees() != null) {
            for(Licensee licensee : feecategoryCreated.getLicensees()) {
                licensee.setFeecategory(feecategoryCreated);
                LOGGER.debug("Creating a new child Licensee with information: {}", licensee);
                licenseeService.create(licensee);
            }
        }
        return feecategoryCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Feecategory getById(Integer feecategoryId) throws EntityNotFoundException {
        LOGGER.debug("Finding Feecategory by id: {}", feecategoryId);
        Feecategory feecategory = this.wmGenericDao.findById(feecategoryId);
        if (feecategory == null){
            LOGGER.debug("No Feecategory found with id: {}", feecategoryId);
            throw new EntityNotFoundException(String.valueOf(feecategoryId));
        }
        return feecategory;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Feecategory findById(Integer feecategoryId) {
        LOGGER.debug("Finding Feecategory by id: {}", feecategoryId);
        return this.wmGenericDao.findById(feecategoryId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Feecategory getByCode(String code) {
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", code);

        LOGGER.debug("Finding Feecategory by unique keys: {}", codeMap);
        Feecategory feecategory = this.wmGenericDao.findByUniqueKey(codeMap);

        if (feecategory == null){
            LOGGER.debug("No Feecategory found with given unique key values: {}", codeMap);
            throw new EntityNotFoundException(String.valueOf(codeMap));
        }

        return feecategory;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Feecategory update(Feecategory feecategory) throws EntityNotFoundException {
        LOGGER.debug("Updating Feecategory with information: {}", feecategory);
        this.wmGenericDao.update(feecategory);

        Integer feecategoryId = feecategory.getPk();

        return this.wmGenericDao.findById(feecategoryId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Feecategory delete(Integer feecategoryId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Feecategory with id: {}", feecategoryId);
        Feecategory deleted = this.wmGenericDao.findById(feecategoryId);
        if (deleted == null) {
            LOGGER.debug("No Feecategory found with id: {}", feecategoryId);
            throw new EntityNotFoundException(String.valueOf(feecategoryId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Feecategory> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Feecategories");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Feecategory> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Feecategories");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Feecategory to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licensee> findAssociatedLicensees(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licensees");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("feecategory.pk = '" + pk + "'");

        return licenseeService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseeService instance
	 */
	protected void setLicenseeService(LicenseeService service) {
        this.licenseeService = service;
    }

}

