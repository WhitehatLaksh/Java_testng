

## Table Of Contents

* [Pre-requisites](#pre-requisites)
* [Run Your First Test](#run-your-first-test)
* [Parallel Testing With TestNG](#executing-parallel-tests-using-testng)
* [Local Testing With TestNG](#testing-locally-hosted-or-privately-hosted-projects)

## Pre-requisites

Before you can start performing Java automation testing with Selenium, you would need to:

- Install the latest **Java development environment** i.e. **JDK 1.6** or higher. We recommend using the latest version.

- Download the latest **Selenium Client** and its **WebDriver bindings** from the [official website](https://www.selenium.dev/downloads/). Latest versions of Selenium Client and WebDriver are ideal for running your automation script on LambdaTest Selenium cloud grid.

- Install **Maven** which supports **JUnit** framework out of the box. **Maven** can be downloaded and installed following the steps from [the official website](https://maven.apache.org/). Maven can also be installed easily on **Linux/MacOS** using [Homebrew](https://brew.sh/) package manager.



You can also run the command below to check for outdated dependencies.

```bash
mvn versions:display-dependency-updates
```




### Configuring Your Test Capabilities

In the test script, you need to update your test capabilities. In this code, we are passing browser, browser version, and operating system information, along with LambdaTest Selenium grid capabilities via capabilities object. The capabilities object in the above code are defined as:

```java
DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
```


### Executing The Test

The tests can be executed in the terminal using the following command.

```bash
mvn test -D suite=single.xml
```

Your test results would be displayed on the test console (or command-line interface if you are using terminal/cmd) and on LambdaTest automation dashboard. 



### Executing Parallel Tests Using TestNG

To run parallel tests using **TestNG**, we would have to execute the below commands in the terminal:

- For the above example code
  ```bash
  mvn test
  ```
- For the cloned Java-TestNG-Selenium repo used to run our first sample test
  ```bash
  mvn test -D suite=parallel.xml
  ```

Contact at lakshayindian19@live.com
