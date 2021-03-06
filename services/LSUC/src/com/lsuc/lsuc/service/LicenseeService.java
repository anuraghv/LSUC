/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.lsuc.lsuc.Licensee;
import com.lsuc.lsuc.Licenseeclasspracticegroup;
import com.lsuc.lsuc.LicenseeclasspracticegroupApprovals;
import com.lsuc.lsuc.LicenseeclasspracticegroupAud;
import com.lsuc.lsuc.Licenseeinsurance;
import com.lsuc.lsuc.Licenseepersonlanguagepurpose;
import com.lsuc.lsuc.Licenseephotoidcard;

/**
 * Service object for domain model class {@link Licensee}.
 */
public interface LicenseeService {

    /**
     * Creates a new Licensee. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Licensee if any.
     *
     * @param licensee Details of the Licensee to be created; value cannot be null.
     * @return The newly created Licensee.
     */
	Licensee create(Licensee licensee);


	/**
	 * Returns Licensee by given id if exists.
	 *
	 * @param licenseeId The id of the Licensee to get; value cannot be null.
	 * @return Licensee associated with the given licenseeId.
     * @throws EntityNotFoundException If no Licensee is found.
	 */
	Licensee getById(Integer licenseeId) throws EntityNotFoundException;

    /**
	 * Find and return the Licensee by given id if exists, returns null otherwise.
	 *
	 * @param licenseeId The id of the Licensee to get; value cannot be null.
	 * @return Licensee associated with the given licenseeId.
	 */
	Licensee findById(Integer licenseeId);

    /**
	 * Find and return the Licensee for given licenseeNumber  if exists.
	 *
	 * @param licenseeNumber value of licenseeNumber; value cannot be null.
	 * @return Licensee associated with the given inputs.
     * @throws EntityNotFoundException if no matching Licensee found.
	 */
    Licensee getByLicenseeNumber(String licenseeNumber)throws EntityNotFoundException;

    /**
	 * Find and return the Licensee for given personFk  andlicenceTypeFk  if exists.
	 *
	 * @param personFk value of personFk; value cannot be null.
	 * @param licenceTypeFk value of licenceTypeFk; value cannot be null.
	 * @return Licensee associated with the given inputs.
     * @throws EntityNotFoundException if no matching Licensee found.
	 */
    Licensee getByPersonFkAndLicenceTypeFk(Integer personFk, Integer licenceTypeFk)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Licensee. It replaces all fields of the existing Licensee with the given licensee.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Licensee if any.
     *
	 * @param licensee The details of the Licensee to be updated; value cannot be null.
	 * @return The updated Licensee.
	 * @throws EntityNotFoundException if no Licensee is found with given input.
	 */
	Licensee update(Licensee licensee) throws EntityNotFoundException;

    /**
	 * Deletes an existing Licensee with the given id.
	 *
	 * @param licenseeId The id of the Licensee to be deleted; value cannot be null.
	 * @return The deleted Licensee.
	 * @throws EntityNotFoundException if no Licensee found with the given id.
	 */
	Licensee delete(Integer licenseeId) throws EntityNotFoundException;

	/**
	 * Find all Licensees matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Licensees.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Licensee> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Licensees matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Licensees.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Licensee> findAll(String query, Pageable pageable);

    /**
	 * Exports all Licensees matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Licensees in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Licensee.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated licenseeclasspracticegroupApprovalses for given Licensee id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated LicenseeclasspracticegroupApprovals instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<LicenseeclasspracticegroupApprovals> findAssociatedLicenseeclasspracticegroupApprovalses(Integer pk, Pageable pageable);

    /*
     * Returns the associated licenseephotoidcardsForLicenseeFkCertified for given Licensee id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Licenseephotoidcard instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Licenseephotoidcard> findAssociatedLicenseephotoidcardsForLicenseeFkCertified(Integer pk, Pageable pageable);

    /*
     * Returns the associated licenseephotoidcardsForLicenseeFk for given Licensee id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Licenseephotoidcard instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Licenseephotoidcard> findAssociatedLicenseephotoidcardsForLicenseeFk(Integer pk, Pageable pageable);

    /*
     * Returns the associated licenseeclasspracticegroupAuds for given Licensee id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated LicenseeclasspracticegroupAud instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<LicenseeclasspracticegroupAud> findAssociatedLicenseeclasspracticegroupAuds(Integer pk, Pageable pageable);

    /*
     * Returns the associated licenseepersonlanguagepurposes for given Licensee id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Licenseepersonlanguagepurpose instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Licenseepersonlanguagepurpose> findAssociatedLicenseepersonlanguagepurposes(Integer pk, Pageable pageable);

    /*
     * Returns the associated licenseeinsurances for given Licensee id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Licenseeinsurance instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Licenseeinsurance> findAssociatedLicenseeinsurances(Integer pk, Pageable pageable);

    /*
     * Returns the associated licenseeclasspracticegroups for given Licensee id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Licenseeclasspracticegroup instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Licenseeclasspracticegroup> findAssociatedLicenseeclasspracticegroups(Integer pk, Pageable pageable);

}

