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


import com.dao.JietidabianDao;
import com.entity.JietidabianEntity;
import com.service.JietidabianService;
import com.entity.vo.JietidabianVO;
import com.entity.view.JietidabianView;

@Service("jietidabianService")
public class JietidabianServiceImpl extends ServiceImpl<JietidabianDao, JietidabianEntity> implements JietidabianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JietidabianEntity> page = this.selectPage(
                new Query<JietidabianEntity>(params).getPage(),
                new EntityWrapper<JietidabianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JietidabianEntity> wrapper) {
		  Page<JietidabianView> page =new Query<JietidabianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JietidabianVO> selectListVO(Wrapper<JietidabianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JietidabianVO selectVO(Wrapper<JietidabianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JietidabianView> selectListView(Wrapper<JietidabianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JietidabianView selectView(Wrapper<JietidabianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
