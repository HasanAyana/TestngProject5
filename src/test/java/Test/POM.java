package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class POM {

    public POM(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(css = "[type='submit']")
    public WebElement loginButton;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(css = "[class='nav-icon fas fa-book']")
    public WebElement catalog;
    @FindBy(css = "[class='nav-icon fas fa-shopping-cart']")
    public WebElement sale;
    @FindBy(css = "[class='nav-icon far fa-user']")
    public WebElement customer;
    @FindBy(css = "[class='nav-icon fas fa-tags']")
    public WebElement promotions;
    @FindBy(css = "[class='nav-icon fas fa-cubes']")
    public WebElement contentmanager;
    @FindBy(css = "[class='nav-icon fas fa-cogs']")
    public WebElement configuration;
    @FindBy(css = "[class='nav-icon fas fa-cube']")
    public WebElement system;
    @FindBy(css = "[class='nav-icon fas fa-chart-line']")
    public WebElement reports;
    @FindBy(css = "[class='nav-icon fas fa-question-circle']")
    public WebElement help;
    @FindBy(css = "li[class='nav-item']>a>p")
    public List<WebElement> helpText;
    @FindBy(xpath = "(//i[@class='nav-icon far fa-dot-circle']/following::p)[18]")
    public WebElement customerss;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement addButton;
    @FindBy(name = "Gender")
    public WebElement male;
    @FindBy(name = "save")
    public WebElement save;
    @FindBy(id = "DateOfBirth")
    public WebElement date;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement onay;
    @FindBy(id = "SearchEmail")
    public WebElement searchEmail;
    @FindBy(id = "search-customers")
    public WebElement search;
    @FindBy(xpath = "//i[@class='fas fa-check true-icon']")
    public WebElement userControl;
    @FindBy(css = "[class='fas fa-pencil-alt']")
    public WebElement edit;
    @FindBy(css = "[data-card-name='customer-info']")
    public WebElement customerInfo;
    @FindBy(id = "[id='FirstName']")
    public WebElement firstName;
    @FindBy(id = "customer-delete")
    public WebElement customerDelete;
    @FindBy(css = "[placeholder='Search']")
    public WebElement searchInput;
    @FindBy(css = "[class='tt-highlight']")
    public WebElement sipments;
    @FindBy(css = "button[class='btn btn-danger float-right']")
    public WebElement delete2;

}