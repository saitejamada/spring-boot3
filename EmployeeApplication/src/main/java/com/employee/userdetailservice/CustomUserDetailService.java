package com.employee.userdetailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.employee.model.Credientials;
import com.employee.repository.CredientailsRepo;
import com.employee.userdetails.CustomUserDetail;

@Service
public class CustomUserDetailService implements UserDetailsService{
@Autowired
CredientailsRepo repo;

public CredientailsRepo getRepo() {
	return repo;
}

public void setRepo(CredientailsRepo repo) {
	this.repo = repo;
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// TODO Auto-generated method stub
	Credientials up=repo.findByuserName(username);
//if(up==null)
//{
//	throw new UsernameNotFoundException("user not found"+username);
//}
return new CustomUserDetail(up);
}



}

