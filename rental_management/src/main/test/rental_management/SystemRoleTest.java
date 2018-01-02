package rental_management;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rental_management.system.bean.SystemRole;
import rental_management.system.service.SystemRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class SystemRoleTest {
	@Autowired
	private SystemRoleService systemRoleService;
	@Test
	public void list(){
		List<SystemRole> list = systemRoleService.list();
		for (SystemRole systemRole : list) {
			System.out.println(systemRole);
		}
	}
}
