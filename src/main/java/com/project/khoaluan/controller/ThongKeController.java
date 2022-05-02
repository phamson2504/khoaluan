package com.project.khoaluan.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.khoaluan.entity.ThongKeDOT;
import com.project.khoaluan.entity.ThongkeSlDOT;
import com.project.khoaluan.service.ChiTietHoaDonDetailsServiceImpl;

@Controller
@RequestMapping("/admin")
public class ThongKeController {
	@Autowired
	ChiTietHoaDonDetailsServiceImpl chiTietHoaDonDetailsServiceImpl;
	@RequestMapping("/thongke")
	public String thongKe(Model model) {
        return "ThongKe";
	}
	@RequestMapping("/theoNam")
	@ResponseBody
	public List<ThongKeDOT> theoNam(@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKeRapNam(nam);
	}
	@RequestMapping("/sltheoNam")
	@ResponseBody
	public List<ThongkeSlDOT> slTheoNam(@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKeSlRapNam(nam);
	}
	@RequestMapping("/phimTheoNam")
	@ResponseBody
	public List<ThongKeDOT> phimTheoNam(@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKePhimNam(nam);
	}
	@RequestMapping("/slPhimtheoNam")
	@ResponseBody
	public List<ThongkeSlDOT> slPhimTheoNam(@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKeSlPhimNam(nam);
	}
	
	@RequestMapping("/theothang")
	@ResponseBody
	public List<ThongKeDOT> theoThang(@RequestParam(value = "thang") int thang,@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKeRapThang(thang, nam);
	}
	@RequestMapping("/sltheothang")
	@ResponseBody
	public List<ThongkeSlDOT> slTheoThang(@RequestParam(value = "thang") int thang,@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKeSlRapThang(thang, nam);
	}
	@RequestMapping("/phimtheoThang")
	@ResponseBody
	public List<ThongKeDOT> phimTheoThang(@RequestParam(value = "thang") int thang,@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKePhimThang(thang, nam);
	}
	@RequestMapping("/slphimtheothang")
	@ResponseBody
	public List<ThongkeSlDOT> slPhimTheothang(@RequestParam(value = "thang") int thang,@RequestParam(value = "nam") int nam) {
        return chiTietHoaDonDetailsServiceImpl.thongKeSlPhimThang(thang, nam);
	}
	
	@RequestMapping("/theoNgay")
	@ResponseBody
	public List<ThongKeDOT> theoNgay(@RequestParam(value = "ngay1") String ngay1,@RequestParam(value = "ngay2") String ngay2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(ngay1, formatter);
		LocalDate date2 = LocalDate.parse(ngay2, formatter);
        return chiTietHoaDonDetailsServiceImpl.thongKeRapNgay(date1, date2);
	}
	@RequestMapping("/sltheoNgay")
	@ResponseBody
	public List<ThongkeSlDOT> slTheoNgay(@RequestParam(value = "ngay1") String ngay1,@RequestParam(value = "ngay2") String ngay2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(ngay1, formatter);
		LocalDate date2 = LocalDate.parse(ngay2, formatter);
        return chiTietHoaDonDetailsServiceImpl.thongKeSlRapNgay(date1, date2);
	}
	@RequestMapping("/phimtheoNgay")
	@ResponseBody
	public List<ThongKeDOT> phimTheoNgay(@RequestParam(value = "ngay1") String ngay1,@RequestParam(value = "ngay2") String ngay2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(ngay1, formatter);
		LocalDate date2 = LocalDate.parse(ngay2, formatter);
        return chiTietHoaDonDetailsServiceImpl.thongKePhimNgay(date1, date2);
	}
	@RequestMapping("/slphimtheoNgay")
	@ResponseBody
	public List<ThongkeSlDOT> slPhimTheoNgay(@RequestParam(value = "ngay1") String ngay1,@RequestParam(value = "ngay2") String ngay2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(ngay1, formatter);
		LocalDate date2 = LocalDate.parse(ngay2, formatter);
        return chiTietHoaDonDetailsServiceImpl.thongKeSlPhimNgay(date1, date2);
	}
	
}
