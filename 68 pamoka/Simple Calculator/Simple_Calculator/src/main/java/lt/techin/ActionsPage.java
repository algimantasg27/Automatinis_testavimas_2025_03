package lt.techin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class ActionsPage extends BasePage{

    @FindBy(xpath = "//div[@class='col-6']//p[@id='doubClickStartText']")
    WebElement actionButton;

    public ActionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickActionButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(actionButton)
                .keyDown(Keys.SHIFT)
                .click(actionButton)
                .perform();


    }
}
