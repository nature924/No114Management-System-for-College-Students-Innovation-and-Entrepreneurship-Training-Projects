package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JietipingjiaEntity;
import com.entity.view.JietipingjiaView;

import com.service.JietipingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 结题评价
 * 后端接口
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
@RestController
@RequestMapping("/jietipingjia")
public class JietipingjiaController {
    @Autowired
    private JietipingjiaService jietipingjiaService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JietipingjiaEntity jietipingjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jietipingjia.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jietipingjia.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhuanjia")) {
			jietipingjia.setZhuanjiaxingming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JietipingjiaEntity> ew = new EntityWrapper<JietipingjiaEntity>();

		PageUtils page = jietipingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jietipingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JietipingjiaEntity jietipingjia, 
		HttpServletRequest request){
        EntityWrapper<JietipingjiaEntity> ew = new EntityWrapper<JietipingjiaEntity>();

		PageUtils page = jietipingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jietipingjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JietipingjiaEntity jietipingjia){
       	EntityWrapper<JietipingjiaEntity> ew = new EntityWrapper<JietipingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jietipingjia, "jietipingjia")); 
        return R.ok().put("data", jietipingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JietipingjiaEntity jietipingjia){
        EntityWrapper< JietipingjiaEntity> ew = new EntityWrapper< JietipingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jietipingjia, "jietipingjia")); 
		JietipingjiaView jietipingjiaView =  jietipingjiaService.selectView(ew);
		return R.ok("查询结题评价成功").put("data", jietipingjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JietipingjiaEntity jietipingjia = jietipingjiaService.selectById(id);
        return R.ok().put("data", jietipingjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JietipingjiaEntity jietipingjia = jietipingjiaService.selectById(id);
        return R.ok().put("data", jietipingjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JietipingjiaEntity jietipingjia, HttpServletRequest request){
    	jietipingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jietipingjia);
        jietipingjiaService.insert(jietipingjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JietipingjiaEntity jietipingjia, HttpServletRequest request){
    	jietipingjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jietipingjia);
        jietipingjiaService.insert(jietipingjia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JietipingjiaEntity jietipingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jietipingjia);
        jietipingjiaService.updateById(jietipingjia);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jietipingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JietipingjiaEntity> wrapper = new EntityWrapper<JietipingjiaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xueshengxuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhuanjia")) {
			wrapper.eq("zhuanjiaxingming", (String)request.getSession().getAttribute("username"));
		}

		int count = jietipingjiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
