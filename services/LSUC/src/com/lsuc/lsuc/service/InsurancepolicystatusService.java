/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.lsuc.lsuc.Insurancepolicystatus;
import com.lsuc.lsuc.Licenseeinsurancepolicy;

/**
 * Service object for domain model class {@link Insurancepolicystatus}.
 */
public interface InsurancepolicystatusService {

    /**
     * Creates a new Insurancepolicystatus. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Insurancepolicystatus if any.
     *
     * @param insurancepolicystatus Details of the Insurancepolicystatus to be created; value cannot be null.
     * @return The newly created Insurancepolicystatus.
     */
	Insurancepolicystatus create(Insurancepolicystatus insurancepolicystatus);


	/**
	 * Returns Insurancepolicystatus by given id if exists.
	 *
	 * @param insurancepolicystatusId The id of the Insurancepolicystatus to get; value cannot be null.
	 * @return Insurancepolicystatus associated with the given insurancepolicystatusId.
     * @throws EntityNotFoundException If no Insurancepolicystatus is found.
	 */
	Insurancepolicystatus getById(Integer insurancepolicystatusId) throws EntityNotFoundException;

    /**
	 * Find and return the Insurancepolicystatus by given id if exists, returns null otherwise.
	 *
	 * @param insurancepolicystatusId The id of the Insurancepolicystatus to get; value cannot be null.
	 * @return Insurancepolicystatus associated with the given insurancepolicystatusId.
	 */
	Insurancepolicystatus findById(Integer insurancepolicystatusId);

    /**
	 * Find and return the Insurancepolicystatus for given code  if exists.
	 *
	 * @param code value of code; value cannot be null.
	 * @return Insurancepolicystatus associated with the given inputs.
     * @throws EntityNotFoundException if no matching Insurancepolicystatus found.
	 */
    Insurancepolicystatus getByCode(String code)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Insurancepolicystatus. It replaces all fields of the existing Insurancepolicystatus with the given insurancepolicystatus.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Insurancepolicystatus if any.
     *
	 * @param insurancepolicystatus The details of the Insurancepolicystatus to be updated; value cannot be null.
	 * @return The updated Insurancepolicystatus.
	 * @throws EntityNotFoundException if no Insurancepolicystatus is found with given input.
	 */
	Insurancepolicystatus update(Insurancepolicystatus insurancepolicystatus) throws EntityNotFoundException;

    /**
	 * Deletes an existing Insurancepolicystatus with the given id.
	 *
	 * @param insurancepolicystatusId The id of the Insurancepolicystatus to be deleted; value cannot be null.
	 * @return The deleted Insurancepolicystatus.
	 * @throws EntityNotFoundException if no Insurancepolicystatus found with the given id.
	 */
	Insurancepolicystatus delete(Integer insurancepolicystatusId) throws EntityNotFoundException;

	/**
	 * Find all Insurancepolicystatuses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Insurancepolicystatuses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Insurancepolicystatus> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Insurancepolicystatuses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Insurancepolicystatuses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Insurancepolicystatus> findAll(String query, Pageable pageable);

    /**
	 * Exports all Insurancepolicystatuses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Insurancepolicystatuses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Insurancepolicystatus.
	 */
	long count(String query);

    /*
     * Returns the associated licenseeinsurancepolicies for given Insurancepolicystatus id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Licenseeinsurancepolicy instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Licenseeinsurancepolicy> findAssociatedLicenseeinsurancepolicies(Integer pk, Pageable pageable);

}

