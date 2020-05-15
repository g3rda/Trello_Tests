package tests;

import TrelloAPI.Board;
import TrelloAPI.Card;
import TrelloAPI.RetrofitBuilder;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.LoginPage;
import pages.PageWithBoards;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestManager {
    static WebDriver driver;
    static WebDriverWait wait;

    protected String boardId;
    private String idList;
    protected String cardId;

    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait getWaitDriver() {return wait; }

    @BeforeSuite
    public void firstBefore_RunDriver() {
        System.setProperty("webdriver.chrome.driver", "your_path_to_webdriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @BeforeSuite(dependsOnMethods={"firstBefore_RunDriver"})
    public void secondBefore_Login() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage(homePage.url);

        homePage.loginLink.click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailField.sendKeys("trello.final.project@gmail.com");
        loginPage.passwordHiddenField.waitUntilInvisible();
        loginPage.emailField.sendKeys(Keys.ENTER);
        loginPage.loginButton.waitUntilClickable();
        loginPage.passwordField.sendKeys("gr33n_unicorns" + Keys.ENTER);
    }

    @BeforeSuite(dependsOnMethods={"secondBefore_Login"})
    public void thirdBefore_CreateBoard() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();

        String boardName = "Board created with Trello API at " + dtf.format(now);

        boardId = retrofitBuilder.getTrelloApi().createBoard(board, boardName).execute().body().getId();

        PageWithBoards pageWithBoards = new PageWithBoards(driver);
        pageWithBoards.setBoardPageLink(boardName);
        pageWithBoards.boardPageLink.waitUntilVisible();


        pageWithBoards.boardPageLink.click();
    }

    @BeforeSuite(dependsOnMethods={"thirdBefore_CreateBoard"})
    public void forthBefore_CreateListAndCard() throws InterruptedException, IOException {
        TimeUnit.SECONDS.sleep(3);
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        idList = retrofitBuilder.getTrelloApi().createList(boardId, "Created with Trello", board.getKey(), board.getToken()).execute().body().getId();

        Card card = new Card("New card", "some info", idList);
        TimeUnit.SECONDS.sleep(1);
        cardId = retrofitBuilder.getTrelloApi().createCard(card, board.getKey(), board.getToken()).execute().body().getId();
    }

    @AfterSuite
    public void deleteBoardAndQuit() throws IOException {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        Board board = new Board();
        int code = retrofitBuilder.getTrelloApi().deleteBoard(boardId, board.getKey(), board.getToken()).execute().code();

        Assert.assertEquals(code, 200);

        driver.quit();
    }

}
