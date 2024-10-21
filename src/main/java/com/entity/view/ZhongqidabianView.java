package com.entity.view;

import com.entity.ZhongqidabianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 中期答辩
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
@TableName("zhongqidabian")
public class ZhongqidabianView  extends ZhongqidabianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhongqidabianView(){
	}
 
 	public ZhongqidabianView(ZhongqidabianEntity zhongqidabianEntity){
 	try {
			BeanUtils.copyProperties(this, zhongqidabianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
