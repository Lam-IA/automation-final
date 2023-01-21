package org.qaway;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qaway.base.CommonAPI;
import org.qaway.pages.HomePage;
import org.qaway.pages.LoginPage;
import org.qaway.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPurchase extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestPurchase.class.getName());

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));
    @Test

    public void addItemToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // login
        loginPage.login(username,password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(homePage.productsHeaderIsDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // add item to cart
        System.out.println(homePage.getItem1Color());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage.addItem1ToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // check items gets black colored
        System.out.println(homePage.getItem1Color());
    }
}
