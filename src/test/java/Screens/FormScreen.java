package Screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FormScreen extends BaseScreen{
    public FormScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement screenTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select the country where you want to shop\"]")
    private WebElement selectCountry;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryDropDown;
    @AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']/*[1]")
    private WebElement countryName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your Name\"]")
    private WebElement yourName;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement inputNameField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Gender\"]")
    private WebElement gender;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleGender;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleGender;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement button;
    @AndroidFindBy(xpath = "//(android.widget.Toast)[1]")
    private WebElement toastMessage;

    String screenTitleText = "General Store";
    String selectCountryText = "Select the country where you want to shop";
    String defaultCountryName = "Afghanistan";
    String yourNameText = "Your Name";
    String genderText = "Gender";
    String errorMessage = "Please enter your name";

    public WebElement getScreenTitle() {
        return screenTitle;
    }

    public void setScreenTitle(WebElement screenTitle) {
        this.screenTitle = screenTitle;
    }

    public WebElement getSelectCountry() {
        return selectCountry;
    }

    public void setSelectCountry(WebElement selectCountry) {
        this.selectCountry = selectCountry;
    }

    public WebElement getCountryDropDown() {
        return countryDropDown;
    }

    public void setCountryDropDown(WebElement countryDropDown) {
        this.countryDropDown = countryDropDown;
    }

    public WebElement getCountryName() {
        return countryName;
    }

    public void setCountryName(WebElement countryName) {
        this.countryName = countryName;
    }

    public WebElement getYourName() {
        return yourName;
    }

    public void setYourName(WebElement yourName) {
        this.yourName = yourName;
    }

    public WebElement getInputNameField() {
        return inputNameField;
    }

    public void setInputNameField(WebElement inputNameField) {
        this.inputNameField = inputNameField;
    }

    public WebElement getGender() {
        return gender;
    }

    public void setGender(WebElement gender) {
        this.gender = gender;
    }

    public WebElement getMaleGender() {
        return maleGender;
    }

    public void setMaleGender(WebElement maleGender) {
        this.maleGender = maleGender;
    }

    public WebElement getFemaleGender() {
        return femaleGender;
    }

    public void setFemaleGender(WebElement femaleGender) {
        this.femaleGender = femaleGender;
    }

    public WebElement getButton() {
        return button;
    }

    public void setButton(WebElement button) {
        this.button = button;
    }

    public WebElement getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(WebElement toastMessage) {
        this.toastMessage = toastMessage;
    }

    public String getScreenTitleText() {
        return screenTitleText;
    }

    public void setScreenTitleText(String screenTitleText) {
        this.screenTitleText = screenTitleText;
    }

    public String getSelectCountryText() {
        return selectCountryText;
    }

    public void setSelectCountryText(String selectCountryText) {
        this.selectCountryText = selectCountryText;
    }

    public String getDefaultCountryName() {
        return defaultCountryName;
    }

    public void setDefaultCountryName(String defaultCountryName) {
        this.defaultCountryName = defaultCountryName;
    }

    public String getYourNameText() {
        return yourNameText;
    }

    public void setYourNameText(String yourNameText) {
        this.yourNameText = yourNameText;
    }

    public String getGenderText() {
        return genderText;
    }

    public void setGenderText(String genderText) {
        this.genderText = genderText;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void defaultElementsVisible() {
//        Assert.assertEquals(getScreenTitle().getText(), getScreenTitleText());
        Assert.assertEquals(getSelectCountry().getText(), getSelectCountryText());
        Assert.assertEquals(getCountryName().getText(), getDefaultCountryName());
        Assert.assertEquals(getYourName().getText(), getYourNameText());
        Assert.assertEquals(getGender().getText(), getGenderText());
        Assert.assertTrue(Boolean.parseBoolean(getMaleGender().getDomAttribute("checked")));
    }

    public void selectNewCountry(String country) {
        getCountryDropDown().click();
        helpMethods.uiAutomatorScroll(country);
        driver.findElement(
                        By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"" + country + "\"]"))
                .click();
    }

    public void enterName(String name) {
        getInputNameField().sendKeys(name);
    }

    public void selectGender(String gender) {
        switch (gender) {
            case "male":
                getMaleGender().click();
                Assert.assertTrue(Boolean.parseBoolean(getMaleGender().getDomAttribute("checked")));
                Assert.assertFalse(Boolean.parseBoolean(getFemaleGender().getDomAttribute("checked")));
                break;
            case "female":
                getFemaleGender().click();
                Assert.assertFalse(Boolean.parseBoolean(getMaleGender().getDomAttribute("checked")));
                Assert.assertTrue(Boolean.parseBoolean(getFemaleGender().getDomAttribute("checked")));
                break;
        }
    }

    public void tapButton() {
        getButton().click();
    }

    public void toastMessageIsDisplayed() {
        tapButton();

        String toastMessage = getToastMessage().getDomAttribute("name");
        Assert.assertEquals(toastMessage, getErrorMessage());
    }

    public void fillForm(String country, String name, String gender) {
        selectNewCountry(country);
        enterName(name);
        selectGender(gender);
        tapButton();
    }
}
