package com.gmail.romkrasko;

import org.testng.annotations.*;

import static com.gmail.romkrasko.BrowserFactory.*;

public class BaseTest{

    private TestLogic logic = new TestLogic();

    @BeforeTest
    public void setUp() {
        logic.goYandex();
    }

    @Test
    public void tests() {

        logic.checkCheckBox();

        logic.checkRadio();

        logic.selectDropDown();

        logic.enterInInput();


    }



    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
