package com.BrowserInit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightLocators {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://letcode.in/test");
        page.locator("'Click'").click();
        System.out.println(page.url());
        page.locator("button:has-text('Goto Home')").click();
        System.out.println(page.url());
//        Thread.sleep(3000);
        page.locator("nav:text('Product')").click();
        System.out.println(page.url());
        playwright.close();



    }
}
