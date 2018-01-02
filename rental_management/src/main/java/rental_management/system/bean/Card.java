package rental_management.system.bean;

import java.util.Date;

public class Card {
	private int id;
	private String cardNo;
	//销卡时间
	private Date effectTime;
	//创建时间
	private Date cdt;
	//姓名
	private String name;
	//卡片状态
	private int status;
	//发卡人员，和管理员ID一致
	private int userId;
	
	private Date cancelDate;
	
	private int personId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}

	public Date getCdt() {
		return cdt;
	}

	public void setCdt(Date cdt) {
		this.cdt = cdt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardNo=" + cardNo + ", effectTime="
				+ effectTime + ", cdt=" + cdt + ", name=" + name + ", status="
				+ status + ", userId=" + userId + ", cancelDate=" + cancelDate
				+ ", personId=" + personId + "]";
	}
	
	
	
	
	
}
