package com.project.khoaluan.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.TheLoai;

public interface TheLoaiRepository extends CrudRepository<TheLoai, Integer>{
	TheLoai findById(int id);
}
