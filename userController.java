package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.User;
import com.example.demo.service.userDaoImpl;
import com.example.demo.service.userRepository;

@Controller
public class userController {
	
   private userRepository  UserRepository;
	
	@RequestMapping("/")
	public String showIndexPage() {
		System.out.println("This is Login Page");
		return "login";
	}


	@RequestMapping("/addUser")
	public String showEmployee() {
		System.out.println("This is show user");
		return "AddUser";
	}

	@Autowired
	userDaoImpl uc;
	@RequestMapping("/validate")
	public ModelAndView addUser(@ModelAttribute User user) {
		System.out.println("This is adduser");
		System.out.println(user);
		int i = 1;
		if (i == 1) {
			uc.addUser(user);
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("message", "Record added Sucessfully");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("message", "Error Occured");
			return mv;
		}
		
		
	}
	@RequestMapping("/Update/{id}")
	    public String updateUser(@PathVariable(value = "id") int id, @ModelAttribute("user") User user) {
		 UserRepository .save(user);
	        return "update:/";
	    }
	@DeleteMapping("Delete/{userid}")
	public String deleteUser(@PathVariable long userid) throws Exception {
	
		UserRepository.deleteById(userid);
		return "delete.jsp";
	}
	 @GetMapping("/records")
	    public ModelAndView listRecords(@RequestParam(name = "search", required = false) String searchQuery) {
	        List<Record> records;
	        if (searchQuery != null && !searchQuery.isEmpty()) {
	            // Perform a search based on the provided search query
	            records = recordService.searchRecords(searchQuery);
	        } else {
	            // Retrieve all records
	            records = recordService.getAllRecords();
	        }

	        ModelAndView modelAndView = new ModelAndView("listPage");
	        modelAndView.addObject("records", records);
	        return modelAndView;
	    }
	
	
	
	
	 private static final Logger logger = LogManager.getLogger(User.class.getName());

	     {
	        // Log significant events
	        logger.info("Application started.");

	        try {
	            // Perform CRUD operations
	            createRecord();
	        } catch (Exception e) {
	            // Log exception and handle gracefully
	            logger.error("Error creating record: " + e.getMessage(), e);
	            // Notify administrators via email
	            sendErrorEmail("Error creating record", e.getMessage());
	        }

	        // Log other events
	        logger.info("Application shutdown.");
	    }

	    // Example method for CRUD operation
	    private static void createRecord() throws Exception {
	        // Simulate an error (e.g., database connection failure)
	        throw new Exception("Database connection failed");
	    }

	    // Send email for error notification
	    private static void sendErrorEmail(String subject, String errorMessage) {
	        try {
	            // Create HTML email
	            Email email = new HtmlEmail();
	            email.setHostName("smtp.example.com"); // SMTP server host
	            email.setSmtpPort(587); // SMTP port
	            email.setAuthentication("username", "password"); // SMTP authentication
	            email.setStartTLSEnabled(true); // Enable TLS

	            email.setFrom("admin@example.com");
	            email.setSubject(subject);
	            email.setMsg("An error occurred: " + errorMessage);
	            email.addTo("admin@example.com");

	            // Send email
	            email.send();
	        } catch (EmailException e) {
	            // Log email sending error
	            logger.error("Error sending email notification: " + e.getMessage(), e);
	        }
	    }
}
 

	


