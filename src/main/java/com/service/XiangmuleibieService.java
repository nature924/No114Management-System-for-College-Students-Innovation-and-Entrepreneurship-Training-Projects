package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmuleibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangmuleibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuleibieView;


/**
 * 项目类别
 *
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface XiangmuleibieService extends IService<XiangmuleibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmuleibieVO> selectListVO(Wrapper<XiangmuleibieEntity> wrapper);
   	
   	XiangmuleibieVO selectVO(@Param("ew") Wrapper<XiangmuleibieEntity> wrapper);
   	
   	List<XiangmuleibieView> selectListView(Wrapper<XiangmuleibieEntity> wrapper);
   	
   	XiangmuleibieView selectView(@Param("ew") Wrapper<XiangmuleibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmuleibieEntity> wrapper);
   	

}

