package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuqidabianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuqidabianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuqidabianView;


/**
 * 初期答辩
 *
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface ChuqidabianService extends IService<ChuqidabianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuqidabianVO> selectListVO(Wrapper<ChuqidabianEntity> wrapper);
   	
   	ChuqidabianVO selectVO(@Param("ew") Wrapper<ChuqidabianEntity> wrapper);
   	
   	List<ChuqidabianView> selectListView(Wrapper<ChuqidabianEntity> wrapper);
   	
   	ChuqidabianView selectView(@Param("ew") Wrapper<ChuqidabianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuqidabianEntity> wrapper);
   	

}

