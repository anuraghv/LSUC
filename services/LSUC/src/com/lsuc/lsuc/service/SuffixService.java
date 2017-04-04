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

import com.lsuc.lsuc.Person;
import com.lsuc.lsuc.Suffix;

/**
 * Service object for domain model class {@link Suffix}.
 */
public interface SuffixService {

    /**
     * Creates a new Suffix. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Suffix if any.
     *
     * @param suffix Details of the Suffix to be created; value cannot be null.
     * @return The newly created Suffix.
     */
	Suffix create(Suffix suffix);


	/**
	 * Returns Suffix by given id if exists.
	 *
	 * @param suffixId The id of the Suffix to get; value cannot be null.
	 * @return Suffix associated with the given suffixId.
     * @throws EntityNotFoundException If no Suffix is found.
	 */
	Suffix getById(Integer suffixId) throws EntityNotFoundException;

    /**
	 * Find and return the Suffix by given id if exists, returns null otherwise.
	 *
	 * @param suffixId The id of the Suffix to get; value cannot be null.
	 * @return Suffix associated with the given suffixId.
	 */
	Suffix findById(Integer suffixId);

    /**
	 * Find and return the Suffix for given code  if exists.
	 *
	 * @param code value of code; value cannot be null.
	 * @return Suffix associated with the given inputs.
     * @throws EntityNotFoundException if no matching Suffix found.
	 */
    Suffix getByCode(String code)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Suffix. It replaces all fields of the existing Suffix with the given suffix.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Suffix if any.
     *
	 * @param suffix The details of the Suffix to be updated; value cannot be null.
	 * @return The updated Suffix.
	 * @throws EntityNotFoundException if no Suffix is found with given input.
	 */
	Suffix update(Suffix suffix) throws EntityNotFoundException;

    /**
	 * Deletes an existing Suffix with the given id.
	 *
	 * @param suffixId The id of the Suffix to be deleted; value cannot be null.
	 * @return The deleted Suffix.
	 * @throws EntityNotFoundException if no Suffix found with the given id.
	 */
	Suffix delete(Integer suffixId) throws EntityNotFoundException;

	/**
	 * Find all Suffixes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Suffixes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Suffix> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Suffixes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Suffixes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Suffix> findAll(String query, Pageable pageable);

    /**
	 * Exports all Suffixes matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Suffixes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Suffix.
	 */
	long count(String query);

    /*
     * Returns the associated persons for given Suffix id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Person instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Person> findAssociatedPersons(Integer pk, Pageable pageable);

}

