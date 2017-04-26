package com.lsuc.emailService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lsuc.emailservice.EmailService;

/**
 * Created by venkateswarluk on 26/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-config.xml")
public class TestEmailService {

    @Autowired
    EmailService emailService;

    @Test
    public void verifyEmailService() {
        String response = emailService.sendEmail("aa", "bjk", "aa");
        System.out.println("Message is :" + response);
        if (!(response.contains("Mail sent successfully.")))
            Assert.fail("Failed with error message, " + response);
    }

}
