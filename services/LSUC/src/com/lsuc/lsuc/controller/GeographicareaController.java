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

import com.lsuc.lsuc.Businessaddress;
import com.lsuc.lsuc.Geographicarea;
import com.lsuc.lsuc.Licensee;
import com.lsuc.lsuc.Organizationalunitaddress;
import com.lsuc.lsuc.Personaddress;
import com.lsuc.lsuc.service.GeographicareaService;


/**
 * Controller object for domain model class Geographicarea.
 * @see Geographicarea
 */
@RestController("LSUC.GeographicareaController")
@Api(value = "GeographicareaController", description = "Exposes APIs to work with Geographicarea resource.")
@RequestMapping("/LSUC/Geographicarea")
public class GeographicareaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeographicareaController.class);

    @Autowired
	@Qualifier("LSUC.GeographicareaService")
	private GeographicareaService geographicareaService;

	@ApiOperation(value = "Creates a new Geographicarea instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Geographicarea createGeographicarea(@RequestBody Geographicarea geographicarea) {
		LOGGER.debug("Create Geographicarea with information: {}" , geographicarea);

		geographicarea = geographicareaService.create(geographicarea);
		LOGGER.debug("Created Geographicarea with information: {}" , geographicarea);

	    return geographicarea;
	}


    @ApiOperation(value = "Returns the Geographicarea instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Geographicarea getGeographicarea(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Geographicarea with id: {}" , id);

        Geographicarea foundGeographicarea = geographicareaService.getById(id);
        LOGGER.debug("Geographicarea details with id: {}" , foundGeographicarea);

        return foundGeographicarea;
    }

    @ApiOperation(value = "Updates the Geographicarea instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Geographicarea editGeographicarea(@PathVariable("id") Integer id, @RequestBody Geographicarea geographicarea) throws EntityNotFoundException {
        LOGGER.debug("Editing Geographicarea with id: {}" , geographicarea.getPk());

        geographicarea.setPk(id);
        geographicarea = geographicareaService.update(geographicarea);
        LOGGER.debug("Geographicarea details with id: {}" , geographicarea);

        return geographicarea;
    }

    @ApiOperation(value = "Deletes the Geographicarea instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteGeographicarea(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Geographicarea with id: {}" , id);

        Geographicarea deletedGeographicarea = geographicareaService.delete(id);

        return deletedGeographicarea != null;
    }
    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Geographicarea with given unique key values.")
    public Geographicarea getByCode(@PathVariable("code") String code) {
        LOGGER.debug("Getting Geographicarea with uniques key Code");
        return geographicareaService.getByCode(code);
    }

    /**
     * @deprecated Use {@link #findGeographicareas(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Geographicarea instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Geographicarea> searchGeographicareasByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Geographicareas list");
        return geographicareaService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Geographicarea instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Geographicarea> findGeographicareas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Geographicareas list");
        return geographicareaService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Geographicarea instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Geographicarea> filterGeographicareas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Geographicareas list");
        return geographicareaService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportGeographicareas(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return geographicareaService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Geographicarea instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countGeographicareas( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Geographicareas");
		return geographicareaService.count(query);
	}

    @RequestMapping(value="/{id:.+}/licensees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the licensees instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licensee> findAssociatedLicensees(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated licensees");
        return geographicareaService.findAssociatedLicensees(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/businessaddresses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the businessaddresses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Businessaddress> findAssociatedBusinessaddresses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated businessaddresses");
        return geographicareaService.findAssociatedBusinessaddresses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/organizationalunitaddresses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the organizationalunitaddresses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Organizationalunitaddress> findAssociatedOrganizationalunitaddresses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated organizationalunitaddresses");
        return geographicareaService.findAssociatedOrganizationalunitaddresses(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personaddresses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personaddresses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personaddress> findAssociatedPersonaddresses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personaddresses");
        return geographicareaService.findAssociatedPersonaddresses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service GeographicareaService instance
	 */
	protected void setGeographicareaService(GeographicareaService service) {
		this.geographicareaService = service;
	}

}

