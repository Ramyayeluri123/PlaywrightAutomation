package com.BrowserInit;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class DropDownsPractice {
    public static void main(String[] args) throws InterruptedException {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://letcode.in/dropdowns");
//        page.selectOption("#fruits","4");//using page
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
