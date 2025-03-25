package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

    @FindBy(css = "#number1")
    private WebElement inputNumberOne;

    @FindBy(css = "#number2")
    private WebElement inputNumberTwo;

    @FindBy(id = "function")
    private WebElement mathSign;

    @FindBy(id = "calculate")
    private WebElement buttonSubmit;

    @FindBy(id = "answer")
    private WebElement answer;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterInputNumberFirst(String value) {
        inputNumberOne.click();
        inputNumberOne.sendKeys(value);
    }

    public void enterInputNumberTwo(String value) {
        inputNumberTwo.click();
        inputNumberTwo.sendKeys(value);
    }

    public void selectMathSign() {
        mathSign.click();
        Select selectSign = new Select(mathSign);
        selectSign.selectByValue("minus");
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }

    public String getAnswer() {
        return answer.getText();
    }

    public String getAnswerWithMinus (int value1, int value2) {
        int value;
        value = value1 - value2;

        return  Integer.toString(value);
    }

    public void setFunction(String operation) {
        Select functionSelect = new Select(mathSign);
        functionSelect.selectByValue(operation);
    }
}
