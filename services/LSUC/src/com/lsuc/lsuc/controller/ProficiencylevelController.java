/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



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
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.lsuc.lsuc.Personlanguagecommunicationchannel;
import com.lsuc.lsuc.Proficiencylevel;
import com.lsuc.lsuc.service.ProficiencylevelService;


/**
 * Controller object for domain model class Proficiencylevel.
 * @see Proficiencylevel
 */
@RestController("LSUC.ProficiencylevelController")
@Api(value = "ProficiencylevelController", description = "Exposes APIs to work with Proficiencylevel resource.")
@RequestMapping("/LSUC/Proficiencylevel")
public class ProficiencylevelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProficiencylevelController.class);

    @Autowired
	@Qualifier("LSUC.ProficiencylevelService")
	private ProficiencylevelService proficiencylevelService;

	@ApiOperation(value = "Creates a new Proficiencylevel instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Proficiencylevel createProficiencylevel(@RequestBody Proficiencylevel proficiencylevel) {
		LOGGER.debug("Create Proficiencylevel with information: {}" , proficiencylevel);

		proficiencylevel = proficiencylevelService.create(proficiencylevel);
		LOGGER.debug("Created Proficiencylevel with information: {}" , proficiencylevel);

	    return proficiencylevel;
	}


    @ApiOperation(value = "Returns the Proficiencylevel instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Proficiencylevel getProficiencylevel(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Proficiencylevel with id: {}" , id);

        Proficiencylevel foundProficiencylevel = proficiencylevelService.getById(id);
        LOGGER.debug("Proficiencylevel details with id: {}" , foundProficiencylevel);

        return foundProficiencylevel;
    }

    @ApiOperation(value = "Updates the Proficiencylevel instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Proficiencylevel editProficiencylevel(@PathVariable("id") Integer id, @RequestBody Proficiencylevel proficiencylevel) throws EntityNotFoundException {
        LOGGER.debug("Editing Proficiencylevel with id: {}" , proficiencylevel.getPk());

        proficiencylevel.setPk(id);
        proficiencylevel = proficiencylevelService.update(proficiencylevel);
        LOGGER.debug("Proficiencylevel details with id: {}" , proficiencylevel);

        return proficiencylevel;
    }

    @ApiOperation(value = "Deletes the Proficiencylevel instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteProficiencylevel(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Proficiencylevel with id: {}" , id);

        Proficiencylevel deletedProficiencylevel = proficiencylevelService.delete(id);

        return deletedProficiencylevel != null;
    }
    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Proficiencylevel with given unique key values.")
    public Proficiencylevel getByCode(@PathVariable("code") String code) {
        LOGGER.debug("Getting Proficiencylevel with uniques key Code");
        return proficiencylevelService.getByCode(code);
    }

    /**
     * @deprecated Use {@link #findProficiencylevels(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Proficiencylevel instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Proficiencylevel> searchProficiencylevelsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Proficiencylevels list");
        return proficiencylevelService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Proficiencylevel instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Proficiencylevel> findProficiencylevels(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Proficiencylevels list");
        return proficiencylevelService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Proficiencylevel instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Proficiencylevel> filterProficiencylevels(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Proficiencylevels list");
        return proficiencylevelService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportProficiencylevels(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return proficiencylevelService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Proficiencylevel instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countProficiencylevels( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Proficiencylevels");
		return proficiencylevelService.count(query);
	}

    @RequestMapping(value="/{id:.+}/personlanguagecommunicationchannels", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personlanguagecommunicationchannels instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personlanguagecommunicationchannel> findAssociatedPersonlanguagecommunicationchannels(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personlanguagecommunicationchannels");
        return proficiencylevelService.findAssociatedPersonlanguagecommunicationchannels(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ProficiencylevelService instance
	 */
	protected void setProficiencylevelService(ProficiencylevelService service) {
		this.proficiencylevelService = service;
	}

}

