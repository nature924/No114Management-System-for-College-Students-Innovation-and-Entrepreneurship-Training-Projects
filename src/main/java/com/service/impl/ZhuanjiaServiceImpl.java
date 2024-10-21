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


import com.dao.ZhuanjiaDao;
import com.entity.ZhuanjiaEntity;
import com.service.ZhuanjiaService;
import com.entity.vo.ZhuanjiaVO;
import com.entity.view.ZhuanjiaView;

@Service("zhuanjiaService")
public class ZhuanjiaServiceImpl extends ServiceImpl<ZhuanjiaDao, ZhuanjiaEntity> implements ZhuanjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanjiaEntity> page = this.selectPage(
                new Query<ZhuanjiaEntity>(params).getPage(),
                new EntityWrapper<ZhuanjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanjiaEntity> wrapper) {
		  Page<ZhuanjiaView> page =new Query<ZhuanjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuanjiaVO> selectListVO(Wrapper<ZhuanjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanjiaVO selectVO(Wrapper<ZhuanjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanjiaView> selectListView(Wrapper<ZhuanjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanjiaView selectView(Wrapper<ZhuanjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
