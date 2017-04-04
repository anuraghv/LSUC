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

import com.lsuc.lsuc.Person;
import com.lsuc.lsuc.Suffix;


/**
 * ServiceImpl object for domain model class Suffix.
 *
 * @see Suffix
 */
@Service("LSUC.SuffixService")
public class SuffixServiceImpl implements SuffixService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuffixServiceImpl.class);

    @Autowired
	@Qualifier("LSUC.PersonService")
	private PersonService personService;

    @Autowired
    @Qualifier("LSUC.SuffixDao")
    private WMGenericDao<Suffix, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Suffix, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Suffix create(Suffix suffix) {
        LOGGER.debug("Creating a new Suffix with information: {}", suffix);
        Suffix suffixCreated = this.wmGenericDao.create(suffix);
        if(suffixCreated.getPersons() != null) {
            for(Person person : suffixCreated.getPersons()) {
                person.setSuffix(suffixCreated);
                LOGGER.debug("Creating a new child Person with information: {}", person);
                personService.create(person);
            }
        }
        return suffixCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Suffix getById(Integer suffixId) throws EntityNotFoundException {
        LOGGER.debug("Finding Suffix by id: {}", suffixId);
        Suffix suffix = this.wmGenericDao.findById(suffixId);
        if (suffix == null){
            LOGGER.debug("No Suffix found with id: {}", suffixId);
            throw new EntityNotFoundException(String.valueOf(suffixId));
        }
        return suffix;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Suffix findById(Integer suffixId) {
        LOGGER.debug("Finding Suffix by id: {}", suffixId);
        return this.wmGenericDao.findById(suffixId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Suffix getByCode(String code) {
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", code);

        LOGGER.debug("Finding Suffix by unique keys: {}", codeMap);
        Suffix suffix = this.wmGenericDao.findByUniqueKey(codeMap);

        if (suffix == null){
            LOGGER.debug("No Suffix found with given unique key values: {}", codeMap);
            throw new EntityNotFoundException(String.valueOf(codeMap));
        }

        return suffix;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Suffix update(Suffix suffix) throws EntityNotFoundException {
        LOGGER.debug("Updating Suffix with information: {}", suffix);
        this.wmGenericDao.update(suffix);

        Integer suffixId = suffix.getPk();

        return this.wmGenericDao.findById(suffixId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Suffix delete(Integer suffixId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Suffix with id: {}", suffixId);
        Suffix deleted = this.wmGenericDao.findById(suffixId);
        if (deleted == null) {
            LOGGER.debug("No Suffix found with id: {}", suffixId);
            throw new EntityNotFoundException(String.valueOf(suffixId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Suffix> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Suffixes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Suffix> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Suffixes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Suffix to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Person> findAssociatedPersons(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated persons");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("suffix.pk = '" + pk + "'");

        return personService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonService instance
	 */
	protected void setPersonService(PersonService service) {
        this.personService = service;
    }

}

