package tech;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.AuthorizationPage;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class FirstTest {

    public static WebDriver driver;
    private String correctMail = "correctMail@mail.ru";
    private String correctPassword = "correctPassword";


    @Before
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() throws InterruptedException {
        String text = new AuthorizationPage(driver)
                .goToStartLink()
                .sendLogin(correctMail)
                .sendPassword(correctPassword)
                .clickSubmitButton()
                .getQuestionText();
        assertEquals(text,"Сколько Вам лет?");
    }

    @After
    public void closeTest(){
        driver.quit();
    }
}
