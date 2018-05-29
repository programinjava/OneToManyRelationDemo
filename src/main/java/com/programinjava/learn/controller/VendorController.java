package com.programinjava.learn.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import com.programinjava.learn.model.Vendor;
import com.programinjava.learn.service.VendorService;

@RestController
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@PostMapping("/vendor")
	public ResponseEntity<Void> addVendor(@RequestBody Vendor vendor,BindingResult errors , HttpServletRequest request){
		if(errors.hasErrors())
		{
			return ResponseEntity.badRequest().build();
		}
		try {
			Integer id =vendorService.add(vendor);
			URI location = new UriTemplate(request.getRequestURI() + "/{id}").expand(id);
			return ResponseEntity.created(location).build();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().build();			
		}
		
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "Pong";
	}
	
	
	

}
