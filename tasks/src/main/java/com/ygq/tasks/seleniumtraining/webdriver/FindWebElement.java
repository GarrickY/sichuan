package com.ygq.tasks.seleniumtraining.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindWebElement {

    WebDriver driver = null;
    String lenovo = "https://www.baidu.com";
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
    public void findById() {
        WebElement searchBtn = driver.findElement(By.id("su"));
        System.out.println("‘百度一下’按钮已找到");
    }

    @Test
    public void findByName() {
        WebElement searchBox = driver.findElement(By.name("wd"));
        System.out.println("search box is found.");
    }

    @Test
    public void findByClassName() {
        WebElement qrcode = driver.findElement(By.className("qrcode-img"));
        System.out.println("QR code is found.");
    }

    @Test
    public void findByTagName() {
        WebElement navMenu = driver.findElement(By.id("u1"));
        WebElement hao123 = navMenu.findElement(By.tagName("a"));
        System.out.println("hao123 link is found.");
    }

    @Test
    public void findByLinkText() {
        WebElement more = driver.findElement(By.linkText("更多产品"));
        System.out.println("更多产品连接已找到");
    }

    @Test
    public void findByPartialLinkText() {
        WebElement more = driver.findElement(By.partialLinkText("更多"));
        System.out.println("通过‘更多’找到更多产品链接");
    }

    @Test
    public void findByXPath() {
        //WebElement video = driver.findElement(By.xpath("//*[@id='u1']/a[4]"));
        //WebElement target = driver.findElement(By.xpath("//form[contains(@class,'fm')]"));
        //WebElement target = driver.findElement(By.xpath("//form[starts-with(@class,'fm')]"));
        //WebElement target = driver.findElement(By.xpath("//p[a]"));
        //WebElement target = driver.findElement(By.xpath("//*[text()='新闻']"));

        System.out.println("找到视频链接");
    }

    @Test
    public void findByCss() {
        //WebElement textBox = driver.findElement(By.cssSelector("input"));
        //WebElement textBox = driver.findElement(By.cssSelector("input[name='wd'][id='kw']"));
        //WebElement textBox = driver.findElement(By.cssSelector("input#kw[name='wd']"));
        //WebElement textBox = driver.findElement(By.cssSelector("#kw[name='wd']"));
        //WebElement textBox = driver.findElement(By.cssSelector("#kw[name]"));
        //WebElement textBox = driver.findElement(By.cssSelector(".s_ipt#kw"));
        //WebElement textBox = driver.findElement(By.cssSelector("form[class^='fm']"));
        //WebElement textBox1 = driver.findElement(By.cssSelector("form[class$='m']"));
        //WebElement textBox2 = driver.findElement(By.cssSelector("span[class~='bg']"));
        //WebElement textBox = driver.findElement(By.cssSelector("div[class*='soutu-env-nomac']"));
        //WebElement textBox2 = driver.findElement(By.cssSelector("img[class|='index']"));
        //WebElement textBox = driver.findElement(By.cssSelector("form.fm>span.tools>span#mHolder>div#mCon"));
        //WebElement textBox = driver.findElement(By.cssSelector("form.fm>input"));
        //WebElement textBox = driver.findElement(By.cssSelector("form.fm>input:nth-child(2)"));
        //WebElement textBox = driver.findElement(By.cssSelector("form.fm>input:first-child"));
        //WebElement textBox = driver.findElement(By.cssSelector("form.fm>input:last-child"));
        //WebElement textBox = driver.findElement(By.cssSelector("form.fm>input:only-child"));
        //WebElement textBox = driver.findElement(By.cssSelector("form.fm>input+input"));


        System.out.println("找到了！");
    }

}
