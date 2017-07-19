package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@ContextConfiguration("testone.xml")
public class TestOne extends AbstractTestNGSpringContextTests {
    public static WebDriver driver;

    @Autowired
    private Methods methods;

    @BeforeClass
    public void setUp() {

    }

    @Test
    public void mainPage() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\tests\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://store.demoqa.com/");


        }


    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}