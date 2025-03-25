package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends BasePage{

    @FindBy(id = "field-id_gender-1")
    private WebElement fieldGender;

    @FindBy(id = "field-firstname")
    private WebElement inputFirstname;

    @FindBy(id = "field-lastname")
    private WebElement inputLasname;

    @FindBy(id = "field-email")
    private WebElement inputEmail;

    @FindBy(id = "field-password")
    private WebElement inputPassword;

    @FindBy(id = "field-birthday")
    private WebElement inputBirthday;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement psgdpr;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletter;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customPrivacy;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickFieldGender() {
        fieldGender.click();
    }

    public void enterInputFirstname(String value) {
        inputFirstname.click();
        inputFirstname.sendKeys(value);
    }

    public void enterInputLastname(String value) {
        inputLasname.click();
        inputLasname.sendKeys(value);
    }

    public void enterInputEmail(String value) {
        inputEmail.click();
        inputEmail.sendKeys(value);
    }

    public void enterInputPassword(String value) {
        inputPassword.click();
        inputPassword.sendKeys(value);
    }

    public void enterInputBirthday(String value) {
        inputBirthday.click();
        inputBirthday.sendKeys(value);
    }

    public void clickCheckBoxes() {
        psgdpr.click();
        newsletter.click();
        customPrivacy.click();
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }
}
