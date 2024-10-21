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


import com.dao.XiangmuzhipaiDao;
import com.entity.XiangmuzhipaiEntity;
import com.service.XiangmuzhipaiService;
import com.entity.vo.XiangmuzhipaiVO;
import com.entity.view.XiangmuzhipaiView;

@Service("xiangmuzhipaiService")
public class XiangmuzhipaiServiceImpl extends ServiceImpl<XiangmuzhipaiDao, XiangmuzhipaiEntity> implements XiangmuzhipaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmuzhipaiEntity> page = this.selectPage(
                new Query<XiangmuzhipaiEntity>(params).getPage(),
                new EntityWrapper<XiangmuzhipaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmuzhipaiEntity> wrapper) {
		  Page<XiangmuzhipaiView> page =new Query<XiangmuzhipaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangmuzhipaiVO> selectListVO(Wrapper<XiangmuzhipaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangmuzhipaiVO selectVO(Wrapper<XiangmuzhipaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangmuzhipaiView> selectListView(Wrapper<XiangmuzhipaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmuzhipaiView selectView(Wrapper<XiangmuzhipaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
