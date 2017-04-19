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

import com.lsuc.lsuc.Personperson;
import com.lsuc.lsuc.Personrelationshiptype;

/**
 * Service object for domain model class {@link Personrelationshiptype}.
 */
public interface PersonrelationshiptypeService {

    /**
     * Creates a new Personrelationshiptype. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Personrelationshiptype if any.
     *
     * @param personrelationshiptype Details of the Personrelationshiptype to be created; value cannot be null.
     * @return The newly created Personrelationshiptype.
     */
	Personrelationshiptype create(Personrelationshiptype personrelationshiptype);


	/**
	 * Returns Personrelationshiptype by given id if exists.
	 *
	 * @param personrelationshiptypeId The id of the Personrelationshiptype to get; value cannot be null.
	 * @return Personrelationshiptype associated with the given personrelationshiptypeId.
     * @throws EntityNotFoundException If no Personrelationshiptype is found.
	 */
	Personrelationshiptype getById(Integer personrelationshiptypeId) throws EntityNotFoundException;

    /**
	 * Find and return the Personrelationshiptype by given id if exists, returns null otherwise.
	 *
	 * @param personrelationshiptypeId The id of the Personrelationshiptype to get; value cannot be null.
	 * @return Personrelationshiptype associated with the given personrelationshiptypeId.
	 */
	Personrelationshiptype findById(Integer personrelationshiptypeId);

    /**
	 * Find and return the Personrelationshiptype for given code  if exists.
	 *
	 * @param code value of code; value cannot be null.
	 * @return Personrelationshiptype associated with the given inputs.
     * @throws EntityNotFoundException if no matching Personrelationshiptype found.
	 */
    Personrelationshiptype getByCode(String code)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Personrelationshiptype. It replaces all fields of the existing Personrelationshiptype with the given personrelationshiptype.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Personrelationshiptype if any.
     *
	 * @param personrelationshiptype The details of the Personrelationshiptype to be updated; value cannot be null.
	 * @return The updated Personrelationshiptype.
	 * @throws EntityNotFoundException if no Personrelationshiptype is found with given input.
	 */
	Personrelationshiptype update(Personrelationshiptype personrelationshiptype) throws EntityNotFoundException;

    /**
	 * Deletes an existing Personrelationshiptype with the given id.
	 *
	 * @param personrelationshiptypeId The id of the Personrelationshiptype to be deleted; value cannot be null.
	 * @return The deleted Personrelationshiptype.
	 * @throws EntityNotFoundException if no Personrelationshiptype found with the given id.
	 */
	Personrelationshiptype delete(Integer personrelationshiptypeId) throws EntityNotFoundException;

	/**
	 * Find all Personrelationshiptypes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Personrelationshiptypes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Personrelationshiptype> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Personrelationshiptypes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Personrelationshiptypes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Personrelationshiptype> findAll(String query, Pageable pageable);

    /**
	 * Exports all Personrelationshiptypes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Personrelationshiptypes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Personrelationshiptype.
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
     * Returns the associated personpersons for given Personrelationshiptype id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Personperson instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Personperson> findAssociatedPersonpersons(Integer pk, Pageable pageable);

}

