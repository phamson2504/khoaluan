package com.project.khoaluan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.ChiTietHoaDon;
import com.project.khoaluan.model.GheNgoi;

public interface GheNgoiRepository extends CrudRepository<GheNgoi, Integer> {
	@Query(value="select n FROM Phong p INNER JOIN p.gheNgois n INNER JOIN p.suats s where s.id =:idSuat")
	List<GheNgoi> gheNgoiCuaSuat(@Param("idSuat") int idSuat);
	
	@Query(value="select gn FROM GheNgoi gn INNER JOIN gn.chiTHDs ct INNER JOIN ct.suatChieu s where s.id =:idSuat")
	List<GheNgoi> gheDaChon(@Param("idSuat") int idSuat);
}
