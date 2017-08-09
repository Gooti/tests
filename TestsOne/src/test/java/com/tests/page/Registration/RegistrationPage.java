package com.tests.page.Registration;

import com.tests.Methods;
import com.tests.data.RegistrationData;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Comarch on 2017-07-24.
 */
public class RegistrationPage {

    @Autowired
    private Methods methods;

    public Methods getMethods() {
        return methods;
    }

    public void setMethods(Methods methods) {
        this.methods = methods;
    }

    public RegistrationPage fillRegistrationElements(RegistrationData data) {
        methods.fillElementFoundByName("uFirstname", data.getFirstName());
        methods.fillElementFoundByName("uSurname", data.getSurName());
        Methods.selectByIndex(Methods.getElement("//select[contains(@name,'uProvince')]", Methods.FindMode.XPATH), 3);
        if (data.getCategory().equals("uczen")) {
            Methods.click("//input[contains(@value,'U')]", Methods.FindMode.XPATH);
        } else Methods.click("//input[contains(@value,'S')]", Methods.FindMode.XPATH);
        methods.fillElementFoundByName("uSchool", data.getSchoolName());
        methods.fillElementFoundByName("uLogin", methods.getLogin());
        methods.fillElementFoundByName("uPassA", methods.getPass());
        methods.fillElementFoundByName("uPassB", methods.getPass());
        setMail();
        System.out.println("Your login is: " + methods.getLogin());
        System.out.println("Your password is: " + methods.getPass());
        methods.fillElementFoundByName("uCaptcha", data.getCaptcha());
        Methods.click("//input[contains(@value,'Zarejestruj się!')]", Methods.FindMode.XPATH);
        error();

        return this;

    }


    public RegistrationPage error() {

        try {
            WebElement error = Methods.getElement("//font[contains(@class,'err-font')]", Methods.FindMode.XPATH);
            String err = error.getAttribute("textContent");
                System.out.println(err);
                Methods.close();

        } catch (NoSuchElementException e) {
            System.out.println("All is ok");
        }
        return this;
    }


    public String setMail() {
        String mail = "mail";
        String value = RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomNumeric(4) + ".xyz";
        methods.fillElementFoundByName("uMail", value);
        System.out.println("Your Mail is: " + value);
        return value;
    }


}
