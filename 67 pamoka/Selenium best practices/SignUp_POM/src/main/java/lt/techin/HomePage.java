package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    private WebElement homePage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInPage() {
        homePage.click();
    }
}
