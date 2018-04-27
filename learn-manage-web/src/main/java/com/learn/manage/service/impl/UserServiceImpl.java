package com.learn.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.manage.mapper.LUserMapper;
import com.learn.manage.pojo.LUser;
import com.learn.manage.pojo.LUserExample;
import com.learn.manage.pojo.LUserExample.Criteria;
import com.learn.manage.service.UserService;
import com.learn.manage.util.LearnResult;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private LUserMapper userMapper;
	
	@Override
	public LearnResult userLogin(String username, String password,String type) {
		//判断用户名和密码是否正确
		LUserExample example=new LUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<LUser> list = userMapper.selectByExample(example);
		if(list == null || list.size() == 0) {
			return LearnResult.build(400, "用户名或密码不正确");
		}
		LUser lUser = list.get(0);
		if(!lUser.getPassword().equals(password)) {
			return LearnResult.build(400, "用户名或密码不正确");
		}
		if (!lUser.getType().equals(type)) {
			return LearnResult.build(400, "选择登录入口错误");
		}
		
		return LearnResult.ok(lUser.getId());
	}

}
