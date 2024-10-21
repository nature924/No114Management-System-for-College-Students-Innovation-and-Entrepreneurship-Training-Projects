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

import com.entity.ZhuanjiaEntity;
import com.entity.view.ZhuanjiaView;

import com.service.ZhuanjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 专家
 * 后端接口
 * @author 
 * @email 
 * @date 2023-01-07 10:27:31
 */
@RestController
@RequestMapping("/zhuanjia")
public class ZhuanjiaController {
    @Autowired
    private ZhuanjiaService zhuanjiaService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ZhuanjiaEntity u = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("zhuanjiaxingming", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"zhuanjia",  "专家" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZhuanjiaEntity zhuanjia){
    	//ValidatorUtils.validateEntity(zhuanjia);
    	ZhuanjiaEntity u = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("zhuanjiaxingming", zhuanjia.getZhuanjiaxingming()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		zhuanjia.setId(uId);
        zhuanjiaService.insert(zhuanjia);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ZhuanjiaEntity u = zhuanjiaService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ZhuanjiaEntity u = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("zhuanjiaxingming", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        zhuanjiaService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuanjiaEntity zhuanjia,
		HttpServletRequest request){
        EntityWrapper<ZhuanjiaEntity> ew = new EntityWrapper<ZhuanjiaEntity>();

		PageUtils page = zhuanjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuanjiaEntity zhuanjia, 
		HttpServletRequest request){
        EntityWrapper<ZhuanjiaEntity> ew = new EntityWrapper<ZhuanjiaEntity>();

		PageUtils page = zhuanjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanjia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuanjiaEntity zhuanjia){
       	EntityWrapper<ZhuanjiaEntity> ew = new EntityWrapper<ZhuanjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuanjia, "zhuanjia")); 
        return R.ok().put("data", zhuanjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuanjiaEntity zhuanjia){
        EntityWrapper< ZhuanjiaEntity> ew = new EntityWrapper< ZhuanjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuanjia, "zhuanjia")); 
		ZhuanjiaView zhuanjiaView =  zhuanjiaService.selectView(ew);
		return R.ok("查询专家成功").put("data", zhuanjiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(id);
        return R.ok().put("data", zhuanjia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuanjiaEntity zhuanjia = zhuanjiaService.selectById(id);
        return R.ok().put("data", zhuanjia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request){
    	zhuanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuanjia);
    	ZhuanjiaEntity u = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("zhuanjiaxingming", zhuanjia.getZhuanjiaxingming()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		zhuanjia.setId(new Date().getTime());
        zhuanjiaService.insert(zhuanjia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request){
    	zhuanjia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuanjia);
    	ZhuanjiaEntity u = zhuanjiaService.selectOne(new EntityWrapper<ZhuanjiaEntity>().eq("zhuanjiaxingming", zhuanjia.getZhuanjiaxingming()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		zhuanjia.setId(new Date().getTime());
        zhuanjiaService.insert(zhuanjia);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuanjiaEntity zhuanjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanjia);
        zhuanjiaService.updateById(zhuanjia);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuanjiaService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhuanjiaEntity> wrapper = new EntityWrapper<ZhuanjiaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = zhuanjiaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
