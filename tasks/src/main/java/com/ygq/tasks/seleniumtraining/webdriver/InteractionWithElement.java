package com.ygq.tasks.seleniumtraining.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InteractionWithElement {
    WebDriver driver = null;
    String lenovo = "https://passport.lenovo.com";
    String pathOfFirefoxDriver = "D:\\software\\selenium\\geckodriver.exe";
    String pathOfChromeDriver = "D:\\software\\selenium\\chromedriver.exe";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", pathOfFirefoxDriver);
        System.setProperty("webdriver.chrome.driver", pathOfChromeDriver);
        //driver = new FirefoxDriver();
        //driver.manage().window().maximize();
        System.out.println("starting");
    }

    @AfterTest
    public void teardown() {
        System.out.println("exiting");
        driver.close();
    }

    @Test
    public void lenovoIdTest() throws InterruptedException {
        driver.get(lenovo);
        WebElement username = driver.findElement(By.cssSelector("input#tuser"));
        username.sendKeys("lenovoid90023234@163.com");
        Thread.sleep(2000);
        username.clear();
        Thread.sleep(2000);
        username.sendKeys("lenovoid900@163.com");
        WebElement passwdTextbox = driver.findElement(By.cssSelector("input#tpass"));
        passwdTextbox.sendKeys("Aa123456");
        //driver.findElement(By.cssSelector("input.jsSubBtn")).click();
        driver.findElement(By.cssSelector("input.jsSubBtn")).submit();
        Thread.sleep(2000);
        System.out.println("logged in already.");
    }

    @Test
    public void getElementText() {
        driver.get(lenovo);
        WebElement inputTextbox = driver.findElement(By.cssSelector("#ldLoginForm > div.hd.clearfix > span"));
        System.out.println("The text is " + inputTextbox.getText());
    }

    @Test
    public void getStatus() throws InterruptedException {
        driver.get(lenovo);

        WebElement checkbox = driver.findElement(By.cssSelector("input[name='autoLoginState']"));

        System.out.println("tag name is " + checkbox.getTagName());
        System.out.println("the value of checked is " + checkbox.getAttribute("checked"));
        System.out.println("CSS outlineColor value is " + checkbox.getCssValue("outlineColor"));
        System.out.println("size is " + checkbox.getSize());
        System.out.println("location is " + checkbox.getLocation());
        System.out.println("point x of rectangle is " + checkbox.getRect().x);
        System.out.println("point y of rectangle is " + checkbox.getRect().y);
        System.out.println("the height of rectangle is " + checkbox.getRect().height);
        System.out.println("the width of rectangle is " + checkbox.getRect().width);

        System.out.println("checkbox is selected? " + checkbox.isSelected());
        System.out.println("checkbox is enabled? " + checkbox.isEnabled());
        System.out.println("checkbox is diplayed? " + checkbox.isDisplayed());
        System.out.println("checkbox is selected? " + checkbox.isSelected());

        Thread.sleep(2000);
        checkbox.click();
        Thread.sleep(2000);
        System.out.println("checkbox is selected? " + checkbox.isSelected());
    }

    @Test
    public void moveBetweenWindowAndFrame() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        WebElement inputText = driver.findElement(By.cssSelector("input#kw"));
        inputText.sendKeys("lenovo");
        inputText.submit();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("联想官网商城九周年庆")));

        driver.findElement(By.partialLinkText("联想官网商城九周年庆")).click();
        System.out.println("previous is : " + driver.getWindowHandle());

        for (String handle : driver.getWindowHandles()) {
            System.out.println(handle);
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("九周年秒杀"))
                break;
            else
                driver.switchTo().defaultContent();
        }
        System.out.println("after is : " + driver.getWindowHandle());
        System.out.println("new window's url is " + driver.getCurrentUrl());
        System.out.println("new window's title is " + driver.getTitle());
        driver.switchTo().defaultContent();
        System.out.println("final is : " + driver.getWindowHandle());

    }

    @Test
    public void mouseAction() throws InterruptedException {
        driver.get("https://www.baidu.com");

        WebElement more = driver.findElement(By.cssSelector("a[name='tj_briicon']"));
        Actions action = new Actions(driver);
        action.moveToElement(more).perform();
        Thread.sleep(2000);
    }

}
