package edu.ecnu.sei.group08.activiti;

import java.util.List;

import org.activiti.engine.task.Task;

/**
 * 提供与活动流相关的服务
 * @author chenjialei
 *
 */
public interface ProcessManagementService {

	/**
	 * 完成部署后，启动流程实例
	 * 受到影响的activiti表有哪些：
	 *   ACT_HI_ACTINST       已完成的活动信息
	 *   ACT_HI_IDENTITYLINK  参与者信息
	 *   ACT_HI_PROCINST      流程实例
	 *   ACT_HI_TASKINST      任务实例
	 *   ACT_RU_EXECUTION     执行表
	 *   ACT_RU_IDENTITYLINK  参与者信息
	 *   ACT_RU_TASK          任务
	 * @param processDefinitionKey 流程定义的key
	 * @param businessKey 业务表中对应的key
	 * @return 是否成功启动流程实例
	 */
	public boolean startProcessInstance(String processDefinitionKey, String businessKey);
	
	/**
	 * 查询某个用户的待办任务
	 * @param processDefinitionKey 流程定义的key
	 * @param taskAssignee 任务执行人
	 * @return 
	 */
	public List<Task> queryActivityTask(String processDefinitionKey, String taskAssignee);
	
	/**
	 * 处理某个用户的某一个任务
	 * 受到影响的activiti表
	 *   ACT_HI_ACTINST      多了一条记录，走到下一个节点，END_TIME_=NULL
	 *   ACT_HI_IDENTITYLINK 添加下一个节点的ASSIGNEE
	 *   ACT_HI_TASKINST     ACT_HI_TASKINST中ACT_HI_TASKINST的ID_字段为2505的END_TIME_不为NULL了；
	 *                 		 且多了一条记录，走到下一个节点，END_TIME_=NULL
	 *   ACT_RU_EXECUTION    ACT_ID_改变
	 *   ACT_RU_IDENTITYLINK 添加下一个节点的ASSIGNEE
	 *   ACT_RU_TASK         删除旧节点记录，添加新节点记录（只保留一条记录，使查询速度快）
	 * @param task 某一个用户的某一个任务
	 * @return 是否成功处理该任务
	 */
	public boolean handleActivityTask(Task task);
	
	
	
	
}
