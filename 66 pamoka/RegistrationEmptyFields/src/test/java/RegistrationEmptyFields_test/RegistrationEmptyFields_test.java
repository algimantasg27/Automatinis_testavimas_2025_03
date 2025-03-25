package RegistrationEmptyFields_test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationEmptyFields_test {

    WebDriver driver;

    @BeforeEach
    void beforeEachTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.112/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.partialLinkText("No account?")).click();
    }

    @AfterEach
    void afterEachTest(){

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Registration with Empty Required Fields")
    void testRegistrationWithEmptyFields() {

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String href = driver.getTitle();
        String expectedHref = "Registration";
        assertEquals(expectedHref, href);

//        Pagal puslapio link`a nesigauna patikrinti!!!
//        WebElement href = driver.findElement(By.xpath("/html/head/link[1]"));
//        String expectedHref = "http://192.168.1.112/registration";

    }

    @Test
    @DisplayName("Registration with Invalid Email Format")
    void testRegistrationWithInvalidEmailFormat() {

        driver.findElement(By.id("field-id_gender-1")).click();

        WebElement inputFirstname = driver.findElement(By.id("field-firstname"));
        inputFirstname.click();
        inputFirstname.sendKeys("Testas");

        WebElement inputLastname = driver.findElement(By.id("field-lastname"));
        inputLastname.click();
        inputLastname.sendKeys("Studentas");

        WebElement inputEmail = driver.findElement(By.id("field-email"));
        inputEmail.click();
        inputEmail.sendKeys("user@com");

        WebElement inputPassword = driver.findElement(By.id("field-password"));
        inputPassword.click();
        inputPassword.sendKeys("Qw3rtyu! 987 WeR@");

        WebElement inputBirthday = driver.findElement(By.id("field-birthday"));
        inputBirthday.click();
        inputBirthday.sendKeys("11/09/2001");

        driver.findElement(By.xpath("//input[@name='psgdpr']")).click();
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorText = driver.findElement(By.xpath("//li[@class='alert alert-danger']"));
        String expectedText = "Invalid format.";
        assertEquals(expectedText, errorText.getText());

        String href = driver.getTitle();
        String expectedHref = "Registration";
        assertEquals(expectedHref, href);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/invalid_registration_data.csv", numLinesToSkip = 3)
    void testFileLogins(String testCase, String firstname, String lastName, String email, String password, String expectedError) {

//        Kadangi narsykles is saves ismeta skirtingus error`us, tai negaliu aprasyti tu klaidu.
        driver.findElement(By.id("field-id_gender-1")).click();

        WebElement inputFirstname = driver.findElement(By.id("field-firstname"));
        inputFirstname.click();
        inputFirstname.sendKeys(firstname);

        WebElement inputLastname = driver.findElement(By.id("field-lastname"));
        inputLastname.click();
        inputLastname.sendKeys(lastName);

        WebElement inputEmail = driver.findElement(By.id("field-email"));
        inputEmail.click();
        inputEmail.sendKeys(email);

        WebElement inputPassword = driver.findElement(By.id("field-password"));
        inputPassword.click();
        inputPassword.sendKeys(password);

        WebElement inputBirthday = driver.findElement(By.id("field-birthday"));
        inputBirthday.click();
        inputBirthday.sendKeys("11/09/2001");

        driver.findElement(By.xpath("//input[@name='psgdpr']")).click();
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorText = driver.findElement(By.xpath("//li[@class='alert alert-danger']"));
//        String expectedText = expectedError;
        assertTrue(errorText.getText().contains(expectedError));

        String href = driver.getTitle();
        String expectedHref = "Registration";
        assertEquals(expectedHref, href);

    }

}
