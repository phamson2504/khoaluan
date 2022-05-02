package com.project.khoaluan.model;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nguoi_dung")
public class NguoiDung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "matKhau", nullable = false)
    private String matKhau;
    
    private String hoTen;
    
    private String sdt;
    
    private String ngaySinh;
    
    private String gioiTinh;
    
    private String tokenQuenMatKhau;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "nguoidung_vaitro",
            joinColumns = @JoinColumn(name = "nguoidung_id"),
            inverseJoinColumns = @JoinColumn(name = "vaitro_id")
    )
    private Set<VaiTro> vaitros;
    
    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDons;
    
    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
    private List<DanhGiaPhim> dGPs;
    
   
    



	public NguoiDung(int id, String email, String matKhau, String hoTen, String sdt, String ngaySinh, String gioiTinh,
			String tokenQuenMatKhau, Set<VaiTro> vaitros) {
		super();
		this.id = id;
		this.email = email;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tokenQuenMatKhau = tokenQuenMatKhau;
		this.vaitros = vaitros;
	}



	public NguoiDung() {
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMatKhau() {
		return matKhau;
	}



	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}



	public String getHoTen() {
		return hoTen;
	}



	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}



	public String getSdt() {
		return sdt;
	}



	public void setSdt(String sdt) {
		this.sdt = sdt;
	}



	public String getNgaySinh() {
		return ngaySinh;
	}



	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}



	public Set<VaiTro> getVaitros() {
		return vaitros;
	}



	public void setVaitros(Set<VaiTro> vaitros) {
		this.vaitros = vaitros;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	


	public String getTokenQuenMatKhau() {
		return tokenQuenMatKhau;
	}



	public void setTokenQuenMatKhau(String tokenQuenMatKhau) {
		this.tokenQuenMatKhau = tokenQuenMatKhau;
	}



	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", email=" + email + ", matKhau=" + matKhau + ", hoTen=" + hoTen + ", sdt=" + sdt
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", vaitros=" + vaitros + "]";
	}
	
	


	


    
}
