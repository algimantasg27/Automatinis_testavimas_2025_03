package PretashopRegistration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PretashopRegistration_test {

    @Test
    @DisplayName("Successful Signup")
    void testRegistration() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.112/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.partialLinkText("No account?")).click();

        driver.findElement(By.id("field-id_gender-1")).click();

        WebElement inputFirstname = driver.findElement(By.id("field-firstname"));
        inputFirstname.click();
        inputFirstname.sendKeys("Testas");

        WebElement inputLastname = driver.findElement(By.id("field-lastname"));
        inputLastname.click();
        inputLastname.sendKeys("Studentas");

        WebElement inputEmail = driver.findElement(By.id("field-email"));
        inputEmail.click();
        String email = "user" + System.currentTimeMillis() + "@test.com";
        inputEmail.sendKeys(email);
//        inputEmail.sendKeys("user" + System.currentTimeMillis() + "@test.com");

        WebElement inputPassword = driver.findElement(By.id("field-password"));
        inputPassword.click();
        inputPassword.sendKeys("Qw3rtyu! 987 WeR@");

        WebElement inputBirthday = driver.findElement(By.id("field-birthday"));
        inputBirthday.click();
        inputBirthday.sendKeys("11/09/2001");

//        driver.findElement(By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[8]/div[1]/span/label/input")).click();
//        driver.findElement(By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[9]/div[1]/span/label/input")).click();
        driver.findElement(By.xpath("//input[@name='psgdpr']")).click();
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@name='customer_privacy']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement title = driver.findElement(By.xpath("//span[@class='hidden-sm-down']"));
        String expectedMessage = "Testas Studentas";
        assertTrue(title.getText().contains(expectedMessage));

        driver.findElement(By.linkText("Sign out")).click();

        driver.findElement(By.linkText("Sign in")).click();

        WebElement inputEmailLogin = driver.findElement(By.id("field-email"));
        inputEmailLogin.click();
        inputEmailLogin.sendKeys(email);

        WebElement inputPasswordLogin = driver.findElement(By.id("field-password"));
        inputPasswordLogin.click();
        inputPasswordLogin.sendKeys("Qw3rtyu! 987 WeR@");

        driver.findElement(By.xpath("//button[@id='submit-login']")).click();

        driver.findElement(By.xpath("//span[@class='hidden-sm-down']")).click();

        driver.findElement(By.linkText("Information")).click();

        WebElement firstName = driver.findElement(By.id("field-firstname"));
        String expectedFirstname = "Testas";
//        assertTrue(firstName.getText().contains(expectedFirstname));
        assertEquals(expectedFirstname, firstName.getDomAttribute("value"));

        WebElement lastName = driver.findElement(By.id("field-lastname"));
        String expectedLastname = "Studentas";
        assertEquals(expectedLastname, lastName.getDomAttribute("value"));

        WebElement emailInformation = driver.findElement(By.id("field-email"));
        assertEquals(email, emailInformation.getDomAttribute("value"));
    }

//    public static String getComplexRandomMail() {
//        String lowerCharacters = "abcdefghijklmnopqrstuvmxyz";
//        String upperCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String numberCharacters = "0123456789";
//        return RandomStringUtils.random(3, lowerCharacters)
//                + RandomStringUtils.random(3, numberCharacters)
//                + RandomStringUtils.random(3, upperCharacters)
//                + System.currentTimeMillis()
//                + "@mail.com";
//    }
}
