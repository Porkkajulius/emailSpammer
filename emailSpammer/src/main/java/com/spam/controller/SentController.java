package com.spam.controller;
import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spam.bean.User;
import com.spam.util.SendMail;

@Controller
@RequestMapping(value = "/")
public class SentController {

	@Autowired
	private SendMail sposti;
	
	// Sent mail form
		@RequestMapping(value = "/sent/new", method = RequestMethod.GET)
		public String sentEmail(Model model) throws IOException {
			User user = new User();
			
			model.addAttribute("user", user);
			
			return "sentEmail";
		}

		// Sender
		@RequestMapping(value = "/sent/new", method = RequestMethod.POST)
		public String getEmail(@RequestParam("count") int count,@RequestParam("sub") String sub,@RequestParam("bod") String bod, @ModelAttribute User user) {
		
			
			
			System.out.println(count);
			  String to = user.getEmail();
		      String subject = (sub);
		      String body = (bod);
		      
		      for(int i=0; i<count;i++){
		    	  
			      sposti.sendMail(to, subject, body);
		    	  
		      }

		  
			return "redirect:/sent/new";
		}
	

}