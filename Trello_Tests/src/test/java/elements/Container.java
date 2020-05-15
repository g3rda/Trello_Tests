package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Container extends Element{

    public Container(By by) {
        super(by);
    }

    public void highlight(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid;');",  driver.findElement(by));
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
    }
}
