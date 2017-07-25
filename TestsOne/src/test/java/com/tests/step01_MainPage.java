package com.tests;

/**
 * Created by Gooti on 26.10.2016.
 */
import com.tests.page.Registration.MainPage;
import com.tests.page.Registration.PatronatyPage;
import com.tests.page.Registration.ZasadyPage;
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

    @Test (description = "1. Start a main page, click every bookmark and every image - hyperlink on a main page.")
    public void mainPage() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.verificationMainTitle()
                .goToAll();
        methods.setMainPageRegistration();
        mainPage.imgClickAll();
    }

    @Test (description = "2. Set 'Patronaty' page and check all every hyperlink.")
        public void patronatyPage() throws InterruptedException {
            MainPage mainPage = new MainPage();
            mainPage.goToPatronaty();
            PatronatyPage patronaty = new PatronatyPage();
            patronaty.clickPatronatyAll();
    }

    @Test (description = "3. Set 'Zasady' page and check every every document - link and img.")
    public void zasadyPage() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.goToZasady();
        ZasadyPage zasady = new ZasadyPage();
        zasady.clickZasadyAll();
        methods.setMainPageRegistration();
    }

    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        methods.quit();
    }


}