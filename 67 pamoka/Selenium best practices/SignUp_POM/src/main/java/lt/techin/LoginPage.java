package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//a[normalize-space()='No account? Create one here']")
    private WebElement loginPage;

    @FindBy(id = "field-email")
    private WebElement inputEmailLogin;

    @FindBy(id = "field-password")
    private WebElement inputPasswordLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateAccountPage(){
        loginPage.click();
    }

    public void enterInputEmailLogin(String value) {
        inputEmailLogin.click();
        inputEmailLogin.sendKeys(value);
    }

    public void enterInputPasswordLogin(String value) {
        inputPasswordLogin.click();
        inputPasswordLogin.sendKeys(value);
    }
}
