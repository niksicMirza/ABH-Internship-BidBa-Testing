package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends PageObject{

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]")
  public WebElement categories;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]")
  public WebElement sorting_dropdown;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[2]")
  public WebElement newArrivalsSorting;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[5]")
  public WebElement firstHighPriceSorting;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[4]")
  public WebElement firstLowPriceSorting;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[3]")
  public WebElement lastChanceSorting;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]")
  public WebElement grid_view_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/button[2]")
  public WebElement list_view_button;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/h4[1]")
  public WebElement product_title;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
  public WebElement product_image;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/p[1]/span[1]")
  public WebElement product_price;

  @FindBy(className = "price")
  public WebElement product_prices;

  @FindBy(className = "desc")
  public WebElement product_description;

  @FindBy(xpath = "//body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
  public WebElement watchlist_button;

  @FindBy(id = "bid-button")
  public WebElement bid_button;

  public ShopPage(WebDriver driver) {
    super(driver);
  }


  public void newArrivalsSorting(){
    this.sorting_dropdown.click();
    this.newArrivalsSorting.click();
  }

  public void lowestPriceFirstSorting(){
    this.sorting_dropdown.click();
    this.firstLowPriceSorting.click();
  }

  public void highestPriceFirstSorting(){
    this.sorting_dropdown.click();
    this.firstHighPriceSorting.click();
    System.out.println("HIGHER FIRST");
  }

  public void lastChanceSorting(){
    this.sorting_dropdown.click();
    this.lastChanceSorting.click();
  }

  public void openProductAuction(){
    this.product_image.click();
  }

  public void listView(){
    this.list_view_button.click();
  }

  public void gridView(){
    this.grid_view_button.click();
  }
}