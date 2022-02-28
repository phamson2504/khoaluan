package com.project.khoaluan.model;

import java.util.ArrayList;
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



@Entity
public class KhuVuc {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
	
	private String tenKhuVuc;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @JoinColumn(name = "khuvuc_id")
	  List<Rap> raps;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhuVuc() {
		return tenKhuVuc;
	}

	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}

	public List<Rap> getRaps() {
		return raps;
	}

	public void setRaps(List<Rap> raps) {
		this.raps = raps;
	}
	public Rap getRap(int id) {
		if(raps!=null) {
			for (Rap rap : raps) {
				if (rap.getId()==id) {
					return rap;
				}
			}
		}
		return null;
	}
	public void addRap(Rap rap){
        if (raps == null) {
            raps = new ArrayList<>();
        }
        raps.add(rap);
    }
	
	

	public KhuVuc(int id, String tenKhuVuc, List<Rap> raps) {
		super();
		this.id = id;
		this.tenKhuVuc = tenKhuVuc;
		
		this.raps = raps;
	}

	public KhuVuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "KhuVuc [id=" + id + ", tenKhuVuc=" + tenKhuVuc + ", raps=" + raps + "]";
	}
}
