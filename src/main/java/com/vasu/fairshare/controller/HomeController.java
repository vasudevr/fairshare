package com.vasu.fairshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author Vasudev Ramachandran
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home(){
		return "landing";
	}
	
	/*@RequestMapping(value ="/" , method=RequestMethod.GET)
	public String loginPage(Model model){
		return "landing";
	}*/

}
