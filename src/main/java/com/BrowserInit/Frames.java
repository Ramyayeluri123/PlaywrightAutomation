package com.BrowserInit;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.regex.Pattern;

public class Frames {
    public static void main(String[] args) {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page= browser.newPage();
        page.navigate("https://letcode.in/frame");
       FrameLocator frameLocator=page.frameLocator("#firstFr");//second way of using frames in playwright.
       frameLocator.getByPlaceholder("Enter name").type("ramya");
        frameLocator.getByPlaceholder("Enter email").type("nandhana");
        List<Frame> frames=page.frames();
//        System.out.println(frames.size());
//        Frame frame= page.frame("firstFr");
//        frame.getByPlaceholder("Enter name").type("ramya");//First way if using framnes in playwright
//        frame.getByPlaceholder("Enter email").type("yeluri");
//        List<Frame> childFrames=frame.childFrames();
//        System.out.println(childFrames.size());
//        childFrames.forEach(f->{
//            System.out.println(f.url());});
//        Frame innerFrame=page.frameByUrl("https://letcode.in/innerframe");
        Frame innerFrame1=page.frameByUrl(Pattern.compile("innerFrame"));
        innerFrame1.getByPlaceholder("Enter email").type("yelurir4@gmail.com");
        playwright.close();
    }
}
