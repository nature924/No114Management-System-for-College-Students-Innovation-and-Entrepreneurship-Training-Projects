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


import com.dao.ChuqidabianDao;
import com.entity.ChuqidabianEntity;
import com.service.ChuqidabianService;
import com.entity.vo.ChuqidabianVO;
import com.entity.view.ChuqidabianView;

@Service("chuqidabianService")
public class ChuqidabianServiceImpl extends ServiceImpl<ChuqidabianDao, ChuqidabianEntity> implements ChuqidabianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuqidabianEntity> page = this.selectPage(
                new Query<ChuqidabianEntity>(params).getPage(),
                new EntityWrapper<ChuqidabianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuqidabianEntity> wrapper) {
		  Page<ChuqidabianView> page =new Query<ChuqidabianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChuqidabianVO> selectListVO(Wrapper<ChuqidabianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuqidabianVO selectVO(Wrapper<ChuqidabianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuqidabianView> selectListView(Wrapper<ChuqidabianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuqidabianView selectView(Wrapper<ChuqidabianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
