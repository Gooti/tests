package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration("testone.xml")
public class Methods {
    @Autowired
    private WebDriver driver;

    public enum FindMode {NAME, ID, XPATH}

    public WebElement fillElementFoundByName(String field, String fieldValue) {
        WebElement element = getElement(field, FindMode.NAME);
        element.sendKeys(fieldValue);
        return element;
    }

    public WebElement fillElementFoundById(String field, String fieldValue) {
        WebElement element = getElement(field, FindMode.ID);
        element.sendKeys(fieldValue);
        return element;
    }

    public WebElement fillElementFoundByXPATH(String field, String fieldValue) {
        WebElement element = getElement(field, FindMode.XPATH);
        element.sendKeys(fieldValue);
        return element;
    }


    public WebElement getElement(String field, FindMode findMode) {

        WebElement element = null;
        switch (findMode) {
            case NAME: {
                element = driver.findElement(By.name(field));
                break;
            }
            case ID: {
                element = driver.findElement(By.id(field));
                break;
            }
            case XPATH: {
                element = driver.findElement(By.xpath(field));
                break;
            }
        }
        return element;
    }


}