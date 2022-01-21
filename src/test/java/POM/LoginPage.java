package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

  public final String EMAIL_ADDRESS = "user1@gmail.com";
  public final String PASSWORD = "123123";

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]")
  public WebElement login_form;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[1]/input[1]")
  public WebElement email_address;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[2]/div[1]/input[1]")
  public WebElement password;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[3]/input[1]")
  public WebElement remember_me_checkbox;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[4]/input[1]")
  public WebElement login_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[1]/span[1]")
  public WebElement email_error;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[2]/div[1]/span[1]")
  public WebElement password_error;



  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void enterEmail(){
    this.email_address.clear();
    this.email_address.sendKeys(EMAIL_ADDRESS);
  }

  public void enterPassword(){
    this.password.clear();
    this.password.sendKeys(PASSWORD);
  }

  public void checkRememberMe(){
    this.remember_me_checkbox.click();
  }

  public void clickLoginButton(){
    this.login_button.click();
  }
}

