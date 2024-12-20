package Tests;

import Screens.CartScreen;
import Screens.FormScreen;
import Screens.ProductsScreen;
import Shared.SharedData;
import org.testng.annotations.Test;

public class GeneralStoreTests extends SharedData {
    // Fill the form details and verify Toast error messages displayed appropriately
    // for wrong inputs
    @Test
    public void Test1() {
        FormScreen formScreen = new FormScreen(getDriver()); // Initialize the formActions object

        formScreen.defaultElementsVisible();
        formScreen.toastMessageIsDisplayed();
        formScreen.fillForm("Aruba", "Vasile", "female");
    }

    // Shop the items in the app by scrolling to specific Product and add to card
    @Test
    public void Test2() {
        Test1();

        ProductsScreen productsScreen = new ProductsScreen(getDriver());

        productsScreen.addItemToCart("Jordan Lift Off");
        productsScreen.addItemToCart("Nike SFB Jungle");
        productsScreen.goToCart();
    }

    // Validate if the items selected in the page 2 are matching with items
    // displayed in check out page

    // Validate the total Amount displayed in the checkout page matches with sum of
    // product amounts selected for Shopping
    @Test
    public void Test3and4() {
        Test1();
        ProductsScreen productsScreen = new ProductsScreen(getDriver());

        productsScreen.addItemToCart("Jordan Lift Off");
        productsScreen.addItemToCart("Nike SFB Jungle");
        productsScreen.goToCart();

        CartScreen cartActions = new CartScreen(getDriver(), productsScreen.itemsAddedToCart,
                productsScreen.totalPrice);
        cartActions.validateCart();
    }

    // Validate Mobile gestures working for Links(long Press) and navigate to
    // WebView
    @Test
    public void Test5() {
        Test1();
        ProductsScreen productsScreen = new ProductsScreen(getDriver());

        productsScreen.addItemToCart("Jordan Lift Off");
        productsScreen.addItemToCart("Nike SFB Jungle");
        productsScreen.goToCart();

        CartScreen cartActions = new CartScreen(getDriver(), productsScreen.itemsAddedToCart,
                productsScreen.totalPrice);
        cartActions.validateCart();
        cartActions.testCartScreen();
    }

    // Verify if user can do operations on the Web view and can navigate back to
    // Native App if needed
    @Test
    public void Test6() {
        Test5();
    }
}
