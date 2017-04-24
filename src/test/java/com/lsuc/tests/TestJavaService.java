package com.lsuc.tests;


import org.junit.Assert;
import org.junit.Test;

import com.lsuc.emailservice.EmailService;

public class TestJavaService {


    /***
     * Test for Validing Hello World Method
     */
    @Test
    public void validateHelloWorld() {
        EmailService emailService = new EmailService();
        final String userMsg = emailService.helloWorld("User");
        Assert.assertTrue(userMsg.contains("Hello User"));
    }

/*    *//***
     * Test for Invalid licence data
     *//*
    @Test
    public void invalidLicenceData() {
        EmailService emailService = new EmailService();
        final String sendEmail = emailService.sendEmail("testlicence", "licenceName", "cc");
        Assert.assertTrue(!sendEmail.contains("Error in method sendEmailNotification: "));
    }*/
}
