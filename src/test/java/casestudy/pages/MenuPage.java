package casestudy.pages;

import casestudy.utils.Driver;
import casestudy.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    public MenuPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "hamburger-menu")
    public WebElement menuButton;

    @FindBy(xpath = "//button[@data-id='node-600']")
    public WebElement audioButton;

    @FindBy(xpath = "//button[@data-id='node-551']")
    public WebElement headphonesButton;

    @FindBy(linkText = "Wireless Headphones")
    public WebElement wirelessHeadphonesButton;

    @FindBy(xpath = "//*[text() = 'Wireless Headphones']")
    public WebElement wirelessHeadphonesText;

    public void setMenuButton() {
        menuButton.click();
    }

    public void setAudioButton() {
        audioButton.click();
    }

    public void setHeadphonesButton() {
        headphonesButton.click();
    }

    public void setWirelessHeadphonesButton() {
        wirelessHeadphonesButton.click();
    }

    public void verifyWirelessHeadphonesText() {
        Assert.assertEquals("Wireless Headphones", wirelessHeadphonesText.getText());
    }


}