package com.dao;

import com.entity.XiangmuleibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmuleibieVO;
import com.entity.view.XiangmuleibieView;


/**
 * 项目类别
 * 
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface XiangmuleibieDao extends BaseMapper<XiangmuleibieEntity> {
	
	List<XiangmuleibieVO> selectListVO(@Param("ew") Wrapper<XiangmuleibieEntity> wrapper);
	
	XiangmuleibieVO selectVO(@Param("ew") Wrapper<XiangmuleibieEntity> wrapper);
	
	List<XiangmuleibieView> selectListView(@Param("ew") Wrapper<XiangmuleibieEntity> wrapper);

	List<XiangmuleibieView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmuleibieEntity> wrapper);
	
	XiangmuleibieView selectView(@Param("ew") Wrapper<XiangmuleibieEntity> wrapper);
	

}
