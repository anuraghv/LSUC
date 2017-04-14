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

import com.lsuc.lsuc.LicenseeAud;
import com.lsuc.lsuc.PersonAud;
import com.lsuc.lsuc.Revinfo;
import com.lsuc.lsuc.service.RevinfoService;


/**
 * Controller object for domain model class Revinfo.
 * @see Revinfo
 */
@RestController("LSUC.RevinfoController")
@Api(value = "RevinfoController", description = "Exposes APIs to work with Revinfo resource.")
@RequestMapping("/LSUC/Revinfo")
public class RevinfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RevinfoController.class);

    @Autowired
	@Qualifier("LSUC.RevinfoService")
	private RevinfoService revinfoService;

	@ApiOperation(value = "Creates a new Revinfo instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Revinfo createRevinfo(@RequestBody Revinfo revinfo) {
		LOGGER.debug("Create Revinfo with information: {}" , revinfo);

		revinfo = revinfoService.create(revinfo);
		LOGGER.debug("Created Revinfo with information: {}" , revinfo);

	    return revinfo;
	}


    @ApiOperation(value = "Returns the Revinfo instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Revinfo getRevinfo(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Revinfo with id: {}" , id);

        Revinfo foundRevinfo = revinfoService.getById(id);
        LOGGER.debug("Revinfo details with id: {}" , foundRevinfo);

        return foundRevinfo;
    }

    @ApiOperation(value = "Updates the Revinfo instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Revinfo editRevinfo(@PathVariable("id") Integer id, @RequestBody Revinfo revinfo) throws EntityNotFoundException {
        LOGGER.debug("Editing Revinfo with id: {}" , revinfo.getRev());

        revinfo.setRev(id);
        revinfo = revinfoService.update(revinfo);
        LOGGER.debug("Revinfo details with id: {}" , revinfo);

        return revinfo;
    }

    @ApiOperation(value = "Deletes the Revinfo instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRevinfo(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Revinfo with id: {}" , id);

        Revinfo deletedRevinfo = revinfoService.delete(id);

        return deletedRevinfo != null;
    }

    /**
     * @deprecated Use {@link #findRevinfos(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Revinfo instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Revinfo> searchRevinfosByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Revinfos list");
        return revinfoService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Revinfo instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Revinfo> findRevinfos(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Revinfos list");
        return revinfoService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Revinfo instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Revinfo> filterRevinfos(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Revinfos list");
        return revinfoService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportRevinfos(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return revinfoService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Revinfo instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countRevinfos( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Revinfos");
		return revinfoService.count(query);
	}

    @RequestMapping(value="/{id:.+}/personAuds", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personAuds instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PersonAud> findAssociatedPersonAuds(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personAuds");
        return revinfoService.findAssociatedPersonAuds(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/licenseeAuds", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the licenseeAuds instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LicenseeAud> findAssociatedLicenseeAuds(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated licenseeAuds");
        return revinfoService.findAssociatedLicenseeAuds(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RevinfoService instance
	 */
	protected void setRevinfoService(RevinfoService service) {
		this.revinfoService = service;
	}

}

