package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
            System.out.println("Page with title '" + element + "' has beeen loaded.");
        } else System.out.println("Page has not loaded!");
        driver.findElement(By.xpath("//input[contains(@value,'Add To Cart')]"));
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent window's handle -> " + parentWindowHandle);
        driver.findElement(By.cssSelector("#fancy_notification_content > a.go_to_checkout"));
        WebElement checker = driver.findElement(By.xpath("//span[contains(class,'yourtotal')]//span[contains(.,'$12.00')]"));
        System.out.println("You have to pay" + checker + ".");
    }

//    @Test // Marking this method as part of the test
//    public void gotoSeleniumWikiPageFailure() {
//        // Go to the Wikipedia home page
//        driver.get("https://en.wikipedia.org/");
//        // Find the text input element by its id and type "Selenium"
//        driver.findElement(By.id("searchInput")).sendKeys("Selenium");
//        // Click search button
//        driver.findElement(By.id("searchButton")).click();
//        // Get text from header of the Selenium page
//        String header = driver.findElement(By.id("firstHeading")).getText();
//        // Verify that header equals "Selenium WebDriver"
//        Assert.assertEquals(header, "Selenium WebDriver");
//    }

    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}