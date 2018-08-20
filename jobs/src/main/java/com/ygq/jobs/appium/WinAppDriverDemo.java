package com.ygq.jobs.appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WinAppDriverDemo {
    RemoteWebDriver calculator = null;
    WebElement result = null;

    @BeforeTest
    public void setup() throws MalformedURLException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            capabilities.setCapability("deviceName", "WindowsPC");
            capabilities.setCapability("platformName", "Windows");
            calculator = new RemoteWebDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            calculator.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            calculator.findElementByXPath("//Button[starts-with(@Name, \"Menu\")]").click();
            calculator.findElementByXPath("//ListItem[@Name=\"Standard Calculator\"]").click();

            calculator.findElementByName("Clear").click();
            calculator.findElementByName("Seven").click();
            result = calculator.findElementByName("Display is  7 ");
            Assert.assertNotNull(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        result = null;
        if (calculator != null)
            calculator.quit();
        calculator = null;
    }

    @Test
    public void addTwoNumber() {
        calculator.findElementByName("One").click();
        calculator.findElementByName("Plus").click();
        calculator.findElementByName("Seven").click();
        calculator.findElementByName("Equals").click();
        Assert.assertEquals("Display is  8 ", result.getText());
    }
}
