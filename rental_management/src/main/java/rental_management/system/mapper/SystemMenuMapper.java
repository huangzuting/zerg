package rental_management.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import rental_management.system.bean.SystemMenu;
import rental_management.system.bean.SystemRole;

@Repository
public interface SystemMenuMapper {

	public List<SystemMenu> getByPId(int parentId);
	
	public void save(SystemMenu systemMenu);

	public void update(SystemMenu systemMenu);

	public void delete(int id);

	public SystemMenu selectId(int id);
}
