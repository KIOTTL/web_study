package com.sist.vo;

import java.util.Date;

/*
GOODS_ID      NOT NULL NUMBER         
NAME_KOR      NOT NULL VARCHAR2(200)  
NAME_ENG               VARCHAR2(200)  
IMG           NOT NULL VARCHAR2(2000) 
BRAND         NOT NULL VARCHAR2(100)  
SKU                    VARCHAR2(100)  
COLOR                  VARCHAR2(100)  
TYPE          NOT NULL VARCHAR2(100)  
VARIANCE               VARCHAR2(200)  
RELEASE_DATE           DATE           
RELEASE_PRICE          VARCHAR2(200)  
RT_PRICE               NUMBER         
IM_SELL                NUMBER         
IM_BUY                 NUMBER         
BOOKMARK               NUMBER         
CATEGORY_ID   NOT NULL NUMBER  
 */
public class ShoesVO {
	private int goods_id, rt_price, im_sell, im_buy, bookmark, category_id;
	private String name_kor, name_eng, img, brand, sku, color, type, variance, release_price;
	private Date release_date;
	
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getRt_price() {
		return rt_price;
	}
	public void setRt_price(int rt_price) {
		this.rt_price = rt_price;
	}
	public int getIm_sell() {
		return im_sell;
	}
	public void setIm_sell(int im_sell) {
		this.im_sell = im_sell;
	}
	public int getIm_buy() {
		return im_buy;
	}
	public void setIm_buy(int im_buy) {
		this.im_buy = im_buy;
	}
	public int getBookmark() {
		return bookmark;
	}
	public void setBookmark(int bookmark) {
		this.bookmark = bookmark;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName_kor() {
		return name_kor;
	}
	public void setName_kor(String name_kor) {
		this.name_kor = name_kor;
	}
	public String getName_eng() {
		return name_eng;
	}
	public void setName_eng(String name_eng) {
		this.name_eng = name_eng;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVariance() {
		return variance;
	}
	public void setVariance(String variance) {
		this.variance = variance;
	}
	public String getRelease_price() {
		return release_price;
	}
	public void setRelease_price(String release_price) {
		this.release_price = release_price;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	
}
