package com.ecart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecart.dao.UserDAO;
import com.ecart.model.User;
@Controller
public class PageController
{
 
	
	@RequestMapping("/")
	public String showIndexPage()
	{
		return "index";
	}
	
	@RequestMapping("/Home")
	public String showHomePage()
	{
		return "Home";
	}
	
	@RequestMapping("/header")
	public String showHeaderPage()
	{
		return "Header";
	}
	
	@RequestMapping("/header_1")
	public String showHeader_1Page()
	{
		return "Header_1";
	}
	
	@RequestMapping("/footer")
	public String showFooterPage()
	{
		return "Footer";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession Session)
	{
		return "Login";
	}
	
	@RequestMapping("/register")
	public String showRegister()
	{
		return "Register";
	}
	
	@RequestMapping("/aboutus")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/contactUs")
	public String showContactUs()
	{
		return "ContactUs";
	}
	
	@RequestMapping("/fiction")
	public String showFiction()
	{
		return "Fiction";
	}
	
	@RequestMapping("/history")
	public String showHistory()
	{
		return "History";
	}
	
	@RequestMapping("/horror")
	public String showHorror()
	{
		return "Horror";
	}
	
	@RequestMapping("/autobiography")
	public String showAutobiography()
	{
		return "Autobiography";
	}
	
	@RequestMapping("/biography")
	public String showBiography()
	{
		return "Biography";
	}
	
	@RequestMapping("/adminHome")
	public String showAdminPage()
	{
		return "AdminHome";
	}
	
	@RequestMapping("/userHome")
	public String showUserPage()
	{
		return "UserHome";
	}
	
	
}

