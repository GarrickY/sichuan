package com.ygq.tasks.seleniumtraining.grid;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDemo {
    WebDriver driver;

    String hubUrl = "http://10.176.121.22:4444/wd/hub";

    /**
     * this test runs on Windows 10 with chrome driver
     */
    @Test
    public void connectChromeOnNode() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WIN10);
        try {
            driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
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
        driver.close();
    }

    /**
     * this test runs on Red Hat Enterprise Linux 7.5 with Firefox
     */
    @Test
    public void connectFirefoxOnNode() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setPlatform(Platform.LINUX);
        try {
            driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("new driver error.");
            e.printStackTrace();
        }

        driver.get("https://www.baidu.com");
        driver.navigate();
        WebElement baidu = driver.findElement(By.id("kw"));
        baidu.sendKeys("how are you?");
        WebElement search = driver.findElement(By.id("su"));
        search.submit();

        try {
            WebElement result = driver.findElement(By.name("tj_settingicon"));
            System.out.println("Find!");
        } catch (NoSuchElementException ex) {
            System.out.println("Not find");
            ex.printStackTrace();
        }
        driver.close();

    }

}
