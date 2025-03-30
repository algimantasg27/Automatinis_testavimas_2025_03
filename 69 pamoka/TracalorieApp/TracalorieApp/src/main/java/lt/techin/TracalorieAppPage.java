package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;
import java.util.List;

import static java.lang.Integer.parseInt;
//import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

public class TracalorieAppPage extends BasePage{

    @FindBy(css = ".fc-cta-consent > p:nth-child(2)")
    WebElement popUp;

    @FindBy(xpath = "//*[@id='item-name']")
    private WebElement addItem;

    @FindBy(xpath = "//*[@id='item-calories']")
    private WebElement addCalories;

    @FindBy(css = ".add-btn")
    private WebElement mealButton;

//    @FindBy(css = "#item-0 > strong:nth-child(1)")
    @FindBy(css = "#item-list li:last-child > strong:nth-child(1)")
    private WebElement firstItem;

    @FindBy(css = "#item-list li:last-child > em:nth-child(2)")
    private WebElement firstCalories;

    @FindBy(css = ".total-calories")
    WebElement totalCalories;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/a")
    WebElement editItem;

    @FindBy(xpath = "/html/body/div[1]/div/div/form/div/button[3]")
    WebElement buttonDeleteMeal;

    int sumTotalCalories = 0;
    List<String> items;
    List<String> calories;

    public TracalorieAppPage(WebDriver driver) {
        super(driver);
    }

    public void clickPopUp() {
        popUp.click();
    }

    public void enterAddItem(String value) {
        addItem.sendKeys(value);
//        items.add(value);
    }

    public void enterAddCalorios(String value) {
        addCalories.sendKeys(value);
        sumTotalCalories += parseInt(value);
//        calories.add(value);
    }

    public void addMeal() {
        mealButton.click();
    }

    public String firstItemMeal() {
        return firstItem.getText();

    }

    public String firstCalories() {
        return firstCalories.getText();
    }

    public String getTotalCalories() {
        return totalCalories.getText();
    }

    public String getSumTotalCalories() {

        return Integer.toString(sumTotalCalories);
    }

    public void pushEditItem() {
        editItem.click();
    }

    public void pushButtonDeleteMeal() {
        buttonDeleteMeal.click();
    }

    public void printLists() {
        for (int i = 0; items.size() > i; i++) {
            System.out.println(items.get(i));
        }
        for (int i = 0; calories.size() > i; i++) {
            System.out.println(calories.get(i));
        }
    }
}
