package com.vasu.fairshare.account.validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vasu.fairshare.account.model.User;
import com.vasu.fairshare.account.service.SecurityService;
import com.vasu.fairshare.account.service.UserService;
import com.vasu.fairshare.commons.UserControllerConstants;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String registration(Model model){
		logger.info("CONTROLLER: User controller Handling /register");
		model.addAttribute(UserControllerConstants.USER_FORM, new User());
		return UserControllerConstants.REGISTRATION_PAGE;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute(UserControllerConstants.USER_FORM) User userForm, BindingResult bindingResult, Model model){
		userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()){
			return "registration";
		}
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		
		return "redirect:/welcome";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(Model model, String error, String logout){
		if(error!=null){
			model.addAttribute("error", "Your credentials are not valid");
		}
		
		if(logout != null){
			model.addAttribute("message", "You have been successfully logged out");
		}
		
		return "login";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String landingPage(Model model){
		logger.info("CONTROLLER: User controller Handling /");
		return UserControllerConstants.LANDING_PAGE;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(null!= auth){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	
	 @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
	    public String welcome(Model model) {
	        return "welcome";
	}
}
