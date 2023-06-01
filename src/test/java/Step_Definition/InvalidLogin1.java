package Step_Definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLogin1 {
    public WebDriver driver;
    @Given("^I am get on the homepage$")
    public void iAmGetOnTheHomepage() throws InterruptedException {
        System.setProperty("web-driver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000); //wait for 2 seconds or 2000 milliseconds//
    }

    @When("^I enter invalid username$")
    public void iEnterInvalidUsername() {
        driver.findElement(By.name("username")).sendKeys("Maggie");
    }

    @And("^I enter Valid Password$")
    public void iEnterValidPassword() {
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @When("^I press the login button$")
    public void iPressTheLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(2000);
    }

    @Then("^my login should not be successful$")
    public void myLoginShouldNotBeSuccessful() {
        String ExpectedLoggedInErrorMessage= "Invalid credentials"; //returned message
        String ActualLoggedInErrorMessage = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        Assert.assertEquals(ExpectedLoggedInErrorMessage, ActualLoggedInErrorMessage);
        System.out.println(ActualLoggedInErrorMessage);
    }
}
