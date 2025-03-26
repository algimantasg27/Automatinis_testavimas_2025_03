package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loadertwo extends BasePage{

    @FindBy(id = "appears")
    private WebElement newParagraph;

    public Loadertwo(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.id("appears"), "This is a new paragraph that appears after 8 seconds."));
    }

    public String getParagraphText () {

        return newParagraph.getText();
    }
}
