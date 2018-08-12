package com.ygq.tasks.seleniumtraining.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assertions {
    WebDriver driver = null;
    String lenovo = "https://passport.lenovo.com";
    String pathOfChromeDriver = "D:\\software\\selenium\\chromedriver.exe";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", pathOfChromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("starting");
        driver.get(lenovo);
    }

    @AfterTest
    public void teardown() {
        System.out.println("exiting");
        driver.close();
    }

    @Test
    public void verifyUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("passport.lenovo.com/wauthen2/preLogin"));
    }

    @Test
    public void verifyCheckpoints() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#ldLoginForm>div>span")).getText().equals("LenovoID Account Login"));
    }
}
