package com.OpenCart;

import com.microsoft.playwright.Page;

public class HomePage {
 private    Page page;
//    object repository in string

    private String search = "input[name='search']";
    private String SearchButton = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String loginLink="a:text('Login')";


    //page constructor
    public HomePage(Page page) {
        this.page = page;
    }
//        page actions or methods

    public String getHomePageTitle() {
        String Title = page.title();
        System.out.println("page title:" + Title);
        return Title;

    }

    public String getHomePageUrl() {
        String Url = page.url();
        System.out.println("page url:" + Url);
        return Url;
    }

    public String doSearchTest(String productName) {
        page.fill(search, productName);
        page.click(SearchButton);
        String header = page.textContent(searchPageHeader);
        System.out.println("search header :"+ header);
        return header;
    }
    public LoginPage navigateToLoginPage(){
        page.click(loginLink);//this method has the responsibility to return the login page
        return new LoginPage(page);
    }

    }

