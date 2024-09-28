import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScooterPage {

    private final WebDriver driver;

    // Кнопка «Да все привыкли»
    private final By closeCookieButton = By.cssSelector(".App_CookieButton__3cvqF");
    // Кнопка «Заказать» вверху главной страницы
    private final By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC button[class='Button_Button__ra12g']");
    // Кнопка «Заказать» в центре главной страницы
    private final By middleOrderButton = By.cssSelector(".Button_Middle__1CSJM");
    // Список «Вопросы о важном»
    private final By dropDownQuestionsListButton = By.cssSelector(".accordion__heading");
    // Список овтеты на «Вопросы о важном»
    private final By dropDownAnswersListButton = By.cssSelector(".accordion__panel");

    public HomeScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void clickCloseCookieButton() {
        driver.findElement(closeCookieButton).click();
    }

    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

    public void clickDropDownQuestionsListButton(int index) {
        driver.findElements(dropDownQuestionsListButton).get(index).click();
    }

    public String getTextFromDownAnswersListButton(int index) {
        return driver.findElements(dropDownAnswersListButton).get(index).getText();
    }
}
