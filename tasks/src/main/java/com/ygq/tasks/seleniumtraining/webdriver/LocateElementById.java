package com.ygq.tasks.seleniumtraining.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocateElementById {

    WebDriver driver = null;
    String lenovo = "https://www.lenovo.com.cn";
    String pathOfChromeDriver = "D:\\software\\selenium\\chromedriver.exe";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", pathOfChromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("starting");

        driver.get(lenovo);
//      also can be done with navigate method
//        driver.navigate().to(lenovo);
    }

    @AfterTest
    public void teardown() {
        System.out.println("exiting");
        driver.close();
    }

    @Test
    public void findWebElementById() {
        WebElement logo = driver.findElement(By.id("logo"));
        WebElement header = driver.findElement(By.id("header"));
        WebElement small_logo = header.findElement(By.id("small_logo"));
//        WebElement small_logo1 = logo.findElement(By.id("small_logo"));
//        Assert.assertEquals(logo.getText(),"");
//        Assert.assertEquals(logo.getCssValue("display"),"block");
    }
}
