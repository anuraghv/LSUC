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

import com.lsuc.lsuc.Businessperson;
import com.lsuc.lsuc.Licensee;
import com.lsuc.lsuc.Licenseephotoidcard;
import com.lsuc.lsuc.Person;
import com.lsuc.lsuc.Personaddress;
import com.lsuc.lsuc.PersonaddressAud;
import com.lsuc.lsuc.Personemailcontact;
import com.lsuc.lsuc.Personlanguage;
import com.lsuc.lsuc.Personnameotherlanguage;
import com.lsuc.lsuc.Personothername;
import com.lsuc.lsuc.Personperson;
import com.lsuc.lsuc.Personphonecontact;
import com.lsuc.lsuc.Personrole;
import com.lsuc.lsuc.Personsocialmediacontact;
import com.lsuc.lsuc.User;
import com.lsuc.lsuc.service.PersonService;


/**
 * Controller object for domain model class Person.
 * @see Person
 */
@RestController("LSUC.PersonController")
@Api(value = "PersonController", description = "Exposes APIs to work with Person resource.")
@RequestMapping("/LSUC/Person")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
	@Qualifier("LSUC.PersonService")
	private PersonService personService;

	@ApiOperation(value = "Creates a new Person instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Person createPerson(@RequestBody Person person) {
		LOGGER.debug("Create Person with information: {}" , person);

		person = personService.create(person);
		LOGGER.debug("Created Person with information: {}" , person);

	    return person;
	}


    @ApiOperation(value = "Returns the Person instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Person getPerson(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Person with id: {}" , id);

        Person foundPerson = personService.getById(id);
        LOGGER.debug("Person details with id: {}" , foundPerson);

        return foundPerson;
    }

    @ApiOperation(value = "Updates the Person instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Person editPerson(@PathVariable("id") Integer id, @RequestBody Person person) throws EntityNotFoundException {
        LOGGER.debug("Editing Person with id: {}" , person.getPk());

        person.setPk(id);
        person = personService.update(person);
        LOGGER.debug("Person details with id: {}" , person);

        return person;
    }

    @ApiOperation(value = "Deletes the Person instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePerson(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Person with id: {}" , id);

        Person deletedPerson = personService.delete(id);

        return deletedPerson != null;
    }

    /**
     * @deprecated Use {@link #findPersons(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Person instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Person> searchPersonsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Persons list");
        return personService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Person instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Person> findPersons(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Persons list");
        return personService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Person instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Person> filterPersons(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Persons list");
        return personService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPersons(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return personService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Person instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPersons( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Persons");
		return personService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPersonAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return personService.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/{id:.+}/licenseephotoidcardsForPersonFkVerified", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the licenseephotoidcardsForPersonFkVerified instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licenseephotoidcard> findAssociatedLicenseephotoidcardsForPersonFkVerified(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated licenseephotoidcardsForPersonFkVerified");
        return personService.findAssociatedLicenseephotoidcardsForPersonFkVerified(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/licenseephotoidcardsForPersonFkIssued", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the licenseephotoidcardsForPersonFkIssued instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licenseephotoidcard> findAssociatedLicenseephotoidcardsForPersonFkIssued(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated licenseephotoidcardsForPersonFkIssued");
        return personService.findAssociatedLicenseephotoidcardsForPersonFkIssued(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personemailcontacts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personemailcontacts instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personemailcontact> findAssociatedPersonemailcontacts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personemailcontacts");
        return personService.findAssociatedPersonemailcontacts(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personphonecontacts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personphonecontacts instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personphonecontact> findAssociatedPersonphonecontacts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personphonecontacts");
        return personService.findAssociatedPersonphonecontacts(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personsocialmediacontacts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personsocialmediacontacts instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personsocialmediacontact> findAssociatedPersonsocialmediacontacts(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personsocialmediacontacts");
        return personService.findAssociatedPersonsocialmediacontacts(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personaddressAuds", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personaddressAuds instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<PersonaddressAud> findAssociatedPersonaddressAuds(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personaddressAuds");
        return personService.findAssociatedPersonaddressAuds(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personpersonsForPersonFkParent", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personpersonsForPersonFkParent instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personperson> findAssociatedPersonpersonsForPersonFkParent(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personpersonsForPersonFkParent");
        return personService.findAssociatedPersonpersonsForPersonFkParent(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personpersonsForPersonFkChild", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personpersonsForPersonFkChild instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personperson> findAssociatedPersonpersonsForPersonFkChild(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personpersonsForPersonFkChild");
        return personService.findAssociatedPersonpersonsForPersonFkChild(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/licensees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the licensees instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Licensee> findAssociatedLicensees(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated licensees");
        return personService.findAssociatedLicensees(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/users", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the users instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<User> findAssociatedUsers(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated users");
        return personService.findAssociatedUsers(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/businesspersons", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the businesspersons instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Businessperson> findAssociatedBusinesspersons(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated businesspersons");
        return personService.findAssociatedBusinesspersons(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personothernames", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personothernames instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personothername> findAssociatedPersonothernames(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personothernames");
        return personService.findAssociatedPersonothernames(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personnameotherlanguages", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personnameotherlanguages instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personnameotherlanguage> findAssociatedPersonnameotherlanguages(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personnameotherlanguages");
        return personService.findAssociatedPersonnameotherlanguages(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personroles", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personroles instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personrole> findAssociatedPersonroles(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personroles");
        return personService.findAssociatedPersonroles(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personlanguages", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personlanguages instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personlanguage> findAssociatedPersonlanguages(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personlanguages");
        return personService.findAssociatedPersonlanguages(id, pageable);
    }

    @RequestMapping(value="/{id:.+}/personaddresses", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the personaddresses instance associated with the given id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Personaddress> findAssociatedPersonaddresses(@PathVariable("id") Integer id, Pageable pageable) {

        LOGGER.debug("Fetching all associated personaddresses");
        return personService.findAssociatedPersonaddresses(id, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonService instance
	 */
	protected void setPersonService(PersonService service) {
		this.personService = service;
	}

}

