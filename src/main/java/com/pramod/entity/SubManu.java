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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "sub_manu")
public class SubManu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "submanu_id")
    private Integer subManuId;
    @Basic(optional = false)
    @Column(name = "subManu_name")
    private String subManuName;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "SubManu")
    @JsonManagedReference
    @JsonIgnore
    private List<Product> productList;
   
    @JoinColumn(name = "manu_parent", referencedColumnName = "manu_id")
    @ManyToOne(optional = false)
    @JsonBackReference
    @JsonIgnore
    private Manu manu;

	/*
	 * public SubManu() { }
	 */
	public Integer getSubManuId() {
		return subManuId;
	}
	public void setSubManuId(Integer subManuId) {
		this.subManuId = subManuId;
	}
	public String getSubManuName() {
		return subManuName;
	}
	public void setSubManuName(String subManuName) {
		this.subManuName = subManuName;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Manu getManu() {
		return manu;
	}
	public void setManu(Manu manu) {
		this.manu = manu;
	}
	

    

}