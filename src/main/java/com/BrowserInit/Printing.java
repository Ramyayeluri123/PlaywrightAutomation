package com.BrowserInit;

import com.microsoft.playwright.*;

public class Printing {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.youtube.com/");
        Locator Printing=page.getByPlaceholder("Search");
        Printing.type("nature 4K");
        Printing.click();
//      page.getByPlaceholder("Search").type("nature 4k");
        page.locator("//button[@id=\"search-icon-legacy\"]").click();
        Thread.sleep(3000);
        page.locator("//h3[@id=\"video-title\"]").click();
        Thread.sleep(3000);
        page.close();
        playwright.close();
    }
}
