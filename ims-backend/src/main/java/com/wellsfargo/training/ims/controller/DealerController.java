package com.wellsfargo.training.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.ims.model.Address;
import com.wellsfargo.training.ims.model.Dealer;
import com.wellsfargo.training.ims.service.DealerService;
import com.wellsfargo.training.ims.exception.ResouceNotFoundException;

/*
 * Controller for registration and login process of a dealer
 */
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/api")
public class DealerController {

	@Autowired //DI
	private DealerService dservice;
	
	/* ResponseEntity represents an HTTP response, including headers, body, and status. */
	
	@PostMapping("/register")
	public ResponseEntity<String> createDealer(@Validated @RequestBody Dealer dealer) {
		
		try {
			Address address = dealer.getAddress();
			
			//Establish the bidirectional 1-1 Mapping
			address.setDealer(dealer);
			dealer.setAddress(address);
			
			Dealer registerDealer = dservice.registerDealer(dealer);
			
			if(registerDealer!=null) {
				return ResponseEntity.ok("Registration Successful");
			} else {
				return ResponseEntity.badRequest().body("Registration Failed");
			}
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An Error Occured: " + e.getMessage());
		}
	}
	
	
	//Open Postman and make POST request with email & password - 
		// http://localhost:8085/ims/api/login
	
	@PostMapping("/login")
	public Boolean loginDealer(@Validated @RequestBody Dealer d) throws ResouceNotFoundException {
		
		Boolean isLoggedin=false;
		
		String email=d.getEmail();
		String password=d.getPassword();
		
		Dealer dealer = dservice.loginDealer(email).orElseThrow(() -> new ResouceNotFoundException("Dealer not found for this Email Id :: "));
		
		if(email.equals(dealer.getEmail()) && password.equals(dealer.getPassword())) {
			isLoggedin=true;
		}
		return isLoggedin;
	}
}
