package com.tests.page.Registration;

import com.tests.Methods;
import com.tests.data.RegistrationData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Comarch on 2017-07-24.
 */
public class RegistrationPage {

    @Autowired
    private Methods methods;

    @FindBy(xpath="//select[contains(@name,'uProvince')]")
    private WebElement province;



    public RegistrationPage fillRegistrationElements(RegistrationData data){
        methods.fillElementFoundByName("uFirstname",data.getFirstName() );
        methods.fillElementFoundByName("uSurname",data.getSurName() );
//        Methods.selectByVisibleText(Methods.getElement("//select[contains(@name,'uProvince')]", Methods.FindMode.XPATH),data.getProvince());
//        Methods.selectByIndex(Methods.getElement("//select[contains(@name,'uProvince')]", Methods.FindMode.XPATH),3);
        Methods.selectByIndex(province,3);
        if(data.getCategory().equals("uczen")){
            Methods.click("//input[contains(@value,'U')]", Methods.FindMode.XPATH);
        } else Methods.click("//input[contains(@value,'S')]", Methods.FindMode.XPATH);
        methods.fillElementFoundByName("uSchool",data.getSchoolName() );
        methods.fillElementFoundByName("uLogin",data.getLogin() );
        methods.fillElementFoundByName("uPassA",data.getPassword() );
        methods.fillElementFoundByName("uPassB",data.getRepeatPassword() );
        methods.fillElementFoundByName("uMail",data.getMail() );
        methods.fillElementFoundByName("uCaptcha",data.getCaptcha());
    return this;
}
}
