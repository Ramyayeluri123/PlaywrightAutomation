package com.BrowserInit;

import com.microsoft.playwright.*;

public class Practice {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://letcode.in/edit");
        page.locator("#fullName").type("ramya yeluri");
//        page.locator("#join").type("she");
        Locator locator= page.locator("#join");
      locator.press("End");//it enters the text in the end of the text field
    locator.type("Nandhana");// it fills one by one
        locator.press("Tab");//this is used to go for the next line of text
        String value=page.locator("id=getMe").getAttribute("value");
        page.locator("#clearMe").clear();
        System.out.println(value);
        page.close();
        browser.close();
        playwright.close();


    }
}