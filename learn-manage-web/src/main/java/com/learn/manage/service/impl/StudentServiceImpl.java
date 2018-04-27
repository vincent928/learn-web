package com.learn.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.manage.mapper.LChooseMapper;
import com.learn.manage.mapper.LHomeworkMapper;
import com.learn.manage.mapper.LJudgmentMapper;
import com.learn.manage.mapper.LStudentMapper;
import com.learn.manage.mapper.LSubjectMapper;
import com.learn.manage.mapper.LTeacherMapper;
import com.learn.manage.mapper.StuChooseMapper;
import com.learn.manage.mapper.StuJudgmentMapper;
import com.learn.manage.mapper.StuSubjectMapper;
import com.learn.manage.pojo.LChoose;
import com.learn.manage.pojo.LChooseExample;
import com.learn.manage.pojo.LHomework;
import com.learn.manage.pojo.LHomeworkExample;
import com.learn.manage.pojo.LJudgment;
import com.learn.manage.pojo.LJudgmentExample;
import com.learn.manage.pojo.LStudent;
import com.learn.manage.pojo.LStudentExample;
import com.learn.manage.pojo.LStudentExample.Criteria;
import com.learn.manage.pojo.LSubject;
import com.learn.manage.pojo.LSubjectExample;
import com.learn.manage.pojo.StuChoose;
import com.learn.manage.pojo.StuChooseExample;
import com.learn.manage.pojo.StuJudgment;
import com.learn.manage.pojo.StuJudgmentExample;
import com.learn.manage.pojo.StuSubject;
import com.learn.manage.pojo.StuSubjectExample;
import com.learn.manage.service.StudentService;
import com.learn.manage.util.LearnResult;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private LTeacherMapper lTeacherMapper;
	@Autowired
	private LStudentMapper lStudentMapper;
	@Autowired
	private LHomeworkMapper lHomeworkMapper;
	@Autowired
	private LChooseMapper lChooseMapper;
	@Autowired
	private LJudgmentMapper lJudgmentMapper;
	@Autowired
	private LSubjectMapper lSubjectMapper;
	@Autowired
	private StuChooseMapper stuChooseMapper;
	@Autowired
	private StuJudgmentMapper stuJudgmentMapper;
	@Autowired
	private StuSubjectMapper stuSubjectMapper;
	

	@Override
	public LearnResult getStudentByToken(String token) {
		//token中存放的是用户id	
		LStudentExample example=new LStudentExample();
		 com.learn.manage.pojo.LStudentExample.Criteria criteria = example.createCriteria();
		criteria.andLIdEqualTo(Integer.parseInt(token));
		//取到学生信息
		List<LStudent> list = lStudentMapper.selectByExample(example);
		LStudent lStudent=new LStudent();
		if(list.size()>0 && list!=null) {
			 lStudent = list.get(0);
			return LearnResult.ok(lStudent);
		}
		return LearnResult.ok(lStudent);
	}

	//学生作业列表
	@Override
	public LearnResult getHomeWorkList(String token) {
		//根据token找到学生id
		String sid = getSid(token);
		//题库id，试题名称，type
		LHomeworkExample example=new LHomeworkExample();
		com.learn.manage.pojo.LHomeworkExample.Criteria criteria = example.createCriteria();
		criteria.andSIdEqualTo(sid);
		List<LHomework> list = lHomeworkMapper.selectByExample(example);
		if(list.size()>0 && list!=null) {
			return LearnResult.ok(list);
		}
		return null;
	}

	//教师端获取type=1、2的学生作业列表
	@Override
	public LearnResult getHomeWorkListByTeacher(String sId) {
		LHomeworkExample example=new LHomeworkExample();
		List values=new ArrayList<>();
		values.add("1");
		values.add("2");
		com.learn.manage.pojo.LHomeworkExample.Criteria criteria = example.createCriteria();
		criteria.andSIdEqualTo(sId);
		criteria.andTypeIn(values);
		List<LHomework> list = lHomeworkMapper.selectByExample(example);
		if(list.size()>0 && list!=null) {
			return LearnResult.ok(list);
		}
		return null;
	}
	
	//根据token找到学生sid
	public String getSid(String token) {
		LStudentExample example=new LStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andLIdEqualTo(Integer.parseInt(token));
		List<LStudent> list = lStudentMapper.selectByExample(example);
		LStudent lStudent=new LStudent();
		if (list!=null && list.size()>0) {
			lStudent = list.get(0);
		}
		return lStudent.getsId();
	}

	@Override
	public List getChoose(String qId) {
		LChooseExample example=new LChooseExample();
		com.learn.manage.pojo.LChooseExample.Criteria criteria = example.createCriteria();
		criteria.andQIdEqualTo(Integer.parseInt(qId));
		List<LChoose> list = lChooseMapper.selectByExample(example);
		return list;
	}

	@Override
	public List getJudgment(String qId) {
		LJudgmentExample example=new LJudgmentExample();
		com.learn.manage.pojo.LJudgmentExample.Criteria criteria = example.createCriteria();
		criteria.andQIdEqualTo(Integer.parseInt(qId));
		List<LJudgment> list = lJudgmentMapper.selectByExample(example);
		return list;
	}

	@Override
	public List getSubject(String qId) {
		LSubjectExample example=new LSubjectExample();
		com.learn.manage.pojo.LSubjectExample.Criteria criteria = example.createCriteria();
		criteria.andQIdEqualTo(Integer.parseInt(qId));
		List<LSubject> list = lSubjectMapper.selectByExample(example);
		return list;
	}

	@Override
	public LearnResult saveChoose(StuChoose stuChoose) {
		stuChooseMapper.insertSelective(stuChoose);
		return LearnResult.ok();
	}

	@Override
	public LearnResult saveJudgment(StuJudgment stuJudgment) {
		stuJudgmentMapper.insertSelective(stuJudgment);
		return LearnResult.ok();
	}

	@Override
	public LearnResult saveSubject(StuSubject stuSubject) {
		stuSubjectMapper.insertSelective(stuSubject);
		return LearnResult.ok();
	}

	@Override
	public LearnResult updateType(String type,int hId) {
		// TODO 自动生成的方法存根
		LHomework lHomework=new LHomework();
		lHomework.setType(type);
		lHomework.sethId(hId);
		lHomeworkMapper.updateByPrimaryKeySelective(lHomework);
		return LearnResult.ok();
	}

	@Override
	public List getChooseAnswer(String hId) {
		StuChooseExample example=new StuChooseExample();
		com.learn.manage.pojo.StuChooseExample.Criteria criteria = example.createCriteria();
		criteria.andHIdEqualTo(Integer.parseInt(hId));
		List<StuChoose> list = stuChooseMapper.selectByExample(example);
		return list;
	}

	@Override
	public List getJudgmentAnswer(String hId) {
		StuJudgmentExample example=new StuJudgmentExample();
		com.learn.manage.pojo.StuJudgmentExample.Criteria criteria = example.createCriteria();
		criteria.andHIdEqualTo(Integer.parseInt(hId));
		List<StuJudgment> list = stuJudgmentMapper.selectByExample(example);
		return list;
	}

	@Override
	public List getSubjectAnswer(String hId) {
		StuSubjectExample example=new StuSubjectExample();
		com.learn.manage.pojo.StuSubjectExample.Criteria criteria = example.createCriteria();
		criteria.andHIdEqualTo(Integer.parseInt(hId));
		List<StuSubject> list = stuSubjectMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	
	
	
	
	
}
