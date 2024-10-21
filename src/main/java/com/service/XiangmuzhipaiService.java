package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmuzhipaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangmuzhipaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuzhipaiView;


/**
 * 项目指派
 *
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface XiangmuzhipaiService extends IService<XiangmuzhipaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmuzhipaiVO> selectListVO(Wrapper<XiangmuzhipaiEntity> wrapper);
   	
   	XiangmuzhipaiVO selectVO(@Param("ew") Wrapper<XiangmuzhipaiEntity> wrapper);
   	
   	List<XiangmuzhipaiView> selectListView(Wrapper<XiangmuzhipaiEntity> wrapper);
   	
   	XiangmuzhipaiView selectView(@Param("ew") Wrapper<XiangmuzhipaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmuzhipaiEntity> wrapper);
   	

}

