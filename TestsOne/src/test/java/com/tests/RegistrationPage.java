package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationPage {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "1. Fill in registration page http://demoqa.com/")
    public void registrationPage() throws InterruptedException {


        String password = "ThisIsGoodPassword123!";
        driver.get("http://demoqa.com/");
//        driver.findElement(By.xpath("//div[contains(@class,'col-md-4')]//img[contains(@alt,'pattern-14')]")).click();
//        driver.navigate().back();
        driver.navigate().refresh();
        String title = driver.getTitle();
        System.out.println(title);
        WebElement registration = driver.findElement(By.xpath("//a[contains(.,'Registration')]"));
        registration.click();


        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("Mateusz");
        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys("Urbaniak");
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'radio_wrap')]//input[contains(@value,'single')]"));
        if (element.isSelected()) {
            System.out.println("Already clicked.");
        } else element.click();
        WebElement radioReading = driver.findElement(By.xpath("//div[contains(@class,'radio_wrap')]//input[contains(@value,'reading')]"));
        radioReading.click();
        WebElement listCountry = driver.findElement(By.xpath("//select[contains(@id,'dropdown_7')]//option[contains(@value,'Andorra')]"));
        System.out.println("Value 'Country' = " + listCountry);
        WebElement mmDate = driver.findElement(By.xpath("//select[contains(@id,'mm_date_8')]//option[contains(@value,'1')]"));
        mmDate.click();
        WebElement ddDate = driver.findElement(By.xpath("//select[contains(@id,'dd_date_8')]//option[contains(@value,'12')]"));
        ddDate.click();
        WebElement yyDate = driver.findElement(By.xpath("//select[contains(@id,'yy_date_8')]//option[contains(@value,'2014')]"));
        yyDate.click();
        WebElement number = driver.findElement(By.name("phone_9"));
        number.sendKeys("ThisIsNotNumber");
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("INeedBetterUsername");
        WebElement mail = driver.findElement(By.name("e_mail"));
        mail.sendKeys("mail@mail.com");
        WebElement description = driver.findElement(By.name("description"));
        description.sendKeys("Roses are red. I have nth special to say.");
        driver.findElement(By.id("password_2")).sendKeys(password);
        driver.findElement(By.id("confirm_password_password_2")).sendKeys(password);
        if (password.equals("ThisIsGoodPassword123!")) {
            number.clear();
            number.sendKeys("0123456789");
        } else number.clear();
        number.sendKeys("9876543210");
        assertEquals(title, "Demoqa | Just another WordPress site");

    }


    @AfterClass
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}