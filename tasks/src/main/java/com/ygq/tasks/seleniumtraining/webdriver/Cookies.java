package com.ygq.tasks.seleniumtraining.webdriver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cookies {
    WebDriver driver = null;
    String baidu = "https://www.baidu.com";
    String pathOfChromeDriver = "D:\\software\\selenium\\chromedriver.exe";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", pathOfChromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        System.out.println("exiting");
        driver.close();
    }

    @Test
    public void getCookie() {
        System.out.println("starting");
        driver.get(baidu);
        for (Cookie cookie : driver.manage().getCookies()) {
            System.out.println(String.format("cookie:%s = %s", cookie.getName(), cookie.getValue()));
        }
    }

    @Test
    public void setCookie() {
        driver.get(baidu);
        Cookie cookie = new Cookie("product", "lenovo");
        driver.manage().addCookie(cookie);
        for (Cookie cook : driver.manage().getCookies()) {
            System.out.println(String.format("cookie:%s = %s", cook.getName(), cook.getValue()));
        }
    }

    @Test
    public void deleteCookie() {
        driver.get(baidu);
        //driver.manage().deleteCookie(cookie);
        //driver.manage().getCookieNamed("xxx");
        driver.manage().deleteAllCookies();
    }


}
