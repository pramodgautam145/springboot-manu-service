package com.pramod.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "manu")
public class Manu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manu_id")
    private Integer manuId;
    @Basic(optional = false)
    @Column(name = "manu_name")
    private String manuName;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manu")
    @JsonManagedReference
    @JsonIgnore
    private List<SubManu> submanuList;

	/*
	 * public Manu() { }
	 */

	public Integer getManuId() {
		return manuId;
	}

	public void setManuId(Integer manuId) {
		this.manuId = manuId;
	}

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public List<SubManu> getSubmanuList() {
		return submanuList;
	}

	public void setSubmanuList(List<SubManu> submanuList) {
		this.submanuList = submanuList;
	}

	@Override
	public String toString() {
		return "Manu [manuId=" + manuId + ", manuName=" + manuName + ", submanuList=" + submanuList + "]";
	}

	
    

}