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

import com.lsuc.lsuc.Legacyclassstatus;
import com.lsuc.lsuc.Licensee;

/**
 * Service object for domain model class {@link Legacyclassstatus}.
 */
public interface LegacyclassstatusService {

    /**
     * Creates a new Legacyclassstatus. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Legacyclassstatus if any.
     *
     * @param legacyclassstatus Details of the Legacyclassstatus to be created; value cannot be null.
     * @return The newly created Legacyclassstatus.
     */
	Legacyclassstatus create(Legacyclassstatus legacyclassstatus);


	/**
	 * Returns Legacyclassstatus by given id if exists.
	 *
	 * @param legacyclassstatusId The id of the Legacyclassstatus to get; value cannot be null.
	 * @return Legacyclassstatus associated with the given legacyclassstatusId.
     * @throws EntityNotFoundException If no Legacyclassstatus is found.
	 */
	Legacyclassstatus getById(Integer legacyclassstatusId) throws EntityNotFoundException;

    /**
	 * Find and return the Legacyclassstatus by given id if exists, returns null otherwise.
	 *
	 * @param legacyclassstatusId The id of the Legacyclassstatus to get; value cannot be null.
	 * @return Legacyclassstatus associated with the given legacyclassstatusId.
	 */
	Legacyclassstatus findById(Integer legacyclassstatusId);

    /**
	 * Find and return the Legacyclassstatus for given code  if exists.
	 *
	 * @param code value of code; value cannot be null.
	 * @return Legacyclassstatus associated with the given inputs.
     * @throws EntityNotFoundException if no matching Legacyclassstatus found.
	 */
    Legacyclassstatus getByCode(String code)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Legacyclassstatus. It replaces all fields of the existing Legacyclassstatus with the given legacyclassstatus.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Legacyclassstatus if any.
     *
	 * @param legacyclassstatus The details of the Legacyclassstatus to be updated; value cannot be null.
	 * @return The updated Legacyclassstatus.
	 * @throws EntityNotFoundException if no Legacyclassstatus is found with given input.
	 */
	Legacyclassstatus update(Legacyclassstatus legacyclassstatus) throws EntityNotFoundException;

    /**
	 * Deletes an existing Legacyclassstatus with the given id.
	 *
	 * @param legacyclassstatusId The id of the Legacyclassstatus to be deleted; value cannot be null.
	 * @return The deleted Legacyclassstatus.
	 * @throws EntityNotFoundException if no Legacyclassstatus found with the given id.
	 */
	Legacyclassstatus delete(Integer legacyclassstatusId) throws EntityNotFoundException;

	/**
	 * Find all Legacyclassstatuses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Legacyclassstatuses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Legacyclassstatus> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Legacyclassstatuses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Legacyclassstatuses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Legacyclassstatus> findAll(String query, Pageable pageable);

    /**
	 * Exports all Legacyclassstatuses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Legacyclassstatuses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Legacyclassstatus.
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
     * Returns the associated licensees for given Legacyclassstatus id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Licensee instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Licensee> findAssociatedLicensees(Integer pk, Pageable pageable);

}

