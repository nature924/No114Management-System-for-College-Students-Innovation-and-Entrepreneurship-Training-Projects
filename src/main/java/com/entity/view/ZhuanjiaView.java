package com.entity.view;

import com.entity.ZhuanjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 专家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
@TableName("zhuanjia")
public class ZhuanjiaView  extends ZhuanjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhuanjiaView(){
	}
 
 	public ZhuanjiaView(ZhuanjiaEntity zhuanjiaEntity){
 	try {
			BeanUtils.copyProperties(this, zhuanjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
