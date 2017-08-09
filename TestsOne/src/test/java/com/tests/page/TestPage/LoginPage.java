package com.tests.page.TestPage;

import com.tests.Methods;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Gooti on 31.07.2017.
 */
public class LoginPage {
    @Autowired
    private Methods methods;


    public LoginPage setLoginData() {

        methods.fillElementFoundByName("uLogin", methods.getLogin());
        methods.fillElementFoundByName("uPass", methods.getPass());
        Methods.click("//input[contains(@value,'Zaloguj')]", Methods.FindMode.XPATH);
        System.out.println("Value of login: " + methods.getLogin());
        System.out.println("Value password is: " + methods.getPass());
        return this;
    }





}
