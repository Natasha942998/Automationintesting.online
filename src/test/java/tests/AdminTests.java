package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.RoomPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTests {

    private static WebDriver driver;

        @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-debugging-pipe"); // Альтернатива DevToolsActivePort
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }


    @Test
    void testAdminLogin() {
        open("https://automationintesting.online/#/admin");
        LoginPage loginPage = new LoginPage();

        loginPage.enterLogin("admin");
        loginPage.enterPassword("password");
        loginPage.clickSubmit();

        // Проверка успешного входа (по заголовку)
        String headerText = loginPage.getHeaderText();
        assertEquals("Admin Panel", headerText);
    }

    @Test
    void testCreateRoom() {
        open("https://automationintesting.online/#/admin");
        LoginPage loginPage = new LoginPage();

        // Авторизация
        loginPage.enterLogin("admin");
        loginPage.enterPassword("password");
        loginPage.clickSubmit();

        // Создание комнаты
        RoomPage roomPage = new RoomPage();
        roomPage.fillRoomName("Test Room");
        roomPage.fillCapacity("10");
        roomPage.clickCreate();
    }
}