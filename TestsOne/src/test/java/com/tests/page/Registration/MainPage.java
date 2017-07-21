package com.tests.page.Registration;

import com.tests.Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    public static void goToAktualnosci() {
        WebElement buttonAktualnosci = Methods.getElement("//a[contains(.,'Aktualności')]", Methods.FindMode.XPATH);
        Methods.clickVisibled(buttonAktualnosci);
    }

    public static void goToOkonkursie() {
        WebElement buttonOkonkursie = Methods.getElement("//a[contains(.,'O konkursie')]", Methods.FindMode.XPATH);
        Methods.clickVisibled(buttonOkonkursie);
    }

    public static void goToRejestracja() {
        WebElement buttonRejestracja = Methods.getElement("//a[contains(.,'Rejestracja')]", Methods.FindMode.XPATH);
        Methods.clickVisibled(buttonRejestracja);
    }

    public static void goToHarmonogram() {
        WebElement buttonHarmonogram = Methods.getElement("//a[contains(.,'Harmonogram')]", Methods.FindMode.XPATH);
        Methods.clickVisibled(buttonHarmonogram);
    }

    public static void goToZasady() {
        WebElement buttonZasady = Methods.getElement("//a[contains(.,'Zasady')]", Methods.FindMode.XPATH);
        Methods.clickVisibled(buttonZasady);
    }

    public static void goToKomisja() {
        WebElement buttonKomisja = Methods.getElement("//a[contains(.,'Komisja')]", Methods.FindMode.XPATH);
        Methods.clickVisibled(buttonKomisja);
    }
    public static void goToPatronaty() {
        WebElement buttonPatronaty = Methods.getElement("//a[contains(.,'Patronaty')]", Methods.FindMode.XPATH);
        Methods.clickVisibled(buttonPatronaty);
    }

    public static void goToAll() {
        goToAktualnosci();
        goToOkonkursie();
        goToRejestracja();
        goToHarmonogram();
        goToZasady();
        goToKomisja();
        goToPatronaty();
    }


}
