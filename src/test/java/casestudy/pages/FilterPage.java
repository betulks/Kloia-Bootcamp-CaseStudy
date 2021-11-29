package casestudy.pages;

import casestudy.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {

    public FilterPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void setClickableInput() {
        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        js.executeScript("arguments[0].click()", filterBrand);
    }

    @FindBy(id = "brand_facet-search-bar-input")
    public WebElement filterBrand;

    @FindBy(xpath = "//button[@aria-label='Remove Remove Filter: Philips']")
    public WebElement verifyResults;

    @FindBy(xpath = "(//div[@data-track=\"[context:listRank=2]\"])")
    public WebElement secondProduct;

    public void setFilterBrand(String filterKey) {
        filterBrand.sendKeys(filterKey);
        filterBrand.sendKeys(Keys.ARROW_DOWN);
        filterBrand.sendKeys(Keys.ENTER);
    }

    public void setVerifyResults() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(verifyResults));
        Assert.assertEquals("Philips", verifyResults.getText());
        }

    public void setSecondProduct(){secondProduct.click();}

}
