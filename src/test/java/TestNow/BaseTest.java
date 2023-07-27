package TestNow;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;

    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\ThuyNV\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        //code
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Google Pixel 6");
        options.setApp("D:\\Github\\LearningAppium\\src\\test\\java\\resources\\testNow - Crowdtesting_8.0_Apkpure.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Wait 10 seconds for the elements to be visible
    }

    //Long press action
    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript
                ("mobile: longClickGesture",
                        ImmutableMap.of
                                ("elementId", ((RemoteWebElement) ele).getId(),
                                        "duration", 2000));
    }

    //Scroll Gesture

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//        service.stop();
//    }
}
