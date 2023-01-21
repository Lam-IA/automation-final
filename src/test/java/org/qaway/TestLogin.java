package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestLogin extends CommonAPI { // je rajoute extends CommonAPI
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    public TestLogin() throws ClassNotFoundException {
    }

    //@Test // il est connectée à la base de données
    public void loginWithValidCredential() {    //j'élimine "throws InterruptedException"
        LoginPage loginPage = new LoginPage(driver); // faut le mettre dans la méthode sinon ça ne va pas marcher
        HomePage homePage = new HomePage(driver); // juste pour cette méthode
   
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");

        // enter username
        System.out.println("enter username success");


        // enter password

        System.out.println("enter password success");

        // click login button
        loginPage.clickOnLoginButton();
        System.out.println("login button click succes");
        boolean productsHeaderIsDisplayed = homePage.productsHeaderIsDisplayed(); 
        Assert.assertTrue(productsHeaderIsDisplayed); 
        LOG.info("Products header is displayed success");
    }


    @Test
    public void loginAttemptWithoutUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");

        // enter username
        loginPage.typeUsername("");

        loginPage.typePassword(password);
        loginPage.clickOnLoginButton();
        LOG.info("login button click succes");
        String textError = loginPage.getErrorMessage();
        LOG.info("error message: "+ textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid username error message"), textError);
        LOG.info("error message validation succes");
    }

    @Test
    public void  loginAttemptWithoutPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");

        loginPage.typeUsername(username);
        loginPage.typePassword("");
        loginPage.clickOnLoginButton();
        LOG.info("login button click succes");
        String textError = loginPage.getErrorMessage();;
        LOG.info("error message: "+ textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid password error message"), textError);
        LOG.info("error message validation succes");
    }
}

