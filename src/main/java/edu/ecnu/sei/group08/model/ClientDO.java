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
@TableName("sys_client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	
	private String outerId;
	
	private String company;
	
	private String level;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String innerPerson;
	
}
