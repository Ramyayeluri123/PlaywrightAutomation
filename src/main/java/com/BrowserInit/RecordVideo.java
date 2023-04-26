package com.BrowserInit;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class RecordVideo {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        com.microsoft.playwright.BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
        Page page = context.newPage();
        page.navigate("https://bookcart.azurewebsites.net/login");
        page.locator("//input[@formcontrolname=\"username\"]").type("ortoni");
        page.locator("//input[@formcontrolname=\"password\"]").type("Pass1234$");
        page.locator("//button[@color=\"primary\"]").click();
        page.locator("//span[@id=\"mat-badge-content-0\"]").click();
        page.close();
        playwright.close();
    }
}