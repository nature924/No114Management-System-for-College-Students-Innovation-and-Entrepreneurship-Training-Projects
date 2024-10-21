package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JietidabianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JietidabianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JietidabianView;


/**
 * 结题答辩
 *
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface JietidabianService extends IService<JietidabianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JietidabianVO> selectListVO(Wrapper<JietidabianEntity> wrapper);
   	
   	JietidabianVO selectVO(@Param("ew") Wrapper<JietidabianEntity> wrapper);
   	
   	List<JietidabianView> selectListView(Wrapper<JietidabianEntity> wrapper);
   	
   	JietidabianView selectView(@Param("ew") Wrapper<JietidabianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JietidabianEntity> wrapper);
   	

}

