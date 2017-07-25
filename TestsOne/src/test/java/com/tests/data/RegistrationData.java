package com.tests.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Comarch on 2017-07-24.
 */
public class RegistrationData {
    private String firstName;
    private String surName;
    private WebElement province;
    private boolean categoryUczen;
    private boolean categoryStudent;
    private String schoolName;
    private String login;
    private String password;
    private String repeatPassword;
    private String mail;
    private String captcha;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public WebElement getProvince() {
        return province;
    }

    public void setProvince(WebElement province) {
        this.province = province;
    }

    public boolean isCategoryUczen() {
        return categoryUczen;
    }

    public void setCategoryUczen(boolean categoryUczen) {
        this.categoryUczen = categoryUczen;
    }

    public boolean isCategoryStudent() {
        return categoryStudent;
    }

    public void setCategoryStudent(boolean categoryStudent) {
        this.categoryStudent = categoryStudent;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
