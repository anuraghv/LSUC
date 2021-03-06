/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.lsuc.lsuc.Personperson;
import com.lsuc.lsuc.Personrelationshiptype;
import com.lsuc.lsuc.service.PersonrelationshiptypeService;


/**
 * Controller object for domain model class Personrelationshiptype.
 * @see Personrelationshiptype
 */
@RestController("LSUC.PersonrelationshiptypeController")
@Api(value = "PersonrelationshiptypeController", description = "Exposes APIs to work with Personrelationshiptype resource.")
@RequestMapping("/LSUC/Personrelationshiptype")
public class PersonrelationshiptypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonrelationshiptypeController.class);

    @Autowired
	@Qualifier("LSUC.PersonrelationshiptypeService")
	private PersonrelationshiptypeService personrelationshiptypeService;

	@ApiOperation(value = "Creates a new Personrelationshiptype instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Personrelationshiptype createPersonrelationshiptype(@RequestBody Personrelationshiptype personrelationshiptype) {
		LOGGER.debug("Create Personrelationshiptype with information: {}" , personrelationshiptype);

		personrelationshiptype = personrelationshiptypeService.create(personrelationshiptype);
		LOGGER.debug("Created Personrelationshiptype with information: {}" , personrelationshiptype);

	    return personrelationshiptype;
	}


    @ApiOperation(value = "Returns the Personrelationshiptype instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Personrelationshiptype getPersonrelationshiptype(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Personrelationshiptype with id: {}" , id);

        Personrelationshiptype foundPersonrelationshiptype = personrelationshiptypeService.getById(id);
        LOGGER.debug("Personrelationshiptype details with id: {}" , foundPersonrelationshiptype);

        return foundPersonrelationshiptype;
    }

    @ApiOperation(value = "Updates the Personrelationshiptype instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Personrelationshiptype editPersonrelationshiptype(@PathVariable("id") Integer id, @RequestBody Personrelationshiptype personrelationshiptype) throws EntityNotFoundException {
        LOGGER.debug("Editing Personrelationshiptype with id: {}" , personrelationshiptype.getPk());

        personrelationshiptype.setPk(id);
        personrelationshiptype = personrelationshiptypeService.update(personrelationshiptype);
        LOGGER.debug("Personrelationshiptype details with id: {}" , personrelationshiptype);

        return personrelationshiptype;
    }

    @ApiOperation(value = "Deletes the Personrelationshiptype instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePersonrelationshiptype(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Personrelationshiptype with id: {}" , id);

        Personrelationshiptype deletedPersonrelationshiptype = personrelationshiptypeService.delete(id);

        return deletedPersonrelationshiptype != null;
    }

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Personrelationshiptype with given unique key values.")
    public Personrelationshiptype getByCode(@PathVariable("code") String code) {
        LOGGER.debug("Getting Personrelationshiptype with uniques key Code");
        return personrelationshiptypeService.getByCode(code);
    }

    /**
     * @deprecated Use {@link #findPersonrelationshiptypes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Personrelationshiptype instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personrelationshiptype> searchPersonrelationshiptypesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Personrelationshiptypes list");
        return personrelationshiptypeService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Personrelationshiptype instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personrelationshiptype> findPersonrelationshiptypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Personrelationshiptypes list");
        return personrelationshiptypeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Personrelationshiptype instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personrelationshiptype> filterPersonrelationshiptypes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Personrelationshiptypes list");
        return personrelationshiptypeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPersonrelationshiptypes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return personrelationshiptypeService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Personrelationshiptype instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPersonrelationshiptypes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Personrelationshiptypes");
		return personrelationshiptypeService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPersonrelationshiptypeAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return personrelationshiptypeService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/personpersons", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personpersons instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personperson> findAssociatedPersonpersons(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personpersons");
        return personrelationshiptypeService.findAssociatedPersonpersons(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonrelationshiptypeService instance
	 */
	protected void setPersonrelationshiptypeService(PersonrelationshiptypeService service) {
		this.personrelationshiptypeService = service;
	}

}

