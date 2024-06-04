package com.pom_manager;

import org.openqa.selenium.WebDriver;

import com.pom.CustomerLogin;
import com.pom.Customer_Dashboard;
import com.pom.Login_Page;
import com.pom.User_List;
import com.pom.User_Profile;
import com.pom.Cusromer_Profile;

public class Pom_Manager {

    private WebDriver driver; 

    public Pom_Manager(WebDriver driver) { 
        this.driver = driver;
    }

    private Login_Page lp;

    public Login_Page lp() {
        if (lp == null) {
            lp = new Login_Page(driver);
        }
        return lp;
    }
    
    private User_List ul;
    
    public User_List ul() {
    	if(ul==null) {
    		ul=new User_List(driver);
    	}
    	return ul;
    }
    
    private User_Profile up;
    public User_Profile up() {
    	if(up==null) {
    		up=new User_Profile(driver);
    	}
    	return up;
    }
    
    private CustomerLogin cl;
    public CustomerLogin cl() {
    	if(cl==null) {
    		cl=new CustomerLogin(driver);
    	}
    	return cl;
    }
    
    private Customer_Dashboard cd;
    public Customer_Dashboard cd() {
    	if (cd==null) {
			cd=new Customer_Dashboard(driver);
		}
    	return cd;
    }
    
    private Cusromer_Profile cp;
    public Cusromer_Profile cp() {
    	if(cp==null) {
    		cp=new Cusromer_Profile(driver);
    	}
    	return cp;
    }
}
