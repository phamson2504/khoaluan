package com.project.khoaluan.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.entity.ChiTietSuat;
import com.project.khoaluan.model.Rap;

public interface RapRepository extends CrudRepository<Rap, Integer>{
		Rap findById(int id);
		@Query(value="select DISTINCT r "
				+ " FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
				+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where ph.id=:idPhim "
				+ "and  s.ngayChieu =:startDate and kv.id =:idKV and tl.id =:idTL")
		List<Rap> rapCuaPhim(@Param("idPhim") int idPhim,@Param("startDate") LocalDate startDate,
				@Param("idKV") int idKV,@Param("idTL") int idTL);
		@Query(value="select DISTINCT r "
				+ " FROM KhuVuc kv INNER JOIN kv.raps r INNER JOIN r.phongs p"
				+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl where "
				+ "  s.ngayChieu =:startDate and kv.id =:idKV")
		List<Rap> rapCuaLichRap(@Param("startDate") LocalDate startDate,
				@Param("idKV") int idKV);
}
