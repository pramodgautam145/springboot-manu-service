package com.pramod.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "item")
public class Items implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemid;
    @Basic(optional = false)
    @Column(name = "item_name")
    private String itemName;
   
    @JoinColumn(name = "product_parent", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    @JsonBackReference
    @JsonIgnore
    private Product product;
    
	/*
	 * public Items() {
	 * 
	 * }
	 */
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Items [itemid=" + itemid + ", itemName=" + itemName + ", product=" + product + "]";
	}
	
    
    
    
}
