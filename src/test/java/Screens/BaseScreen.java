package Screens;

import Help.HelpMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

    public AndroidDriver driver;
    public HelpMethods helpMethods;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        helpMethods = new HelpMethods(driver);
    }
}
