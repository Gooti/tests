package com.tests.page.Registration;

import com.tests.Methods;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Comarch on 2017-07-22.
 */
public class PatronatyPage {
    @Autowired
    private Methods methods;

    public void nowinkiTextClick(){
        Methods.click("//a[contains(@href,'http://www.nowinki.pk.edu.pl')]", Methods.FindMode.XPATH);
    }
    public void nowinkiImgClick(){
        Methods.click("//img[contains(@src,'img/p/nowinki.png')]", Methods.FindMode.XPATH);
    }
    public void clickPatronatyAll(){
        nowinkiTextClick();
        Methods.back();
        nowinkiImgClick();
        Methods.back();
    }


}
