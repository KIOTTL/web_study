package com.sist.vo;

import java.io.Serializable;

import org.openqa.selenium.By;

/*
 *                System.out.print(element.findElement(By.tagName("img")).getAttribute("src"));
               System.out.print("|"+element.findElement(By.className("brand")).getText());         
               System.out.print("|"+element.findElement(By.className("name")).getText());
               System.out.print("|"+element.findElement(By.className("translated_name")).getText());
               System.out.print("|"+element.findElement(By.className("amount")).getText());
               System.out.print("|"+element.findElement(By.className("desc")).getText());
               System.out.print("|"+element.findElement(By.className("express_mark")).getText());
 */
public class KreamVO implements Serializable {
	private int kno;
	private String img, brand, name, translated_name, amount, desc, express_mark;
	
	public int getKno() {
		return kno;
	}
	public void setKno(int kno) {
		this.kno = kno;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTranslated_name() {
		return translated_name;
	}
	public void setTranslated_name(String translated_name) {
		this.translated_name = translated_name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getExpress_mark() {
		return express_mark;
	}
	public void setExpress_mark(String express_mark) {
		this.express_mark = express_mark;
	}
	
}
