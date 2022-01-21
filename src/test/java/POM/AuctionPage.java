package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuctionPage extends PageObject{

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

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/p[1]/span[1]")
  public WebElement span;

  @FindBy(xpath = "//tbody/tr[1]/td[6]/p[1]")
  public WebElement span2;

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

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[1]/input[1]")
  public WebElement bid_input;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[1]/button[1]")
  public WebElement place_bid_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]")
  public WebElement bid_toastr;

  public AuctionPage(WebDriver driver) {
    super(driver);
  }

  public void openRegisterPage(){
    this.create_an_account_button.click();
  }

  public void openLoginPage(){
    this.log_in_button.click();
  }

  public void openAuctionPage(){
    this.bid_now_button.click();
  }

  public void logOut(){
    this.log_out_button.click();
  }

  public void clickOnLogo(){
    this.logo.click();
  }

  public void insertLowerAmount(){
    String price = this.span.getText();
    price = price.replace("$", "");
    int i =  Integer.parseInt(price);
    i = i - 1;
    String lower_bid = String.valueOf(i);
    this.bid_input.clear();
    this.bid_input.sendKeys(lower_bid);
  }

  public void insertHigherAmount(){
    String price = this.span.getText();
    price = price.replace("$", "");
    int i =  Integer.parseInt(price);
    i = i + 1;
    String highest_bid = String.valueOf(i);
    this.bid_input.clear();
    this.bid_input.sendKeys(highest_bid);
  }

  public void placeBid(){
    this.place_bid_button.click();
  }
}