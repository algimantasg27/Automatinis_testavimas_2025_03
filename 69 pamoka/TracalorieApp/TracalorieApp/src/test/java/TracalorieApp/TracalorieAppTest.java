package TracalorieApp;

import lt.techin.BasePage;
import lt.techin.TracalorieAppPage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TracalorieAppTest extends BaseTest {

    @Test
    @Order(1)
    void TestTracalorieApp() {
        String itemString = "Riesutai";
        String caloriesString = "300";
        TracalorieAppPage tracalorieApp = new TracalorieAppPage(driver);

        tracalorieApp.clickPopUp();

        tracalorieApp.enterAddItem(itemString);
        tracalorieApp.enterAddCalorios(caloriesString);
        tracalorieApp.addMeal();

        assertTrue(tracalorieApp.firstItemMeal().contains(itemString));
        assertTrue(tracalorieApp.firstCalories().contains(caloriesString));
    }

    @Test
    @Order(2)
    void TestTracaloriesApp() {
        String itemString1 = "Riesutai";
        String caloriesString1 = "300";
        String itemString2 = "Obuolys";
        String caloriesString2 = "50";
        TracalorieAppPage tracalorieApp = new TracalorieAppPage(driver);

        tracalorieApp.clickPopUp();

        tracalorieApp.enterAddItem(itemString1);
        tracalorieApp.enterAddCalorios(caloriesString1);
        tracalorieApp.addMeal();

        tracalorieApp.enterAddItem(itemString2);
        tracalorieApp.enterAddCalorios(caloriesString2);
        tracalorieApp.addMeal();

        System.out.println(tracalorieApp.getSumTotalCalories());
        assertTrue(tracalorieApp.firstItemMeal().contains(itemString2));
        assertEquals(tracalorieApp.getTotalCalories(), tracalorieApp.getSumTotalCalories());
    }

    @Test
    @Order(3)
// 3 testas nepabaigtas, nesuskaiciuoja calories.
    void TestTracaloriesAppDeleteMeal() {
        String itemString1 = "Riesutai";
        String caloriesString1 = "300";
        String itemString2 = "Obuolys";
        String caloriesString2 = "50";
        TracalorieAppPage tracalorieApp = new TracalorieAppPage(driver);

        tracalorieApp.clickPopUp();

        tracalorieApp.enterAddItem(itemString1);
        tracalorieApp.enterAddCalorios(caloriesString1);
        tracalorieApp.addMeal();

        tracalorieApp.enterAddItem(itemString2);
        tracalorieApp.enterAddCalorios(caloriesString2);
        tracalorieApp.addMeal();

//        tracalorieApp.printLists();

        tracalorieApp.pushEditItem();
        tracalorieApp.pushButtonDeleteMeal();

//        System.out.println(tracalorieApp.getSumTotalCalories());

        assertTrue(tracalorieApp.firstItemMeal().contains(itemString2));
//        assertEquals(tracalorieApp.getTotalCalories(), tracalorieApp.getSumTotalCalories());
    }
}
