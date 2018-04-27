package com.learn.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.manage.mapper.LChooseMapper;
import com.learn.manage.mapper.LGradeMapper;
import com.learn.manage.mapper.LHomeworkMapper;
import com.learn.manage.mapper.LJudgmentMapper;
import com.learn.manage.mapper.LQuestionMapper;
import com.learn.manage.mapper.LStudentMapper;
import com.learn.manage.mapper.LSubjectMapper;
import com.learn.manage.mapper.LTeacherMapper;
import com.learn.manage.mapper.LUserMapper;
import com.learn.manage.pojo.LChoose;
import com.learn.manage.pojo.LGrade;
import com.learn.manage.pojo.LGradeExample;
import com.learn.manage.pojo.LHomework;
import com.learn.manage.pojo.LJudgment;
import com.learn.manage.pojo.LQuestion;
import com.learn.manage.pojo.LQuestionExample;
import com.learn.manage.pojo.LStudent;
import com.learn.manage.pojo.LStudentExample;
import com.learn.manage.pojo.LSubject;
import com.learn.manage.pojo.LTeacher;
import com.learn.manage.pojo.LTeacherExample;
import com.learn.manage.pojo.LTeacherExample.Criteria;
import com.learn.manage.service.TeacherService;
import com.learn.manage.util.LearnResult;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private LTeacherMapper lTeacherMapper;
	@Autowired
	private LUserMapper lUserMapper;
	@Autowired 
	private LGradeMapper lGradeMapper;
	@Autowired
	private LStudentMapper lStudentMapper;
	@Autowired
	private LQuestionMapper lQuestionMapper;
	@Autowired
	private LChooseMapper lChooseMapper;
	@Autowired
	private LJudgmentMapper lJudgmentMapper;
	@Autowired
	private LSubjectMapper lSubjectMapper;
	@Autowired
	private LHomeworkMapper lHomeworkMapper;
	
	
	@Override
	public LearnResult getTeacherByToken(String token) {
		//token中存放的是用户id	
		LTeacherExample example=new LTeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andLIdEqualTo(Integer.parseInt(token));
		//取到教师信息
		List<LTeacher> list = lTeacherMapper.selectByExample(example);
		LTeacher lTeacher=new LTeacher();
		if (list.size()>0 && list!=null) {
			 lTeacher = list.get(0);
			return LearnResult.ok(lTeacher);
		}
		return LearnResult.ok(lTeacher);
	}

	//获取教师名下班级
	@Override
	public LearnResult getGradeAndClass(String tid) {
		List rows=new ArrayList<>();
		LTeacherExample eLTeacherExample=new LTeacherExample();
		Criteria criteria2 = eLTeacherExample.createCriteria();
		criteria2.andLIdEqualTo(Integer.parseInt(tid));
		List<LTeacher> teacherList = lTeacherMapper.selectByExample(eLTeacherExample);
		if (teacherList.size()>0 && teacherList!=null) {
			LTeacher teacher = teacherList.get(0);
			LGradeExample example=new LGradeExample();
			com.learn.manage.pojo.LGradeExample.Criteria criteria = example.createCriteria();
			criteria.andTIdEqualTo(teacher.gettId());
			List<LGrade> list = lGradeMapper.selectByExample(example);
			if (list.size()>0 && list!=null) {
				for (LGrade lGrade : list) {
					String gc=lGrade.getlGrade()+lGrade.getlClass();
					rows.add(gc);
				}
		}
		}
		return LearnResult.ok(rows);
	}

	@Override
	public LearnResult getStudentList(String grade) {
		//根据班级找到学生列表
		String[] strings = grade.split("级");
		String stuGrade=strings[0]+"级";
		String stuClass=strings[1];
		LStudentExample example=new LStudentExample();
		com.learn.manage.pojo.LStudentExample.Criteria criteria = example.createCriteria();
		criteria.andSGradeEqualTo(stuGrade);
		criteria.andSClassEqualTo(stuClass);
		//取得查询结果
		List<LStudent> list = lStudentMapper.selectByExample(example);
		return LearnResult.ok(list);
	}

	@Override
	public LearnResult getQuestionList(String token, String isUse) {
		//根据token得到tid
		String tid = getTeacherTid(token);
		//根据tid查找题库
		LQuestionExample example=new LQuestionExample();
		com.learn.manage.pojo.LQuestionExample.Criteria criteria = example.createCriteria();
		criteria.andTIdEqualTo(tid);
		criteria.andIsUseEqualTo(isUse);
		List<LQuestion> list = lQuestionMapper.selectByExampleWithBLOBs(example);
		return LearnResult.ok(list);
	}
	
	
	public String getTeacherTid(String token) {
		LTeacherExample example=new LTeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andLIdEqualTo(Integer.parseInt(token));
		//取到教师信息
		List<LTeacher> list = lTeacherMapper.selectByExample(example);
		LTeacher lTeacher=new LTeacher();
		if (list.size()>0 && list!=null) {
			 lTeacher = list.get(0);
		}
		return lTeacher.gettId();
	}

	@Override
	public LearnResult deleteQuestion(String ids) {
		String[] split = ids.split(",");
		for (String id : split) {
			//更新is_use字段为0:不可用 1:可用
			LQuestion question = lQuestionMapper.selectByPrimaryKey(Integer.parseInt(id));
			question.setIsUse("0");
			lQuestionMapper.updateByPrimaryKey(question);
		}
		return LearnResult.ok();
	}

	//插入题库，返回主键
	@Override
	public int insertQuestion(LQuestion lQuestion,String token) {
		//取题目录入人Id
		String tid = getTeacherTid(token);
		lQuestion.settId(tid);
		lQuestionMapper.insert(lQuestion);
		return lQuestion.getId();
	}

	//插入选择题
	@Override
	public LearnResult insertXz(LChoose lChoose) {
		lChooseMapper.insertSelective(lChoose);
		return LearnResult.ok();
	}

	//插入判断题
	@Override
	public LearnResult insertPd(LJudgment lJudgment) {
		// TODO 自动生成的方法存根
		lJudgmentMapper.insertSelective(lJudgment);
		return LearnResult.ok();
	}

	//插入主观题
	@Override
	public LearnResult insertZg(LSubject lSubject) {
		lSubjectMapper.insertSelective(lSubject);
		return LearnResult.ok();
	}

	//发布作业
	@Override
	public LearnResult sendHomeWork(String gradeAndClass, String id, String title) {
		//根据班级信息，得到学生id列表
		String[] strings = gradeAndClass.split("级");
		String stuGrade=strings[0]+"级";
		String stuClass=strings[1];
		LStudentExample example=new LStudentExample();
		com.learn.manage.pojo.LStudentExample.Criteria criteria = example.createCriteria();
		criteria.andSGradeEqualTo(stuGrade);
		criteria.andSClassEqualTo(stuClass);
		//取得查询结果
		List<LStudent> list = lStudentMapper.selectByExample(example);
		if(list.size()>0 && list!=null) {
			for (LStudent lStudent : list) {
				//根据学生id插入作业表
				LHomework lHomework=new LHomework();
				lHomework.setqTitle(title);
				lHomework.setqId(Integer.parseInt(id));
				//0:未完成,1:提交,2:审批完成
				lHomework.setType("0");
				lHomework.setsId(lStudent.getsId());
				lHomeworkMapper.insert(lHomework);
			}
		}
		return LearnResult.ok();
	}

	@Override
	public LearnResult markScope(String scope, String hId) {
		// TODO 自动生成的方法存根
		LHomework homework=new LHomework();
		homework.setsScope(scope);
		homework.sethId(Integer.parseInt(hId));
		lHomeworkMapper.updateByPrimaryKeySelective(homework);
		return LearnResult.ok();
	}
	
}
