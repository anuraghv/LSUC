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

import com.lsuc.lsuc.LicenseeclasspracticegroupAud;
import com.lsuc.lsuc.LicenseeclasspracticegroupAudId;
import com.lsuc.lsuc.service.LicenseeclasspracticegroupAudService;


/**
 * Controller object for domain model class LicenseeclasspracticegroupAud.
 * @see LicenseeclasspracticegroupAud
 */
@RestController("LSUC.LicenseeclasspracticegroupAudController")
@Api(value = "LicenseeclasspracticegroupAudController", description = "Exposes APIs to work with LicenseeclasspracticegroupAud resource.")
@RequestMapping("/LSUC/LicenseeclasspracticegroupAud")
public class LicenseeclasspracticegroupAudController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LicenseeclasspracticegroupAudController.class);

    @Autowired
	@Qualifier("LSUC.LicenseeclasspracticegroupAudService")
	private LicenseeclasspracticegroupAudService licenseeclasspracticegroupAudService;

	@ApiOperation(value = "Creates a new LicenseeclasspracticegroupAud instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public LicenseeclasspracticegroupAud createLicenseeclasspracticegroupAud(@RequestBody LicenseeclasspracticegroupAud licenseeclasspracticegroupAud) {
		LOGGER.debug("Create LicenseeclasspracticegroupAud with information: {}" , licenseeclasspracticegroupAud);

		licenseeclasspracticegroupAud = licenseeclasspracticegroupAudService.create(licenseeclasspracticegroupAud);
		LOGGER.debug("Created LicenseeclasspracticegroupAud with information: {}" , licenseeclasspracticegroupAud);

	    return licenseeclasspracticegroupAud;
	}

    @ApiOperation(value = "Returns the LicenseeclasspracticegroupAud instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LicenseeclasspracticegroupAud getLicenseeclasspracticegroupAud(@RequestParam("pk") Integer pk,@RequestParam("rev") Integer rev) throws EntityNotFoundException {

        LicenseeclasspracticegroupAudId licenseeclasspracticegroupaudId = new LicenseeclasspracticegroupAudId();
        licenseeclasspracticegroupaudId.setPk(pk);
        licenseeclasspracticegroupaudId.setRev(rev);

        LOGGER.debug("Getting LicenseeclasspracticegroupAud with id: {}" , licenseeclasspracticegroupaudId);
        LicenseeclasspracticegroupAud licenseeclasspracticegroupAud = licenseeclasspracticegroupAudService.getById(licenseeclasspracticegroupaudId);
        LOGGER.debug("LicenseeclasspracticegroupAud details with id: {}" , licenseeclasspracticegroupAud);

        return licenseeclasspracticegroupAud;
    }



    @ApiOperation(value = "Updates the LicenseeclasspracticegroupAud instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public LicenseeclasspracticegroupAud editLicenseeclasspracticegroupAud(@RequestParam("pk") Integer pk,@RequestParam("rev") Integer rev, @RequestBody LicenseeclasspracticegroupAud licenseeclasspracticegroupAud) throws EntityNotFoundException {

        licenseeclasspracticegroupAud.setPk(pk);
        licenseeclasspracticegroupAud.setRev(rev);

        LOGGER.debug("LicenseeclasspracticegroupAud details with id is updated with: {}" , licenseeclasspracticegroupAud);

        return licenseeclasspracticegroupAudService.update(licenseeclasspracticegroupAud);
    }


    @ApiOperation(value = "Deletes the LicenseeclasspracticegroupAud instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteLicenseeclasspracticegroupAud(@RequestParam("pk") Integer pk,@RequestParam("rev") Integer rev) throws EntityNotFoundException {

        LicenseeclasspracticegroupAudId licenseeclasspracticegroupaudId = new LicenseeclasspracticegroupAudId();
        licenseeclasspracticegroupaudId.setPk(pk);
        licenseeclasspracticegroupaudId.setRev(rev);

        LOGGER.debug("Deleting LicenseeclasspracticegroupAud with id: {}" , licenseeclasspracticegroupaudId);
        LicenseeclasspracticegroupAud licenseeclasspracticegroupAud = licenseeclasspracticegroupAudService.delete(licenseeclasspracticegroupaudId);

        return licenseeclasspracticegroupAud != null;
    }


    /**
     * @deprecated Use {@link #findLicenseeclasspracticegroupAuds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of LicenseeclasspracticegroupAud instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LicenseeclasspracticegroupAud> searchLicenseeclasspracticegroupAudsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering LicenseeclasspracticegroupAuds list");
        return licenseeclasspracticegroupAudService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LicenseeclasspracticegroupAud instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LicenseeclasspracticegroupAud> findLicenseeclasspracticegroupAuds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LicenseeclasspracticegroupAuds list");
        return licenseeclasspracticegroupAudService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of LicenseeclasspracticegroupAud instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<LicenseeclasspracticegroupAud> filterLicenseeclasspracticegroupAuds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering LicenseeclasspracticegroupAuds list");
        return licenseeclasspracticegroupAudService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportLicenseeclasspracticegroupAuds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return licenseeclasspracticegroupAudService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of LicenseeclasspracticegroupAud instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countLicenseeclasspracticegroupAuds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting LicenseeclasspracticegroupAuds");
		return licenseeclasspracticegroupAudService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getLicenseeclasspracticegroupAudAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return licenseeclasspracticegroupAudService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LicenseeclasspracticegroupAudService instance
	 */
	protected void setLicenseeclasspracticegroupAudService(LicenseeclasspracticegroupAudService service) {
		this.licenseeclasspracticegroupAudService = service;
	}

}

