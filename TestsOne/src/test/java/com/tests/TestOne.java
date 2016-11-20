package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestOne {

    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test // Marking this method as part of the test
    public void mainPage() throws InterruptedException {

        driver.get("http://store.demoqa.com/");

        driver.findElement(By.xpath("//a[contains(.,'Product Category')]")).click();
        String element = driver.getTitle();
        if (element.equals("Product Category | ONLINE STORE")){
            driver.findElement(By.xpath("//div[contains(@class,'group')]//a[contains(.,'iPhone 5')]")).click();
            System.out.println("Page with title '" + element + "' has been loaded.");
        } else System.out.println("Page has not loaded!");
        driver.findElement(By.xpath("//input[contains(@value,'Add To Cart')]")).click();
//        System.out.println("clicked");

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent window's handle -> " + parentWindowHandle);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#fancy_notification_content > a.go_to_checkout")).click();
        }


//    }

    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}