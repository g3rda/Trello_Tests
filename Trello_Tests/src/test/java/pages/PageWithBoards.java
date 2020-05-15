package pages;

import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageWithBoards extends Page{
    public PageWithBoards(WebDriver driver) {
        super(driver);
    }
    public Link boardPageLink;
    public void setBoardPageLink(String boardName){
        boardPageLink = new Link(By.cssSelector("div[title='" + boardName +"']"));
    }


}
