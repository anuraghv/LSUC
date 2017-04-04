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

import com.lsuc.lsuc.Personrole;
import com.lsuc.lsuc.service.PersonroleService;


/**
 * Controller object for domain model class Personrole.
 * @see Personrole
 */
@RestController("LSUC.PersonroleController")
@Api(value = "PersonroleController", description = "Exposes APIs to work with Personrole resource.")
@RequestMapping("/LSUC/Personrole")
public class PersonroleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonroleController.class);

    @Autowired
	@Qualifier("LSUC.PersonroleService")
	private PersonroleService personroleService;

	@ApiOperation(value = "Creates a new Personrole instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Personrole createPersonrole(@RequestBody Personrole personrole) {
		LOGGER.debug("Create Personrole with information: {}" , personrole);

		personrole = personroleService.create(personrole);
		LOGGER.debug("Created Personrole with information: {}" , personrole);

	    return personrole;
	}


    @ApiOperation(value = "Returns the Personrole instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Personrole getPersonrole(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Personrole with id: {}" , id);

        Personrole foundPersonrole = personroleService.getById(id);
        LOGGER.debug("Personrole details with id: {}" , foundPersonrole);

        return foundPersonrole;
    }

    @ApiOperation(value = "Updates the Personrole instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Personrole editPersonrole(@PathVariable("id") Integer id, @RequestBody Personrole personrole) throws EntityNotFoundException {
        LOGGER.debug("Editing Personrole with id: {}" , personrole.getPk());

        personrole.setPk(id);
        personrole = personroleService.update(personrole);
        LOGGER.debug("Personrole details with id: {}" , personrole);

        return personrole;
    }

    @ApiOperation(value = "Deletes the Personrole instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePersonrole(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Personrole with id: {}" , id);

        Personrole deletedPersonrole = personroleService.delete(id);

        return deletedPersonrole != null;
    }
    @RequestMapping(value = "/personFk-roleFk", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Personrole with given unique key values.")
    public Personrole getByPersonFkAndRoleFk(@RequestParam(name = "personFk") int personFk, @RequestParam(name = "roleFk") Integer roleFk) {
        LOGGER.debug("Getting Personrole with uniques key PersonFkAndRoleFk");
        return personroleService.getByPersonFkAndRoleFk(personFk, roleFk);
    }

    /**
     * @deprecated Use {@link #findPersonroles(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Personrole instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personrole> searchPersonrolesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Personroles list");
        return personroleService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Personrole instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personrole> findPersonroles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Personroles list");
        return personroleService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Personrole instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personrole> filterPersonroles(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Personroles list");
        return personroleService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPersonroles(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return personroleService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Personrole instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPersonroles( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Personroles");
		return personroleService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonroleService instance
	 */
	protected void setPersonroleService(PersonroleService service) {
		this.personroleService = service;
	}

}

