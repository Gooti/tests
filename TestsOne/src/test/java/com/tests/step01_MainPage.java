package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import com.tests.page.Registration.MainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@ContextConfiguration("testone.xml")
public class step01_MainPage extends AbstractTestNGSpringContextTests {

    @Autowired
    private Methods methods;

    public void setMethods(Methods methods) {
        this.methods = methods;
    }

    @BeforeClass
    public void setUp() {

        methods.setMainPageRegistration();
    }

    @Test
    public void mainPage() throws InterruptedException {
        MainPage mainPage = new MainPage();
//        mainPage.verificationMainTitle();
//        mainPage.goToAll();
//        methods.setMainPageRegistration();
//        mainPage.imgClickAll();

//        mainPage.goToPatronaty();
//        PatronatyPage patronaty = new PatronatyPage();
//        patronaty.clickPatronatyAll();




        /*TODO dokonczyc przejmowanie okna i zamkniecie
        mainPage.goToZasady();
        ZasadyPage zasady = new ZasadyPage();
        zasady.clickZasadyAll();*/
    }


    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        methods.quit();
    }



}