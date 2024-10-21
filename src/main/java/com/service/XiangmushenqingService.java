package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmushenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangmushenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmushenqingView;


/**
 * 项目申请
 *
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface XiangmushenqingService extends IService<XiangmushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmushenqingVO> selectListVO(Wrapper<XiangmushenqingEntity> wrapper);
   	
   	XiangmushenqingVO selectVO(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
   	
   	List<XiangmushenqingView> selectListView(Wrapper<XiangmushenqingEntity> wrapper);
   	
   	XiangmushenqingView selectView(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmushenqingEntity> wrapper);
   	

}

