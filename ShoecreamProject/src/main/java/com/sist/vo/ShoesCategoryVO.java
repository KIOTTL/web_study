package com.sist.vo;
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
public class ShoesCategoryVO {
	private int category_id;
	private String img, brand, name_eng, im_buy;

	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
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
	public String getName_eng() {
		return name_eng;
	}
	public void setName_eng(String name_eng) {
		this.name_eng = name_eng;
	}
	public String getIm_buy() {
		return im_buy;
	}
	public void setIm_buy(String im_buy) {
		this.im_buy = im_buy;
	}
	
}
