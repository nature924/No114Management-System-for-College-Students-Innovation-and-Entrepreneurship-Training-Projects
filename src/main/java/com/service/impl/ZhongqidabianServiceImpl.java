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


import com.dao.ZhongqidabianDao;
import com.entity.ZhongqidabianEntity;
import com.service.ZhongqidabianService;
import com.entity.vo.ZhongqidabianVO;
import com.entity.view.ZhongqidabianView;

@Service("zhongqidabianService")
public class ZhongqidabianServiceImpl extends ServiceImpl<ZhongqidabianDao, ZhongqidabianEntity> implements ZhongqidabianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhongqidabianEntity> page = this.selectPage(
                new Query<ZhongqidabianEntity>(params).getPage(),
                new EntityWrapper<ZhongqidabianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhongqidabianEntity> wrapper) {
		  Page<ZhongqidabianView> page =new Query<ZhongqidabianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhongqidabianVO> selectListVO(Wrapper<ZhongqidabianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhongqidabianVO selectVO(Wrapper<ZhongqidabianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhongqidabianView> selectListView(Wrapper<ZhongqidabianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhongqidabianView selectView(Wrapper<ZhongqidabianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
