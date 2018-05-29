package com.programinjava.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programinjava.learn.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{
	
	

}
