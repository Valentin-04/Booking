package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import peges.BookingPage;

public class BookingSteps {
    BookingPage bookingPage;
    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        bookingPage = new BookingPage(driver);
    }

    @Given("Booking page is opened")
    public void bookingPageIsOpened() {
        bookingPage.openSite();
    }

    @When("I write {string} to search field")
    public void iWriteToSearchField(String arg) {
        bookingPage.writeToInput(arg);
    }

    @And("Click Search button")
    public void clickSearchButton() {
        bookingPage.clickSearch();
    }

    @Then("Check hotel name")
    public void checkHotelName() {
        bookingPage.checkName();
    }

    @Then("Check rate of hotel")
    public void checkRateOfHotel() {
        bookingPage.checkRate();
    }

    @After
    public void close() {
        driver.quit();
    }
}
