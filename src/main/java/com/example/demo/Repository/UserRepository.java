package com.example.demo.Repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> 
{
  //  public User findOne(int id);
	public User findByUsernameAndPassword(String username, String password);
}
