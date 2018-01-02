package rental_management.system.bean;

public class Address {

	private int id;
	private String location;
	private int pid;
	private int levelJudge;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getLevelJudge() {
		return levelJudge;
	}
	public void setLevelJudge(int levelJudge) {
		this.levelJudge = levelJudge;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", location=" + location + ", pid=" + pid + ", levelJudge=" + levelJudge + "]";
	}

}
