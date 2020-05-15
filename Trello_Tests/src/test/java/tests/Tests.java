package tests;

import TrelloAPI.Board;
import TrelloAPI.Label;
import TrelloAPI.ListTrello;
import TrelloAPI.RetrofitBuilder;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tests extends TestManager{

    @Test (priority = 1)
    public void checkAddMemberTrello() throws IOException, InterruptedException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        BoardPage boardPage = new BoardPage(driver);
        Board board = new Board();

        String idMember = "r3d_unicorn";

        int code = retrofitBuilder.getTrelloApi().addMember(boardId, idMember, "normal", board.getKey(), board.getToken()).execute().code();

        TimeUnit.SECONDS.sleep(1);
        boardPage.lastActivityPostContainer.highlight();
        Assert.assertEquals(code, 200);
    }

    @Test (priority = 2)
    public void checkAddMemberSelenium() throws InterruptedException {
        BoardPage boardPage = new BoardPage(driver);

        boardPage.addMemberButton.click();
        boardPage.memberNameField.sendKeys("julia17755319");
        boardPage.chooseMemberButton.click();
        boardPage.sendInviteButton.click();
        TimeUnit.SECONDS.sleep(1);

        boardPage.lastActivityPostContainer.highlight();

    }


    @Test (priority = 3)
    public void checkArchiveListTrello() throws IOException, InterruptedException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        BoardPage boardPage = new BoardPage(driver);
        ListTrello ListTrello = new ListTrello();

        String listName = "List1 created with Trello API";
        String value = "true";

        String idListLocal = retrofitBuilder.getTrelloApi().createList(boardId, listName, ListTrello.getKey(), ListTrello.getToken()).execute().body().getId();

        int code = retrofitBuilder.getTrelloApi().archiveList(idListLocal, value, ListTrello.getKey(), ListTrello.getToken()).execute().code();

        TimeUnit.SECONDS.sleep(1);
        boardPage.lastActivityPostContainer.highlight();
        Assert.assertEquals(code, 200);

    }

    @Test (priority = 4)
    public void checkArchiveListSelenium() throws InterruptedException {
        BoardPage boardPage = new BoardPage(driver);

        boardPage.addOneMoreListButton.click();
        boardPage.listNameField.sendKeys("List2 created with Selenium");
        boardPage.addListButton.click();
        boardPage.closeAddListWindowButton.click();
        TimeUnit.MILLISECONDS.sleep(200);
        boardPage.listMenuButton.clickLast();
        boardPage.archiveListButton.waitUntilClickable();
        boardPage.archiveListButton.click();
        TimeUnit.SECONDS.sleep(1);

        boardPage.lastActivityPostContainer.highlight();

    }

    @Test(priority = 5)
    public void checkAddLabelToCardTrello() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Label label = new Label("label1", boardId);

        Label createdLabel = retrofitBuilder.getTrelloApi().createLabel(label).execute().body();

        int code = retrofitBuilder.getTrelloApi().addLabel(cardId, createdLabel.getId(), label.getKey(), label.getToken()).execute().code();

        Assert.assertEquals(code, 200);
    }

    @Test (priority = 6)
    public void checkAddLabelToCardSelenium() throws InterruptedException {
        BoardPage boardPage = new BoardPage(driver);

        TimeUnit.SECONDS.sleep(1);
        boardPage.cardButton.click();
        boardPage.labelsButton.click();
        boardPage.editLabelButton.click();
        boardPage.labelNameField.sendKeys("label2"+Keys.ENTER);
        boardPage.addLabelButton.click();
        TimeUnit.MILLISECONDS.sleep(200);
        boardPage.closeLabelWindowButton.click();
        boardPage.closeCardWindowButton.click();
    }

}
