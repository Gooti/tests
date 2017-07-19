package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
@ContextConfiguration("testone.xml")

public class RegistrationPage extends AbstractTestNGSpringContextTests {


    @Autowired
    private Methods methods;

    public void setMethods(Methods methods) {
        this.methods = methods;
    }
    
    private void pickData() {
//        methods.getElement("//select[contains(@id,'mm_date_8')]//option[contains(@value,'1')]", Methods.FindMode.XPATH).click();
//        methods.getElement("//select[contains(@id,'dd_date_8')]//option[contains(@value,'12')]", Methods.FindMode.XPATH).click();
//        methods.getElement("//select[contains(@id,'yy_date_8')]//option[contains(@value,'2014')]", Methods.FindMode.XPATH).click();
        return;
    }

    @BeforeClass
    public void setUp() {

    }

    @Test(description = "1. Fill in registration page http://demoqa.com/")
    public void registrationPage() throws InterruptedException {

        methods.getElement("//a[contains(.,'Aktualności')]", Methods.FindMode.XPATH).click();
        WebElement oKonkursie = methods.getElement("//a[contains(.,'O konkursie')]", Methods.FindMode.XPATH);
        oKonkursie.click();
        WebElement rejestracja = methods.getElement("//a[contains(.,'Rejestracja')]", Methods.FindMode.XPATH);
        rejestracja.click();
        methods.getElement("//a[contains(.,'Harmonogram')]", Methods.FindMode.XPATH).click();
        methods.getElement("//a[contains(.,'Zasady')]", Methods.FindMode.XPATH).click();
        methods.getElement("//a[contains(.,'Komisja')]", Methods.FindMode.XPATH).click();
        methods.getElement("//a[contains(.,'Patronaty')]", Methods.FindMode.XPATH).click();



    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }


}