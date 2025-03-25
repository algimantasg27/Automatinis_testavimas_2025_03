package Formos_pildymas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
import static java.time.Duration.ofSeconds;

public class Formos_Pildyma_Test {

    @Test
    @DisplayName("Formos uzpildymas")
    void testForm() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form?classId=672fd27a-83d7-44cc-9e33-1abb45b3e5b8&assignmentId=f69410e7-908d-40f5-9ae4-f7e6d2f91b8e&submissionId=b98c3c17-44a1-7129-2374-cc9eba7e3380");
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));

        driver.findElement(By.id("firstName")).sendKeys("Testas");
        driver.findElement(By.id("lastName")).sendKeys("Studentas");
        driver.findElement(By.id("userEmail")).sendKeys("testas@studentas.lt");

        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("12345679890");

        driver.findElement(By.id("dateOfBirthInput")).click();
        Select selectYear = new Select (driver.findElement(By.className("react-datepicker__year-select")));
        selectYear.selectByValue("2001");
        Select selectMonth = new Select (driver.findElement(By.className("react-datepicker__month-select")));
        selectMonth.selectByValue("9");
        driver.findElement(By.cssSelector(".react-datepicker__day--011")).click();

        WebElement inputSubjects = driver.findElement(By.id("subjectsInput"));
        inputSubjects.sendKeys("Maths");
        inputSubjects.sendKeys(Keys.ENTER);
        inputSubjects.sendKeys("Biology");
        inputSubjects.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();

        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
        uploadPicture.sendKeys("C:\\Users\\grabl\\Desktop\\Techin\\Automatinis testavimas\\64 pamoka\\JUnit_praktinis\\src\\test\\resources\\logins.csv");

        driver.findElement(By.id("currentAddress")).sendKeys("Labas vakaras.");

        driver.findElement(By.id("submit")).click();

        WebElement title = driver.findElement(By.className("table-responsive"));
        String expectedMessage = "Testas Studentas";
        assertTrue(title.getText().contains(expectedMessage));
//        assertEquals(expectedMessage, title.getText());

    }


}
