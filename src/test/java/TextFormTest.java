import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextFormTest {
    @BeforeAll
     static void beforeAll() {
        Configuration.browserSize = "920x920";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Darya");
        $("#lastName").setValue("Melgunova");
        $("#userEmail").setValue("darya.melgunova@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999543121");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $(".react-datepicker__day.react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("380x240.jfif");
        $("#currentAddress").setValue("Street1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Darya Melgunova"));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("darya.melgunova@gmail.com"));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("8999543121"));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("04 March,1996"));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Music"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("380x240.jfif"));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text("Street1"));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));

    }

}

