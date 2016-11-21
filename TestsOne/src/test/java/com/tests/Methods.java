package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.junit.testsetup.Data;

public class Methods {
    public enum FindMode {NAME, ID, XPATH}
    public static WebDriver driver;
    public static WebElement fillElementFoundByName(String field, String fieldValue) {
        WebElement element = getElement(field, FindMode.NAME);
        element.sendKeys(fieldValue);
        return element;
    }

    public static WebElement fillElementFoundById(String field, String fieldValue) {
        WebElement element = getElement(field, FindMode.ID);
        element.sendKeys(fieldValue);
        return element;
    }
    public static WebElement fillElementFoundByXPATH(String field, String fieldValue) {
        WebElement element = getElement(field, FindMode.XPATH);
        element.sendKeys(fieldValue);
        return element;
    }


    public static WebElement getElement(String field, FindMode findMode) {

        WebElement element = null;
        switch (findMode) {
            case NAME:
            {
                element = driver.findElement(By.name(field));
                break;
            }
            case ID:
            {
                element = driver.findElement(By.id(field));
                break;
            }
            case XPATH:
            {
                element = driver.findElement(By.xpath(field));
                break;
            }
        }
        return element;
    }



}