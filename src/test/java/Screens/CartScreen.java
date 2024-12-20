package Screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class CartScreen extends BaseScreen{
    private List<String> itemsInCartSent;
    private float totalPriceSent;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPriceInCart;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsAndCo;
    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement websiteButton;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> itemsInCartActual;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement termsAndCoButton;

    public CartScreen(AndroidDriver driver, List<String> itemsInCartSent, float totalPriceSent){
        super(driver);
        this.itemsInCartSent = itemsInCartSent;
        this.totalPriceSent = totalPriceSent;
    }

    public WebElement getTotalPriceInCart() {
        return totalPriceInCart;
    }

    public void setTotalPriceInCart(WebElement totalPriceInCart) {
        this.totalPriceInCart = totalPriceInCart;
    }

    public WebElement getTermsAndCo() {
        return termsAndCo;
    }

    public void setTermsAndCo(WebElement termsAndCo) {
        this.termsAndCo = termsAndCo;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(WebElement checkBox) {
        this.checkBox = checkBox;
    }

    public WebElement getWebsiteButton() {
        return websiteButton;
    }

    public void setWebsiteButton(WebElement websiteButton) {
        this.websiteButton = websiteButton;
    }

    public List<WebElement> getItemsInCartActual() {
        return itemsInCartActual;
    }

    public void setItemsInCartActual(List<WebElement> itemsInCartActual) {
        this.itemsInCartActual = itemsInCartActual;
    }

    public WebElement getTermsAndCoButton() {
        return termsAndCoButton;
    }

    public void setTermsAndCoButton(WebElement termsAndCoButton) {
        this.termsAndCoButton = termsAndCoButton;
    }

    public void validateCart() {
        for (WebElement item : getItemsInCartActual()) {
            String itemInCartName = item.getText();
            helpMethods.uiAutomatorScroll(itemInCartName);
            Assert.assertTrue(itemsInCartSent.contains(itemInCartName));
        }

        Assert.assertEquals(Float.parseFloat(getTotalPriceInCart().getText().replaceAll("[^\\d.]", "")), totalPriceSent);
    }

    public void testCartScreen() {
        helpMethods.longPressAction(getTermsAndCo());
        getTermsAndCoButton().click();
        getCheckBox().click();
        getWebsiteButton().click();
    }

    public void getContexts() {
        Set<String> contexts = driver.getContextHandles();

        for(String context : contexts) {
            System.out.println(context);
        }
    }
}
