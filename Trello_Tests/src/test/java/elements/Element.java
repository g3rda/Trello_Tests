package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static tests.Tests.getDriver;
import static tests.Tests.getWaitDriver;

public abstract class Element {
    protected By by;
    protected WebDriver driver = getDriver();
    protected WebDriverWait wait = getWaitDriver();

    public Element(By by){
        this.by = by;
    }

    public WebElement compose(){
        return driver.findElement(by);
    }



    WebElement waitUntilWebElement(ExpectedCondition<WebElement> cond){
        return wait.until(cond);
    }

    void waitUntilBoolean(ExpectedCondition<Boolean> cond){
        wait.until(cond);
    }

    public void waitUntilVisible(){
        waitUntilWebElement(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilInvisible(){
        waitUntilBoolean(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitUntilClickable(){
        waitUntilWebElement(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(){
        compose().click();
    }

    public WebElement composeLast(){
        List<WebElement> elements = driver.findElements(by);
        return elements.get(elements.size()-1);
    }
    public void clickLast(){
        composeLast().click();
    }

}
