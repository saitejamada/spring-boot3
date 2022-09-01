package com.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.employee.model.Credientials;
import com.employee.repository.CredientailsRepo;

@Service
public class CredentailsService {

	@Autowired
	private CredientailsRepo credientailsRepo;
	
	@Autowired
	BCryptPasswordEncoder bpc;

	// it will save credentials into database
	public Credientials saveCrediantials(Credientials c) throws Exception{
		//c.setPassword(CipherPassword.encrypt(c.getPassword()));
		c.setPassword(this.bpc.encode(c.getPassword()));
		return credientailsRepo.save(c);
	}
	//it will retrieve all users from database and return the list of users
	public List<Credientials> allUsers(){
		return credientailsRepo.findAll();
	}
	//it will delete user from database
	public  void deleteUser(Credientials c1){
		credientailsRepo.delete(c1);
	}
	//it will find the  user and return it
	public Credientials findUser(String name){
		Credientials c =credientailsRepo.findByuserName(name);
		return c;
		//		try {
//			c.setPassword(CipherPassword.decrypt(c.getPassword()));
//			return c;
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
		
	}
	
	 
	
}
