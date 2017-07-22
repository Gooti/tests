package com.tests.page.Registration;

import com.tests.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

/**
 * Created by Comarch on 2017-07-21.
 */
public class MainPage {

    @Autowired
    private Methods methods;

    public void setMethods(Methods methods) {
        this.methods = methods;
    }

    public void goToAktualnosci() {
        methods.click("//a[contains(.,'Aktualności')]", Methods.FindMode.XPATH);
    }

    public void goToOkonkursie() {
        methods.click("//a[contains(.,'O konkursie')]", Methods.FindMode.XPATH);
    }

    public void goToRejestracja() {
        methods.click("//a[contains(.,'Rejestracja')]", Methods.FindMode.XPATH);
    }

    public void goToHarmonogram() {
        methods.click("//a[contains(.,'Harmonogram')]", Methods.FindMode.XPATH);
    }

    public void goToZasady() {
        methods.click("//a[contains(.,'Zasady')]", Methods.FindMode.XPATH);
    }

    public void goToKomisja() {
        methods.click("//a[contains(.,'Komisja')]", Methods.FindMode.XPATH);
    }

    public void goToPatronaty() {
        methods.click("//a[contains(.,'Patronaty')]", Methods.FindMode.XPATH);
    }

    public void goToAll() {
        goToAktualnosci();
        goToOkonkursie();
        goToRejestracja();
        goToHarmonogram();
        goToZasady();
        goToKomisja();
        goToPatronaty();
    }

    public void imgPKClick() {
        methods.click("//img[contains(@src,'img/bcg03.png')]", Methods.FindMode.XPATH);
    }

    public void imgPKFP() {
        methods.click("//img[contains(@src,'img/compFP.png')]", Methods.FindMode.XPATH);
    }

    public void imgPKFB() {
        methods.click("//img[contains(@src,'img/img06.png')]", Methods.FindMode.XPATH);
    }
    //TODO dokonczyc przejmowanie okna
    public void imgClickAll() {
        imgPKClick();
        Methods.back();
        imgPKFP();
        Methods.back();
        imgPKFB();
        Methods.back();
        Methods.forward();
        Methods.back();
    }

    public void verificationMainTitle() {
        if (Methods.pageTitle().equals("Tadeusz Kościuszko - inżynier i żołnierz")) {
            System.out.println("Title correct - " + Methods.pageTitle());
        } else System.out.println("Title incorrect - " + Methods.pageTitle());
    }
}
