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

//    LoginPage loginPage = new LoginPage(driver); // on crée des objets génériques
//    HomePage homePage = new HomePage(driver); // pour avoir accès à driver qu'on a crée dans CommonAPI


    // je fais appel à config.properties

//    String username = prop.getProperty("username");
//    String password = prop.getProperty("password");


    // tant que j'ai rajouté decod dans Utility, je dois décoder mes coordonées

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    // on se connecte à DB "classeDB"
    //ConnectDB connectDB = new ConnectDB();

    //tring dbUsername = connectDB.getTableColumnData("select * from cred", "username").get(0);
    //String dbPassword= connectDB.getTableColumnData("select * from cred", "password").get(0);

    public TestLogin() throws ClassNotFoundException {
    }


    // on va créer un autre test
    //@Test // il est connectée à la base de données
    public void loginWithValidCredential() {    //j'élimine "throws InterruptedException"
        LoginPage loginPage = new LoginPage(driver); // faut le mettre dans la méthode sinon ça ne va pas marcher
        HomePage homePage = new HomePage(driver); // juste pour cette méthode
        // je crée des objets ici
        // check user land and the right page
        // pour pouvoir utiliser de LoginPage dans TestLogin et je crée des objets
//        LoginPage loginPage = new loginPage(); // il est générique je le met accessible pour toutes les méthodes
//        String expected = "Swag Labs";
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
//        System.out.println("page title validation succes");
        LOG.info("page title validation succes");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
        // j'utilise l'objet loginPage pour appeler la méthode type
//        loginPage.typeUsername(username);
        //loginPage.typeUsername(dbUsername);
//        loginPage.typeUsername("standard_user");
//        type("#user-name", "standard_user");
        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindée ou pas
        System.out.println("enter username success");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");
        // j'utilise l'objet loginPage pour appeler la méthode type
//        loginPage.typePassword(password);
        //loginPage.typePassword(dbPassword);
//        type("#password", "secret_sauce");
        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
        // Assert.assertTrue(passwordIsDisplayed);
        System.out.println("enter password success");
//        Thread.sleep(3000);
//        waitFor(3);

        // click login button
//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        loginButtonFiled.click();
        // j'utilise l'objet loginPage pour appeler la méthode type
        loginPage.clickOnLoginButton();
//        clickOn("#login-button"); // ne prend plus des strings plutot des WebElement
        // boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
        System.out.println("login button click succes");
        // je clique sur le boutton "LOGIN" et je vérifie si ça marche ou pas
//        WebElement productsHeader = driver.findElement(By.cssSelector(".title")); // on récupere le css selector
//        boolean productsHeaderIsDisplayed = productsHeader.isDisplayed();
//        boolean productsHeaderIsDisplayed = isDisplayed(".title");
        boolean productsHeaderIsDisplayed = homePage.productsHeaderIsDisplayed(); // productsHeader n'est pas dans la page,
        // donc on va créer une nouvelle classe HomePage
        Assert.assertTrue(productsHeaderIsDisplayed); // par contre cette étape nécéssite une validation
//        System.out.println("Products header is displayed success");
        LOG.info("Products header is displayed success");
//        Thread.sleep(3000);
//        waitFor(3);
    }


    @Test
    public void loginAttemptWithoutUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        // check user land and the right page
//        String expected = "Swag Labs";
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
//        System.out.println("page title validation succes");
        LOG.info("page title validation succes");
//        Thread.sleep(3000);
//        waitFor(3);


        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
        // j'utilise l'objet loginPage pour appeler la méthode type
        loginPage.typeUsername("");
//        type("#user-name", "");
        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindée ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");

//        type("#password", "secret_sauce");
        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//        Thread.sleep(3000);
//        waitFor(3);

//        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("");// envoyer une certaine formation
//        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
//        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindé ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//
//        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");
//        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
//        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//        Thread.sleep(3000);

        // click login button
//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        loginButtonFiled.click();
        // j'utilise l'objet loginPage pour appeler la méthode type
        loginPage.typePassword(password);
//        clickOn("#login-button");
        // boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
        loginPage.clickOnLoginButton();
//        System.out.println("login button click succes");
        LOG.info("login button click succes");
        // je clique sur le boutton "LOGIN" et je vérifie si ça marche ou pas
