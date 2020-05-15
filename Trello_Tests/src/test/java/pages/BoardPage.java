package pages;

import elements.Button;
import elements.Container;
import elements.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardPage extends Page{
    public BoardPage(WebDriver driver) {
        super(driver);
    }


    public Button addMemberButton = new Button(By.cssSelector("a[class='board-header-btn board-header-btn-invite board-header-btn-without-icon js-open-manage-board-members']"));
    public Field memberNameField = new Field(By.cssSelector("input.autocomplete-input"));
    public Button chooseMemberButton = new Button(By.cssSelector("div.member-container"));
    public Button sendInviteButton = new Button(By.cssSelector("button[class='autocomplete-btn primary']"));
    public Container lastActivityPostContainer = new Container(By.cssSelector("div[class='phenom mod-attachment-type']"));

    public Button addOneMoreListButton = new Button(By.cssSelector("a.open-add-list"));
    public Field listNameField = new Field(By.cssSelector("input.list-name-input"));
    public Button closeAddListWindowButton = new Button(By.cssSelector("a.icon-lg.icon-close.dark-hover.js-cancel-edit"));
    public Button addListButton = new Button(By.cssSelector("input.primary.mod-list-add-button.js-save-edit"));
    public Button listMenuButton = new Button(By.cssSelector("a.list-header-extras-menu.dark-hover.js-open-list-menu.icon-sm.icon-overflow-menu-horizontal"));
    public Button archiveListButton = new Button(By.cssSelector("a.js-close-list"));

    public Button cardButton = new Button(By.cssSelector("a.list-card.js-member-droppable.ui-droppable"));
    public Button labelsButton = new Button(By.cssSelector("a.button-link.js-edit-labels"));
    public Button editLabelButton = new Button(By.cssSelector("a.card-label-edit-button.icon-sm.icon-edit.js-edit-label"));
    public Field labelNameField = new Field(By.cssSelector("input#labelName.js-autofocus.js-label-name"));
    public Button addLabelButton = new Button(By.cssSelector("span.card-label.mod-selectable.card-label-green.js-select-label"));
    public Button closeLabelWindowButton = new Button(By.cssSelector("a.pop-over-header-close-btn.icon-sm.icon-close"));
    public Button closeCardWindowButton = new Button(By.cssSelector("a.icon-md.icon-close.dialog-close-button.js-close-window"));


}
