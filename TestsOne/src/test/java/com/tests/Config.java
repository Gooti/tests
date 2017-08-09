package com.tests;

import com.tests.data.RegistrationData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gooti on 07.08.2017.
 */
public class Config {
    @Autowired
    private RegistrationData registration;

    public RegistrationData getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationData registration) {
        this.registration = registration;
    }
}
