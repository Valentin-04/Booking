package peges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookingPage {
    private WebDriver driver;
    private String name;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    public void writeToInput(String arg) {
        name = arg;
        driver.findElement(By.id("ss")).sendKeys(name);
    }

    public void clickSearch() {
        driver.findElement(By.cssSelector(".sb-searchbox__button")).click();
    }

    public void checkName() {
        String nameOfHotel = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", name))).getText();
        Assert.assertEquals(nameOfHotel, name);
    }

    public void checkRate(String rate) {
        String rateOfHotel = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]/ancestor::div[contains(@class,'sr_item_content')]//div[contains(@class, 'bui-review-score__badge')]", name))).getText();
        Assert.assertEquals(rateOfHotel, rate);
    }
}
