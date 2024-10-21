package com.dao;

import com.entity.JietipingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JietipingjiaVO;
import com.entity.view.JietipingjiaView;


/**
 * 结题评价
 * 
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface JietipingjiaDao extends BaseMapper<JietipingjiaEntity> {
	
	List<JietipingjiaVO> selectListVO(@Param("ew") Wrapper<JietipingjiaEntity> wrapper);
	
	JietipingjiaVO selectVO(@Param("ew") Wrapper<JietipingjiaEntity> wrapper);
	
	List<JietipingjiaView> selectListView(@Param("ew") Wrapper<JietipingjiaEntity> wrapper);

	List<JietipingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<JietipingjiaEntity> wrapper);
	
	JietipingjiaView selectView(@Param("ew") Wrapper<JietipingjiaEntity> wrapper);
	

}
