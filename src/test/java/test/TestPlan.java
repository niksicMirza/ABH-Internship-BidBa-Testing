package test;
import POM.*;

import data.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class TestPlan {
  WebDriver driver;
  ChromeOptions options;
  @BeforeTest
  public void setUp() {
    // ChromeDriver location set up in Utils class
    System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    options = new ChromeOptions();
    options.setHeadless(true);
    driver = new ChromeDriver(options);
  }

  @Test(testName = "Smoke Test")
  public void smoke() throws InterruptedException {
    driver.get(Utils.HOME_PAGE_URL);
    driver.manage().window().maximize();

    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AuctionPage auctionPage = new AuctionPage(driver);
    ShopPage shopPage = new ShopPage(driver);

    assertEquals(Utils.HOME_PAGE_TITLE, driver.getTitle()); //check the title
    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl()); //check the URL
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed
    assertTrue(homePage.product_title.isDisplayed()); //check if product title is displayed
    assertTrue(homePage.product_image.isDisplayed()); //check if product image is displayed
    assertTrue(homePage.facebook_button.isDisplayed()); //check if facebook button is displayed
    assertTrue(homePage.instagram_button.isDisplayed()); //check if instagram button is displayed
    assertTrue(homePage.twitter_button.isDisplayed()); //check if twitter button is displayed
    assertTrue(homePage.skype_button.isDisplayed()); //check if skype button is displayed
    assertTrue(homePage.log_in_button.isDisplayed()); //check if log in is displayed
    assertTrue(homePage.create_an_account_button.isDisplayed()); //check if register button is displayed
/*
    homePage.openRegisterPage();
    assertEquals(Utils.REGISTER_PAGE_TITLE, driver.getTitle()); //check the title
    assertEquals(Utils.REGISTER_PAGE_URL, driver.getCurrentUrl()); //check the URL
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed
    assertTrue(registerPage.register_button.isDisplayed());  //check if register button is displayed

    registerPage.enterFirstName();
    assertFalse(registerPage.first_name.getAttribute("value").isEmpty());
    registerPage.enterLastName();
    assertFalse(registerPage.last_name.getAttribute("value").isEmpty());
    registerPage.enterEmail();
    assertFalse(registerPage.email_address.getAttribute("value").isEmpty());
    registerPage.enterPassword();
    assertFalse(registerPage.password.getAttribute("value").isEmpty());
    registerPage.clickRegisterButton();
    Thread.sleep(1000);*/
    homePage.logIn();

    assertEquals(Utils.LOGIN_PAGE_TITLE, driver.getTitle()); //check the title
    assertEquals(Utils.LOGIN_PAGE_URL, driver.getCurrentUrl()); //check the URL
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed

    loginPage.enterEmail();
    assertFalse(loginPage.email_address.getAttribute("value").isEmpty());
    loginPage.enterPassword();
    assertFalse(loginPage.password.getAttribute("value").isEmpty());
    loginPage.clickLoginButton();
    Thread.sleep(1000);

    assertEquals(Utils.HOME_PAGE_TITLE, driver.getTitle()); //check the title
    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl()); //check the URL
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed
    assertTrue(homePage.log_out_button.isDisplayed()); //check if log out button is displayed

    homePage.openAuctionPage();
    assertEquals(Utils.AUCTION_PAGE_TITLE, driver.getTitle()); //check the title
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed
    Thread.sleep(3000);
    //insert higher bid
    auctionPage.insertHigherAmount();
    assertFalse(auctionPage.bid_input.getAttribute("value").isEmpty());
    String input = auctionPage.bid_input.getAttribute("value");
    String inputValue1 = "$ " + input;
    auctionPage.placeBid();
    Thread.sleep(3000);
    Assert.assertEquals(driver.getCurrentUrl(), Utils.ACCOUNT_BIDS_PAGE_URL);
    String price = auctionPage.span2.getText();
    assertEquals(inputValue1, price);

    homePage.clickOnLogo();
    assertEquals(Utils.HOME_PAGE_TITLE, driver.getTitle()); //check the title
    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl()); //check the URL
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed

    homePage.openShopPage();
    Thread.sleep(2000);
    assertEquals(Utils.SHOP_PAGE_URL, driver.getCurrentUrl()); //check the URL
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed
    assertTrue(shopPage.product_image.isDisplayed()); //check if product image is displayed
    assertTrue(shopPage.product_title.isDisplayed()); //check if product title is displayed
    assertTrue(shopPage.product_price.isDisplayed()); //check if product price is displayed
    assertTrue(shopPage.sorting_dropdown.isDisplayed()); //check if sorting dropdown is displayed
    assertTrue(shopPage.categories.isDisplayed()); //check if categories box is displayed
    assertTrue(shopPage.grid_view_button.isDisplayed()); //check if grid view button is displayed
    assertTrue(shopPage.list_view_button.isDisplayed()); //check if list view button is displayed

    shopPage.listView();
    assertTrue(shopPage.bid_button.isDisplayed()); //check if bid button is displayed
    assertTrue(shopPage.watchlist_button.isDisplayed()); //check if watchlist button is displayed
    assertTrue(shopPage.product_description.isDisplayed()); //check if product description is displayed
    shopPage.gridView();
    Thread.sleep(1000);

    //check if image is clickable and if it opens auction page
    shopPage.openProductAuction();
    Thread.sleep(2000);
    homePage.logOut();
  }

  @Test(testName = "URL check")
  public  void URLCheck(){
    driver.get(Utils.HOME_PAGE_URL);
    driver.manage().window().maximize();
    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl());
  }

  @Test(testName = "Register form")
  public  void registerForm() throws InterruptedException {
    driver.get(Utils.REGISTER_PAGE_URL);
    driver.manage().window().maximize();

    RegisterPage registerPage = new RegisterPage(driver);

    assertEquals(Utils.REGISTER_PAGE_URL, driver.getCurrentUrl());
    registerPage.enterFirstName();
    assertFalse(registerPage.first_name.getAttribute("value").isEmpty());
    registerPage.enterLastName();
    assertFalse(registerPage.last_name.getAttribute("value").isEmpty());
    registerPage.enterEmail();
    assertFalse(registerPage.email_address.getAttribute("value").isEmpty());
    registerPage.enterPassword();
    assertFalse(registerPage.password.getAttribute("value").isEmpty());
    registerPage.clickRegisterButton();
    Thread.sleep(1000);
    assertEquals(Utils.LOGIN_PAGE_URL, driver.getCurrentUrl());
  }

  @Test(testName = "Login form")
  public  void loginForm() throws InterruptedException {
    driver.get(Utils.LOGIN_PAGE_URL);
    driver.manage().window().maximize();

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    assertEquals(Utils.LOGIN_PAGE_URL, driver.getCurrentUrl());

    loginPage.enterEmail();
    assertFalse(loginPage.email_address.getAttribute("value").isEmpty());
    loginPage.enterPassword();
    assertFalse(loginPage.password.getAttribute("value").isEmpty());
    loginPage.clickLoginButton();
    Thread.sleep(1000);
    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl());
    assertTrue(homePage.log_out_button.isDisplayed());
  }

  @Test(testName = "Logo Check")
  public  void logoCheck() throws InterruptedException {
    driver.get(Utils.REGISTER_PAGE_URL);
    driver.manage().window().maximize();

    HomePage homePage = new HomePage(driver);

    assertEquals(Utils.REGISTER_PAGE_URL, driver.getCurrentUrl());

    assertTrue(homePage.logo.isDisplayed());
    homePage.clickOnLogo();
    Thread.sleep(1000);
    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl());
  }

  @Test(testName = "Lower bid process")
  public void lowerBidProcess() throws InterruptedException {
    driver.get(Utils.LOGIN_PAGE_URL);
    driver.manage().window().maximize();

    HomePage homePage = new HomePage(driver);
    AuctionPage auctionPage = new AuctionPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    loginPage.enterEmail();
    assertFalse(loginPage.email_address.getAttribute("value").isEmpty());
    loginPage.enterPassword();
    assertFalse(loginPage.password.getAttribute("value").isEmpty());
    loginPage.clickLoginButton();

    Thread.sleep(1000);
    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl());
    assertTrue(homePage.log_out_button.isDisplayed());
    assertTrue(homePage.logo.isDisplayed());

    homePage.openAuctionPage();
    assertEquals(Utils.AUCTION_PAGE_TITLE, driver.getTitle());
    assertTrue(homePage.logo.isDisplayed()); //check if logo is displayed
    assertTrue(homePage.footer.isDisplayed()); //check if footer is displayed

    auctionPage.insertLowerAmount();
    assertFalse(auctionPage.bid_input.getAttribute("value").isEmpty());
    auctionPage.placeBid();
    assertEquals("There are higher bids than yours! You could give a second try!", auctionPage.bid_toastr.getAttribute("innerHTML"));
  }

  @Test(testName = "Logout")
  public  void logout() throws InterruptedException {
    driver.get(Utils.LOGIN_PAGE_URL);
    driver.manage().window().maximize();

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    loginPage.enterEmail();
    assertFalse(loginPage.email_address.getAttribute("value").isEmpty());
    loginPage.enterPassword();
    assertFalse(loginPage.password.getAttribute("value").isEmpty());
    loginPage.clickLoginButton();
    Thread.sleep(1000);

    assertEquals(Utils.HOME_PAGE_URL, driver.getCurrentUrl());
    assertTrue(homePage.log_out_button.isDisplayed());
    assertTrue(homePage.logo.isDisplayed());

    homePage.logOut();
    assertTrue(homePage.create_an_account_button.isDisplayed());
    assertTrue(homePage.log_in_button.isDisplayed());
  }

  @Test(testName = "Register form (negative)")
  public  void registerFormNegative() throws InterruptedException {
    driver.get(Utils.REGISTER_PAGE_URL);
    driver.manage().window().maximize();

    RegisterPage registerPage = new RegisterPage(driver);

    registerPage.clickRegisterButton();
    Thread.sleep(1000);
    assertEquals("First name field must not be empty!", registerPage.first_name_error.getText());
    assertEquals("Last name field must not be empty!", registerPage.last_name_error.getText());
    assertEquals("Email field must not be empty!",registerPage.email_error.getText());
    assertEquals("Password field must not be empty!", registerPage.password_error.getText());
  }

  @Test(testName = "Login form (negative)")
  public  void loginFormNegative() throws InterruptedException {
    driver.get(Utils.LOGIN_PAGE_URL);
    driver.manage().window().maximize();

    LoginPage loginPage = new LoginPage(driver);

    loginPage.clickLoginButton();
    Thread.sleep(1000);
    assertEquals("Email field must not be empty!", loginPage.email_error.getText());
    assertEquals("Password field must not be empty!", loginPage.password_error.getText());
  }

  @Test(testName = "Social Media Buttons")
  public  void socialMediaButtons(){
    driver.get(Utils.HOME_PAGE_URL);
    driver.manage().window().maximize();

    HomePage homePage = new HomePage(driver);
    homePage.openTwitterPage();
    List<String> browserTabs = new ArrayList<> (driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
    assertEquals(Utils.TWITTER_URL, driver.getCurrentUrl());
    driver.close();
    driver.switchTo().window(browserTabs.get(0));

    homePage.openInstagramPage();
    browserTabs = new ArrayList<> (driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
    assertEquals(Utils.INSTAGRAM_URL, driver.getCurrentUrl());
    driver.close();
    driver.switchTo().window(browserTabs.get(0));

    homePage.openFacebookPage();
    browserTabs = new ArrayList<> (driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
    assertEquals(Utils.FACEBOOK_URL, driver.getCurrentUrl());
    driver.close();
    driver.switchTo().window(browserTabs.get(0));

    homePage.openSkypePage();
    browserTabs = new ArrayList<> (driver.getWindowHandles());
    driver.switchTo().window(browserTabs.get(1));
    assertEquals(Utils.SKYPE_URL, driver.getCurrentUrl());
    driver.close();
    driver.switchTo().window(browserTabs.get(0));
  }

  @Test(testName = "Search Bar")
  public void search(){
      driver.get(Utils.HOME_PAGE_URL);
      driver.manage().window().maximize();

      HomePage homePage = new HomePage(driver);
      ShopPage shopPage =  new ShopPage(driver);

      String searchText = "Mona Lisa";
      homePage.searchBar(searchText);
      assertTrue(shopPage.product_image.isDisplayed());
      assertTrue(shopPage.product_price.isDisplayed());
      assertEquals(shopPage.product_title.getText(), searchText);
  }

  @AfterTest
  public void cleanUp(){
    driver.manage().deleteAllCookies();
    driver.quit();
  }
}