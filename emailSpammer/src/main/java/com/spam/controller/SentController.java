package com.spam.controller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

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
			
			// Here is new user creation, just for future use if needed
			User user = new User();			
			model.addAttribute("user", user);
			
			return "sentEmail";
		}

		// Sender, parameters from form will be returned here
		@RequestMapping(value = "/sent/new", method = RequestMethod.POST)
		public String getEmail(@RequestParam("count") int count,@RequestParam("sub") String sub,@RequestParam("bod") String bod, @ModelAttribute User user) throws DocumentException {		  
			
			System.out.println(count);
			
			// Email parameters will be inserted to variables
			String to = user.getEmail();
			String subject = (sub);
			String body = (bod);
		      
		     // count contains requested email count
		     for(int i=0; i<count;i++){
		    	  
		    	 	// uses sendMail method from sposti util for sending email messages
		    	 	sposti.sendMail(to, subject, body);
		    	  
		      }

			return "redirect:/sent/new";
		}

}