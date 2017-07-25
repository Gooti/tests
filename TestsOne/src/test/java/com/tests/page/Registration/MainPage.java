package com.tests.page.Registration;

import com.tests.Methods;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Comarch on 2017-07-21.
 */
public class MainPage {

    @Autowired
    private Methods methods;

    public void setMethods(Methods methods) {
        this.methods = methods;
    }

    public MainPage goToAktualnosci() {
        methods.click("//a[contains(.,'Aktualności')]", Methods.FindMode.XPATH);
    return this;
    }

    public MainPage goToOkonkursie() {
        methods.click("//a[contains(.,'O konkursie')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage goToRejestracja() {
        methods.click("//a[contains(.,'Rejestracja')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage goToHarmonogram() {
        methods.click("//a[contains(.,'Harmonogram')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage goToZasady() {
        methods.click("//a[contains(.,'Zasady')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage goToKomisja() {
        methods.click("//a[contains(.,'Komisja')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage goToPatronaty() {
        methods.click("//a[contains(.,'Patronaty')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage goToAll() {
        goToAktualnosci();
        goToOkonkursie();
        goToRejestracja();
        goToHarmonogram();
        goToZasady();
        goToKomisja();
        goToPatronaty();
        return this;
    }

    public MainPage imgPK() {
        methods.click("//img[contains(@src,'img/bcg03.png')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage imgPKFP() {
        methods.click("//img[contains(@src,'img/compFP.png')]", Methods.FindMode.XPATH);
        return this;
    }

    public MainPage imgPKFB() {
        methods.click("//img[contains(@src,'img/img06.png')]", Methods.FindMode.XPATH);
        return this;
    }


    public MainPage imgClickAll() {
        imgPK();
        Methods.back();
        imgPKFP();
        Methods.back();
        imgPKFB();
        Methods.back();
        Methods.forward();
        Methods.back();
        return this;
    }

    public MainPage verificationMainTitle() {
        if (Methods.pageTitle().equals("Tadeusz Kościuszko - inżynier i żołnierz")) {
            System.out.println("Title correct - " + Methods.pageTitle());
        } else System.out.println("Title incorrect - " + Methods.pageTitle());
    return this;
    }
}
