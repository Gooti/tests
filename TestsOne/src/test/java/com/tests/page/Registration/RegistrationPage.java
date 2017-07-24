package com.tests.page.Registration;

import com.tests.Methods;
import com.tests.data.RegistrationData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Comarch on 2017-07-24.
 */
public class RegistrationPage {
    @Autowired
    private Methods methods;

public RegistrationPage fillRegistrationElements(RegistrationData data){
    methods.fillElementFoundByName("uFirstname",data.getFirstName() );
    methods.fillElementFoundByName("uSurname",data.getSurName() );
    methods.fillElementFoundByName("uSchool",data.getSchoolName() );
    methods.fillElementFoundByName("uLogin",data.getLogin() );
    methods.fillElementFoundByName("uPassA",data.getPassword() );
    methods.fillElementFoundByName("uPassB",data.getRepeatPassword() );
    methods.fillElementFoundByName("uMail",data.getMail() );
    methods.fillElementFoundByName("uCaptcha",data.getCaptcha());
    return this;
}
}
