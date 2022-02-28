package com.project.khoaluan.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.Phong;

public interface PhongRepository  extends CrudRepository<Phong, Integer>{
	Phong findById(int id);
}
