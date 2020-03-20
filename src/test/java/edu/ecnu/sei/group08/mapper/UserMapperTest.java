package edu.ecnu.sei.group08.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ecnu.sei.group08.model.UserDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;	
	@Autowired
	private PermissionMapper pm;
	@Autowired
	private ProjectSkillMapper psm;

//	@Test
//	public void selectCountByOuterIdTest() {
//		int id = 1;
//		UserDO user = userMapper.selectById(id);  //BaseMapper
//		System.out.println(user.getUsername());
//		int count = userMapper.selectCountById(1L);  //UserMapper
//		System.out.println("count = "+count);
//		
//	}
//	@Test
//	public void permissionTest() {
//		System.out.println(pm.selectPermissionsByRoleId(1L));
//	}
	
	@Test
	public void projectSkillTest() {
		System.out.println(psm.selectProjectSkillByProjectId(3L));
	}
}
