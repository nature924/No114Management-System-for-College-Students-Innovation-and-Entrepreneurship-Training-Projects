package com.entity.view;

import com.entity.JietidabianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 结题答辩
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
@TableName("jietidabian")
public class JietidabianView  extends JietidabianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JietidabianView(){
	}
 
 	public JietidabianView(JietidabianEntity jietidabianEntity){
 	try {
			BeanUtils.copyProperties(this, jietidabianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
