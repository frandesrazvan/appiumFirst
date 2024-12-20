package Screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductsScreen extends BaseScreen{
    public ProductsScreen(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> productList;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private WebElement productName;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> productAddCart;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productString;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
    private WebElement cartCounterElement;

    public WebElement getCart() {
        return cart;
    }

    public void setCart(WebElement cart) {
        this.cart = cart;
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public void setProductList(List<WebElement> productList) {
        this.productList = productList;
    }

    public WebElement getProductName() {
        return productName;
    }

    public void setProductName(WebElement productName) {
        this.productName = productName;
    }

    public List<WebElement> getProductAddCart() {
        return productAddCart;
    }

    public void setProductAddCart(List<WebElement> productAddCart) {
        this.productAddCart = productAddCart;
    }

    public List<WebElement> getProductString() {
        return productString;
    }

    public void setProductString(List<WebElement> productString) {
        this.productString = productString;
    }

    public WebElement getCartCounterElement() {
        return cartCounterElement;
    }

    public void setCartCounterElement(WebElement cartCounterElement) {
        this.cartCounterElement = cartCounterElement;
    }

    public List<String> itemsAddedToCart = new ArrayList<String>();
    public float totalPrice = 0;

    public void addItemToCart(String name) {
        helpMethods.uiAutomatorScroll(name);

        for (int i = 0; i < getProductList().size(); i++) {
            String productName = getProductList().get(i)
                    .getText();

            if (productName.equals(name)) {
                getProductAddCart().get(i).click();
                String priceString = getProductString().get(i)
                        .getText();
                itemsAddedToCart.add(productName);
                totalPrice += Float.parseFloat(priceString.replaceAll("[^\\d.]", ""));
                break;
            }
        }

        WebElement cartCounterElement = getCartCounterElement();
        Assert.assertTrue(cartCounterElement.isDisplayed());
    }

    public void goToCart() {
        getCart().click();
    }
}
