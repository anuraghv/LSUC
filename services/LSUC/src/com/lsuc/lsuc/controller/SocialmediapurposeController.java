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

import com.lsuc.lsuc.Businesssocialmediacontact;
import com.lsuc.lsuc.Personsocialmediacontact;
import com.lsuc.lsuc.Socialmediapurpose;
import com.lsuc.lsuc.service.SocialmediapurposeService;


/**
 * Controller object for domain model class Socialmediapurpose.
 * @see Socialmediapurpose
 */
@RestController("LSUC.SocialmediapurposeController")
@Api(value = "SocialmediapurposeController", description = "Exposes APIs to work with Socialmediapurpose resource.")
@RequestMapping("/LSUC/Socialmediapurpose")
public class SocialmediapurposeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialmediapurposeController.class);

    @Autowired
	@Qualifier("LSUC.SocialmediapurposeService")
	private SocialmediapurposeService socialmediapurposeService;

	@ApiOperation(value = "Creates a new Socialmediapurpose instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Socialmediapurpose createSocialmediapurpose(@RequestBody Socialmediapurpose socialmediapurpose) {
		LOGGER.debug("Create Socialmediapurpose with information: {}" , socialmediapurpose);

		socialmediapurpose = socialmediapurposeService.create(socialmediapurpose);
		LOGGER.debug("Created Socialmediapurpose with information: {}" , socialmediapurpose);

	    return socialmediapurpose;
	}


    @ApiOperation(value = "Returns the Socialmediapurpose instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Socialmediapurpose getSocialmediapurpose(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Socialmediapurpose with id: {}" , id);

        Socialmediapurpose foundSocialmediapurpose = socialmediapurposeService.getById(id);
        LOGGER.debug("Socialmediapurpose details with id: {}" , foundSocialmediapurpose);

        return foundSocialmediapurpose;
    }

    @ApiOperation(value = "Updates the Socialmediapurpose instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Socialmediapurpose editSocialmediapurpose(@PathVariable("id") Integer id, @RequestBody Socialmediapurpose socialmediapurpose) throws EntityNotFoundException {
        LOGGER.debug("Editing Socialmediapurpose with id: {}" , socialmediapurpose.getPk());

        socialmediapurpose.setPk(id);
        socialmediapurpose = socialmediapurposeService.update(socialmediapurpose);
        LOGGER.debug("Socialmediapurpose details with id: {}" , socialmediapurpose);

        return socialmediapurpose;
    }

    @ApiOperation(value = "Deletes the Socialmediapurpose instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteSocialmediapurpose(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Socialmediapurpose with id: {}" , id);

        Socialmediapurpose deletedSocialmediapurpose = socialmediapurposeService.delete(id);

        return deletedSocialmediapurpose != null;
    }
    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Socialmediapurpose with given unique key values.")
    public Socialmediapurpose getByCode(@PathVariable("code") String code) {
        LOGGER.debug("Getting Socialmediapurpose with uniques key Code");
        return socialmediapurposeService.getByCode(code);
    }

    /**
     * @deprecated Use {@link #findSocialmediapurposes(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Socialmediapurpose instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Socialmediapurpose> searchSocialmediapurposesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Socialmediapurposes list");
        return socialmediapurposeService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Socialmediapurpose instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Socialmediapurpose> findSocialmediapurposes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Socialmediapurposes list");
        return socialmediapurposeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Socialmediapurpose instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Socialmediapurpose> filterSocialmediapurposes(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Socialmediapurposes list");
        return socialmediapurposeService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSocialmediapurposes(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return socialmediapurposeService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Socialmediapurpose instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countSocialmediapurposes( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Socialmediapurposes");
		return socialmediapurposeService.count(query);
	}

    @RequestMapping(value="/{id:.+}/businesssocialmediacontacts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the businesssocialmediacontacts instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Businesssocialmediacontact> findAssociatedBusinesssocialmediacontacts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated businesssocialmediacontacts");
        return socialmediapurposeService.findAssociatedBusinesssocialmediacontacts(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personsocialmediacontacts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personsocialmediacontacts instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personsocialmediacontact> findAssociatedPersonsocialmediacontacts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personsocialmediacontacts");
        return socialmediapurposeService.findAssociatedPersonsocialmediacontacts(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service SocialmediapurposeService instance
	 */
	protected void setSocialmediapurposeService(SocialmediapurposeService service) {
		this.socialmediapurposeService = service;
	}

}

