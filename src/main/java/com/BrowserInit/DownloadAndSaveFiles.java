package com.BrowserInit;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DownloadAndSaveFiles {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://letcode.in/file");
       Download download= page.waitForDownload(()->{
            page.locator("'Download Excel'").click();}  );
        System.out.println(download.path());
        System.out.println(download.url());
        System.out.println(download.failure());
        System.out.println(download.suggestedFilename());
        download.saveAs(Paths.get(download.suggestedFilename()));
        playwright.close();

    }
}
