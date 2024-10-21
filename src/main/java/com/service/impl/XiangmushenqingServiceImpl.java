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


import com.dao.XiangmushenqingDao;
import com.entity.XiangmushenqingEntity;
import com.service.XiangmushenqingService;
import com.entity.vo.XiangmushenqingVO;
import com.entity.view.XiangmushenqingView;

@Service("xiangmushenqingService")
public class XiangmushenqingServiceImpl extends ServiceImpl<XiangmushenqingDao, XiangmushenqingEntity> implements XiangmushenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmushenqingEntity> page = this.selectPage(
                new Query<XiangmushenqingEntity>(params).getPage(),
                new EntityWrapper<XiangmushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmushenqingEntity> wrapper) {
		  Page<XiangmushenqingView> page =new Query<XiangmushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangmushenqingVO> selectListVO(Wrapper<XiangmushenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangmushenqingVO selectVO(Wrapper<XiangmushenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangmushenqingView> selectListView(Wrapper<XiangmushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmushenqingView selectView(Wrapper<XiangmushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
