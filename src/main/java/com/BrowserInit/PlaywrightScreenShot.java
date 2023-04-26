package com.BrowserInit;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotCaret;

import java.nio.file.Paths;
import java.util.Arrays;

public class PlaywrightScreenShot {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://github.com/ortoniKC/playwright-java-2023");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(".screenshot/img.png")));//direct screenshot by playwright
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(".ramya/img.jpg")).setFullPage(true));
        /*by playwright locators screenshots*/
        Locator searchLocator=page.getByPlaceholder("Search");
        searchLocator.click();
        searchLocator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(".nandhana/img.png")).setCaret(ScreenshotCaret.INITIAL));
        /*mask locators*/
    page.screenshot(new Page.ScreenshotOptions().setMask(Arrays.asList(searchLocator)).setPath(Paths.get("./rora/mask.png")));
     playwright.close();
    }
}
