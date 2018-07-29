package com.ygq.tasks.seleniumtraining.grid;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDemo {
    WebDriver driver;

    @Test
    public void connectNode() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:18485/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("new driver error.");
            e.printStackTrace();
        }

        driver.get("https://www.baidu.com");
        driver.navigate();
        WebElement baidu = driver.findElement(By.id("kw"));
        baidu.sendKeys("who are you?");
        WebElement search = driver.findElement(By.id("su"));
        search.submit();

        try {
            WebElement result = driver.findElement(By.name("tj_settingicon"));
            System.out.println("Find!");
        } catch (NoSuchElementException ex) {
            System.out.println("Not find");
            ex.printStackTrace();
        }

    }
}
