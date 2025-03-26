package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    private WebElement title;

    @FindBy(linkText = "Sign out")
    WebElement buttonSignOut;

    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    WebElement customerAccount;

    @FindBy(linkText = "Information")
    WebElement information;

    @FindBy(id = "field-firstname")
    WebElement firstname;

    @FindBy(id = "field-lastname")
    WebElement lastname;

    @FindBy(id = "field-email")
    WebElement email;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return title.getText();
    }

    public void clickButtonSignOut() {
        buttonSignOut.click();
    }

    public void clickCustomerAccount() {
        customerAccount.click();
    }

    public void clickInformation() {
        information.click();
    }

    public String getFirstname() {
        return firstname.getDomAttribute("value");
    }

    public String getLastname() {
        return lastname.getDomAttribute("value");
    }

    public String getEmail() {
        return email.getDomAttribute("value");
    }

}
