package com.project.khoaluan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.khoaluan.dao.ChiTietHoaDonRepository;
import com.project.khoaluan.entity.GheLichSuDvDOT;
import com.project.khoaluan.entity.LichSuDatVeDOT;
import com.project.khoaluan.entity.ThongKeDOT;
import com.project.khoaluan.entity.ThongkeSlDOT;
import com.project.khoaluan.model.ChiTietHoaDon;

@Service
public class ChiTietHoaDonDetailsServiceImpl implements ChiTietHoaDonDetailsService{
	@Autowired
	ChiTietHoaDonRepository chiTietHoaDonRepository;
	@Override
	public void addCTHD(ChiTietHoaDon CTHD) {
		chiTietHoaDonRepository.save(CTHD);
	}
	@Override
	public List<LichSuDatVeDOT> lichSuDatVe(int idNd) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.lichSuDatVe(idNd);
	}
	@Override
	public List<GheLichSuDvDOT> lichSuCtDatVe(int idNd) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.lichSuCtDatVe(idNd);
	}
	@Override
	public List<ThongKeDOT> thongKeRapThang(int thang, int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeRapThang(thang, nam);
	}
	@Override
	public List<ThongKeDOT> thongKeRapNgay(LocalDate ngay1, LocalDate ngay2) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeRapNgay(ngay1, ngay2);
	}
	@Override
	public List<ThongKeDOT> thongKeRapNam(int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeRapNam(nam);
	}
	@Override
	public List<ThongkeSlDOT> thongKeSlRapThang(int thang, int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeSlRapThang(thang, nam);
	}
	@Override
	public List<ThongkeSlDOT> thongKeSlRapNam(int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeSlRapNam(nam);
	}
	@Override
	public List<ThongkeSlDOT> thongKeSlRapNgay(LocalDate ngay1, LocalDate ngay2) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeSlRapNgay(ngay1, ngay2);
	}
	@Override
	public List<ThongKeDOT> thongKePhimNam(int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKePhimNam(nam);
	}
	@Override
	public List<ThongKeDOT> thongKePhimThang(int thang, int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKePhimThang(thang,nam);
	}
	@Override
	public List<ThongKeDOT> thongKePhimNgay(LocalDate ngay1, LocalDate ngay2) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKePhimNgay(ngay1, ngay2);
	}
	@Override
	public List<ThongkeSlDOT> thongKeSlPhimNam(int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeSlPhimNam(nam);
	}
	@Override
	public List<ThongkeSlDOT> thongKeSlPhimThang(int thang, int nam) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeSlPhimThang(thang, nam);
	}
	@Override
	public List<ThongkeSlDOT> thongKeSlPhimNgay(LocalDate ngay1, LocalDate ngay2) {
		// TODO Auto-generated method stub
		return chiTietHoaDonRepository.thongKeSlPhimNgay(ngay1, ngay2);
	}
	
}
