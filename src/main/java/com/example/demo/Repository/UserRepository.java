package com.example.demo.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> 
{
  //  public User findOne(int id);
	public User findByUsernameAndPassword(String username, String password);
}
