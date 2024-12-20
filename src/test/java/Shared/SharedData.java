package Shared;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class SharedData {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    final String ip = "127.0.0.1";
    final int port = 4723;

    @BeforeMethod
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
        // Appium code -> Appium Server -> Mobile
        // start Appium service
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(
                        "C:\\Users\\RFRANDES\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ip)
                .usingPort(port)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("samsung SM-G980F"); // S20
        // options.setChromedriverExecutable("C:\\Users\\RFRANDES\\Downloads\\automation repo\\Eclipse\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
        options.setApp(
                "C:\\Users\\RFRANDES\\Downloads\\automation repo\\Eclipse\\Appium\\src\\test\\java\\resources\\General-Store.apk");

        driver = new AndroidDriver(new URI("http://" + ip + ":" + port).toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
