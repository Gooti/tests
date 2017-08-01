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

    public RegistrationPage fillRegistrationElements(RegistrationData data){
        methods.fillElementFoundByName("uFirstname",data.getFirstName() );
        methods.fillElementFoundByName("uSurname",data.getSurName() );
//        Methods.selectByVisibleText(Methods.getElement("//select[contains(@name,'uProvince')]", Methods.FindMode.XPATH),data.getProvince());
        Methods.selectByIndex(Methods.getElement("//select[contains(@name,'uProvince')]", Methods.FindMode.XPATH),3);
//        Methods.selectByIndex(province,3);
        if(data.getCategory().equals("uczen")){
            Methods.click("//input[contains(@value,'U')]", Methods.FindMode.XPATH);
        } else Methods.click("//input[contains(@value,'S')]", Methods.FindMode.XPATH);
        methods.fillElementFoundByName("uSchool",data.getSchoolName() );
        setLogin();
        setPass();
        setMail();
        methods.fillElementFoundByName("uCaptcha",data.getCaptcha());
        Methods.click("//input[contains(@value,'Zarejestruj się!')]", Methods.FindMode.XPATH);
        error();

    return this;
    }

    public RegistrationPage error(){

        try{
            WebElement error = Methods.getElement("//font[contains(@class,'err-font')]", Methods.FindMode.XPATH);
            String err = error.getAttribute("textContent");
            if (!err.equals(null)){
                System.out.println(err);
                Methods.close();
            }
        }
        catch (NoSuchElementException e){
            System.out.println("All is ok");
        }
        return this;
    }

    public String setLogin(){
        String user = "User";
        String value = user +  RandomStringUtils.randomNumeric(3);
        methods.fillElementFoundByName("uLogin", value );
        System.out.println("Your Login is: " + value);

        return value;
    }

    public String setPass(){
        String value = RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3);
        methods.fillElementFoundByName("uPassA", value );
        methods.fillElementFoundByName("uPassB", value );
        System.out.println("Your Password is: " + value);
        return value;
    }

    public String setMail(){
        String mail = "mail";
        String value = RandomStringUtils.randomAlphabetic(3) + "@" +  RandomStringUtils.randomNumeric(4) + ".xyz";
        methods.fillElementFoundByName("uMail", value );
        System.out.println("Your Mail is: " + value);
        return value;
    }

    public String getLogin(){
        WebElement log = Methods.getElement("uLogin", Methods.FindMode.NAME);
        String login = log.getAttribute("value");
    return login;}

    public String getPass(){
        WebElement pass = Methods.getElement("uPassA", Methods.FindMode.NAME);
        String password = pass.getAttribute("value");
        return password;}

        public enum LogPass {LOGIN, PASSWORD}

    public String getValueName(String field, LogPass logPass){
        WebElement ele = Methods.getElement(field, Methods.FindMode.NAME);
        String element=null;
        switch(logPass) {
            case LOGIN:{
              element = ele.getAttribute("value");
              break;
        }
            case PASSWORD:{
              element = ele.getAttribute("value");
              break;
            }
        }
        return element;
        }
}
