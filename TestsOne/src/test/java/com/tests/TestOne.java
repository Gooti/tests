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

    @Autowired
    private WebDriver driver;
    @Autowired
    private Methods methods;

    @BeforeClass
    public void setUp() {
    }

    @Test
    public void mainPage() throws InterruptedException {

        driver.get("http://store.demoqa.com/");

        methods.getElement("//a[contains(.,'Product Category')]", Methods.FindMode.XPATH).click();
        String element = driver.getTitle();
        if (element.equals("Product Category | ONLINE STORE")){
            methods.getElement("//div[contains(@class,'group')]//a[contains(.,'iPhone 5')]", Methods.FindMode.XPATH).click();
            System.out.println("Page with title '" + element + "' has been loaded.");
        } else System.out.println("Page has not loaded!");
        methods.getElement("//input[contains(@value,'Add To Cart')]", Methods.FindMode.XPATH).click();

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent window's handle -> " + parentWindowHandle);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#fancy_notification_content > a.go_to_checkout")).click();
        }


    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}