//        WebElement errorAlert = driver.findElement(By.cssSelector(".error-message-container.error")); // on récupere le css selector
        // boolean productsHeaderIsDisplayed = productsHeader.isDisplayed(); // il ne s'agit pas de vérifier
//        String textError = errorAlert.getText();// je mets le text dans un string
//        String textError = getWebElementText(".error-message-container.error");
        //on remplace le dessus ainsi:
        String textError = loginPage.getErrorMessage();
//        System.out.println("error message: "+ textError);
        LOG.info("error message: "+ textError);
//        Assert.assertEquals("Epic sadface: Username is required",textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid username error message"), textError);
//        System.out.println("error message validation succes");
        LOG.info("error message validation succes");
        //Assert.assertTrue(productsHeaderIsDisplayed); // par contre cette étape nécéssite une validation
//        Thread.sleep(3000);
//        waitFor(3);
    }

    @Test
    public void  loginAttemptWithoutPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        // check user land and the right page
//        String expected = "Swag Labs";
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "login page title");
//        String actual = driver.getTitle();
        String actual = getPageTitle();
        Assert.assertEquals(expected, actual);
//        System.out.println("page title validation succes");
        LOG.info("page title validation succes");
//        Thread.sleep(3000);
//        waitFor(3);

        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
        // j'utilise l'objet loginPage pour appeler la méthode type
        loginPage.typeUsername(username);
//        type("#user-name", "standard_user");
        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindée ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//        waitFor(3);
        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("secret_sauce");
        // j'utilise l'objet loginPage pour appeler la méthode type
        loginPage.typePassword("");
//        type("#password", "");
        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//
//        waitFor(3);
//        // enter username
//        WebElement usernameFiled=driver.findElement(By.id("user-name"));
//        usernameFiled.sendKeys("standard_user");// envoyer une certaine formation
//        // boolean userNameIsDisplayed = usernameFiled.isDisplayed(); on enleve les validations
//        // Assert.assertTrue(userNameIsDisplayed); // on va l'enlever cette étape car on ne va pas décider si elle est cindé ou pas
//        System.out.println("enter username success");
//        Thread.sleep(3000);
//
//        // enter password
//        WebElement passwordFiled=driver.findElement(By.id("password"));
//        passwordFiled.sendKeys("");
//        // boolean passwordIsDisplayed = usernameFiled.isDisplayed();
//        // Assert.assertTrue(passwordIsDisplayed);
//        System.out.println("enter password success");
//        Thread.sleep(3000);

        // click login button
//        WebElement loginButtonFiled=driver.findElement(By.id("login-button"));
//        loginButtonFiled.click();
        // j'utilise l'objet loginPage pour appeler la méthode type
//        clickOn("#login-button");
        // boolean loginButtonIsDisplayed = usernameFiled.isDisplayed();
        loginPage.clickOnLoginButton();
//        System.out.println("login button click succes");
        LOG.info("login button click succes");
        // je clique sur le boutton "LOGIN" et je vérifie si ça marche ou pas
//        WebElement errorAlert = driver.findElement(By.cssSelector(".error-message-container.error")); // on récupere le css selector
        // boolean productsHeaderIsDisplayed = productsHeader.isDisplayed(); // il ne s'agit pas de vérifier
//        String textError = errorAlert.getText();// je mets le text dans un string
        //on remplace le dessus ainsi:
        String textError = loginPage.getErrorMessage();
//        String textError = getWebElementText(".error-message-container.error");
//        System.out.println("error message: "+ textError);
        LOG.info("error message: "+ textError);
//        Assert.assertEquals("Epic sadface: Password is required",textError);
        Assert.assertEquals(excelReader.getDataForGivenHeaderAndKey("key", "invalid password error message"), textError);
//        System.out.println("error message validation succes");
        LOG.info("error message validation succes");
        //Assert.assertTrue(productsHeaderIsDisplayed); // par contre cette étape nécéssite une validation
//        Thread.sleep(3000);
//        waitFor(3);
    }
}


// Remarque: quand on a modifié le System.out.println par LOG.info et q'uon a compilé ce test on a pas eu
// de log, on est obligé de rajouter le ficher log4j2.xml dans ressources pour que ça m'affiche ces log
// grace à <AppenderRef ref="Console"/>
// on peut meme les mettre dans un fichier    <AppenderRef ref="file"/>
