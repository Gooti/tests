package com.tests.page.TestPage;

import com.tests.Methods;
import com.tests.data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Comarch on 2017-07-24.
 */
public class TestPage {

    @Autowired
    private Methods methods;


    public Methods getMethods() {
        return methods;
    }

    public void setMethods(Methods methods) {
        this.methods = methods;
    }


    public TestPage question(TestData data) throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            String value = "//font[@class='m-font']//input[@name=\"q" + (i + 1) + "\" and @value=\"" + data.getQuest()[i] + "\"]";
            WebElement radiobt = Methods.getDriver().findElement(By.xpath(value));
            JavascriptExecutor executor = (JavascriptExecutor) Methods.getDriver();
            executor.executeScript("arguments[0].checked = true;", radiobt);

        }

        return this;
    }

}
