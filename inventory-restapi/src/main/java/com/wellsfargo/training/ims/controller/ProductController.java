package com.wellsfargo.training.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.ims.model.Product;
import com.wellsfargo.training.ims.service.ProductService;

/*
*Spring RestController annotation is used to create RESTful web services using Spring MVC. 
* Spring RestController takes care of mapping request data to the defined request handler method. 
* Once response body is generated from the handler method, it converts it to JSON or XML response. 
* 
* @RequestMapping - maps HTTP request with a path to a controller 
 */

@RestController
@RequestMapping(value="/api")
public class ProductController {
	
	//DI
	@Autowired
	private ProductService pservice;
	
	// POSTMAN - REST API Testing Tool

	/*Open PostMan, make a POST Request - http://localhost:8085/ims/api/products
	    Select body -> raw -> JSON 
	  Insert JSON product object.
	  @RequestBody converts JSON object into Java object / 
	  @RequestBody annotation automatically deserializes the JSON into a Java object
	*/
	
	//FLOW OF APP
	//Postman/Browser --> HTTP POST Request --> Controller --> Service --> Repository --> Database
	
	@PostMapping("/products")
	public Product saveProduct(@Validated @RequestBody Product product) {
		Product p =pservice.saveProduct(product);
		return p;
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return pservice.listAll();
	}

}
