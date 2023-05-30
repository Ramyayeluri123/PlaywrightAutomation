package com.BrowserInit;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class YouTubeTask {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.youtube.com/");
        page.getByPlaceholder("Search").type("nature 4k");
        page.locator("//button[@id=\"search-icon-legacy\"]").click();
        Thread.sleep(3000);
//      page.locator("//img[@id='emb67BA4A77']").click();
//        page.locator("//a[@id='video-title'and@title='How to interact with dropdown | Playwright (Java) - Part 4']").click();
        page.locator("//h3[@id=\"video-title\"]").click();
        Thread.sleep(3000);
        page.close();
        playwright.close();
    }
}