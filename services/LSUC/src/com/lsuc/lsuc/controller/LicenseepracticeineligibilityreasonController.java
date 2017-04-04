/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.lsuc.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.sql.Date;

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

import com.lsuc.lsuc.Licenseepracticeineligibilityreason;
import com.lsuc.lsuc.Licenseepracticeineligibilitysubreason;
import com.lsuc.lsuc.service.LicenseepracticeineligibilityreasonService;


/**
 * Controller object for domain model class Licenseepracticeineligibilityreason.
 * @see Licenseepracticeineligibilityreason
 */
@RestController("LSUC.LicenseepracticeineligibilityreasonController")
@Api(value = "LicenseepracticeineligibilityreasonController", description = "Exposes APIs to work with Licenseepracticeineligibilityreason resource.")
@RequestMapping("/LSUC/Licenseepracticeineligibilityreason")
public class LicenseepracticeineligibilityreasonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LicenseepracticeineligibilityreasonController.class);

    @Autowired
	@Qualifier("LSUC.LicenseepracticeineligibilityreasonService")
	private LicenseepracticeineligibilityreasonService licenseepracticeineligibilityreasonService;

	@ApiOperation(value = "Creates a new Licenseepracticeineligibilityreason instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Licenseepracticeineligibilityreason createLicenseepracticeineligibilityreason(@RequestBody Licenseepracticeineligibilityreason licenseepracticeineligibilityreason) {
		LOGGER.debug("Create Licenseepracticeineligibilityreason with information: {}" , licenseepracticeineligibilityreason);

		licenseepracticeineligibilityreason = licenseepracticeineligibilityreasonService.create(licenseepracticeineligibilityreason);
		LOGGER.debug("Created Licenseepracticeineligibilityreason with information: {}" , licenseepracticeineligibilityreason);

	    return licenseepracticeineligibilityreason;
	}


    @ApiOperation(value = "Returns the Licenseepracticeineligibilityreason instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Licenseepracticeineligibilityreason getLicenseepracticeineligibilityreason(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Licenseepracticeineligibilityreason with id: {}" , id);

        Licenseepracticeineligibilityreason foundLicenseepracticeineligibilityreason = licenseepracticeineligibilityreasonService.getById(id);
        LOGGER.debug("Licenseepracticeineligibilityreason details with id: {}" , foundLicenseepracticeineligibilityreason);

        return foundLicenseepracticeineligibilityreason;
    }

    @ApiOperation(value = "Updates the Licenseepracticeineligibilityreason instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Licenseepracticeineligibilityreason editLicenseepracticeineligibilityreason(@PathVariable("id") Integer id, @RequestBody Licenseepracticeineligibilityreason licenseepracticeineligibilityreason) throws EntityNotFoundException {
        LOGGER.debug("Editing Licenseepracticeineligibilityreason with id: {}" , licenseepracticeineligibilityreason.getPk());

        licenseepracticeineligibilityreason.setPk(id);
        licenseepracticeineligibilityreason = licenseepracticeineligibilityreasonService.update(licenseepracticeineligibilityreason);
        LOGGER.debug("Licenseepracticeineligibilityreason details with id: {}" , licenseepracticeineligibilityreason);

        return licenseepracticeineligibilityreason;
    }

    @ApiOperation(value = "Deletes the Licenseepracticeineligibilityreason instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLicenseepracticeineligibilityreason(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Licenseepracticeineligibilityreason with id: {}" , id);

        Licenseepracticeineligibilityreason deletedLicenseepracticeineligibilityreason = licenseepracticeineligibilityreasonService.delete(id);

        return deletedLicenseepracticeineligibilityreason != null;
    }
    @RequestMapping(value = "/licenseeClassPracticeGroupFk-practiceIneligibilityReason-effectiveFromDate-effectiveToDate", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Licenseepracticeineligibilityreason with given unique key values.")
    public Licenseepracticeineligibilityreason getByLicenseeClassPracticeGroupFkAndPracticeIneligibilityReasonAndEffectiveFromDateAndEffectiveToDate(@RequestParam(name = "licenseeClassPracticeGroupFk") Integer licenseeClassPracticeGroupFk, @RequestParam(name = "practiceIneligibilityReason") Integer practiceIneligibilityReason, @RequestParam(name = "effectiveFromDate") Date effectiveFromDate, @RequestParam(name = "effectiveToDate") Date effectiveToDate) {
        LOGGER.debug("Getting Licenseepracticeineligibilityreason with uniques key LicenseeClassPracticeGroupFkAndPracticeIneligibilityReasonAndEffectiveFromDateAndEffectiveToDate");
        return licenseepracticeineligibilityreasonService.getByLicenseeClassPracticeGroupFkAndPracticeIneligibilityReasonAndEffectiveFromDateAndEffectiveToDate(licenseeClassPracticeGroupFk, practiceIneligibilityReason, effectiveFromDate, effectiveToDate);
    }

    /**
     * @deprecated Use {@link #findLicenseepracticeineligibilityreasons(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Licenseepracticeineligibilityreason instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licenseepracticeineligibilityreason> searchLicenseepracticeineligibilityreasonsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Licenseepracticeineligibilityreasons list");
        return licenseepracticeineligibilityreasonService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Licenseepracticeineligibilityreason instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licenseepracticeineligibilityreason> findLicenseepracticeineligibilityreasons(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Licenseepracticeineligibilityreasons list");
        return licenseepracticeineligibilityreasonService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Licenseepracticeineligibilityreason instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licenseepracticeineligibilityreason> filterLicenseepracticeineligibilityreasons(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Licenseepracticeineligibilityreasons list");
        return licenseepracticeineligibilityreasonService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportLicenseepracticeineligibilityreasons(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return licenseepracticeineligibilityreasonService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Licenseepracticeineligibilityreason instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countLicenseepracticeineligibilityreasons( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Licenseepracticeineligibilityreasons");
		return licenseepracticeineligibilityreasonService.count(query);
	}

    @RequestMapping(value="/{id:.+}/licenseepracticeineligibilitysubreasons", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the licenseepracticeineligibilitysubreasons instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licenseepracticeineligibilitysubreason> findAssociatedLicenseepracticeineligibilitysubreasons(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated licenseepracticeineligibilitysubreasons");
        return licenseepracticeineligibilityreasonService.findAssociatedLicenseepracticeineligibilitysubreasons(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseepracticeineligibilityreasonService instance
	 */
	protected void setLicenseepracticeineligibilityreasonService(LicenseepracticeineligibilityreasonService service) {
		this.licenseepracticeineligibilityreasonService = service;
	}

}

