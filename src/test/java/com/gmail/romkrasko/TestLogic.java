package com.gmail.romkrasko;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

import static com.gmail.romkrasko.BrowserFactory.*;

public class TestLogic {

    private BrowserFactory singleton = BrowserFactory.getInstance();


    public void goYandex() {
        driver = singleton.setDriver();
        driver.get("https://market.yandex.by/catalog/54726/list?local-offers-first=0&deliveryincluded=0&onstock=1/");
    }

    public void checkCheckBox(){
        WebElement check = driver.findElement((By.xpath("//label[@class='_1e7iX1B2oW'][@for='delivery-included-filter']")));
        scrollToElement(check);
        check.click();
        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();",check);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }
    }

    public void checkRadio(){
        WebElement radioButton = driver.findElement(By.xpath("//li/div/label[@class='_2qeJ9otxLk'][@for='qrfrom_2']"));
        scrollToElement(radioButton);
        radioButton.click();
        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();",radioButton);
    }

    public void selectDropDown() {
        WebElement drop = driver.findElement(By.cssSelector("div.n-pager.i-bem.n-pager_js_inited span button"));
        WebElement qqq = driver.findElement(By.xpath("//div[@class='n-popular-recipes-list__item']"));
        scrollToElement(qqq);
        drop.click();

        WebElement value12 = driver.findElement(By.xpath("//div[@class='popup__content']/div/div/span"));
        value12.click();



    }


    public void enterInInput(){
        WebElement input = driver.findElement(By.xpath("//input[@class='_2yK7W3SWQ- _1d02bPcWht']"));
        scrollToElement(input);
        input.sendKeys("123");

        System.out.println(input.getAttribute("value"));
    }


    public void scrollToElement(WebElement element){

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }

    }



}