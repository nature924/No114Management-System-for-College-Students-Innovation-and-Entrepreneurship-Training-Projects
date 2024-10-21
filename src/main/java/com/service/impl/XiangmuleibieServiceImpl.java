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


import com.dao.XiangmuleibieDao;
import com.entity.XiangmuleibieEntity;
import com.service.XiangmuleibieService;
import com.entity.vo.XiangmuleibieVO;
import com.entity.view.XiangmuleibieView;

@Service("xiangmuleibieService")
public class XiangmuleibieServiceImpl extends ServiceImpl<XiangmuleibieDao, XiangmuleibieEntity> implements XiangmuleibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmuleibieEntity> page = this.selectPage(
                new Query<XiangmuleibieEntity>(params).getPage(),
                new EntityWrapper<XiangmuleibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmuleibieEntity> wrapper) {
		  Page<XiangmuleibieView> page =new Query<XiangmuleibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangmuleibieVO> selectListVO(Wrapper<XiangmuleibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangmuleibieVO selectVO(Wrapper<XiangmuleibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangmuleibieView> selectListView(Wrapper<XiangmuleibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmuleibieView selectView(Wrapper<XiangmuleibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
