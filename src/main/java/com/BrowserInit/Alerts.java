package com.BrowserInit;

import com.microsoft.playwright.*;

public class Alerts
{
    public static void main(String[] args)
    {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://letcode.in/alert");
      page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept("Nandhu");
        });
//        page.locator("#accept").click();
//        page.locator("id=prompt").click();
//        System.out.println(page.locator("#myName").textContent());
        page.locator("id=confirm").click();




    }
}