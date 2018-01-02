package rental_management.system.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuMapper {
	 public void insert(@Param("roleId")int roleId,@Param("menuId")int menuId);
     public void deleterole(int roleId);
     public void deletemenu(int menuId);
     public void updatecard(@Param("roleId")int roleId,@Param("menuId")int menuId);
     public void updatedev(@Param("roleId")int roleId,@Param("menuId")int menuId);
     public List<Integer> selectrole(int menuId);
     public List<Integer> selectmenu(int roleId);
}
