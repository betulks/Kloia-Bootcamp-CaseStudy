package casestudy.pages;

import casestudy.utils.Driver;
import casestudy.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(tagName = "h1")
    public WebElement title;

    @FindBy(id = "fld-e")
    public WebElement emailInput;

    @FindBy(id = "fld-p1")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[text() = 'Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[contains(text(), 'Hi,')]")
    public WebElement hiText;

    @FindBy(xpath = "//*[text() = 'Sign in with Google']")
    public WebElement signInButtonWithGoogle;

    @FindBy(xpath = "//*[@id=\"headingText\"]/span")
    public WebElement googleSignInTitle;

    @FindBy(id = "identifierId")
    public WebElement emailInputWithGoogle;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]")
    public WebElement next1Button;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    public WebElement emailPasswordInputWithGoogle;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[2]")
    public WebElement next2Button;

    public void verifyTitle() {
        Assert.assertEquals("Sign In to Best Buy", title.getText());
    }

    public void emailInput(String emailAddress) {
        emailInput.click();
        emailInput.sendKeys(emailAddress);
    }

    public void passwordInput(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void setSignInButton() {
        signInButton.sendKeys(Keys.ENTER);
    }

    public void verifySignIn() {
        Assert.assertTrue(hiText.getText().contains("Hi"));
    }

    public void setSignInButtonWithGoogle() {
        signInButtonWithGoogle.sendKeys(Keys.ENTER);
    }

    public void verifyGoogleSignInTitle() {
        Helper.switchLastTab();
        Assert.assertEquals("Oturum aç", googleSignInTitle.getText());
    }

    public void gmailInput(String gmail) {
        emailInputWithGoogle.click();
        emailInputWithGoogle.sendKeys(gmail);
    }

    public void setNext1Button() {next1Button.click();}

    public void gmailPasswordInput(String gmailPassword) {
        emailPasswordInputWithGoogle.click();
        emailPasswordInputWithGoogle.sendKeys(gmailPassword);
    }

    public void setNext2Button() {
        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        js.executeScript("arguments[0].click()", next2Button);
    }

}

