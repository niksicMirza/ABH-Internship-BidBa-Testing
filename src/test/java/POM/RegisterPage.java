package POM;

import data.GenerateCredentials;
import data.Utils;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.Matchers.equalTo;

public class RegisterPage extends PageObject{

  GenerateCredentials generateCredentials = new GenerateCredentials();
  public final String FIRST_NAME = "Tester";
  public final String LAST_NAME = "Tester";
  public final String EMAIL_ADDRESS = generateCredentials.emailAddressGenerator();
  public final String PASSWORD = "123456";

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[1]/input[1]")
  public WebElement first_name;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[2]/div[1]/input[1]")
  public WebElement last_name;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[3]/div[1]/input[1]")
  public WebElement email_address;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[4]/div[1]/input[1]")
  public WebElement password;

  @FindBy(xpath = "//input[@id='register_btn']")
  public WebElement register_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[1]/span[1]")
  public WebElement first_name_error;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[2]/div[1]/span[1]")
  public WebElement last_name_error;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[3]/div[1]/span[1]")
  public WebElement email_error;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/form[1]/div[4]/div[1]/span[1]")
  public WebElement password_error;

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  public void enterFirstName(){
    this.first_name.clear();
    this.first_name.sendKeys(FIRST_NAME);
  }

  public void enterLastName(){
    this.last_name.clear();
    this.last_name.sendKeys(LAST_NAME);
  }

  public void enterEmail(){
    this.email_address.clear();
    this.email_address.sendKeys(EMAIL_ADDRESS);
  }

  public void enterPassword(){
    this.password.clear();
    this.password.sendKeys(PASSWORD);
  }

  public void clickRegisterButton(){
    this.register_button.sendKeys(Keys.ENTER);
  }
}
