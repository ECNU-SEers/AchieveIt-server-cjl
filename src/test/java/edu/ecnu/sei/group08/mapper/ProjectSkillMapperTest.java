package edu.ecnu.sei.group08.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ecnu.sei.group08.model.ProjectSkillDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSkillMapperTest {

	@Autowired
	private ProjectSkillMapper projectSkillMapper;
	
	@Test
	public void selectProjectSkillByProjectIdTest() {
		Long projectId = 3L;
		List<ProjectSkillDO> projectskills = new ArrayList<ProjectSkillDO>();
		projectskills = projectSkillMapper.selectProjectSkillByProjectId(projectId);
		System.out.println(projectskills.size());
		
	}
}
