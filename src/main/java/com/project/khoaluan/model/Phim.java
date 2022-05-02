package com.project.khoaluan.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Phim implements Serializable{
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private int id;
		@Column(length = 2000)
		private String tenPhim;
		
		private int thoiLuong;
	
		private String moTa;
		
		private String theLoai;
		
		private String daoDien;
		
		private String dienVien;
		
		private	String trailer;
		
		private String hinhAnh;
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		private LocalDate ngayCongChieu;
		
		@OneToMany(mappedBy = "phim", cascade = CascadeType.ALL)
	     private List<SuatChieu> suats;
		
		@OneToMany(mappedBy = "phim", cascade = CascadeType.ALL)
	    private List<DanhGiaPhim> dGPs;
	
		
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTenPhim() {
			return tenPhim;
		}

		public void setTenPhim(String tenPhim) {
			this.tenPhim = tenPhim;
		}

		public int getThoiLuong() {
			return thoiLuong;
		}

		public void setThoiLuong(int thoiLuong) {
			this.thoiLuong = thoiLuong;
		}

		public String getMoTa() {
			return moTa;
		}

		public void setMoTa(String moTa) {
			this.moTa = moTa;
		}

		public String getTheLoai() {
			return theLoai;
		}

		public void setTheLoai(String theLoai) {
			this.theLoai = theLoai;
		}

		public String getDaoDien() {
			return daoDien;
		}

		public void setDaoDien(String daoDien) {
			this.daoDien = daoDien;
		}

		public String getDienVien() {
			return dienVien;
		}

		public void setDienVien(String dienVien) {
			this.dienVien = dienVien;
		}

		public String getTrailer() {
			return trailer;
		}

		public void setTrailer(String trailer) {
			this.trailer = trailer;
		}

		public String getHinhAnh() {
			return hinhAnh;
		}

		public void setHinhAnh(String hinhAnh) {
			this.hinhAnh = hinhAnh;
		}
		public LocalDate getNgayCongChieu() {
			return ngayCongChieu;
		}

		public void setNgayCongChieu(LocalDate ngayCongChieu) {
			this.ngayCongChieu = ngayCongChieu;
		}

		public Phim() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Phim(int id, String tenPhim, int thoiLuong, String moTa, String theLoai, String daoDien, String dienVien,
				String trailer, String hinhAnh, LocalDate ngayCongChieu) {
			super();
			this.id = id;
			this.tenPhim = tenPhim;
			this.thoiLuong = thoiLuong;
			this.moTa = moTa;
			this.theLoai = theLoai;
			this.daoDien = daoDien;
			this.dienVien = dienVien;
			this.trailer = trailer;
			this.hinhAnh = hinhAnh;
			this.ngayCongChieu = ngayCongChieu;
			
		}
		
		@Override
		public String toString() {
			return "Phim [id=" + id + ", tenPhim=" + tenPhim + ", thoiLuong=" + thoiLuong + ", moTa=" + moTa
					+ ", theLoai=" + theLoai + ", daoDien=" + daoDien + ", dienVien=" + dienVien + ", trailer="
					+ trailer + ", hinhAnh=" + hinhAnh + ", ngayCongChieu=" + ngayCongChieu + "]";
		}

		
		
		
		
		

}
