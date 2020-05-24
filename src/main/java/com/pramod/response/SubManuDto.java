package com.pramod.response;

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


public class SubManuDto  {
  
    private Integer subManuId;
    
    private String subManuName;
   
    
    private List<ProductDto> productList;


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


	public List<ProductDto> getProductList() {
		return productList;
	}


	public void setProductList(List<ProductDto> productList) {
		this.productList = productList;
	}


	
   
    
	

    

}