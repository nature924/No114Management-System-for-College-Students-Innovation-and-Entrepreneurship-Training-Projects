package com.dao;

import com.entity.XiangmuzhipaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmuzhipaiVO;
import com.entity.view.XiangmuzhipaiView;


/**
 * 项目指派
 * 
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface XiangmuzhipaiDao extends BaseMapper<XiangmuzhipaiEntity> {
	
	List<XiangmuzhipaiVO> selectListVO(@Param("ew") Wrapper<XiangmuzhipaiEntity> wrapper);
	
	XiangmuzhipaiVO selectVO(@Param("ew") Wrapper<XiangmuzhipaiEntity> wrapper);
	
	List<XiangmuzhipaiView> selectListView(@Param("ew") Wrapper<XiangmuzhipaiEntity> wrapper);

	List<XiangmuzhipaiView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmuzhipaiEntity> wrapper);
	
	XiangmuzhipaiView selectView(@Param("ew") Wrapper<XiangmuzhipaiEntity> wrapper);
	

}
