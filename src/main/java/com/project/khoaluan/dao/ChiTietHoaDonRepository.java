package com.project.khoaluan.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.khoaluan.entity.GheLichSuDvDOT;
import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.entity.ThongKeDOT;
import com.project.khoaluan.entity.ThongkeSlDOT;
import com.project.khoaluan.model.ChiTietHoaDon;

public interface ChiTietHoaDonRepository extends CrudRepository<ChiTietHoaDon, Integer>{
	@Query(value="select  new com.project.khoaluan.entity.ThongKeDOT(sum(ct.gia),r.tenRap)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where month(hd.ngayLap)=:thang and year(hd.ngayLap)=:nam GROUP BY r.tenRap")
	List<ThongKeDOT> thongKeRapThang(@Param("thang") int thang,@Param("nam") int nam);
	@Query(value="select  DISTINCT new com.project.khoaluan.entity.LichSuDatVeDOT(hd.id,ph.tenPhim,r.tenRap,p.tenPhong,DATE_FORMAT(hd.ngayLap, '%d/%m/%Y'),DATE_FORMAT(s.ngayChieu, '%d/%m/%Y'),s.gioBatDau,ct.gia)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where nd.id=:idNd ORDER BY hd.id")
	List<LichSuDatVeDOT> lichSuDatVe(@Param("idNd") int idNd);
	@Query(value="select  new com.project.khoaluan.entity.GheLichSuDvDOT(hd.id,ng.viTriHang,ng.viTriCot)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where nd.id=:idNd ORDER BY ng.viTriHang,ng.viTriCot")
	List<GheLichSuDvDOT> lichSuCtDatVe(@Param("idNd") int idNd);
	@Query(value="select new com.project.khoaluan.entity.ThongKeDOT(sum(ct.gia),r.tenRap)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where hd.ngayLap >=:ngay1 and hd.ngayLap <=:ngay2 GROUP BY r.tenRap")
	List<ThongKeDOT> thongKeRapNgay(@Param("ngay1") LocalDate ngay1,@Param("ngay2") LocalDate ngay2);
	@Query(value="select  new com.project.khoaluan.entity.ThongKeDOT(sum(ct.gia),r.tenRap)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where year(hd.ngayLap)=:nam GROUP BY r.tenRap")
	List<ThongKeDOT> thongKeRapNam(@Param("nam") int nam);
	@Query(value="select  new com.project.khoaluan.entity.ThongkeSlDOT(COUNT(ct.id),r.tenRap)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where month(hd.ngayLap)=:thang and year(hd.ngayLap)=:nam GROUP BY r.tenRap")
	List<ThongkeSlDOT> thongKeSlRapThang(@Param("thang") int thang,@Param("nam") int nam);
	@Query(value="select  new com.project.khoaluan.entity.ThongkeSlDOT(COUNT(ct.id),r.tenRap)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where year(hd.ngayLap)=:nam GROUP BY r.tenRap")
	List<ThongkeSlDOT> thongKeSlRapNam(@Param("nam") int nam);
	@Query(value="select  new com.project.khoaluan.entity.ThongkeSlDOT(COUNT(ct.id),r.tenRap)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where hd.ngayLap >=:ngay1 and hd.ngayLap <=:ngay2 GROUP BY r.tenRap")
	List<ThongkeSlDOT> thongKeSlRapNgay(@Param("ngay1") LocalDate ngay1,@Param("ngay2") LocalDate ngay2);
	
	@Query(value="select  new com.project.khoaluan.entity.ThongKeDOT(sum(ct.gia),ph.tenPhim)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where year(hd.ngayLap)=:nam GROUP BY ph.tenPhim")
	List<ThongKeDOT> thongKePhimNam(@Param("nam") int nam);
	@Query(value="select  new com.project.khoaluan.entity.ThongKeDOT(sum(ct.gia),ph.tenPhim)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where month(hd.ngayLap)=:thang and year(hd.ngayLap)=:nam GROUP BY ph.tenPhim")
	List<ThongKeDOT> thongKePhimThang(@Param("thang") int thang,@Param("nam") int nam);
	@Query(value="select new com.project.khoaluan.entity.ThongKeDOT(sum(ct.gia),ph.tenPhim)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where hd.ngayLap >=:ngay1 and hd.ngayLap <=:ngay2 GROUP BY ph.tenPhim")
	List<ThongKeDOT> thongKePhimNgay(@Param("ngay1") LocalDate ngay1,@Param("ngay2") LocalDate ngay2);
	@Query(value="select  new com.project.khoaluan.entity.ThongkeSlDOT(COUNT(ct.id),ph.tenPhim)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where year(hd.ngayLap)=:nam GROUP BY ph.tenPhim")
	List<ThongkeSlDOT> thongKeSlPhimNam(@Param("nam") int nam);
	@Query(value="select  new com.project.khoaluan.entity.ThongkeSlDOT(COUNT(ct.id),ph.tenPhim)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where month(hd.ngayLap)=:thang and year(hd.ngayLap)=:nam GROUP BY ph.tenPhim")
	List<ThongkeSlDOT> thongKeSlPhimThang(@Param("thang") int thang,@Param("nam") int nam);
	@Query(value="select  new com.project.khoaluan.entity.ThongkeSlDOT(COUNT(ct.id),ph.tenPhim)"
			+ " FROM Rap r INNER JOIN r.phongs p"
			+ " INNER JOIN p.suats s INNER JOIN s.phim ph INNER JOIN s.theloai tl "
			+ "INNER JOIN s.chiTHDs ct INNER JOIN ct.hoaDon hd INNER JOIN hd.nguoiDung nd "
			+ "INNER JOIN ct.gheNgoi ng where hd.ngayLap >=:ngay1 and hd.ngayLap <=:ngay2 GROUP BY ph.tenPhim")
	List<ThongkeSlDOT> thongKeSlPhimNgay(@Param("ngay1") LocalDate ngay1,@Param("ngay2") LocalDate ngay2);
}
