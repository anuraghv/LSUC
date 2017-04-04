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

import com.lsuc.lsuc.Licenseepersonlanguagepurpose;
import com.lsuc.lsuc.Personlanguage;
import com.lsuc.lsuc.Personlanguagecommunicationchannel;


/**
 * ServiceImpl object for domain model class Personlanguage.
 *
 * @see Personlanguage
 */
@Service("LSUC.PersonlanguageService")
public class PersonlanguageServiceImpl implements PersonlanguageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonlanguageServiceImpl.class);

    @Autowired
	@Qualifier("LSUC.PersonlanguagecommunicationchannelService")
	private PersonlanguagecommunicationchannelService personlanguagecommunicationchannelService;

    @Autowired
	@Qualifier("LSUC.LicenseepersonlanguagepurposeService")
	private LicenseepersonlanguagepurposeService licenseepersonlanguagepurposeService;

    @Autowired
    @Qualifier("LSUC.PersonlanguageDao")
    private WMGenericDao<Personlanguage, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Personlanguage, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Personlanguage create(Personlanguage personlanguage) {
        LOGGER.debug("Creating a new Personlanguage with information: {}", personlanguage);
        Personlanguage personlanguageCreated = this.wmGenericDao.create(personlanguage);
        if(personlanguageCreated.getLicenseepersonlanguagepurposes() != null) {
            for(Licenseepersonlanguagepurpose licenseepersonlanguagepurpose : personlanguageCreated.getLicenseepersonlanguagepurposes()) {
                licenseepersonlanguagepurpose.setPersonlanguage(personlanguageCreated);
                LOGGER.debug("Creating a new child Licenseepersonlanguagepurpose with information: {}", licenseepersonlanguagepurpose);
                licenseepersonlanguagepurposeService.create(licenseepersonlanguagepurpose);
            }
        }

        if(personlanguageCreated.getPersonlanguagecommunicationchannels() != null) {
            for(Personlanguagecommunicationchannel personlanguagecommunicationchannel : personlanguageCreated.getPersonlanguagecommunicationchannels()) {
                personlanguagecommunicationchannel.setPersonlanguage(personlanguageCreated);
                LOGGER.debug("Creating a new child Personlanguagecommunicationchannel with information: {}", personlanguagecommunicationchannel);
                personlanguagecommunicationchannelService.create(personlanguagecommunicationchannel);
            }
        }
        return personlanguageCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Personlanguage getById(Integer personlanguageId) throws EntityNotFoundException {
        LOGGER.debug("Finding Personlanguage by id: {}", personlanguageId);
        Personlanguage personlanguage = this.wmGenericDao.findById(personlanguageId);
        if (personlanguage == null){
            LOGGER.debug("No Personlanguage found with id: {}", personlanguageId);
            throw new EntityNotFoundException(String.valueOf(personlanguageId));
        }
        return personlanguage;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Personlanguage findById(Integer personlanguageId) {
        LOGGER.debug("Finding Personlanguage by id: {}", personlanguageId);
        return this.wmGenericDao.findById(personlanguageId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Personlanguage getByPersonFkAndLanguageFk(Integer personFk, Integer languageFk) {
        Map<String, Object> personFkAndLanguageFkMap = new HashMap<>();
        personFkAndLanguageFkMap.put("personFk", personFk);
        personFkAndLanguageFkMap.put("languageFk", languageFk);

        LOGGER.debug("Finding Personlanguage by unique keys: {}", personFkAndLanguageFkMap);
        Personlanguage personlanguage = this.wmGenericDao.findByUniqueKey(personFkAndLanguageFkMap);

        if (personlanguage == null){
            LOGGER.debug("No Personlanguage found with given unique key values: {}", personFkAndLanguageFkMap);
            throw new EntityNotFoundException(String.valueOf(personFkAndLanguageFkMap));
        }

        return personlanguage;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Personlanguage update(Personlanguage personlanguage) throws EntityNotFoundException {
        LOGGER.debug("Updating Personlanguage with information: {}", personlanguage);
        this.wmGenericDao.update(personlanguage);

        Integer personlanguageId = personlanguage.getPk();

        return this.wmGenericDao.findById(personlanguageId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Personlanguage delete(Integer personlanguageId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Personlanguage with id: {}", personlanguageId);
        Personlanguage deleted = this.wmGenericDao.findById(personlanguageId);
        if (deleted == null) {
            LOGGER.debug("No Personlanguage found with id: {}", personlanguageId);
            throw new EntityNotFoundException(String.valueOf(personlanguageId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Personlanguage> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Personlanguages");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Personlanguage> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Personlanguages");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Personlanguage to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licenseepersonlanguagepurpose> findAssociatedLicenseepersonlanguagepurposes(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseepersonlanguagepurposes");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("personlanguage.pk = '" + pk + "'");

        return licenseepersonlanguagepurposeService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Personlanguagecommunicationchannel> findAssociatedPersonlanguagecommunicationchannels(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated personlanguagecommunicationchannels");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("personlanguage.pk = '" + pk + "'");

        return personlanguagecommunicationchannelService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonlanguagecommunicationchannelService instance
	 */
	protected void setPersonlanguagecommunicationchannelService(PersonlanguagecommunicationchannelService service) {
        this.personlanguagecommunicationchannelService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseepersonlanguagepurposeService instance
	 */
	protected void setLicenseepersonlanguagepurposeService(LicenseepersonlanguagepurposeService service) {
        this.licenseepersonlanguagepurposeService = service;
    }

}

