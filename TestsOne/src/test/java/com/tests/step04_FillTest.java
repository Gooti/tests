package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import com.tests.page.TestPage.LoginPage;
import com.tests.page.TestPage.TestPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration("testone.xml")

public class step04_FillTest extends AbstractTestNGSpringContextTests {

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

    }

    @Test(description = "Go to TestPage and fill answers.")
    public void registrationPage() throws InterruptedException {
        TestPage test = new TestPage();
        test.question(config.getTest());
        test.submitButton();
    }

    @AfterClass
    public void tearDown() {

        methods.quit();
    }


}