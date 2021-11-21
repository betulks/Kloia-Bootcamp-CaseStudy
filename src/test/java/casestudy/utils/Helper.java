package casestudy.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Helper {
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilVisible(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void clickWithLinkText(String linkText){
        Driver.get().findElement(By.linkText(linkText)).click();
    }

    public static void switchLastTab() {
        String originTab = Driver.get().getWindowHandle();
        Set<String> allTabs = Driver.get().getWindowHandles();

        for(String tab : allTabs){
            if(!originTab.equals(tab))
                Driver.get().switchTo().window(tab);
        }
    }



}
