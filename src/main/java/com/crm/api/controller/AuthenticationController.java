package com.crm.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UserDetails;

import com.crm.api.model.AuthenticationDTO;
import com.crm.api.model.LoginResponseDTO;
import com.crm.api.model.RegisterDTO;
import com.crm.api.model.User;
import com.crm.api.repository.UserRepository;
import com.crm.api.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TokenService tokenService;

	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var token = "";
		
		try {

			var auth = this.authenticationManager.authenticate(usernamePassword);
			//var auth = this.repository.findByLogin(data.login());
			
			token = tokenService.generateToken((User) auth.getPrincipal());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		
		if(this.repository.findByLogin(data.login()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		var encriptyPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encriptyPassword, data.role());
		
		this.repository.save(newUser);
		
		return ResponseEntity.ok().build();
		
	}
}
