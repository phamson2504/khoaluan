package com.project.khoaluan.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.Rap;

public interface RapRepository extends CrudRepository<Rap, Integer>{
		Rap findById(int id);
}
