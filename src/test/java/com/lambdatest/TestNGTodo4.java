package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo4 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "MicrosoftEdge");
        caps.setCapability("version", "102.0");
        caps.setCapability("build", "noon7");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("acceptInsecureCerts", "true");
        caps.setCapability("extendedDebuging", "true");
        caps.setCapability("idleTimeout", "360");
        caps.setCapability("network", "true");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("video", "true");
        caps.setCapability("visual", "true");
        caps.setCapability("w3c", "true");
        //   caps.setCapability("acceptInsecureCerts", "true");
        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        driver.get("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div[1]/div/div/div[2]/div[2]/a")).click(); // add to cart
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div[2]/div[1]/div[2]/div/div/button/span/em")).click(); // complete check out
        Thread.sleep(20000);
        driver.findElement(By.xpath("/html/body/np-root/div/div/div/div[2]/div/np-card-main/div/div[2]/np-saved-card-list/div[1]/np-saved-card/div/div[1]/div/label")).click(); // select card number
        Thread.sleep(20000);
/* driver.findElement(By.xpath("/html/body/np-root/div/div/div/div[2]/div/np-card-main/div/div[2]/np-saved-card-list/div[1]/np-saved-card/div/div[2]/div/input")).sendKeys("123"); // select box for cvv and enter the number
Thread.sleep(1000); */
        driver.findElement(By.cssSelector("#txtSavedCardsFormCvv_0")).sendKeys("234"); // select box for cvv and enter the number
        Thread.sleep(10000);
        driver.findElement(By.id("btnPayWithCard")).click(); // select submit button
        Thread.sleep(20000);


    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}
