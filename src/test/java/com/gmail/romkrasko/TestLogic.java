package com.gmail.romkrasko;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import static com.gmail.romkrasko.BrowserFactory.*;

public class TestLogic {

    private BrowserFactory singleton = BrowserFactory.getInstance();
    private JavascriptExecutor js = (JavascriptExecutor) driver;


    public void goYandex() {
        driver = singleton.setDriver();
        driver.get("https://market.yandex.by/catalog/54726/list?local-offers-first=0&deliveryincluded=0&onstock=1/");
    }

    public void checkCheckBox(){
        WebElement check = driver.findElement((By.xpath("//label[@class='_1e7iX1B2oW'][@for='delivery-included-filter']")));//"delivery-included-filter  #local-offers-first
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
        WebElement drop = driver.findElement(By.xpath("//span[@class='select select_size_s select_theme_normal b-pager__select i-bem select_js_inited']"));

        scrollToElement(drop);

        Select dropDown = new Select(driver.findElement(By.xpath("//select")));
        dropDown.selectByVisibleText("Показывать по 12");
    }

    public void enterInInput(){
        WebElement input = driver.findElement(By.xpath("//input[@class='_2yK7W3SWQ- _1d02bPcWht']"));
        scrollToElement(input);
        input.sendKeys("123");

        System.out.println(input.getAttribute("value"));
    }


    public void scrollToElement(WebElement element){
        Point point = element.getLocation();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo("+point.getX()+","+point.getY()+");");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }

    }



}