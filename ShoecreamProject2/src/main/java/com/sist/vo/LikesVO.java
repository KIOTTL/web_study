package com.sist.vo;

/*
LIKES_ID NOT NULL NUMBER = 좋아요 고유번호
USER_ID           NUMBER = 회원 고유번호
GOODS_ID          NUMBER  = 상품 고유번호 
 */

public class LikesVO {

	private int likes_id, goods_id, user_id;

	public int getLikes_id() {
		return likes_id;
	}

	public void setLikes_id(int likes_id) {
		this.likes_id = likes_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
