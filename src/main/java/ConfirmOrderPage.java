import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPage {

    private final WebDriver driver;

    // Кнопка «Да»
    private final By confirmOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]");
    // Окно «Заказ оформлен»
    private final By orderWindow = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Заказ оформлен')]");

    public ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isDisplayedOrderWindow() {
        return driver.findElement(orderWindow).isDisplayed();
    }
}
