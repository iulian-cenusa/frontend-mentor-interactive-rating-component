package com.iuliancenusa.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RatingComponentStepDefs {
    public WebDriver driver;
    private final String chromeDriverPath = "./src/test/java/com/iuliancenusa/drivers/chromedriver.exe";
    private final String baseUrl = "http://127.0.0.1:5500/index.html";
    private final String baseUrlTitle = "Frontend Mentor | Interactive rating component";
    private final String submitButtonId = "btn";
    private final String expectedratingId = "selected-rating";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am on the rating page")
    public void iAmOnTheRatingPage() {
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        wait.until(ExpectedConditions.titleIs(baseUrlTitle));
        Assert.assertEquals(driver.getTitle(), baseUrlTitle);
    }
    @When("I select {string} as my rating")
    public void iSelectAsMyRating(String requestedRating) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement ratingOption = driver.findElement(By.id(requestedRating));
        wait.until(ExpectedConditions.elementToBeClickable(ratingOption));
        ratingOption.click();
        ratingOption.click();
        wait.until(ExpectedConditions.attributeContains(ratingOption, "class", "selected"));
        WebElement ratingButton = driver.findElement(By.id(submitButtonId));
        wait.until(ExpectedConditions.elementToBeClickable(ratingButton));
        ratingButton.click();
    }

    @Then("I should see the rating {int} in the next section")
    public void iShouldSeeTheRating(int expectedRating) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        WebElement rating = driver.findElement(By.id(expectedratingId));
        wait.until(ExpectedConditions.visibilityOf(rating));
        Assert.assertEquals(Integer.parseInt(rating.getText()), expectedRating);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
