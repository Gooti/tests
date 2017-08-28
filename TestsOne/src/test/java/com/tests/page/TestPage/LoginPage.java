package com.tests.page.TestPage;

import com.tests.Methods;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gooti on 31.07.2017.
 */
public class LoginPage {
    @Autowired
    private Methods methods;

    public LoginPage setData() {
        setLoginData();
        checkCorrect();
        checkError();
        return this;
    }


    public LoginPage setLoginData() {

        methods.fillElementFoundByName("uLogin", methods.getLogin());
        methods.fillElementFoundByName("uPass", methods.getPass());
        Methods.click("//input[contains(@value,'Zaloguj')]", Methods.FindMode.XPATH);
        System.out.println("Value of login: " + methods.getLogin());
        System.out.println("Value password is: " + methods.getPass());
        return this;

    }

    public LoginPage checkError() {
        try {
            WebElement error = Methods.getElement("//font[contains(@class,'err-font')]", Methods.FindMode.XPATH);
            String err = error.getAttribute("textContent");
            if (!err.equals(null)) {
                System.out.println(err);
            }
        } catch (NoSuchElementException e) {

        }

        return this;
    }

    public LoginPage checkCorrect() {
        try {
            WebElement error = Methods.getElement("//font[contains(@class,'correct-font')]", Methods.FindMode.XPATH);
            String err = error.getAttribute("textContent");
            if (!err.equals(null)) {
                System.out.println(err);
            }
        } catch (NoSuchElementException e) {

        }

        return this;
    }


}
