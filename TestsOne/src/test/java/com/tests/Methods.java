package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Methods {
    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("New");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\FirefoxNew\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\tests\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver(myprofile);
        System.out.println("Driver used is: " + driver);

    }

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


    public static WebElement getElement(String field, FindMode findMode) {

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

    public WebDriver quit()
    {
        WebDriver closeDriver = getDriver();
        closeDriver.quit();
        return closeDriver;
    }

    public WebDriver setPage(String page)
    {
        WebDriver Page = getDriver();
        Page.get(page);
        return Page;
    }

    public static void clickVisibled(WebElement webElement) {
        webElement.click();
    }

}