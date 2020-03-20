package edu.ecnu.sei.group08.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ecnu.sei.group08.dto.project.ApproveProjectDTO;
import edu.ecnu.sei.group08.dto.project.CreateProjectDTO;
import edu.ecnu.sei.group08.dto.project.RetrieveProjectDTO;
import edu.ecnu.sei.group08.dto.project.ShowProjectListDTO;
import edu.ecnu.sei.group08.dto.project.UpdateProjectDTO;
import edu.ecnu.sei.group08.model.ProjectDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

	@Autowired
	private ProjectService projectService;
	
//	@Test
//	public void createProjectTest() {
//		CreateProjectDTO project = new CreateProjectDTO();
//		List<String> skillNames = new ArrayList<String>();
//		skillNames.add("tech1");
//		skillNames.add("tech2");
//		
//		project.setOuterId("2020-1234-D-qq");
//		project.setName("AchieveIt");
//		project.setStartDate("2020-03-16");
//		project.setEndDate("2020-05-01");
//		project.setCompany("April");
//		project.setSupervisorId(4);
//		project.setSupervisorName("zhangsan");
//		project.setManagerId(3);
//		project.setManagerName("lisi");
//		project.setSkillNames(skillNames);
//		project.setBusinessAreaName("administration");
//		
//		projectService.createProject(project);
//	}
	
//	@Test
//	public void retrieveProjectTest() {
//		String outerId = "2020-1234-D-qq";
//		RetrieveProjectDTO rpd = projectService.retrieveProject(outerId);
//		System.out.println("projectClientId = "+rpd.getProject().getClientId());
//		System.out.println("projectClientEmail = "+rpd.getProjectClient().getEmail());
//		System.out.println("projectSkillsSize = "+rpd.getProjectSkills().size());
//		System.out.println("projectBusinessAreaName = "+rpd.getProjectBusinessArea().getBusinessAreaName());
//		System.out.println("projectMilestonesSize = "+rpd.getProjectMilestones().size());
//		System.out.println("projectFunctionsSize = "+rpd.getProjectFunctions().size());
//	}
	
//	@Test
//	public void updateProjectTest() {
//		UpdateProjectDTO project = new UpdateProjectDTO();
//		List<String> skillNames = new ArrayList<String>();
//		skillNames.add("tech1");
//		skillNames.add("tech3");
//		
//		project.setOuterId("2020-1234-D-qq");
//		project.setName("AchieveIt2");
//		project.setStartDate("2020-03-18");
//		project.setEndDate("2020-06-01");
//		project.setClientOuterId("20200318test");
//		project.setCompany("March");
//		project.setSupervisorId(5);
//		project.setSupervisorName("wangwu");
//		project.setSkillNames(skillNames);
//		project.setBusinessAreaName("management");
//		project.setMilestone("milestone:1st");
//		projectService.updateProjectInfo(project);
//	}
	
//	@Test
//	public void searchProjectTest() {
//		String keyword = "ch";
//		List<ProjectDO> projects = projectService.selectProjectByNameWithKeyword(keyword);
//		System.out.println(projects.size());
//	}
	
	@Test
	public void showProjectListTest() {
		String outerId = "2020-1234-D-qq";
		ShowProjectListDTO projectList = projectService.showProjectList(outerId);
		System.out.println("startDate="+projectList.getStartDate());
		System.out.println("company="+projectList.getCompany());
		System.out.println("epg="+projectList.getEpgAssigned());
		System.out.println("counter="+projectList.getParticipantCounter());
	}
	
//	@Test
//	public void acceptProjectTest() {
//		String outerId = "2020-1234-D-qq";
//		RetrieveProjectDTO rpd = projectService.retrieveProject(outerId);
//		rpd.getProject().setRemark("good job!");
//		ApproveProjectDTO apd = projectService.acceptProject(rpd);
//		System.out.println("state = "+apd.getProjectInfo().getProject().getState());
//		if (apd.isReviewResult()) {
//			System.out.println("yes");
//		}
//	}
	
//	@Test
//	public void assignEQGTest() {
//		String outerId = "2020-1234-D-qq";
//		List<Long> userId = new ArrayList<Long>();
//		userId.add(1L);
//		userId.add(2L);
//		ProjectDO project = projectService.assignEQG(outerId, userId);
//		System.out.println("EPG state = "+project.getEpgAssigned());
//	}
}
