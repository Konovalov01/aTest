package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AuthorizationPage extends BasePage{

    private String startLink = "http://u920152e.beget.tech/# ";

    @FindBy(css = "input[name^='auth_email']")
    private WebElement loginInput;
    @FindBy(css = "input[name^='auth_pass']")
    private WebElement passwordInput;
    @FindBy(css = "button[name^='form_auth_submit']")
    private WebElement submitButton;

    public AuthorizationPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
        this.driver = driver;
    }

    public AuthorizationPage goToStartLink(){
        driver.get(startLink);
        return this;
    }

    public AuthorizationPage sendLogin(String login){
        loginInput.sendKeys(login);
        return this;
    }

    public AuthorizationPage sendPassword(String login){
        passwordInput.sendKeys(login);
        return this;
    }

    public InterviewPage clickSubmitButton(){
        submitButton.click();
        return new InterviewPage(driver);
    }


}
