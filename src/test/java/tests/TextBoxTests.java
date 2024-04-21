package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Tusik");
        $("#userEmail").setValue("tusik@user.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 2");
        $("#submit").scrollIntoView(true).click();
        //$("#submit").click();

        $("#output").$("#name").shouldHave(text("Tusik"));
        $("#output").$("#email").shouldHave(text("tusik@user.com"));
        $("#output").$("#currentAddress").shouldHave(text("Some street 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Another street 2"));
    }
}
