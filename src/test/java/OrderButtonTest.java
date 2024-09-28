import models.ColorScooterEnum;
import models.RentalDurationEnum;
import models.Scooter;
import models.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderButtonTest {

    private static WebDriver driver;
    final User user;
    final Scooter scooter;


    public OrderButtonTest(User user, Scooter scooter) {
        this.user = user;
        this.scooter = scooter;
    }


    @After
    public void closePageScooter() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new User(
                        "Алина",
                        "Малина",
                        "Войковская",
                        "Россия",
                        "89763337890"
                ), new Scooter(
                        "09.01.2025",
                        RentalDurationEnum.FOUR_DAYS,
                        ColorScooterEnum.GREY,
                        "не стучать"
                )},
                {new User(
                        "Петр",
                        "Котиков",
                        "Кузьминки",
                        "Россия",
                        "89765564311"
                ), new Scooter(
                        "29.09.2024",
                        RentalDurationEnum.THREE_DAYS,
                        ColorScooterEnum.BLACK,
                        "стучать"
                )}
        });
    }

    @Test
    public void orderHeaderButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomeScooterPage objHomeScooterPage = new HomeScooterPage(driver);
        objHomeScooterPage.clickCloseCookieButton();
        objHomeScooterPage.clickHeaderOrderButton();

        OrderUserInfoPage objOrderUserInfoPage = new OrderUserInfoPage(driver);
        objOrderUserInfoPage.fillUserInfoFields(user);
        objOrderUserInfoPage.clickNextButton();

        OrderRentInfoPage objOrderRentInfoPage = new OrderRentInfoPage(driver);
        objOrderRentInfoPage.fillScooterInfoFields(scooter);
        objOrderRentInfoPage.clickBottomOrderButton();

        ConfirmOrderPage objConfirmOrderPage = new ConfirmOrderPage(driver);
        objConfirmOrderPage.clickConfirmOrderButton();

        assertTrue("Не открылась страница заказа", objConfirmOrderPage.isDisplayedOrderWindow());
    }

    @Test
    public void orderBottomButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomeScooterPage objHomeScooterPage = new HomeScooterPage(driver);
        objHomeScooterPage.clickCloseCookieButton();
        objHomeScooterPage.clickMiddleOrderButton();

        OrderUserInfoPage objOrderUserInfoPage = new OrderUserInfoPage(driver);
        objOrderUserInfoPage.fillUserInfoFields(user);
        objOrderUserInfoPage.clickNextButton();

        OrderRentInfoPage objOrderRentInfoPage = new OrderRentInfoPage(driver);
        objOrderRentInfoPage.fillScooterInfoFields(scooter);
        objOrderRentInfoPage.clickBottomOrderButton();

        ConfirmOrderPage objConfirmOrderPage = new ConfirmOrderPage(driver);
        objConfirmOrderPage.clickConfirmOrderButton();

        assertTrue("Не открылась страница заказа", objConfirmOrderPage.isDisplayedOrderWindow());
    }
}
