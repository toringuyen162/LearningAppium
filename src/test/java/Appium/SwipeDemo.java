package Appium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest {

    @Test
    public void ScrollDemoTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        

    }

}
