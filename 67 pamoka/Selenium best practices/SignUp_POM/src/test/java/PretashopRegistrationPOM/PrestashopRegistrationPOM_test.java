package PretashopRegistrationPOM;

import lt.techin.CreateAnAccountPage;
import lt.techin.HomePage;
import lt.techin.LoginPage;
import lt.techin.MainPage;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrestashopRegistrationPOM_test extends BaseTest{

    private String email;

    @Test
    void testRegistration() {

        HomePage homePage = new HomePage(driver);
        homePage.clickSignInPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnCreateAccountPage();

        CreateAnAccountPage createAccount = new CreateAnAccountPage(driver);
        createAccount.clickFieldGender();
        createAccount.enterInputFirstname("Testas");
        createAccount.enterInputLastname("Studentas");
        email = "user" + System.currentTimeMillis() + "@test.com";
        createAccount.enterInputEmail(email);
        createAccount.enterInputPassword("Password123!Strong");
        createAccount.enterInputBirthday("11/09/2001");
        createAccount.clickCheckBoxes();
        createAccount.clickButtonSubmit();

        MainPage mainPage = new MainPage(driver);
        assertEquals("Testas Studentas", mainPage.getTitleText());

        mainPage.clickButtonSignOut();
    }

    @Test
    void testSignInInformation() throws InterruptedException {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.clickButtonSignOut();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInPage();

        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterInputEmailLogin(email);
        loginPage.enterInputEmailLogin("user1742844029958@test.com");
        loginPage.enterInputPasswordLogin("Password123!Strong");
        loginPage.clickSubmitButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickCustomerAccount();
        mainPage.clickInformation();

        assertEquals("Testas", mainPage.getFirstname());
        assertEquals("Studentas", mainPage.getLastname());
        assertEquals("user1742844029958@test.com", mainPage.getEmail());

//        Nesugaudau kampo kaip email`a issaugoti ir panaudoti kituose testuose prie login page.
    }
}
