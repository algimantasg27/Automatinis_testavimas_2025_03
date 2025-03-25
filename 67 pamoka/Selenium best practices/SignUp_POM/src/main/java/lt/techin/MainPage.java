package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(xpath = "//span[@class='hidden-sm-down']")
    private WebElement title;

    @FindBy(linkText = "Sign out")
    WebElement buttonSignOut;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return title.getText();
    }

    public void clickButtonSignOut() {
        buttonSignOut.click();
    }

}
