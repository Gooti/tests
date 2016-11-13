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

import java.util.concurrent.TimeUnit;

public class RegistrationPage {

    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "1. Open page http://demoqa.com/")
    public void registrationPage() throws InterruptedException {

        String password = "ThisIsGoodPassword123!";

        driver.get("http://demoqa.com/");
//        driver.findElement(By.xpath("//div[contains(@class,'col-md-4')]//img[contains(@alt,'pattern-14')]")).click();
//        driver.navigate().back();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[contains(.,'Registration')]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Mateusz");
        driver.findElement(By.name("last_name")).sendKeys("Urbaniak");
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'radio_wrap')]//input[contains(@value,'single')]"));
        if (element.isSelected()){
            System.out.println("Already clicked.");
        } else element.click();
        driver.findElement(By.xpath("//div[contains(@class,'radio_wrap')]//input[contains(@value,'reading')]")).click();
        WebElement listCountry = driver.findElement(By.xpath("//select[contains(@id,'dropdown_7')]//option[contains(@value,'Andorra')]"));
        System.out.println("Value 'Country' = " + listCountry);
        driver.findElement(By.xpath("//select[contains(@id,'mm_date_8')]//option[contains(@value,'1')]")).click();
        driver.findElement(By.xpath("//select[contains(@id,'dd_date_8')]//option[contains(@value,'12')]")).click();
        driver.findElement(By.xpath("//select[contains(@id,'yy_date_8')]//option[contains(@value,'2014')]")).click();
        WebElement number = driver.findElement(By.name("phone_9"));
        number.sendKeys("ThisIsNotNumber");
        driver.findElement(By.name("username")).sendKeys("INeedBetterUsername");
        driver.findElement(By.name("e_mail")).sendKeys("mail@mail.com");
        driver.findElement(By.name("description")).sendKeys("Roses are red. I have nth special to say.");
        driver.findElement(By.id("password_2")).sendKeys(password);
        driver.findElement(By.id("confirm_password_password_2")).sendKeys(password);
        if (number != null){
            number.clear();
            number.sendKeys("0123456789");
        } else number.sendKeys("9876543210");
        WebElement submit = driver.findElement(By.xpath("//input[contains(@value,'Submit')]"));
        submit.click();
        driver.wait();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);




        }


//    @AfterClass // Runs this method after all the test methods in the current class have been run
//    public void tearDown() {
//        // Close all browser windows and safely end the session
//        driver.quit();
//    }

}