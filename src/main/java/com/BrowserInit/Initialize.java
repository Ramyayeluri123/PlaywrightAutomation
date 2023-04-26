package com.BrowserInit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Initialize {
    public static void main(String[] args) {
//        https://practice.expandtesting.com/

        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.lambdatest.com/playwright");
        System.out.println(page.title());
        page.close();
        browser.close();
        playwright.close();


    }
}
