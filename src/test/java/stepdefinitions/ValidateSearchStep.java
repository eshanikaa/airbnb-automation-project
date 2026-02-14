package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateSearchStep {

    public static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(ValidateSearchStep.class);

    @Given("User is on Airbnb homepage")
    public void user_is_on_homepage() throws InterruptedException {
        log.info("Launching Chrome and navigating to Airbnb.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com");
        log.info("Opened URL: {}", driver.getCurrentUrl());
        Thread.sleep(5000);
    }

    @When("User enters location {string}")
    public void users_enters_location(String location) throws InterruptedException {
        log.info("Entering location: {}", location);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys(location);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@role='option'])[1]")).click();
        log.info("Selected first suggestion for location.");
        Thread.sleep(3000);
    }

    @When("User clicks on search button")
    public void users_clicks_search() throws InterruptedException {
        log.info("Clicking on Search button.");
        driver.findElement(By.xpath("//div[text()='Search']")).click();
        Thread.sleep(5000);
    }

    @Then("Search results should be displayed")
    public void verify_results() {
        String currentUrl = driver.getCurrentUrl();
        log.info("Current URL: {}", currentUrl);

        if (currentUrl.contains("New-York")) {
            log.info("Test Passed: URL contains 'New-York'.");
        } else {
            log.warn("Test Failed: URL does not contain 'New-York'.");
        }

        log.info("Quitting browser.");
        driver.quit();
    }
}
