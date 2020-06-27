package com.shobu.model;

public class MemberVO {
	private String id;
	private String password;
	private String nickname;
	private String image;
	private int point;
	
	public MemberVO() {}
	public MemberVO(String id, String password, String nickname, String image) {
		//프로필 사진을 업로드 했을 경우
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.image = image;
		this.point = 0; //회원가입시 포인트 0점 부여
	}
	public MemberVO(String id, String password, String nickname) {
		//프로필 사진 업로드를 하지 않았을 경우
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.image = "image/default.png";
		this.point = 0; //회원가입시 포인트 0점 부여
	}
	public MemberVO(String id, String password, String nickname, String image, int point) {
		//DB에서 회원을 찾아올 경우
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.image = image;
		this.point = point;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", nickname=" + nickname + ", image=" + image
				+ ", point=" + point + "]";
	}
}
