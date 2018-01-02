package zmEducation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zm.admin.dao.SysUser;
import com.zm.admin.dao.Teacher;
import com.zm.admin.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

public class TestMyBatis {

	@Autowired
	private TeacherService teacherService;

	@Test
	public void test() {
		Teacher teacher = new Teacher();
//		teacher.setId(1);
		teacher.setName("huang");
		teacherService.addorupdate(teacher);

	}
	
	@Test
	public void test2() {

		Teacher teacher =  teacherService.selectById(1);
		System.out.println(teacher.getName());
	}
	
	@Test
	public void test3() {
		SysUser user = new SysUser();
		user.setUsername("wang");
		user.setPassword("123");
		user.setStatus(0);
		user.setRoleId(1);
		
		
	}
	
}