import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

@Test
     void main() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement inputUsername = driver.findElement(By.id("username"));
        inputUsername.sendKeys("student");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("Password123");

//        WebElement clickSubmit = driver.findElement(By.id("submit"));
//        clickSubmit.click();

        driver.findElement(By.id("submit")).click();
//        driver.quit();

        WebElement title = driver.findElement(By.cssSelector(".post-title"));

//        System.out.println(title.getText());
//        String expectedTitle = "Practice Test Automation - Login";

        String expectedMessage = "Logged In Successfully";
        assertEquals(expectedMessage, title.getText());

//        String expectedTitle = "Logged In Successfully | Practice Test Automation";
//        String actualTitle = driver.getTitle();
//        assertEquals(expectedTitle, actualTitle);

//        driver.quit();

    }

@Test
    void Test2 () {

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://practicetestautomation.com/practice-test-login/");

    WebElement inputUsername = driver.findElement(By.id("username"));
    inputUsername.sendKeys("incorrectUser");

    WebElement inputPassword = driver.findElement(By.id("password"));
    inputPassword.sendKeys("Password123");

    driver.findElement(By.id("submit")).click();

    WebElement title = driver.findElement(By.id("error"));
    String expectedMessage = "Your username is invalid!";
    assertEquals(expectedMessage, title.getText());

    }

    @Test
    void Test3 () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement inputUsername = driver.findElement(By.id("username"));
        inputUsername.sendKeys("student");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("incorrectPassword");

        driver.findElement(By.id("submit")).click();

        WebElement title = driver.findElement(By.id("error"));
        String expectedMessage = "Your password is invalid!";
        String actualTitle = title.getText();
        assertEquals(expectedMessage, actualTitle);

    }

    @Test
    public void checkThatJavaMavenAndJUnitAreInstalled() {
    assertTrue(true);
    }
}
