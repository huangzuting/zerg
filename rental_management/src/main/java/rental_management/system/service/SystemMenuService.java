package rental_management.system.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import rental_management.system.bean.SystemMenu;

public interface SystemMenuService {

	public JSONArray tree(int parentId);
	
	public void saveOrUpdate(SystemMenu systemMenu);
	
	public void delete(int id);
	
	public SystemMenu selectId(int id);
	
	public JSONObject getUpTree(int id);

}
