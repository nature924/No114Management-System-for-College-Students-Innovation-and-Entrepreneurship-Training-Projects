package com.dao;

import com.entity.ChuqidabianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuqidabianVO;
import com.entity.view.ChuqidabianView;


/**
 * 初期答辩
 * 
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface ChuqidabianDao extends BaseMapper<ChuqidabianEntity> {
	
	List<ChuqidabianVO> selectListVO(@Param("ew") Wrapper<ChuqidabianEntity> wrapper);
	
	ChuqidabianVO selectVO(@Param("ew") Wrapper<ChuqidabianEntity> wrapper);
	
	List<ChuqidabianView> selectListView(@Param("ew") Wrapper<ChuqidabianEntity> wrapper);

	List<ChuqidabianView> selectListView(Pagination page,@Param("ew") Wrapper<ChuqidabianEntity> wrapper);
	
	ChuqidabianView selectView(@Param("ew") Wrapper<ChuqidabianEntity> wrapper);
	

}
