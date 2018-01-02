package rental_management;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rental_management.system.mapper.DevCardMapper;
import rental_management.system.mapper.UserPropertyMapper;
import rental_management.system.service.CardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml",
		"classpath:spring.xml", "classpath:spring-tx.xml", })
public class RelationTest {

	@Autowired
	private DevCardMapper devCardMapper;
	
	@Autowired
	private UserPropertyMapper userPropertyMapper;
	@Test
	public void Testdevcard(){
		
		//devCardMapper.insert(5, 6);
		//devCardMapper.deletecard(6);
		//devCardMapper.deletedev(1);
		//System.out.println(devCardMapper.selectcard(9));
		//System.out.println(devCardMapper.selectdev(5));
		//devCardMapper.updatecard(2, 5);
		//devCardMapper.updatedev(3, 7);
	}
	
	@Test
	public void Testuserproperty(){
		//System.err.println(userPropertyMapper.selectaddress(9));
		//System.err.println(userPropertyMapper.selectuser(8));
		//userPropertyMapper.insert(10, 15);
		//userPropertyMapper.deleteaddress(10);
		//userPropertyMapper.deleteuser(8);
		//userPropertyMapper.updateaddress(8, 10);
		//userPropertyMapper.updateuser(5, 9);
	}
}