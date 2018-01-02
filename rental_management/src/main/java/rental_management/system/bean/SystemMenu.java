package rental_management.system.bean;

import java.util.List;

public class SystemMenu {

	private int id;
	private String name;
	private String defineRight;
	private String pageUrl;
	private int pid;
	
//	private SystemMenu parent; //多对一
//	private List<SystemMenu> menus; //一对多
	
	
	
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
	public String getDefineRight() {
		return defineRight;
	}
	public void setDefineRight(String defineRight) {
		this.defineRight = defineRight;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "SystemMenu [id=" + id + ", name=" + name + ", defineRight=" + defineRight + ", pageUrl=" + pageUrl
				+ ", pid=" + pid + "]";
	}
	
	
	
}
