package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo1 {

    private RemoteWebDriver driver;
    private String Status = "";
    String height = "600";
    String width = "850";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "chrome");
        caps.setCapability("version", "104.0");
        caps.setCapability("build", "Fis");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("acceptInsecureCerts", "true");
        caps.setCapability("extendedDebuging", "true");
        caps.setCapability("idleTimeout", "360");
        caps.setCapability("network", "true");
        caps.setCapability("viewport", "700x500");
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
        driver.get("https://whatismyviewport.com/");
        driver.manage().window().setSize(new Dimension(800, 800));

        WebDriver browser;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String windowSize = js.executeScript("return (window.outerWidth - window.innerWidth + "+width+") + ',' + (window.outerHeight - window.innerHeight + "+height+"); ").toString();


        driver.manage().window().setSize(new Dimension(600, 850));
        Thread.sleep(1000);
        Thread.sleep(20000);
    }
    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }
}
