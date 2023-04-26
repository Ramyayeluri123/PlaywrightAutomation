package com.BrowserInit;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadMultipleFiles {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
//        page.navigate("https://www.sendgb.com/");
//        page.locator("span:has-text('OK')) >>  Visible=true").click();
//        page.locator("input[type='file']").setInputFiles(Paths.get(""));


        page.navigate("https://the-internet.herokuapp.com/upload");


        FileChooser fileChooser = page.waitForFileChooser(() -> {
            page.locator("id=drag-drop-upload").click();
        });
        boolean multiple = fileChooser.isMultiple();
        System.out.println(multiple);
        Thread.sleep(3000);
        fileChooser.setFiles(new Path[]{
                Paths.get("sample.xlsx"), Paths.get("ramya.xlsx"),Paths.get("google.pdf")});
        Thread.sleep(3000);
        playwright.close();

    }


}
