package com.project.khoaluan.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.model.KhuVuc;
import com.project.khoaluan.model.Phim;
import com.project.khoaluan.model.Rap;

public interface KhuVucRepository extends CrudRepository<KhuVuc, Integer>{
	KhuVuc findById(int id);
	@Query(value="select DISTINCT kv "
			+ " FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where ph.id=:idPhim "
			+ "and  s.ngayChieu =:startDate")
	List<KhuVuc> khuVucCuaPhim(@Param("idPhim") int idPhim,@Param("startDate") LocalDate startDateL);
	@Query(value="select DISTINCT kv "
			+ " FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where s.ngayChieu =:startDate")
	List<KhuVuc> khuVucCuaRap(@Param("startDate") LocalDate startDateL);
}
