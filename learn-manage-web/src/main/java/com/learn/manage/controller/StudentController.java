package com.learn.manage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.learn.manage.mapper.LHomeworkMapper;
import com.learn.manage.mapper.StuChooseMapper;
import com.learn.manage.mapper.StuJudgmentMapper;
import com.learn.manage.mapper.StuSubjectMapper;
import com.learn.manage.pojo.LChoose;
import com.learn.manage.pojo.LHomework;
import com.learn.manage.pojo.LJudgment;
import com.learn.manage.pojo.LSubject;
import com.learn.manage.pojo.StuChoose;
import com.learn.manage.pojo.StuJudgment;
import com.learn.manage.pojo.StuSubject;
import com.learn.manage.pojo.StuSubjectExample;
import com.learn.manage.pojo.StuSubjectExample.Criteria;
import com.learn.manage.service.StudentService;
import com.learn.manage.util.CookieUtils;
import com.learn.manage.util.CustomSQL;
import com.learn.manage.util.LearnResult;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private StuChooseMapper stuChooseMapper;
	@Autowired
	private StuJudgmentMapper stuJudgmentMapper;
	@Autowired
	private StuSubjectMapper stuSubjectMapper;
	@Autowired
	private LHomeworkMapper lHomeworkMapper;
	
	@RequestMapping("/student")
	public String showStudent() {
		return "student";
	}
	
	@RequestMapping("/student/logout")
	public String studentLogout(HttpServletRequest request,HttpServletResponse response) {
		//清除token
		CookieUtils.setCookie(request, response, "TOKEN", "");
		return "redirect:/student";
	}
	
	@RequestMapping("/student/homeworklist")
	@ResponseBody
	public LearnResult showHomeWork(String token) {
		LearnResult result = studentService.getHomeWorkList(token);
		return result;
	}
	
	@RequestMapping("/teacher/getstudentworklist")
	@ResponseBody
	public LearnResult showHomeWorkListByTeacher(String sId) {
		LearnResult result = studentService.getHomeWorkListByTeacher(sId);
		return result;
	}
	
	
	
	@RequestMapping("/student/tostudent")
	public String toStudent(HttpServletRequest request) {
		String qId = request.getParameter("qId");
		String hId = request.getParameter("hId");
		//返回选择题列表
		List choose = studentService.getChoose(qId);
		//返回判断题列表
		List judgment = studentService.getJudgment(qId);
		//返回主观题列表
		List subject = studentService.getSubject(qId);
		request.setAttribute("chooseList", choose);
		request.setAttribute("judgmentList", judgment);
		request.setAttribute("subjectList", subject);
		request.setAttribute("hId", hId);
		request.setAttribute("qId", qId);
		return "student-dowork";
	}
	
	@RequestMapping("/student/updateHomeWork")
	public String toUpdate(HttpServletRequest request) {
		String qId = request.getParameter("qId");
		String hId = request.getParameter("hId");
		//返回学生答案
		List<StuChoose> chooseAnswer = studentService.getChooseAnswer(hId);
		List<StuJudgment> judgmentAnswer = studentService.getJudgmentAnswer(hId);
		List<StuSubject> subjectAnswer = studentService.getSubjectAnswer(hId);
		//返回选择题列表
		List<LChoose> choose = studentService.getChoose(qId);
		List<CustomSQL> cuList=new ArrayList<>();
		if (choose.size()>0 && choose!=null) {
			for(int i=0;i<choose.size();i++) {
			LChoose lChoose = choose.get(i);
			StuChoose stuChoose = chooseAnswer.get(i);
			lChoose.setXzCurrent(stuChoose.getsAnswer());
			}
		}
		//返回判断题列表
		List<LJudgment> judgment = studentService.getJudgment(qId);
		if (judgment.size()>0 && judgment!=null) {
			for(int i=0;i<judgment.size();i++) {
				LJudgment lJudgment = judgment.get(i);
				StuJudgment stuJudgment = judgmentAnswer.get(i);
				lJudgment.setPdCurrent(stuJudgment.getsAnswer());
			}
		}
		//返回主观题列表
		List<LSubject> subject = studentService.getSubject(qId);
		
		if (subject.size()>0 && subject!=null) {
			int index=0;
			for (LSubject lSubject : subject) {
				CustomSQL customSQL=new CustomSQL();
				customSQL.setqId(lSubject.getqId());
				customSQL.setZgId(lSubject.getZgId());
				customSQL.setZgTitle(lSubject.getZgTitle());
				StuSubject stuSubject = subjectAnswer.get(index);
				customSQL.sethId(stuSubject.gethId());
				customSQL.setsAnswer(stuSubject.getsAnswer());
				cuList.add(customSQL);
				index++;
			}	
		}
		request.setAttribute("chooseList", choose);
		request.setAttribute("judgmentList", judgment);
		request.setAttribute("subjectList", subject);
		request.setAttribute("cuList", cuList);
		request.setAttribute("hId", hId);
		request.setAttribute("qId", qId);
		return "student-update";
	}
	
	@RequestMapping("/student/saveQuestion")
	public String saveQuestion(HttpServletRequest request,HttpServletResponse response) {
		//保存学生答案
		String hId = request.getParameter("hId");
		String qId = request.getParameter("qId");
		List<LChoose> choose = studentService.getChoose(qId);
		List<LJudgment> judgment = studentService.getJudgment(qId);
		List<LSubject> subject = studentService.getSubject(qId);
		if(choose.size()>0 && choose!=null) {
			//保存选择题答案
			int index=0;
			for (LChoose lChoose : choose) {
			StuChoose stuChoose=new StuChoose();
			stuChoose.setXzId(lChoose.getXzId());
			stuChoose.sethId(Integer.parseInt(hId));
			String sAnswer = request.getParameter("choose"+index);
			stuChoose.setsAnswer(sAnswer);
			studentService.saveChoose(stuChoose);
			index++;
			}	
		}
		if(judgment.size()>0 && judgment!=null) {
			//保存判断题答案
			int index=0;
			for (LJudgment lJudgment : judgment) {
				StuJudgment stuJudgment=new StuJudgment();
				stuJudgment.setPdId(lJudgment.getPdId());
				stuJudgment.sethId(Integer.parseInt(hId));
				String sAnswer = request.getParameter("judg"+index);
				stuJudgment.setsAnswer(sAnswer);
				studentService.saveJudgment(stuJudgment);
				index++;
			}
		}
		if(subject.size()>0 && subject!=null) {
			//保存主观题答案
			int index=0;
			for (LSubject lSubject : subject) {
				StuSubject stuSubject=new StuSubject();
				stuSubject.sethId(Integer.parseInt(hId));
				stuSubject.setZgId(lSubject.getZgId());
				String sAnswer = request.getParameter("subj"+index);
				stuSubject.setsAnswer(sAnswer);
				studentService.saveSubject(stuSubject);
				index++;
			}
		}
		//作业状态变为3 未提交
		studentService.updateType("3",Integer.parseInt(hId));
		CookieUtils.setCookie(request, response, "msg", "保存成功", true);
		return "redirect:/student";
	}
	
	@RequestMapping("/student/updateQuestion")
	public String updateQuestion(HttpServletRequest request,HttpServletResponse response) {
		//保存学生答案
		String hId = request.getParameter("hId");
		String qId = request.getParameter("qId");
		List<LChoose> choose = studentService.getChoose(qId);
		List<LJudgment> judgment = studentService.getJudgment(qId);
		List<LSubject> subject = studentService.getSubject(qId);
		if(choose.size()>0 && choose!=null) {
			//保存选择题答案
			int index=0;
			for (LChoose lChoose : choose) {
			StuChoose stuChoose=new StuChoose();
			stuChoose.setXzId(lChoose.getXzId());
			stuChoose.sethId(Integer.parseInt(hId));
			String sAnswer = request.getParameter("choose"+index);
			stuChoose.setsAnswer(sAnswer);
			stuChooseMapper.updateByPrimaryKeySelective(stuChoose);
			index++;
			}	
		}
		if(judgment.size()>0 && judgment!=null) {
			//保存判断题答案
			int index=0;
			for (LJudgment lJudgment : judgment) {
				StuJudgment stuJudgment=new StuJudgment();
				stuJudgment.setPdId(lJudgment.getPdId());
				stuJudgment.sethId(Integer.parseInt(hId));
				String sAnswer = request.getParameter("judg"+index);
				stuJudgment.setsAnswer(sAnswer);
				stuJudgmentMapper.updateByPrimaryKeySelective(stuJudgment);
				index++;
			}
		}
		if(subject.size()>0 && subject!=null) {
			//保存主观题答案
			int index=0;
			for (LSubject lSubject : subject) {
				StuSubject stuSubject=new StuSubject();
				String sAnswer = request.getParameter("subj"+index);
				stuSubject.setsAnswer(sAnswer);
				stuSubject.sethId(Integer.parseInt(hId));
				stuSubject.setZgId(lSubject.getZgId());
				stuSubjectMapper.updateByMyself(stuSubject);
				index++;
			}
		}
		
		CookieUtils.setCookie(request, response, "msg", "保存成功", true);
		return "redirect:/student";
	}
	
	@RequestMapping("/student/submithomework")
	@ResponseBody
	public LearnResult submitHomeWork(String hId) {
		LearnResult result = studentService.updateType("1", Integer.parseInt(hId));
		return result;
	}
	
	
	
	@RequestMapping("/student/correctdetail")
	public String toDetail(HttpServletRequest request) {
		String qId = request.getParameter("qId");
		String hId = request.getParameter("hId");
		//根据hId返回分数
		LHomework key = lHomeworkMapper.selectByPrimaryKey(Integer.parseInt(hId));
		request.setAttribute("Qtitle", key.getqTitle());
		request.setAttribute("scope", key.getsScope());
		//返回学生答案
		List<StuChoose> chooseAnswer = studentService.getChooseAnswer(hId);
		List<StuJudgment> judgmentAnswer = studentService.getJudgmentAnswer(hId);
		List<StuSubject> subjectAnswer = studentService.getSubjectAnswer(hId);
		//返回选择题列表
		List<LChoose> choose = studentService.getChoose(qId);
		List theXZ = studentService.getChoose(qId);
		List<CustomSQL> cuList=new ArrayList<>();
		if (choose.size()>0 && choose!=null) {
			for(int i=0;i<choose.size();i++) {
			LChoose lChoose = choose.get(i);
			StuChoose stuChoose = chooseAnswer.get(i);
			lChoose.setXzCurrent(stuChoose.getsAnswer());
			}
		}
		//返回判断题列表
		List<LJudgment> judgment = studentService.getJudgment(qId);
		List theJU = studentService.getJudgment(qId);
		if (judgment.size()>0 && judgment!=null) {
			for(int i=0;i<judgment.size();i++) {
				LJudgment lJudgment = judgment.get(i);
				StuJudgment stuJudgment = judgmentAnswer.get(i);
				lJudgment.setPdCurrent(stuJudgment.getsAnswer());
			}
		}
		//返回主观题列表
		List<LSubject> subject = studentService.getSubject(qId);
		
		if (subject.size()>0 && subject!=null) {
			int index=0;
			for (LSubject lSubject : subject) {
				CustomSQL customSQL=new CustomSQL();
				customSQL.setqId(lSubject.getqId());
				customSQL.setZgId(lSubject.getZgId());
				customSQL.setZgTitle(lSubject.getZgTitle());
				StuSubject stuSubject = subjectAnswer.get(index);
				customSQL.sethId(stuSubject.gethId());
				customSQL.setsAnswer(stuSubject.getsAnswer());
				cuList.add(customSQL);
				index++;
			}	
		}
		request.setAttribute("chooseList", choose);
		request.setAttribute("theXZ", theXZ);
		request.setAttribute("theJU", theJU);
		request.setAttribute("judgmentList", judgment);
		request.setAttribute("subjectList", subject);
		request.setAttribute("cuList", cuList);
		request.setAttribute("hId", hId);
		request.setAttribute("qId", qId);
		return "student-correct";
	}
	
	@RequestMapping("/student/homeworkdetail")
	public String toHomeWorkDetail(HttpServletRequest request) {
		String qId = request.getParameter("qId");
		String hId = request.getParameter("hId");
		LHomework lHomework = lHomeworkMapper.selectByPrimaryKey(Integer.parseInt(hId));
		//返回学生答案
		List<StuChoose> chooseAnswer = studentService.getChooseAnswer(hId);
		List<StuJudgment> judgmentAnswer = studentService.getJudgmentAnswer(hId);
		List<StuSubject> subjectAnswer = studentService.getSubjectAnswer(hId);
		//返回选择题列表
		List<LChoose> choose = studentService.getChoose(qId);
		List<CustomSQL> cuList=new ArrayList<>();
		if (choose.size()>0 && choose!=null) {
			for(int i=0;i<choose.size();i++) {
			LChoose lChoose = choose.get(i);
			StuChoose stuChoose = chooseAnswer.get(i);
			lChoose.setXzCurrent(stuChoose.getsAnswer());
			}
		}
		//返回判断题列表
		List<LJudgment> judgment = studentService.getJudgment(qId);
		if (judgment.size()>0 && judgment!=null) {
			for(int i=0;i<judgment.size();i++) {
				LJudgment lJudgment = judgment.get(i);
				StuJudgment stuJudgment = judgmentAnswer.get(i);
				lJudgment.setPdCurrent(stuJudgment.getsAnswer());
			}
		}
		//返回主观题列表
		List<LSubject> subject = studentService.getSubject(qId);
		
		if (subject.size()>0 && subject!=null) {
			int index=0;
			for (LSubject lSubject : subject) {
				CustomSQL customSQL=new CustomSQL();
				customSQL.setqId(lSubject.getqId());
				customSQL.setZgId(lSubject.getZgId());
				customSQL.setZgTitle(lSubject.getZgTitle());
				StuSubject stuSubject = subjectAnswer.get(index);
				customSQL.sethId(stuSubject.gethId());
				customSQL.setsAnswer(stuSubject.getsAnswer());
				cuList.add(customSQL);
				index++;
			}	
		}
		request.setAttribute("Qtitle", lHomework.getqTitle());
		request.setAttribute("chooseList", choose);
		request.setAttribute("judgmentList", judgment);
		request.setAttribute("subjectList", subject);
		request.setAttribute("cuList", cuList);
		request.setAttribute("hId", hId);
		request.setAttribute("qId", qId);
		return "student-detail";
	}
	
}
