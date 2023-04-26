package com.BrowserInit;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class InteractWithMultipleElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://letcode.in/elements");
        page.getByPlaceholder("Enter your ").type("ortonikc");
        page.locator("id=search").click();
        Locator links=page.locator("ol li a");
        links.last().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED).setTimeout(2000));
        int count= links.count();
        System.out.println(count);
        for (int i=0;i<count;i++){
            String textContent=links.nth(i).textContent();
            System.out.println(textContent);
        }
        playwright.close();



    }
}
