package com.learn.manage.service;

import java.util.List;

import com.learn.manage.pojo.StuChoose;
import com.learn.manage.pojo.StuJudgment;
import com.learn.manage.pojo.StuSubject;
import com.learn.manage.util.LearnResult;

public interface StudentService {
	public LearnResult getStudentByToken(String token);
	//作业列表
	public LearnResult getHomeWorkList(String token);
	//教师端作业表
	public LearnResult getHomeWorkListByTeacher(String sId);
	//作业id对应的选择题
	public List getChoose(String qId);
	//作业id对应的判断题
	public List getJudgment(String qId);
	//作业id对应的主观题
	public List getSubject(String qId);
	//保存选择题答案
	public LearnResult saveChoose(StuChoose stuChoose);
	//保存判断题答案
	public LearnResult saveJudgment(StuJudgment stuJudgment);
	//保存主观题答案
	public LearnResult saveSubject(StuSubject stuSubject);
	//更改作业状态
	public LearnResult updateType(String type,int hId);
	//返回选择题答案
	public List getChooseAnswer(String hId);
	//返回判断题答案
	public List getJudgmentAnswer(String hId);
	//返回主观题答案
	public List getSubjectAnswer(String hId);
}
