package rental_management;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rental_management.system.bean.SystemMenu;
import rental_management.system.bean.SystemRole;
import rental_management.system.service.SystemMenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class SystemMenuTest {
	
	@Autowired
	private SystemMenuService systemMenuService;
	

//	@Test
//	public void list(){
//		List<SystemMenu> list = systemMenuService.tree(0);
//		for (SystemMenu systemMenu : list) {
//			System.out.println(systemMenu);
//		}
//	}
	
}
