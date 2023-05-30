package com.BrowserInit;

import com.microsoft.playwright.*;

public class BrowserContext {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        com.microsoft.playwright.BrowserContext context=browser.newContext();
        Page page=context.newPage();
        page.navigate("https://bookcart.azurewebsites.net/login");
        Locator locator=page.locator("//input[@formcontrolname=\"username\"]");
        locator.type("ortoni");
        System.out.println(locator);
       //page.locator("//input[@formcontrolname=\"username\"]").type("ortoni");
       page.locator("//input[@formcontrolname=\"password\"]").type("Pass1234$");
       page.locator("//button[@color=\"primary\"]").click();
       page.locator("//span[@id=\"mat-badge-content-0\"]").click();
       page.bringToFront();
        page.locator("input[type='search']").type("HP2");
        page.close();
        com.microsoft.playwright.BrowserContext context1=browser.newContext();
        Page page1=context1.newPage();
        page1.navigate("https://bookcart.azurewebsites.net/login");
        playwright.close();

    }
}
