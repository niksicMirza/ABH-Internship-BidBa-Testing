package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]")
  public WebElement logo;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/a[1]")
  public WebElement log_in_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/button[1]")
  public WebElement log_out_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[3]/a[1]")
  public WebElement create_an_account_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/a[1]")
  public WebElement bid_now_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/span[2]/a[1]")
  public WebElement shop_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[1]")
  public WebElement new_arrivals_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/button[2]")
  public WebElement last_chance_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
  public WebElement facebook_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]")
  public WebElement instagram_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]")
  public WebElement twitter_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[4]")
  public WebElement skype_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/h4[1]")
  public WebElement product_title;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[3]/img[1]")
  public WebElement product_image;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/footer[1]")
  public WebElement footer;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/button[1]/a[1]")
  public WebElement my_account_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")
  public WebElement search_bar;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void openRegisterPage(){
    this.create_an_account_button.click();
  }

  public void openAuctionPage(){
    this.bid_now_button.click();
  }

  public void logOut(){
    this.log_out_button.click();
  }

  public void logIn(){
    this.log_in_button.click();
  }

  public void clickOnLogo(){
    this.logo.click();
  }

  public void openShopPage(){
    this.shop_button.click();
  }

  public void openMyAccountPage(){
    this.my_account_button.click();
  }

  public void openFacebookPage(){
    this.facebook_button.click();
  }

  public void openInstagramPage(){
    this.instagram_button.click();
  }

  public void openTwitterPage(){
    this.twitter_button.click();
  }

  public void openSkypePage(){
    this.skype_button.click();
  }

  public void searchBar(String text){
    this.search_bar.sendKeys(text);
    this.search_bar.sendKeys(Keys.ENTER);
  }

}
