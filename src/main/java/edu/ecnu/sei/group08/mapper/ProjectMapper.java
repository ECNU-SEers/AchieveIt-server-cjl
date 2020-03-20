package edu.ecnu.sei.group08.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.ecnu.sei.group08.model.ProjectDO;

/**
 * 
 * @author chenjialei
 *
 */
@Repository
public interface ProjectMapper extends BaseMapper<ProjectDO> {

	/**
	 * 查询项目ID为$outerId的项目数
	 * @param outerId
	 * @return 项目数
	 */
	int selectCountByOuterId(String outerId);
	
	/**
	 * 查询项目名称中包含关键字的所有项目
	 * @param keyword
	 * @return
	 */
	List<ProjectDO> selectByNameLikeKeyword(@Param("keyword")String keyword);
}
