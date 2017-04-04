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

import com.lsuc.lsuc.Businessaddress;
import com.lsuc.lsuc.Country;
import com.lsuc.lsuc.Mailinglabel;
import com.lsuc.lsuc.Organizationalunitaddress;
import com.lsuc.lsuc.Personaddress;
import com.lsuc.lsuc.Province;

/**
 * Service object for domain model class {@link Country}.
 */
public interface CountryService {

    /**
     * Creates a new Country. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Country if any.
     *
     * @param country Details of the Country to be created; value cannot be null.
     * @return The newly created Country.
     */
	Country create(Country country);


	/**
	 * Returns Country by given id if exists.
	 *
	 * @param countryId The id of the Country to get; value cannot be null.
	 * @return Country associated with the given countryId.
     * @throws EntityNotFoundException If no Country is found.
	 */
	Country getById(Integer countryId) throws EntityNotFoundException;

    /**
	 * Find and return the Country by given id if exists, returns null otherwise.
	 *
	 * @param countryId The id of the Country to get; value cannot be null.
	 * @return Country associated with the given countryId.
	 */
	Country findById(Integer countryId);

    /**
	 * Find and return the Country for given code  if exists.
	 *
	 * @param code value of code; value cannot be null.
	 * @return Country associated with the given inputs.
     * @throws EntityNotFoundException if no matching Country found.
	 */
    Country getByCode(String code)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing Country. It replaces all fields of the existing Country with the given country.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Country if any.
     *
	 * @param country The details of the Country to be updated; value cannot be null.
	 * @return The updated Country.
	 * @throws EntityNotFoundException if no Country is found with given input.
	 */
	Country update(Country country) throws EntityNotFoundException;

    /**
	 * Deletes an existing Country with the given id.
	 *
	 * @param countryId The id of the Country to be deleted; value cannot be null.
	 * @return The deleted Country.
	 * @throws EntityNotFoundException if no Country found with the given id.
	 */
	Country delete(Integer countryId) throws EntityNotFoundException;

	/**
	 * Find all Countries matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Countries.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Country> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Countries matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Countries.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Country> findAll(String query, Pageable pageable);

    /**
	 * Exports all Countries matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Countries in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Country.
	 */
	long count(String query);

    /*
     * Returns the associated mailinglabels for given Country id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Mailinglabel instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Mailinglabel> findAssociatedMailinglabels(Integer pk, Pageable pageable);

    /*
     * Returns the associated provinces for given Country id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Province instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Province> findAssociatedProvinces(Integer pk, Pageable pageable);

    /*
     * Returns the associated businessaddresses for given Country id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Businessaddress instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Businessaddress> findAssociatedBusinessaddresses(Integer pk, Pageable pageable);

    /*
     * Returns the associated organizationalunitaddresses for given Country id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Organizationalunitaddress instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Organizationalunitaddress> findAssociatedOrganizationalunitaddresses(Integer pk, Pageable pageable);

    /*
     * Returns the associated personaddresses for given Country id.
     *
     * @param pk value of pk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Personaddress instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Personaddress> findAssociatedPersonaddresses(Integer pk, Pageable pageable);

}

