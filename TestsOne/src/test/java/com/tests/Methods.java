package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Methods {
    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    {
        //COMARCH VERSION

//        ProfilesIni profile = new ProfilesIni();
//        FirefoxProfile myprofile = profile.getProfile("New");
//        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\FirefoxNew\\firefox.exe");
//        System.setProperty("webdriver.gecko.driver", "C:\\tests\\geckodriver\\geckodriver.exe");
//        driver = new FirefoxDriver(myprofile);
//        System.out.println("Driver used is: " + driver);

        //HOME VERSION

        System.setProperty("webdriver.gecko.driver", "C:\\tests\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
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
    public WebDriver setMainPageRegistration(){
        WebDriver mainPage = setPage("http://localhost:1331/TK-StronaRejestracja/");
    return mainPage;
    }


    public static WebElement click(String field, FindMode findMode) {

        WebElement element = null;
        switch (findMode) {
            case NAME: {
                element = getElement(field, FindMode.NAME);
                element.click();
                break;
            }
            case ID: {
                element = getElement(field, FindMode.ID);
                element.click();
            }
            case XPATH: {
                element = getElement(field, FindMode.XPATH);
                element.click();
            }
        }
        return element;
    }
    public static WebDriver back (){
        WebDriver page = getDriver();
        page.navigate().back();
    return page;
    }

    public static WebDriver close (){
        WebDriver page = getDriver();
        page.close();
        return page;
    }

    public static WebDriver forward (){
        WebDriver page = getDriver();
        page.navigate().forward();
        return page;
    }

    public static String pageTitle (){
       String title = getDriver().getTitle();
    return title;
    }
    public static void backToParentHandle() throws InterruptedException {
        String  parent = driver.getWindowHandle();
//        System.out.println("Parent handle id is: " + parent);
        Set<String> allWindows = driver.getWindowHandles();
        int cout = allWindows.size();
//        System.out.println(cout);
        for(String child:allWindows){
            if(!parent.equalsIgnoreCase(child)) {
            driver.switchTo().window(child);
            driver.close();
            Thread.sleep(3000);
            }
            driver.switchTo().window(parent);
        }
    return;
    }

}