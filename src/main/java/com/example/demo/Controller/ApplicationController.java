package com.example.demo.Controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.AdminLogin;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;



@Controller
public class ApplicationController {

	@Autowired
	UserService userService;

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	/*@RequestMapping("/MBL_Auth")
	public String WelcomeMBL(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "UserLogin";
	}
*/
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "homepage";
	}

	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "UserLogin";
	}

	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "homepage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request,HttpServletResponse response)
	{
		
		
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) 
		{
			return "homepage";
		}
		
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}

	}
	
	@RequestMapping("/AdminLoginPage")
	public String AdminLogin(@ModelAttribute AdminLogin admin,HttpServletRequest request,HttpServletResponse response)
	{
		if(userService.findByadminNameadminPassword(admin.getAdminName(), admin.getAdminPassword()) != null)
		{
			return "homepage";
		}
		else
		{
			request.setAttribute("Error", "invalid admin");
			request.setAttribute("mode", "MODE_ADMIN");
			return "welcomepage";
		}
	}

	
		
}
