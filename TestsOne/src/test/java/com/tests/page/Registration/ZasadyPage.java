package com.tests.page.Registration;

import com.tests.Methods;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Comarch on 2017-07-22.
 */
public class ZasadyPage {
    @Autowired
    private Methods methods;

    public void downloadRKIMG(){
        Methods.click("//a[contains(@href,'files/RegulaminKonkursu.pdf')]//img", Methods.FindMode.XPATH);
    }
    public void downloadHKIMG(){
        Methods.click("//a[contains(@href,'files/files/HarmonogramKonkursu.pdf')]//img", Methods.FindMode.XPATH);
    }
    public void downloadWLIMG(){
        Methods.click("//a[contains(@href,'files/WykazLiteratury.pdf')]//img", Methods.FindMode.XPATH);
    }

    public void downloadRKTEXT(){
        Methods.click("//a[contains(.,'Pobierz regulamin konkursu')]", Methods.FindMode.XPATH);
    }

    public void downloadHKTEXT(){
        Methods.click("//a[contains(.,'Pobierz harmonogram konkursu')]", Methods.FindMode.XPATH);
    }

    public void downloadWLTEXT(){
        Methods.click("//a[contains(.,'Pobierz wykaz literatury')]", Methods.FindMode.XPATH);
    }

    public void clickZasadyAll(){
        downloadRKIMG();
        Methods.back();
        downloadRKTEXT();
        Methods.close();
        downloadHKIMG();
        Methods.back();
        downloadHKTEXT();
        Methods.close();
        downloadWLIMG();
        Methods.back();
        downloadWLTEXT();
        Methods.closeTab();
        methods.setMainPageRegistration();
    }
}
