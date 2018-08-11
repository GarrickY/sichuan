package com.ygq.jobs.selenium;


import fitlibrary.DoFixture;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BaiduDemo extends DoFixture {

    String baseUrl = "http://www.baidu.com";
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){

        System.setProperty("webdriver.edge.driver", "D:\\servers\\localrepo\\org\\seleniumhq\\selenium\\selenium-edge-driver\\3.12.0\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.navigate();
    }

    @Test
    public void searchText(){
        String keyword = "China";
        driver.findElement(By.id("kw")).sendKeys(keyword);
        driver.findElement(By.id("su")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("god"));
        WebElement pic = driver.findElement(By.className("index-logo-src"));
        Assert.assertTrue(false);
    }

    @Test
    public void searchText1(){

        Assert.assertTrue(true);
    }

    public void takeScreenshot(String path) throws IOException {
        openBrowser();
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File(path));
        System.out.println("Screenshot is saved in " + path);
        closeBrowser();
    }

    public String takeScreenshotP(Object x) throws IOException {
        openBrowser();
        String path = "FitNesseRoot\\files\\ii\\123.png";
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(source, new File(path));
        System.out.println("Screenshot is saved in " + path);
        closeBrowser();
        return "!img -w 500 http://files/ii/123.png";
    }

    public void getBlank() {
    }

    public String picture() {
        return "!img -w 500 http://files/ii/${filename}";
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
        //driver.quit();
    }

}
