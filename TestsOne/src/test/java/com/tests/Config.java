package com.tests;

import com.tests.data.RegistrationData;
import com.tests.data.TestData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gooti on 07.08.2017.
 */
public class Config {
    @Autowired
    private RegistrationData registration;
    @Autowired
    private TestData test;

    public RegistrationData getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationData registration) {
        this.registration = registration;
    }

    public TestData getTest() {
        return test;
    }

    public void setTest(TestData test) {
        this.test = test;
    }
}
