package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JietipingjiaDao;
import com.entity.JietipingjiaEntity;
import com.service.JietipingjiaService;
import com.entity.vo.JietipingjiaVO;
import com.entity.view.JietipingjiaView;

@Service("jietipingjiaService")
public class JietipingjiaServiceImpl extends ServiceImpl<JietipingjiaDao, JietipingjiaEntity> implements JietipingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JietipingjiaEntity> page = this.selectPage(
                new Query<JietipingjiaEntity>(params).getPage(),
                new EntityWrapper<JietipingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JietipingjiaEntity> wrapper) {
		  Page<JietipingjiaView> page =new Query<JietipingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JietipingjiaVO> selectListVO(Wrapper<JietipingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JietipingjiaVO selectVO(Wrapper<JietipingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JietipingjiaView> selectListView(Wrapper<JietipingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JietipingjiaView selectView(Wrapper<JietipingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
