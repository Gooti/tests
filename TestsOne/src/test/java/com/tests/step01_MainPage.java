package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import com.tests.page.Registration.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.concurrent.TimeUnit;

@ContextConfiguration("testone.xml")
public class step01_MainPage extends AbstractTestNGSpringContextTests {

    @Autowired
    private Methods methods;

    public void setMethods(Methods methods) {
        this.methods = methods;
    }

    @BeforeClass
    public void setUp() {
        methods.setPage("http://localhost/TK-StronaRejestracja/");
    }

    @Test
    public void mainPage() throws InterruptedException {

   methods.goToAll();

        }


    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        methods.quit();
    }



}