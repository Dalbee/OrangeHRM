package Step_Definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    public WebDriver driver;
    @Given("^I am on the Home page$")
    public void i_am_on_the_Home_page() throws Throwable {
        System.setProperty("web-driver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000); //wait for 2 seconds or 2000 milliseconds//

    }

    @Then("^I should see the application logo$")
    public void i_should_see_the_application_logo() throws Throwable {
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
        //driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-branding > img")).isDisplayed();
        Thread.sleep(2000); //wait for 2 seconds or 2000 milliseconds//

    }


    @And("^I assert that ActualLogoText is present$")
    public void iAssertThatActualLogoTextIsPresent() {
        String ExpectedLogoText = "OrangeHRM OS 5.4";
        String ActualLogoText = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[1]")).getText();
        Assert.assertEquals(ExpectedLogoText, ActualLogoText);
        System.out.println(ActualLogoText);

        driver.quit();
    }
}

