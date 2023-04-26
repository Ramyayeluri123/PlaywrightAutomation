package com.BrowserInit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class PlayWrightSkipLogin {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        com.microsoft.playwright.BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("auth.json")) ) ;
        Page page= browser.newPage();
        page.navigate("https://bookcart.azurewebsites.net/login");
        page.locator("//input[@formcontrolname=\"username\"]").type("ortoni");
        page.locator("//input[@formcontrolname=\"password\"]").type("Pass1234$");
        page.locator("//button[@color=\"primary\"]").click();
        page.locator("//span[@id=\"mat-badge-content-0\"]").click();
        /*Generate Auth*/
//        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auth.json")));
        page.close();
        playwright.close();
    }
}
