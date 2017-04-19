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

import com.lsuc.lsuc.Businessaddress;
import com.lsuc.lsuc.Mailinglabel;
import com.lsuc.lsuc.Organizationalunitaddress;
import com.lsuc.lsuc.Personaddress;
import com.lsuc.lsuc.Province;


/**
 * ServiceImpl object for domain model class Province.
 *
 * @see Province
 */
@Service("LSUC.ProvinceService")
public class ProvinceServiceImpl implements ProvinceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProvinceServiceImpl.class);

    @Autowired
	@Qualifier("LSUC.PersonaddressService")
	private PersonaddressService personaddressService;

    @Autowired
	@Qualifier("LSUC.OrganizationalunitaddressService")
	private OrganizationalunitaddressService organizationalunitaddressService;

    @Autowired
	@Qualifier("LSUC.BusinessaddressService")
	private BusinessaddressService businessaddressService;

    @Autowired
	@Qualifier("LSUC.MailinglabelService")
	private MailinglabelService mailinglabelService;

    @Autowired
    @Qualifier("LSUC.ProvinceDao")
    private WMGenericDao<Province, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Province, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Province create(Province province) {
        LOGGER.debug("Creating a new Province with information: {}", province);
        Province provinceCreated = this.wmGenericDao.create(province);
        if(provinceCreated.getMailinglabels() != null) {
            for(Mailinglabel mailinglabel : provinceCreated.getMailinglabels()) {
                mailinglabel.setProvince(provinceCreated);
                LOGGER.debug("Creating a new child Mailinglabel with information: {}", mailinglabel);
                mailinglabelService.create(mailinglabel);
            }
        }

        if(provinceCreated.getBusinessaddresses() != null) {
            for(Businessaddress businessaddresse : provinceCreated.getBusinessaddresses()) {
                businessaddresse.setProvince(provinceCreated);
                LOGGER.debug("Creating a new child Businessaddress with information: {}", businessaddresse);
                businessaddressService.create(businessaddresse);
            }
        }

        if(provinceCreated.getOrganizationalunitaddresses() != null) {
            for(Organizationalunitaddress organizationalunitaddresse : provinceCreated.getOrganizationalunitaddresses()) {
                organizationalunitaddresse.setProvince(provinceCreated);
                LOGGER.debug("Creating a new child Organizationalunitaddress with information: {}", organizationalunitaddresse);
                organizationalunitaddressService.create(organizationalunitaddresse);
            }
        }

        if(provinceCreated.getPersonaddresses() != null) {
            for(Personaddress personaddresse : provinceCreated.getPersonaddresses()) {
                personaddresse.setProvince(provinceCreated);
                LOGGER.debug("Creating a new child Personaddress with information: {}", personaddresse);
                personaddressService.create(personaddresse);
            }
        }
        return provinceCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Province getById(Integer provinceId) throws EntityNotFoundException {
        LOGGER.debug("Finding Province by id: {}", provinceId);
        Province province = this.wmGenericDao.findById(provinceId);
        if (province == null){
            LOGGER.debug("No Province found with id: {}", provinceId);
            throw new EntityNotFoundException(String.valueOf(provinceId));
        }
        return province;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Province findById(Integer provinceId) {
        LOGGER.debug("Finding Province by id: {}", provinceId);
        return this.wmGenericDao.findById(provinceId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Province getByCode(String code) {
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", code);

        LOGGER.debug("Finding Province by unique keys: {}", codeMap);
        Province province = this.wmGenericDao.findByUniqueKey(codeMap);

        if (province == null){
            LOGGER.debug("No Province found with given unique key values: {}", codeMap);
            throw new EntityNotFoundException(String.valueOf(codeMap));
        }

        return province;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Province update(Province province) throws EntityNotFoundException {
        LOGGER.debug("Updating Province with information: {}", province);
        this.wmGenericDao.update(province);

        Integer provinceId = province.getPk();

        return this.wmGenericDao.findById(provinceId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Province delete(Integer provinceId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Province with id: {}", provinceId);
        Province deleted = this.wmGenericDao.findById(provinceId);
        if (deleted == null) {
            LOGGER.debug("No Province found with id: {}", provinceId);
            throw new EntityNotFoundException(String.valueOf(provinceId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Province> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Provinces");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Province> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Provinces");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Province to {} format", exportType);
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

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Mailinglabel> findAssociatedMailinglabels(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated mailinglabels");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("province.pk = '" + pk + "'");

        return mailinglabelService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Businessaddress> findAssociatedBusinessaddresses(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated businessaddresses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("province.pk = '" + pk + "'");

        return businessaddressService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Organizationalunitaddress> findAssociatedOrganizationalunitaddresses(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated organizationalunitaddresses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("province.pk = '" + pk + "'");

        return organizationalunitaddressService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Personaddress> findAssociatedPersonaddresses(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated personaddresses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("province.pk = '" + pk + "'");

        return personaddressService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonaddressService instance
	 */
	protected void setPersonaddressService(PersonaddressService service) {
        this.personaddressService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service OrganizationalunitaddressService instance
	 */
	protected void setOrganizationalunitaddressService(OrganizationalunitaddressService service) {
        this.organizationalunitaddressService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BusinessaddressService instance
	 */
	protected void setBusinessaddressService(BusinessaddressService service) {
        this.businessaddressService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service MailinglabelService instance
	 */
	protected void setMailinglabelService(MailinglabelService service) {
        this.mailinglabelService = service;
    }

}

