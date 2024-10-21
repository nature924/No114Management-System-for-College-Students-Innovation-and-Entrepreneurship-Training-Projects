package com.dao;

import com.entity.JietidabianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JietidabianVO;
import com.entity.view.JietidabianView;


/**
 * 结题答辩
 * 
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface JietidabianDao extends BaseMapper<JietidabianEntity> {
	
	List<JietidabianVO> selectListVO(@Param("ew") Wrapper<JietidabianEntity> wrapper);
	
	JietidabianVO selectVO(@Param("ew") Wrapper<JietidabianEntity> wrapper);
	
	List<JietidabianView> selectListView(@Param("ew") Wrapper<JietidabianEntity> wrapper);

	List<JietidabianView> selectListView(Pagination page,@Param("ew") Wrapper<JietidabianEntity> wrapper);
	
	JietidabianView selectView(@Param("ew") Wrapper<JietidabianEntity> wrapper);
	

}
