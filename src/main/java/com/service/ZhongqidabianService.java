package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhongqidabianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhongqidabianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhongqidabianView;


/**
 * 中期答辩
 *
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface ZhongqidabianService extends IService<ZhongqidabianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongqidabianVO> selectListVO(Wrapper<ZhongqidabianEntity> wrapper);
   	
   	ZhongqidabianVO selectVO(@Param("ew") Wrapper<ZhongqidabianEntity> wrapper);
   	
   	List<ZhongqidabianView> selectListView(Wrapper<ZhongqidabianEntity> wrapper);
   	
   	ZhongqidabianView selectView(@Param("ew") Wrapper<ZhongqidabianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongqidabianEntity> wrapper);
   	

}

