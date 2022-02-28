package com.project.khoaluan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.Phim;


public interface PhimRepository extends CrudRepository<Phim, Integer> {
	
	Phim findById(int id);
	
	
	
}
