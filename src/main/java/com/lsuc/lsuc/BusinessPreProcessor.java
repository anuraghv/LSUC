package com.lsuc.lsuc;

import com.lsuc.lsuc.service.BusinessServiceImpl;
import com.lsuc.lsuc.service.BusinessaddressService;
import com.wavemaker.commons.WMRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tribhuvand on 26/4/17.
 */
public class BusinessPreProcessor extends BusinessServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessPreProcessor.class);

    @Autowired
    @Qualifier("LSUC.BusinessaddressService")
    private BusinessaddressService businessaddressService;

    @Override
    @Transactional(value = "LSUCTransactionManager")
    public Business create(Business business) {
        List<Businessaddress> businessaddresses = business.getBusinessaddresses();
        for (Businessaddress address : businessaddresses
                ) {
            long count = businessaddressService.findAll("addressLine1='"+address.getAddressLine1()+"'", null).getTotalElements();
            if (count > 0) {
                throw new WMRuntimeException("A business with provided address already exists");
            }
        }
        return super.create(business);
    }
}
