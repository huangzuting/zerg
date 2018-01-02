package rental_management.system.bean;

import java.util.Date;

public class Person {
	private int id;
	private String name;
	//籍贯地址
	private String address;
	//出生日期
	private Date brithDate;
	//手机号码
	private String phone;
	//性别
	private int sex;
	//是否注销
	private String islogoff;
	//注销原因
	private int logoffreason;
	//注销时间
	private Date logofftime;
	//注销人员
	private String logoffPerson;
	//身份证
	private String identityNumber;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBrithDate() {
		return brithDate;
	}
	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIslogoff() {
		return islogoff;
	}
	public void setIslogoff(String islogoff) {
		this.islogoff = islogoff;
	}
	public int getLogoffreason() {
		return logoffreason;
	}
	public void setLogoffreason(int logoffreason) {
		this.logoffreason = logoffreason;
	}
	public Date getLogofftime() {
		return logofftime;
	}
	public void setLogofftime(Date logofftime) {
		this.logofftime = logofftime;
	}
	public String getLogoffPerson() {
		return logoffPerson;
	}
	public void setLogoffPerson(String logoffPerson) {
		this.logoffPerson = logoffPerson;
	}
	
	
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address
				+ ", brithDate=" + brithDate + ", phone=" + phone + ", sex="
				+ sex + ", islogoff=" + islogoff + ", logoffreason="
				+ logoffreason + ", logofftime=" + logofftime
				+ ", logoffPerson=" + logoffPerson + ", identityNumber="
				+ identityNumber + "]";
	}
	
	


	
	
	
	
}
