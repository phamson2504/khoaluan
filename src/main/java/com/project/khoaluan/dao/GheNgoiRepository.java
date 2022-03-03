package com.project.khoaluan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.khoaluan.model.GheNgoi;

public interface GheNgoiRepository extends CrudRepository<GheNgoi, Integer> {
	@Query(value="select n FROM Phong p INNER JOIN p.gheNgois n where p.id = 23")
	List<GheNgoi> gheNgoiCuaPhong();
}
