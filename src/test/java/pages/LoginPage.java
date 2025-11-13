package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("#login");
    private SelenideElement passwordField = $("#password");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement headerElement = $("h1");

    public void enterLogin(String login) {
        loginField.setValue(login);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getHeaderText() {
        return headerElement.getText();
    }
}