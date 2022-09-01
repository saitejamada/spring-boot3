package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.helper.JwtTokenUtil;
import com.employee.model.Credientials;
import com.employee.model.JwtResponse;
import com.employee.userdetailservice.CustomUserDetailService;



@RestController
public class JWTController {
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	
	@PostMapping("/signin")
	public ResponseEntity<?> generateToken(@RequestBody Credientials c){
		try {
			this.mgr.authenticate(new UsernamePasswordAuthenticationToken(c.getUserName(),c.getPassword()));
		}catch(UsernameNotFoundException ue){
			throw new UsernameNotFoundException("user not found");
		}	
		UserDetails ud=this.customUserDetailService.loadUserByUsername(c.getUserName());
		String token=this.jwttokenutil.generateToken(ud);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("token is" +token);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
