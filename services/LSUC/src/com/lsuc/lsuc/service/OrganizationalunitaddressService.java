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

import com.lsuc.lsuc.Organizationalunitaddress;

/**
 * Service object for domain model class {@link Organizationalunitaddress}.
 */
public interface OrganizationalunitaddressService {

    /**
     * Creates a new Organizationalunitaddress. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Organizationalunitaddress if any.
     *
     * @param organizationalunitaddress Details of the Organizationalunitaddress to be created; value cannot be null.
     * @return The newly created Organizationalunitaddress.
     */
	Organizationalunitaddress create(Organizationalunitaddress organizationalunitaddress);


	/**
	 * Returns Organizationalunitaddress by given id if exists.
	 *
	 * @param organizationalunitaddressId The id of the Organizationalunitaddress to get; value cannot be null.
	 * @return Organizationalunitaddress associated with the given organizationalunitaddressId.
     * @throws EntityNotFoundException If no Organizationalunitaddress is found.
	 */
	Organizationalunitaddress getById(Integer organizationalunitaddressId) throws EntityNotFoundException;

    /**
	 * Find and return the Organizationalunitaddress by given id if exists, returns null otherwise.
	 *
	 * @param organizationalunitaddressId The id of the Organizationalunitaddress to get; value cannot be null.
	 * @return Organizationalunitaddress associated with the given organizationalunitaddressId.
	 */
	Organizationalunitaddress findById(Integer organizationalunitaddressId);

    /**
	 * Find and return the Organizationalunitaddress for given organizationalunitFk  andaddressTypeFk  if exists.
	 *
	 * @param organizationalunitFk value of organizationalunitFk; value cannot be null.
	 * @param addressTypeFk value of addressTypeFk; value cannot be null.
	 * @return Organizationalunitaddress associated with the given inputs.
     * @throws EntityNotFoundException if no matching Organizationalunitaddress found.
	 */
    Organizationalunitaddress getByOrganizationalunitFkAndAddressTypeFk(int organizationalunitFk, Integer addressTypeFk)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Organizationalunitaddress. It replaces all fields of the existing Organizationalunitaddress with the given organizationalunitaddress.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Organizationalunitaddress if any.
     *
	 * @param organizationalunitaddress The details of the Organizationalunitaddress to be updated; value cannot be null.
	 * @return The updated Organizationalunitaddress.
	 * @throws EntityNotFoundException if no Organizationalunitaddress is found with given input.
	 */
	Organizationalunitaddress update(Organizationalunitaddress organizationalunitaddress) throws EntityNotFoundException;

    /**
	 * Deletes an existing Organizationalunitaddress with the given id.
	 *
	 * @param organizationalunitaddressId The id of the Organizationalunitaddress to be deleted; value cannot be null.
	 * @return The deleted Organizationalunitaddress.
	 * @throws EntityNotFoundException if no Organizationalunitaddress found with the given id.
	 */
	Organizationalunitaddress delete(Integer organizationalunitaddressId) throws EntityNotFoundException;

	/**
	 * Find all Organizationalunitaddresses matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Organizationalunitaddresses.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Organizationalunitaddress> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Organizationalunitaddresses matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Organizationalunitaddresses.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Organizationalunitaddress> findAll(String query, Pageable pageable);

    /**
	 * Exports all Organizationalunitaddresses matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Organizationalunitaddresses in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Organizationalunitaddress.
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


}

