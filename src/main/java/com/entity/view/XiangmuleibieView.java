package com.entity.view;

import com.entity.XiangmuleibieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 项目类别
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
@TableName("xiangmuleibie")
public class XiangmuleibieView  extends XiangmuleibieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiangmuleibieView(){
	}
 
 	public XiangmuleibieView(XiangmuleibieEntity xiangmuleibieEntity){
 	try {
			BeanUtils.copyProperties(this, xiangmuleibieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
