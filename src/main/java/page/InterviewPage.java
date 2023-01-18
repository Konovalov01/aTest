package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class InterviewPage extends BasePage{

    @FindBy(css = "form[class^='form_auth_style'] p")
    private WebElement questionLabel;

    public InterviewPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
        this.driver = driver;
    }

    public String getQuestionText(){
        String text = questionLabel.getText();
        return text;
    }
}
