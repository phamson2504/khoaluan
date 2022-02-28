package com.project.khoaluan.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "vai_tro")
public class VaiTro implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "ten", nullable = false)
    private String ten;

    @ManyToMany(mappedBy = "vaitros")
    private Set<NguoiDung> nguoidungs;
    
    

	public VaiTro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VaiTro(String ten) {
		this.ten = ten;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Set<NguoiDung> getNguoidungs() {
		return nguoidungs;
	}

	public void setNguoidungs(Set<NguoiDung> nguoidungs) {
		this.nguoidungs = nguoidungs;
	}
    
    
    
}
