package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import com.tests.page.Registration.MainPage;
import com.tests.page.Registration.RegistrationPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration("testone.xml")

public class step02_RegistrationPage extends AbstractTestNGSpringContextTests {

    @Autowired
    private Methods methods;
    @Autowired
    private Config config;

    public void setConfig(Config config) {
        this.config = config;
    }

    public void setMethods(Methods methods) {

        this.methods = methods;
    }

    @BeforeClass
    public void setUp() {

        methods.setMainPageRegistration();
    }

    @Test(description = "Go to 'Rejestracja' page and fill elements.")
    public void registrationPage() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.goToRejestracja();
        RegistrationPage register = new RegistrationPage();
        register.fillRegistrationElements(config.getRegistration());
    }

}