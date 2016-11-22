package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private WebDriver driver;
    @Autowired
    private Methods methods;

    private void pickData() {
        methods.getElement("//select[contains(@id,'mm_date_8')]//option[contains(@value,'1')]", Methods.FindMode.XPATH).click();
        methods.getElement("//select[contains(@id,'dd_date_8')]//option[contains(@value,'12')]", Methods.FindMode.XPATH).click();
        methods.getElement("//select[contains(@id,'yy_date_8')]//option[contains(@value,'2014')]", Methods.FindMode.XPATH).click();
        return;
    }

    @BeforeClass
    public void setUp() {
        System.out.println("Driver used is: " + driver);

    }

    @Test(description = "1. Fill in registration page http://demoqa.com/")
    public void registrationPage() throws InterruptedException {

        String password = "ThisIsGoodPassword123!";
        System.out.println(driver==null);
        driver.get("http://demoqa.com/");
//        driver.findElement(By.xpath("//div[contains(@class,'col-md-4')]//img[contains(@alt,'pattern-14')]")).click();
//        driver.navigate().back();
        driver.navigate().refresh();
        String title = driver.getTitle();
        System.out.println(title);
        WebElement registration = driver.findElement(By.xpath("//a[contains(.,'Registration')]"));
        registration.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        methods.fillElementFoundByName("first_name", "Mateusz");
        methods.fillElementFoundByName("last_name", "Urbaniak");

        WebElement value = driver.findElement(By.xpath("//div[contains(@class,'radio_wrap')]//input[contains(@value,'single')]"));
        if (value.isSelected()) {
            System.out.println("Already clicked.");
        } else value.click();

        methods.getElement("//div[contains(@class,'radio_wrap')]//input[contains(@value,'reading')]", Methods.FindMode.XPATH).click();
        WebElement listCountry = methods.getElement("//select[contains(@id,'dropdown_7')]//option[contains(@value,'Andorra')]", Methods.FindMode.XPATH);
        listCountry.click();
        System.out.println("Value 'Country' = " + listCountry);

        pickData();

        WebElement number = methods.fillElementFoundByName("phone_9", "ThisIsNotNumber");
        methods.fillElementFoundByName("username", "INeedBetterUsername");
        methods.fillElementFoundByName("e_mail", "mail@mail.com");
        methods.fillElementFoundByName("description", "Roses are red. I have nth special to say.");

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