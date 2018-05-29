package com.programinjava.learn.service;

import com.programinjava.learn.model.Rating;
import com.programinjava.learn.model.Vendor;

public interface VendorService {

	
	   public int add(Vendor vendor) throws Exception;
	   
	   public void getAll();
	   
	   public void provideRating(Rating rating , Integer vendorId) throws Exception;
}
