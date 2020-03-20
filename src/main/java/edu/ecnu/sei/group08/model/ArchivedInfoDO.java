package edu.ecnu.sei.group08.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author chenjialei
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("sys_archived_info")
public class ArchivedInfoDO implements Serializable {

private static final long serialVersionUID = 1L;
	
	@TableId(value = "project_id", type = IdType.AUTO)
	private Long projectId;
	
	private int basicData;
	private int proposal;
	private int quotation;
	private int estimation;
	private int planning;
	private int processClipping;
	private int costManage;
	private int reqChange;
	private int riskManage;
	private int clientAccPro;
	private int clientAcc;
	private int infoSummary;
	private int bestExperience;
	private int devTool;
	private int devTemplate;
	private int checklist;
	private int qaSummary;
}
