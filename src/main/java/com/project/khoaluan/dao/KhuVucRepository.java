package com.project.khoaluan.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.Phim;

public interface KhuVucRepository extends CrudRepository<KhuVuc, Integer>{
	KhuVuc findById(int id);
}
