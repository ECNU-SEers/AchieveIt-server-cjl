package edu.ecnu.sei.group08.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ecnu.sei.group08.model.ProjectDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectMapperTest {

	@Autowired
	private ProjectMapper projectMapper;
	
//	@Test
//	public void insertProjectTest() {
//		ProjectDO project = new ProjectDO();
//		project.setId(1);
//		project.setOuterId("2020-1234-D");
//		project.setName("AchieveIt");
//		project.setStartDate("2020-03-16");
//		project.setEndDate("2020-05-01");
//		project.setState("");
//		project.setClientId(5);
//		project.setSupervisorId(4);
//		project.setSupervisorName("zhangsan");
//		project.setManagerId(3);
//		project.setManagerName("lisi");
//		projectMapper.insert(project);
//	}
	

	@Test
	public void selectCountByOuterIdTest() {
		String outerId = "2020-1234-D";
		int count = projectMapper.selectCountByOuterId(outerId);
		System.out.println("count="+count);
		
		
	}
}
