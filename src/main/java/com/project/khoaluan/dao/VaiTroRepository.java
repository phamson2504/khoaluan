package com.project.khoaluan.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.VaiTro;


public interface VaiTroRepository extends CrudRepository<VaiTro, Integer> {

    VaiTro findByTen(String name);
    

}