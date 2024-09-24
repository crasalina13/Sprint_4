import models.ColorScooterEnum;
import models.RentalDurationEnum;
import models.Scooter;
import models.User;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class OrderHeaderButtonTest {

    private WebDriver driver;

    @After
    public void closePageScooter() {
        driver.quit();
    }

    @Test
    public void OrderHeaderButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomeScooterPage objHomeScooterPage = new HomeScooterPage(driver);
        objHomeScooterPage.clickCloseCookieButton();
        objHomeScooterPage.clickHeaderOrderButton();

        User user = new User(
                "Петр",
                "Котиков",
                "Кузьминки",
                "Россия",
                "89765564311"
        );

        OrderUserInfoPage objOrderUserInfoPage = new OrderUserInfoPage(driver);
        objOrderUserInfoPage.fillUserInfoFields(user);
        objOrderUserInfoPage.clickNextButton();

        Scooter scooter = new Scooter(
                "09.09.2024",
                RentalDurationEnum.FOUR_DAYS,
                ColorScooterEnum.GREY,
                "не стучать"
        );


        OrderRentInfoPage objOrderRentInfoPage = new OrderRentInfoPage(driver);
        objOrderRentInfoPage.fillScooterInfoFields(scooter);
        objOrderRentInfoPage.clickBottomOrderButton();

        ConfirmOrderPage objConfirmOrderPage = new ConfirmOrderPage(driver);
        objConfirmOrderPage.clickConfirmOrderButton();

        assertTrue("Не открылась страница заказа",objConfirmOrderPage.isDisplayedOrderWindow());
    }
}
