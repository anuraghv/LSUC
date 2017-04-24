package com.lsuc.lsuc;

import com.lsuc.lsuc.service.PersonServiceImpl;
import com.lsuc.lsuc.service.PersonaddressService;
import com.wavemaker.commons.WMRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tribhuvand on 24/4/17.
 */
public class PersonPreProcessor extends PersonServiceImpl {


    private static final Logger LOGGER = LoggerFactory.getLogger(PersonPreProcessor.class);

    @Autowired
    @Qualifier("LSUC.PersonaddressService")
    private PersonaddressService personaddressService;


    @Override
    // @Transactional
    public Person create(Person person) {

        LOGGER.info(person.getPersonaddresses()+"");
        List<Personaddress> personaddresses = person.getPersonaddresses();
        for (Personaddress address : personaddresses
                ) {
                    LOGGER.info("Searched for Person with FirstName" + person.getFirstName() + ", LastName " + person.getLastName() + ".Address " + address.getAddressLine1() );
            long count = personaddressService.findAll("person.firstName = '" + person.getFirstName() + "' and person.lastName = '" + person.getLastName() + "' and addressLine1 = '" + address.getAddressLine1() + "'", null).getTotalElements();
            
            if (count > 0) {
                throw new WMRuntimeException("Person already exists with given Firstname, Lastname and Address");
            }
        }
        return super.create(person);

    }

}