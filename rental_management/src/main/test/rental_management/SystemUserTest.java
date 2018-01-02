package rental_management;



import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rental_management.system.bean.SystemUser;
import rental_management.system.service.SystemUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml","classpath:spring.xml", "classpath:spring-tx.xml",})
public class SystemUserTest {
	@Autowired
	private SystemUserService systemUserService;
	
	@Test
	public void list(){
		List<SystemUser> list=systemUserService.list();
		for (SystemUser systemUser : list) {
			System.out.println(systemUser);
		}
	}
	@Test
	public void getSystemUser(){
		SystemUser systemUser=systemUserService.getSystemUser("李白");
		System.out.println(systemUser.toString());
	}
		
/*		Iterator it = list.iterator();
		while(it.hasNext()) {
		  System.out.println(it.next());
		}*/
	

	
	
}
