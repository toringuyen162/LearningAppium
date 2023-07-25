package Appium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumBasics extends BaseTest{

    @Test
    public void WifiSettingName() throws MalformedURLException {
        //Locator: xpath,
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //xpath syntax : tagName[@attribute='value'] -> //tagName
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); //Second matching item [2]
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("toriwifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


    }

}
