package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class RoomPage {
    private SelenideElement roomNameField = $("#roomName");
    private SelenideElement capacityField = $("#capacity");
    private SelenideElement createButton = $("#createRoom");

    public void fillRoomName(String name) {
        roomNameField.setValue(name);
    }

    public void fillCapacity(String capacity) {
        capacityField.setValue(capacity);
    }

    public void clickCreate() {
        createButton.click();
    }
}