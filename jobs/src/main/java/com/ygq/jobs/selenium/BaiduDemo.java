package com.ygq.jobs.selenium;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class BaiduDemo {

    String baseUrl = "http://www.baidu.com";
    WebDriver driver;
    @Before
    public void openBrowser(){

        System.setProperty("webdriver.edge.driver","D:\\maven\\localrepo\\org\\seleniumhq\\selenium\\selenium-edge-driver\\3.12.0\\MicrosoftWebDriver.exe");
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

        WebElement pic = driver.findElement(By.className("index-logo-src"));
        Assert.assertTrue(false);
    }

    @Test
    public void searchText1(){

        Assert.assertTrue(true);
    }

    @After
    public void closeBrowser(){
        driver.close();
        //driver.quit();
    }

}
