package com.BrowserInit;

import com.google.gson.JsonObject;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DropDownsPractice {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            JsonObject capabilities = new JsonObject();
            JsonObject ltOptions = new JsonObject();
            String user = "userId"; // add your userid
            String accessKey = "Accesskey"; // add your accesskey
            capabilities.addProperty("browsername", "pw-chromium");
            capabilities.addProperty("browserVersion", "latest");
            ltOptions.addProperty("platform", "Windows 10");
            ltOptions.addProperty("name", "Playwright Test");
            ltOptions.addProperty("build", "Playwrite Testing in Java");
            ltOptions.addProperty("user", user);
            ltOptions.addProperty("accessKey", accessKey);
            capabilities.add("LT:Options", ltOptions);

            BrowserType chromium = playwright.chromium();
            String caps = URLEncoder.encode(capabilities.toString(), "utf-8");
            String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + capabilities;
            Browser browser = chromium.connect(cdpUrl);
            Page page = browser.newPage();

            page.navigate("https://www.saucedemo.com/");
            Locator locator = page.locator("#login-button");
            locator.click();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://letcode.in/dropdowns");
        page.selectOption("#fruits","4");//using page
        Thread.sleep(3000);
        Locator SelectingFruits=page.locator("#fruits");
//        SelectingFruits.selectOption(new SelectOption().setLabel("Orange"));//using label
        SelectingFruits.selectOption(new SelectOption().setIndex(5)); //using index


//        SelectingFruits.selectOption("3");
        String selectionMessage=page.locator("p.subtitle").textContent();//using textContent
        System.out.println(selectionMessage);//printing  the selecting fruit console
        Locator heros=page.locator("id=superheros");
        heros.selectOption(new String[]{"ta","bp","am"});
        System.out.println(heros);
        Locator selectingLanguage=page.locator("id=lang");
        selectingLanguage.selectOption("java");
        playwright.close();



    }

}
