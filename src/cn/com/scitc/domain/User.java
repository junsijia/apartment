package cn.com.scitc.domain;

public class User {	
/*
  �û�
  
  `userId` varchar(100) NOT NULL COMMENT '�û�ID',
  `userName` varchar(12) NOT NULL COMMENT '�û���',
  `userPassword` varchar(12) NOT NULL COMMENT '����',
  `linkPerson` varchar(7) DEFAULT NULL COMMENT '��ϵ��',
  `telphone` varchar(11) DEFAULT NULL COMMENT '�绰',
  `email` varchar(20) DEFAULT NULL COMMENT '����',
  `sex` int(4) DEFAULT NULL COMMENT '�Ա�',
  `age` varchar(4) DEFAULT NULL COMMENT '����',
  `qq` varchar(20) DEFAULT NULL COMMENT 'qq',
  `signature` varchar(255) DEFAULT NULL COMMENT 'ǩ��',
 */
	private String userId;
	private String userName;
	private String userPassword;
	private String linkPerson;
	private String telphone;
	private String email;
	private String sex;
	private Integer age;
	private String qq;
	private String signature;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getLinkPerson() {
		return linkPerson;
	}
	public void setLinkPerson(String linkPerson) {
		this.linkPerson = linkPerson;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}	