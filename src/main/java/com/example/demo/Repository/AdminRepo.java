package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.AdminLogin;

@Repository
public interface AdminRepo extends CrudRepository<AdminLogin, Integer>
{
	public AdminLogin findByAdminNameAndAdminPassword(String adminName,String adminPassword);

}
