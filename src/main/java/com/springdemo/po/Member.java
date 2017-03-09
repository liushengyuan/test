package com.springdemo.po;

public class Member {
	private Integer id; //会员id
	private String memberName; // 会员名 
	private String password;  // 会员登录密码
	private Integer ifFrozenAccount; //是否冻结账号
	private String createDate;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIfFrozenAccount() {
		return ifFrozenAccount;
	}
	public void setIfFrozenAccount(Integer ifFrozenAccount) {
		this.ifFrozenAccount = ifFrozenAccount;
	}
	
	
	
}
