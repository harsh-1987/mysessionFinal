package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AdminLogin;
import com.example.demo.Model.User;
import com.example.demo.Repository.AdminRepo;
import com.example.demo.Repository.UserRepository;



@Service
//@Transactional
public class UserService {

	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private AdminRepo adminrepo;



	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;

	}

	public void saveMyUser(User user ) {
		userRepository.save(user);
	}

	public List<User> showAllUsers()
	{
		List<User> users = new ArrayList<User>();
		for(User user : userRepository.findAll()) {
			users.add(user);

		}
		return users;
	}

	public void deleteMyUser(int id) {
		userRepository.deleteById(id);;
	}

	public User editUser(int id) {
		return userRepository.findById(id).orElse(null);


	}

	public User findByUsernameAndPassword(String username, String password)
	{
		return userRepository.findByUsernameAndPassword(username, password);

	}
	
	/*public UserService(AdminRepo adminrepo)
	{
		this.adminrepo = adminrepo;
	}*/
	
	/*public List<AdminLogin> ShowAdmin()
	{
		List<AdminLogin> adminData=new ArrayList<AdminLogin>();
		for(AdminLogin admin:adminrepo.findAll())
		{
			adminData.add(admin);
		}
		return adminData;
	}
	*/
	public AdminLogin findByadminNameadminPassword(String adminName, String adminPassword) {
		return adminrepo.findByAdminNameAndAdminPassword(adminName, adminPassword);
		
	}
	
}
