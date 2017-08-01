package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import com.tests.data.RegistrationData;
import com.tests.page.Registration.MainPage;
import com.tests.page.Registration.RegistrationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@ContextConfiguration("testone.xml")

public class step02_RegistrationPage extends AbstractTestNGSpringContextTests {

    @Autowired
    private Methods methods;

    @Autowired
    private RegistrationData registration;

    public void setMethods(Methods methods) {

        this.methods = methods;
    }

    public void setRegistration(RegistrationData registration) {
        this.registration = registration;
    }

    @BeforeClass
    public void setUp() {

        methods.setMainPageRegistration();
    }

    @Test(description = "1. Go to 'Rejestracja' page and fill elements.")
    public void registrationPage() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.goToRejestracja();
        RegistrationPage register = new RegistrationPage();
        register.fillRegistrationElements(registration);
        Thread.sleep(3000000);
    }

    @AfterClass
    public void tearDown() {

        methods.quit();
    }


}