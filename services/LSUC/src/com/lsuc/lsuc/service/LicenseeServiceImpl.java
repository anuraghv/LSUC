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

import com.lsuc.lsuc.Lawyer;
import com.lsuc.lsuc.Licensee;
import com.lsuc.lsuc.Licenseeclasspracticegroup;
import com.lsuc.lsuc.LicenseeclasspracticegroupApprovals;
import com.lsuc.lsuc.LicenseeclasspracticegroupAud;
import com.lsuc.lsuc.Licenseeinsurance;
import com.lsuc.lsuc.Licenseepersonlanguagepurpose;
import com.lsuc.lsuc.Licenseephotoidcard;
import com.lsuc.lsuc.Paralegal;


/**
 * ServiceImpl object for domain model class Licensee.
 *
 * @see Licensee
 */
@Service("LSUC.LicenseeService")
public class LicenseeServiceImpl implements LicenseeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LicenseeServiceImpl.class);

    @Autowired
	@Qualifier("LSUC.LicenseeclasspracticegroupService")
	private LicenseeclasspracticegroupService licenseeclasspracticegroupService;

    @Autowired
	@Qualifier("LSUC.LawyerService")
	private LawyerService lawyerService;

    @Autowired
	@Qualifier("LSUC.LicenseeinsuranceService")
	private LicenseeinsuranceService licenseeinsuranceService;

    @Autowired
	@Qualifier("LSUC.LicenseeclasspracticegroupAudService")
	private LicenseeclasspracticegroupAudService licenseeclasspracticegroupAudService;

    @Autowired
	@Qualifier("LSUC.LicenseepersonlanguagepurposeService")
	private LicenseepersonlanguagepurposeService licenseepersonlanguagepurposeService;

    @Autowired
	@Qualifier("LSUC.LicenseeclasspracticegroupApprovalsService")
	private LicenseeclasspracticegroupApprovalsService licenseeclasspracticegroupApprovalsService;

    @Autowired
	@Qualifier("LSUC.LicenseephotoidcardService")
	private LicenseephotoidcardService licenseephotoidcardService;

    @Autowired
	@Qualifier("LSUC.ParalegalService")
	private ParalegalService paralegalService;

    @Autowired
    @Qualifier("LSUC.LicenseeDao")
    private WMGenericDao<Licensee, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Licensee, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "LSUCTransactionManager")
    @Override
	public Licensee create(Licensee licensee) {
        LOGGER.debug("Creating a new Licensee with information: {}", licensee);
        Licensee licenseeCreated = this.wmGenericDao.create(licensee);
        if(licenseeCreated.getLicenseeclasspracticegroupApprovalses() != null) {
            for(LicenseeclasspracticegroupApprovals licenseeclasspracticegroupApprovalse : licenseeCreated.getLicenseeclasspracticegroupApprovalses()) {
                licenseeclasspracticegroupApprovalse.setLicensee(licenseeCreated);
                LOGGER.debug("Creating a new child LicenseeclasspracticegroupApprovals with information: {}", licenseeclasspracticegroupApprovalse);
                licenseeclasspracticegroupApprovalsService.create(licenseeclasspracticegroupApprovalse);
            }
        }

        if(licenseeCreated.getLicenseephotoidcardsForLicenseeFkCertified() != null) {
            for(Licenseephotoidcard licenseephotoidcardsForLicenseeFkCertified : licenseeCreated.getLicenseephotoidcardsForLicenseeFkCertified()) {
                licenseephotoidcardsForLicenseeFkCertified.setLicenseeByLicenseeFkCertified(licenseeCreated);
                LOGGER.debug("Creating a new child Licenseephotoidcard with information: {}", licenseephotoidcardsForLicenseeFkCertified);
                licenseephotoidcardService.create(licenseephotoidcardsForLicenseeFkCertified);
            }
        }

        if(licenseeCreated.getLicenseephotoidcardsForLicenseeFk() != null) {
            for(Licenseephotoidcard licenseephotoidcardsForLicenseeFk : licenseeCreated.getLicenseephotoidcardsForLicenseeFk()) {
                licenseephotoidcardsForLicenseeFk.setLicenseeByLicenseeFk(licenseeCreated);
                LOGGER.debug("Creating a new child Licenseephotoidcard with information: {}", licenseephotoidcardsForLicenseeFk);
                licenseephotoidcardService.create(licenseephotoidcardsForLicenseeFk);
            }
        }

        if(licenseeCreated.getParalegal() != null) {
            Paralegal paralegal = licenseeCreated.getParalegal();
            LOGGER.debug("Creating a new child Paralegal with information: {}", paralegal);
            paralegal.setLicensee(licenseeCreated);
            paralegalService.create(paralegal);
        }

        if(licenseeCreated.getLicenseepersonlanguagepurposes() != null) {
            for(Licenseepersonlanguagepurpose licenseepersonlanguagepurpose : licenseeCreated.getLicenseepersonlanguagepurposes()) {
                licenseepersonlanguagepurpose.setLicensee(licenseeCreated);
                LOGGER.debug("Creating a new child Licenseepersonlanguagepurpose with information: {}", licenseepersonlanguagepurpose);
                licenseepersonlanguagepurposeService.create(licenseepersonlanguagepurpose);
            }
        }

        if(licenseeCreated.getLicenseeinsurances() != null) {
            for(Licenseeinsurance licenseeinsurance : licenseeCreated.getLicenseeinsurances()) {
                licenseeinsurance.setLicensee(licenseeCreated);
                LOGGER.debug("Creating a new child Licenseeinsurance with information: {}", licenseeinsurance);
                licenseeinsuranceService.create(licenseeinsurance);
            }
        }

        if(licenseeCreated.getLawyer() != null) {
            Lawyer lawyer = licenseeCreated.getLawyer();
            LOGGER.debug("Creating a new child Lawyer with information: {}", lawyer);
            lawyer.setLicensee(licenseeCreated);
            lawyerService.create(lawyer);
        }

        if(licenseeCreated.getLicenseeclasspracticegroups() != null) {
            for(Licenseeclasspracticegroup licenseeclasspracticegroup : licenseeCreated.getLicenseeclasspracticegroups()) {
                licenseeclasspracticegroup.setLicensee(licenseeCreated);
                LOGGER.debug("Creating a new child Licenseeclasspracticegroup with information: {}", licenseeclasspracticegroup);
                licenseeclasspracticegroupService.create(licenseeclasspracticegroup);
            }
        }

        if(licenseeCreated.getLicenseeclasspracticegroupAuds() != null) {
            for(LicenseeclasspracticegroupAud licenseeclasspracticegroupAud : licenseeCreated.getLicenseeclasspracticegroupAuds()) {
                licenseeclasspracticegroupAud.setLicensee(licenseeCreated);
                LOGGER.debug("Creating a new child LicenseeclasspracticegroupAud with information: {}", licenseeclasspracticegroupAud);
                licenseeclasspracticegroupAudService.create(licenseeclasspracticegroupAud);
            }
        }
        return licenseeCreated;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Licensee getById(Integer licenseeId) throws EntityNotFoundException {
        LOGGER.debug("Finding Licensee by id: {}", licenseeId);
        Licensee licensee = this.wmGenericDao.findById(licenseeId);
        if (licensee == null){
            LOGGER.debug("No Licensee found with id: {}", licenseeId);
            throw new EntityNotFoundException(String.valueOf(licenseeId));
        }
        return licensee;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Licensee findById(Integer licenseeId) {
        LOGGER.debug("Finding Licensee by id: {}", licenseeId);
        return this.wmGenericDao.findById(licenseeId);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Licensee getByLicenseeNumber(String licenseeNumber) {
        Map<String, Object> licenseeNumberMap = new HashMap<>();
        licenseeNumberMap.put("licenseeNumber", licenseeNumber);

        LOGGER.debug("Finding Licensee by unique keys: {}", licenseeNumberMap);
        Licensee licensee = this.wmGenericDao.findByUniqueKey(licenseeNumberMap);

        if (licensee == null){
            LOGGER.debug("No Licensee found with given unique key values: {}", licenseeNumberMap);
            throw new EntityNotFoundException(String.valueOf(licenseeNumberMap));
        }

        return licensee;
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Licensee getByPersonFkAndLicenceTypeFk(Integer personFk, Integer licenceTypeFk) {
        Map<String, Object> personFkAndLicenceTypeFkMap = new HashMap<>();
        personFkAndLicenceTypeFkMap.put("personFk", personFk);
        personFkAndLicenceTypeFkMap.put("licenceTypeFk", licenceTypeFk);

        LOGGER.debug("Finding Licensee by unique keys: {}", personFkAndLicenceTypeFkMap);
        Licensee licensee = this.wmGenericDao.findByUniqueKey(personFkAndLicenceTypeFkMap);

        if (licensee == null){
            LOGGER.debug("No Licensee found with given unique key values: {}", personFkAndLicenceTypeFkMap);
            throw new EntityNotFoundException(String.valueOf(personFkAndLicenceTypeFkMap));
        }

        return licensee;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "LSUCTransactionManager")
	@Override
	public Licensee update(Licensee licensee) throws EntityNotFoundException {
        LOGGER.debug("Updating Licensee with information: {}", licensee);
        this.wmGenericDao.update(licensee);

        Integer licenseeId = licensee.getPk();

        return this.wmGenericDao.findById(licenseeId);
    }

    @Transactional(value = "LSUCTransactionManager")
	@Override
	public Licensee delete(Integer licenseeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Licensee with id: {}", licenseeId);
        Licensee deleted = this.wmGenericDao.findById(licenseeId);
        if (deleted == null) {
            LOGGER.debug("No Licensee found with id: {}", licenseeId);
            throw new EntityNotFoundException(String.valueOf(licenseeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "LSUCTransactionManager")
	@Override
	public Page<Licensee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Licensees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licensee> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Licensees");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service LSUC for table Licensee to {} format", exportType);
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
    public Page<LicenseeclasspracticegroupApprovals> findAssociatedLicenseeclasspracticegroupApprovalses(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseeclasspracticegroupApprovalses");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("licensee.pk = '" + pk + "'");

        return licenseeclasspracticegroupApprovalsService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licenseephotoidcard> findAssociatedLicenseephotoidcardsForLicenseeFkCertified(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseephotoidcardsForLicenseeFkCertified");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("licenseeByLicenseeFkCertified.pk = '" + pk + "'");

        return licenseephotoidcardService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licenseephotoidcard> findAssociatedLicenseephotoidcardsForLicenseeFk(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseephotoidcardsForLicenseeFk");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("licenseeByLicenseeFk.pk = '" + pk + "'");

        return licenseephotoidcardService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licenseepersonlanguagepurpose> findAssociatedLicenseepersonlanguagepurposes(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseepersonlanguagepurposes");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("licensee.pk = '" + pk + "'");

        return licenseepersonlanguagepurposeService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licenseeinsurance> findAssociatedLicenseeinsurances(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseeinsurances");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("licensee.pk = '" + pk + "'");

        return licenseeinsuranceService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<Licenseeclasspracticegroup> findAssociatedLicenseeclasspracticegroups(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseeclasspracticegroups");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("licensee.pk = '" + pk + "'");

        return licenseeclasspracticegroupService.findAll(queryBuilder.toString(), pageable);
    }

    @Transactional(readOnly = true, value = "LSUCTransactionManager")
    @Override
    public Page<LicenseeclasspracticegroupAud> findAssociatedLicenseeclasspracticegroupAuds(Integer pk, Pageable pageable) {
        LOGGER.debug("Fetching all associated licenseeclasspracticegroupAuds");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("licensee.pk = '" + pk + "'");

        return licenseeclasspracticegroupAudService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseeclasspracticegroupService instance
	 */
	protected void setLicenseeclasspracticegroupService(LicenseeclasspracticegroupService service) {
        this.licenseeclasspracticegroupService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LawyerService instance
	 */
	protected void setLawyerService(LawyerService service) {
        this.lawyerService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseeinsuranceService instance
	 */
	protected void setLicenseeinsuranceService(LicenseeinsuranceService service) {
        this.licenseeinsuranceService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseeclasspracticegroupAudService instance
	 */
	protected void setLicenseeclasspracticegroupAudService(LicenseeclasspracticegroupAudService service) {
        this.licenseeclasspracticegroupAudService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseepersonlanguagepurposeService instance
	 */
	protected void setLicenseepersonlanguagepurposeService(LicenseepersonlanguagepurposeService service) {
        this.licenseepersonlanguagepurposeService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseeclasspracticegroupApprovalsService instance
	 */
	protected void setLicenseeclasspracticegroupApprovalsService(LicenseeclasspracticegroupApprovalsService service) {
        this.licenseeclasspracticegroupApprovalsService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseephotoidcardService instance
	 */
	protected void setLicenseephotoidcardService(LicenseephotoidcardService service) {
        this.licenseephotoidcardService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ParalegalService instance
	 */
	protected void setParalegalService(ParalegalService service) {
        this.paralegalService = service;
    }

}

