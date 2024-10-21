package com.entity.view;

import com.entity.ChuqidabianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 初期答辩
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
@TableName("chuqidabian")
public class ChuqidabianView  extends ChuqidabianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChuqidabianView(){
	}
 
 	public ChuqidabianView(ChuqidabianEntity chuqidabianEntity){
 	try {
			BeanUtils.copyProperties(this, chuqidabianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
