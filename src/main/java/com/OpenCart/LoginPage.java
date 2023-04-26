package com.OpenCart;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private String emailId = "#input-email";
    private String password = "#input-password";
    private String Login = "//input[@value=\"Login\"]";
    private String forgetPswd="//div[@class=\"form-group\"]//a[normalize-space()='Forgotten Password']";
    private String logoutLink="//a[@class='list-group-item'][normalize-space()='Logout']";


    public LoginPage(Page page){
        this.page=page;
    }
    public String getLoginPageTitle(){
      return   page.title();
    }
    public boolean isForgotPwdLinkExist(){
        return page.isVisible(forgetPswd);
    }
    public boolean doLogin(String appUsername,String appPassword){
        System.out.println("app creds:"+appUsername+":"+appPassword);
        page.fill(emailId,appUsername);
        page.fill(password,appPassword);
        page.click(Login);
        if (page.isVisible(logoutLink)){
            System.out.println("user logged successfully.......");
            return true;
        }
        return false;
    }

}
