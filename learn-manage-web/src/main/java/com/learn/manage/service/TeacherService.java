package com.learn.manage.service;

import com.learn.manage.pojo.LChoose;
import com.learn.manage.pojo.LJudgment;
import com.learn.manage.pojo.LQuestion;
import com.learn.manage.pojo.LSubject;
import com.learn.manage.util.LearnResult;

public interface TeacherService {

	public LearnResult getTeacherByToken(String token);
	public LearnResult getGradeAndClass(String tid);
	public LearnResult getStudentList(String grade);
	//获取题库列表
	public LearnResult getQuestionList(String token,String isUse);
	//删除题库
	public LearnResult deleteQuestion(String ids);
	//插入题库
	public int insertQuestion(LQuestion lQuestion,String token);
	//插入选择题
	public LearnResult insertXz(LChoose lChoose);
	//插入判断题
	public LearnResult insertPd(LJudgment lJudgment);
	//插入主观题
	public LearnResult insertZg(LSubject lSubject);
	//发布作业
	public LearnResult sendHomeWork(String gradeAndClass,String id,String title);
	//更新分数
	public LearnResult markScope(String scope,String hId);
}
