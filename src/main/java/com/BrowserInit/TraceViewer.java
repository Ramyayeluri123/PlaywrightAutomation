package com.BrowserInit;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserContext;

import java.nio.file.Paths;

public class TraceViewer {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context= browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        Page page= context.newPage();
        page.navigate("https://letcode.in/edit");
        page.locator("#fullName").type("ramya yeluri");
//        page.locator("#join").type("she");
        Locator locator= page.locator("#join");
        locator.press("End");//it enters the text in the end of the text field
        locator.type("nandhana");// it fills one by one
        locator.press("Tab");//this is used to go for the next line of text
        String value=page.locator("id=getMe").getAttribute("value");
        page.locator("#clearMe").clear();
        System.out.println(value);
        page.navigate("https://bookcart.azurewebsites.net/login");
       page.locator("//input[@formcontrolname=\"username\"]").type("ortoni");
        page.locator("//input[@formcontrolname=\"password\"]").type("Pass1234$");
        page.locator("//button[@color=\"primary\"]").click();
        page.locator("//span[@id=\"mat-badge-content-0\"]").click();
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        page.close();
        context.close();
        playwright.close();
    }
}
