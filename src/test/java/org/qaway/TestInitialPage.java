package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.LoginPage;
import org.qaway.utility.ExcelReader;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class TestInitialPage extends CommonAPI { 
    Logger LOG = LogManager.getLogger(TestInitialPage.class.getName());

    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");
  
    @Test
    public void validateLandingPage() {

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("test pass");
    }
    @Test
    public void validateLoginPageElements(){
        LoginPage loginPage = new LoginPage(driver);
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
        LOG.info("page title validation succes");
        captureScreenshot("initialpage");

        boolean userNameIsDisplayed = loginPage.usernameFieldIsDisplayed();
        Assert.assertTrue(userNameIsDisplayed);
        LOG.info("username field is displayed");

        boolean passwordIsDisplayed = loginPage.passwordFieldIsDisplayed();
        Assert.assertTrue(passwordIsDisplayed);
        LOG.info("password field is displayed");

        boolean loginButtonIsDisplayed = loginPage.loginBtnIsDisplayed();

        Assert.assertTrue(loginButtonIsDisplayed);
        LOG.info("login button field is displayed");
    }

}







