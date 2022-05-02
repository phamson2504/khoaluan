package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.khoaluan.entity.GheLichSuDvDOT;
import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.entity.ThongKeDOT;
import com.project.khoaluan.entity.ThongkeSlDOT;
import com.project.khoaluan.model.ChiTietHoaDon;

public interface ChiTietHoaDonDetailsService {
	public void addCTHD(ChiTietHoaDon CTHD);
	List<LichSuDatVeDOT> lichSuDatVe(int idNd);
	List<GheLichSuDvDOT> lichSuCtDatVe(int idNd);
	List<ThongKeDOT> thongKeRapThang(int thang,int nam);
	List<ThongKeDOT> thongKeRapNgay(LocalDate ngay1,LocalDate ngay2);
	List<ThongKeDOT> thongKeRapNam(int nam);
	List<ThongkeSlDOT> thongKeSlRapThang(int thang,int nam);
	List<ThongkeSlDOT> thongKeSlRapNam(int nam);
	List<ThongkeSlDOT> thongKeSlRapNgay(LocalDate ngay1,LocalDate ngay2);
	List<ThongKeDOT> thongKePhimNam(int nam);
	List<ThongKeDOT> thongKePhimThang(int thang,int nam);
	List<ThongKeDOT> thongKePhimNgay(LocalDate ngay1,LocalDate ngay2);
	List<ThongkeSlDOT> thongKeSlPhimNam(int nam);
	List<ThongkeSlDOT> thongKeSlPhimThang(int thang,int nam);
	List<ThongkeSlDOT> thongKeSlPhimNgay(LocalDate ngay1,LocalDate ngay2);
}
