package rental_management.system.bean;

public class SystemRole {

	private int id;
	private String roleName;
	private String flag;
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "SystemRole [id=" + id + ", roleName=" + roleName + ", flag=" + flag + ", status=" + status + "]";
	}
	
	
	
	
}
