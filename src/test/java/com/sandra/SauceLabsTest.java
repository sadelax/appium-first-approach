package com.sandra;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceLabsTest {

    public AndroidDriver driver;
    public DesiredCapabilities capabilities;

    @BeforeEach
    public void setup() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("appium:app", "/Users/n218688/Documents/KeepCoding/Appium keepcoding/Android-MyDemoAppRN.1.3.0.build-244.apk");
        capabilities.setCapability("appium:automationName", "UIAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }


    @Test
    public void testShoppingNavigation() {
        WebElement productTitle = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"store item text\"])[2]"));
        assertEquals("Sauce Labs Bike Light", productTitle.getText());
        WebElement hamburguer = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
        hamburguer.click();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
