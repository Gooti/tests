package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import com.tests.Methods;
import com.tests.data.RegistrationData;
import com.tests.page.Registration.MainPage;
import com.tests.page.Registration.RegistrationPage;
import com.tests.page.TestPage.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration("testone.xml")

public class step03_TestLogin extends AbstractTestNGSpringContextTests {

    @Autowired
    private Methods methods;


    public void setMethods(Methods methods) {

        this.methods = methods;
    }


    @BeforeClass
    public void setUp() {

        methods.setTestPage();
    }

    @Test(description = "1. Go to main page of test and log in.")
    public void registrationPage() throws InterruptedException {
        LoginPage logInData = new LoginPage();
        logInData.setLoginData();
        Thread.sleep(300000);
    }

    @AfterClass
    public void tearDown() {

        methods.quit();
    }


}