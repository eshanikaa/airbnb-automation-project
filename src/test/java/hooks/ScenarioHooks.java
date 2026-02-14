package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import stepdefinitions.SearchSteps;

public class ScenarioHooks {

    private static final Logger log = LoggerFactory.getLogger(ScenarioHooks.class);

    @Before
    public void setup() {
        log.info("=== Test Started ===");
    }

    @After
    public void tearDown(Scenario scenario) {

       
        if (!scenario.isFailed()) {
            log.info("Scenario PASSED: {}", scenario.getName());
            try {
                byte[] screenshot = ((TakesScreenshot) SearchSteps.driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Success Screenshot");
                log.info("Success screenshot captured and attached.");
            } catch (Exception e) {
                log.warn("Success screenshot not captured: {}", e.getMessage());
            }
        } else {
            log.error("Scenario FAILED: {}", scenario.getName());
           
        }

        log.info("=== Test Finished ===");
    }
}