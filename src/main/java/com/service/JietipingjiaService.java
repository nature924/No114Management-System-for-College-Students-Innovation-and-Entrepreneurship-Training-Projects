package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JietipingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JietipingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JietipingjiaView;


/**
 * 结题评价
 *
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
public interface JietipingjiaService extends IService<JietipingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JietipingjiaVO> selectListVO(Wrapper<JietipingjiaEntity> wrapper);
   	
   	JietipingjiaVO selectVO(@Param("ew") Wrapper<JietipingjiaEntity> wrapper);
   	
   	List<JietipingjiaView> selectListView(Wrapper<JietipingjiaEntity> wrapper);
   	
   	JietipingjiaView selectView(@Param("ew") Wrapper<JietipingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JietipingjiaEntity> wrapper);
   	

}

