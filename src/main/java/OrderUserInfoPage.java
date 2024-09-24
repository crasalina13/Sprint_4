import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderUserInfoPage {

    private final WebDriver driver;

    // Станция метро
    private static final String METRO_STATION_XPATH = "//div[@class='Order_Text__2broi' and contains(text(), '%s')]";

    // Поле «Имя»
    private final By firstNameField = By.xpath("//*[@placeholder ='* Имя']");
    // Поле «Фамилия»
    private final By lastNameField = By.xpath("//*[@placeholder ='* Фамилия']");
    // Поле «Адрес»
    private final By addressField = By.xpath("//*[@placeholder = '* Адрес: куда привезти заказ']");
    // Поле «Станция метро»
    private final By metroField = By.xpath("//*[@placeholder = '* Станция метро']");
    // Поле «Телефон»
    private final By phoneField = By.xpath("//*[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка «Далее»
    private final By nextButton = By.cssSelector(".Order_NextButton__1_rCA .Button_Button__ra12g");

    public OrderUserInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUserInfoFields(User user) {
        driver.findElement(firstNameField).sendKeys(user.getFirstNameField());
        driver.findElement(lastNameField).sendKeys(user.getLastNameField());
        driver.findElement(addressField).sendKeys(user.getAddressField());
        setMetroField(user.getMetroField());
        driver.findElement(phoneField).sendKeys(user.getPhoneField());
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    private void setMetroField(String text) {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(String.format(METRO_STATION_XPATH, text))).click();
    }
}
