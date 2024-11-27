package com.excelr.MajorProjectCMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pno;
	private String producttname;
	private String productcategory;
	private String productcolor;
	private double productprice;
	public Product() {}
	public Product(int pno, String producttname, String productcategory, String productcolor, double productprice) {
		this.pno = pno;
		this.producttname = producttname;
		this.productcategory = productcategory;
		this.productcolor = productcolor;
		this.productprice = productprice;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getProducttname() {
		return producttname;
	}
	public void setProducttname(String producttname) {
		this.producttname = producttname;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public String getProductcolor() {
		return productcolor;
	}
	public void setProductcolor(String productcolor) {
		this.productcolor = productcolor;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	@Override
	public String toString() {
		return "Product [pno=" + pno + ", producttname=" + producttname + ", productcategory=" + productcategory
				+ ", productcolor=" + productcolor + ", productprice=" + productprice + "]";
	}
	
	
}
