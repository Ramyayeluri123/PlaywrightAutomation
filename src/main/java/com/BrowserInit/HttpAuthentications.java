package com.BrowserInit;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserContext;

public class HttpAuthentications {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser = playwright.firefox().launch();
        BrowserContext context= browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin","admin"));
        Page page=context.newPage();
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        System.out.println(page.locator("p").textContent());
        playwright.close();
    }
}
