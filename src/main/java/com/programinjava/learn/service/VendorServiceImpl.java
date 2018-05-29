package com.programinjava.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programinjava.learn.model.Rating;
import com.programinjava.learn.model.Vendor;
import com.programinjava.learn.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	VendorRepository vendorRepository;
	
	@Override
	public int add(Vendor vendor) throws Exception {
		
		Vendor vendor1 =vendorRepository.save(vendor);
		if(vendor1 == null)
			throw new Exception("Vendor not saved");
		return vendor1.getId();
		
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void provideRating(Rating rating, Integer vendorId) throws Exception {

		if(vendorId !=null)
		{
			Optional<Vendor> vendor1 =vendorRepository.findById(vendorId);
			if(vendor1 == null)
				throw new Exception("Vendor not found");
			Vendor ve =vendor1.get();
			ve.getRatings().add(rating);
		}
		
		
	}

}
