/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.lsuc.emailservice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import com.lsuc.emailservice.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 */
@ExposeToClient
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    private static final String NO_REPLY_MAIL_ID ="pramati.wave@gmail.com";
    private static final String NO_REPLY_MAIL_PASSWORD ="Pr@m@t!123";
    private static final String SUPERVISOR_MAIL_ID ="tribhuvan.durgam@wavemaker.com";
    //private static final String FORM_URL = "http://e12561a71473b.cloud.wavemakeronline.com/CivicXpress/#/Forms?

    @Autowired
    private SecurityService securityService;

    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     *
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */
    // public String sampleJavaOperation(String name, HttpServletRequest request) {
    //     logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
        
    //     String result = null;
    //     if (securityService.isAuthenticated()) {
    //         result = "Hello " + name + ", You are logged in as "+  securityService.getLoggedInUser().getUserName();
    //     } else {
    //         result = "Hello " + name + ", You are not authenticated yet!";
    //     }
    //     logger.debug("Returning {}", result);
    //     return result;
    // }
    
    public String sendEmail(String licenseeNumber,String licenseeName) {
        try {
            // Use javamail api, set parameters from registration.properties file
            // set the session properties
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            Session session = Session.getDefaultInstance(props, null);
            
            String emailSubject = "Licensee Status Change for "+ licenseeNumber;
            String emailMessage = "Hi <br><br>";
            emailMessage = emailMessage+"The Licensee Status for " + licenseeName;
            emailMessage = emailMessage+" with Licensee Number:"+licenseeNumber+" has been changed. Please review and provide your approval.<br><br>";
            emailMessage = emailMessage+"Click <a href ='https://www.wavemakeronline.com/run-53t562sphl/LSUC/#/Main'>here</a> to review changes.<br><br>";
             emailMessage = emailMessage+"Regards<br>"+securityService.getLoggedInUser().getUserName()+"<br><br>";
             emailMessage = emailMessage+"Note: This is a system generated email. Kindly do not reply.";
            
            // Create email message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(NO_REPLY_MAIL_ID));
            String[] recipientList = SUPERVISOR_MAIL_ID.split(",");
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient: recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);
            message.setSubject(emailSubject);
            message.setContent(emailMessage, "text/html");
            // Send smtp message
            Transport tr = session.getTransport("smtp");
            tr.connect("smtp.gmail.com", 587, NO_REPLY_MAIL_ID, NO_REPLY_MAIL_PASSWORD);
            message.saveChanges();
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();

            return "Mail sent successfully.";

        } catch (MessagingException e) {
            return "Error in method sendEmailNotification: " + e;
        }}

}
