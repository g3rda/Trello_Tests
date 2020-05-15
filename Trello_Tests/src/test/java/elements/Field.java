package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Field extends Element{

    public Field(By by) {
        super(by);
    }

    public void sendKeys(String text){
        compose().sendKeys(text);
    }
    public void sendKeys(Keys key){
        compose().sendKeys(key);
    }
}
