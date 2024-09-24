import models.Scooter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderRentInfoPage {

    private final WebDriver driver;

    // Поле «Когда привезти»
    private final By deliveryDate = By.xpath("//*[@placeholder ='* Когда привезти самокат']");
    // Поле «Срок аренды»
    private final By rentalDuration = By.cssSelector(".Dropdown-arrow-wrapper .Dropdown-arrow");
    // Чекбокс «Цвет самоката»
    private final By checkBoxColors = By.cssSelector(".Checkbox_Input__14A2w");
    // Список срока аренды
    private final By durationList = By.cssSelector(".Dropdown-option");
    // Поле «Комментарий для курьера»
    private final By deliveryComment = By.xpath("//*[@placeholder ='Комментарий для курьера']");
    // Кнопка «Заказать»
    private final By bottomOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");

    public OrderRentInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillScooterInfoFields(Scooter scooter) {
        driver.findElement(deliveryDate).sendKeys(scooter.getDeliveryDate());
        selectDuration(scooter.getRentalDuration().getValue());
        selectColor(scooter.getColor().getValue());
        driver.findElement(deliveryComment).sendKeys(scooter.getDeliveryComment());
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    private void selectDuration(int index) {
        driver.findElement(rentalDuration).click();
        List<WebElement> elements = driver.findElements(durationList);
        elements.get(index).click();
    }

    private void selectColor(int index) {
        List<WebElement> elements = driver.findElements(checkBoxColors);
        elements.get(index).click();
    }
}
