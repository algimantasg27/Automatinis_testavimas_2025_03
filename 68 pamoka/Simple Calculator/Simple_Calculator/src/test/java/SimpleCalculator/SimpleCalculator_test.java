package SimpleCalculator;

import lt.techin.ActionsPage;
import lt.techin.BasePage;
import lt.techin.HomePage;
import lt.techin.Loadertwo;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SimpleCalculator_test extends BaseTest{

@Test
    void testCalculator () {

    HomePage homePage = new HomePage(driver);

    homePage.enterInputNumberFirst("3");
    homePage.selectMathSign();
    homePage.enterInputNumberTwo("2");
    homePage.clickButtonSubmit();

    assertEquals("1", homePage.getAnswer());
    }

    @Test
    void testCalculatorError() {
        HomePage homePage = new HomePage(driver);

        homePage.enterInputNumberFirst("as");
        homePage.selectMathSign();
        homePage.enterInputNumberTwo("2");
        homePage.clickButtonSubmit();

        assertEquals("ERR", homePage.getAnswer());

    }

    @Test
    void testCalculatorWithMinusSign() {
        HomePage homePage = new HomePage(driver);

        homePage.enterInputNumberFirst("6000");
        homePage.selectMathSign();
        homePage.enterInputNumberTwo("1999");
        homePage.clickButtonSubmit();

        assertEquals(homePage.getAnswerWithMinus(6000, 1999), homePage.getAnswer());

    }

    @Test
    void testAdd() {
    HomePage homePage = new HomePage(driver);
        homePage.enterInputNumberFirst("6000");
        homePage.setFunction("plus");
        homePage.enterInputNumberTwo("1999");
        homePage.clickButtonSubmit();
        assertEquals("7999", homePage.getAnswer());
    }

    @Test
    void testLoader () {

        Loadertwo loaderPage = new Loadertwo(driver);
        assertEquals("This is a new paragraph that appears after 8 seconds.", loaderPage.getParagraphText());

    }

    @Test
    void testActions () {

        ActionsPage actionsPage = new ActionsPage(driver);
        actionsPage.clickActionButton();
        Alert alert = driver.switchTo().alert();
        assertEquals("The SHIFT key was pressed!", alert.getText());
        alert.accept();
    }
}
