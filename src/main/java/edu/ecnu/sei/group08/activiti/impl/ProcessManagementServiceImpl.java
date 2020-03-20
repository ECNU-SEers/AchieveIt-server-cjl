package edu.ecnu.sei.group08.activiti.impl;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import edu.ecnu.sei.group08.activiti.ProcessManagementService;

public class ProcessManagementServiceImpl implements ProcessManagementService {
	
	private ProcessEngineConfiguration configuration;
	private ProcessEngine processEngine;
	
	public ProcessManagementServiceImpl() {
		this.configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		this.processEngine = configuration.buildProcessEngine();
	}
	
	/**
	 * 完成部署后，启动流程实例
	 */
	@Override
	public boolean startProcessInstance(String processDefinitionKey, String businessKey) {	
		try {
//			1.得到RuntimeService对象
			RuntimeService runtimeService = processEngine.getRuntimeService();
			
//			2.启动一个流程实例，流程定义的key（ACT_RE_PROCDEF的key字段）加上businessKey（对应业务表中记录的id）
			ProcessInstance processInstanceWithBusinessKey = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
			
//			3.输出实例的一些信息（非必须）
//			System.out.println("流程部署ID："+processInstanceWithBusinessKey.getDeploymentId());  //null 找不到
//			System.out.println("流程定义ID："+processInstanceWithBusinessKey.getProcessDefinitionId());  //ACT_RE_PROCDEF的ID_字段
//			System.out.println("流程实例ID："+processInstanceWithBusinessKey.getId());  //ACT_HI_PROCINST的ID_字段
//			System.out.println("活动ID："+processInstanceWithBusinessKey.getActivityId());  //null 找不到
//			System.out.println("BusinessKey："+processInstanceWithBusinessKey.getBusinessKey()); //ACT_RU_EXECUTION的BUSINESS_KEY_
//			ACT_RU_EXECUTION的BUSINESS_KEY_要存入业务标识
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return false;
	}

	/**
	 * 查询某个用户的待办任务
	 */
	@Override
	public List<Task> queryActivityTask(String processDefinitionKey, String taskAssignee) {
//		1.得到TaskService对象
		TaskService taskService = processEngine.getTaskService();
		
//		2.创建流程实例：流程定义的key（ACT_RE_PROCDEF的key字段）需要知道
		List<Task> taskList = taskService.createTaskQuery()
				   .processDefinitionKey(processDefinitionKey)
				   .taskAssignee(taskAssignee)
				   .list();
		
//		3.输出实例的一些信息（非必须）
//		for (Task task: taskList) {
//			System.out.println("流程实例ID："+task.getProcessInstanceId());  //ACT_HI_PROCINST的ID_字段
//			System.out.println("任务ID："+task.getId());  //ACT_HI_TASKINST的ID_字段
//			System.out.println("任务负责人："+task.getAssignee());  //ACT_HI_TASKINST的ASSIGNEE_字段
//			System.out.println("任务名称："+task.getName());  //ACT_HI_TASKINST的NAME_字段
//			System.out.println("\n");
//		}
		return taskList;
	}

	/**
	 * 处理某个用户的某一个任务
	 */
	@Override
	public boolean handleActivityTask(Task task) {
		try {
//			1.得到TaskService对象
			TaskService taskService = processEngine.getTaskService();
			
//			2.处理任务，结合当前用户列表的查询操作，得到任务ID（ACT_HI_TASKINST的ID_字段）
			taskService.complete(task.getId());
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return false;
	}


	
	

}
