package com.learn.manage.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.logging.Log;
import com.learn.manage.mapper.LHomeworkMapper;
import com.learn.manage.mapper.LStudentMapper;
import com.learn.manage.pojo.LChoose;
import com.learn.manage.pojo.LHomework;
import com.learn.manage.pojo.LJudgment;
import com.learn.manage.pojo.LQuestion;
import com.learn.manage.pojo.LStudent;
import com.learn.manage.pojo.LSubject;
import com.learn.manage.pojo.StuChoose;
import com.learn.manage.pojo.StuJudgment;
import com.learn.manage.pojo.StuSubject;
import com.learn.manage.service.StudentService;
import com.learn.manage.service.TeacherService;
import com.learn.manage.util.CookieUtils;
import com.learn.manage.util.CustomSQL;
import com.learn.manage.util.DataGridResult;
import com.learn.manage.util.JsonUtils;
import com.learn.manage.util.LearnResult;



@Controller
public class TeacherController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private LStudentMapper lStudentMapper;
	@Autowired
	private LHomeworkMapper lHomeworkMapper;
	
	@RequestMapping("/teacher")
	public String showTeacher() {
		return "teacher";
	}
	
	@RequestMapping("/teacher/logout")
	public String teacherLogout(HttpServletRequest request,HttpServletResponse response) {
		//清除token
		CookieUtils.setCookie(request, response, "TOKEN", "");
		return "redirect:/teacher";
	}
	
	@RequestMapping("/teacher/query")
	@ResponseBody
	public LearnResult queryGradeAndClass(HttpServletRequest request,HttpServletResponse response) {
		String token = CookieUtils.getCookieValue(request, "TOKEN");
		LearnResult result = teacherService.getGradeAndClass(token);
		return result;
		
	}
	
	@RequestMapping("/teacher/list")
	@ResponseBody
	public LearnResult getStudentList(String gradeAndClass) throws UnsupportedEncodingException {
		String decode = URLDecoder.decode(gradeAndClass, "UTF-8");
		LearnResult result=teacherService.getStudentList(decode);
		return result;
	}

	@RequestMapping("/teacher/questionlist")
	@ResponseBody
	public LearnResult getQuestionList(String token,String isUse) {
		LearnResult result = teacherService.getQuestionList(token, isUse);
		return result;
	}
	
	@RequestMapping("/teacher/deleteQuestion")
	@ResponseBody
	public LearnResult deleteQuestion(String ids) {
		LearnResult result = teacherService.deleteQuestion(ids);
		return result;
	}
	
	@RequestMapping("/teacher/toteacher")
	@ResponseBody
	public LearnResult resultOk() {
		return LearnResult.ok();
	}
	@RequestMapping("/teacher/teacher-add")
	public String showAdd() {
		return "teacher-add";
	}
	
	@RequestMapping("/teacher/teacher-worklist")
	public String showWorkList(HttpServletRequest request) {
		String sId = request.getParameter("sId");
		//得到学生信息
		LStudent lStudent = lStudentMapper.selectByPrimaryKey(sId);
		request.setAttribute("sId", sId);
		request.setAttribute("student", lStudent);
		return "teacher-worklist";
	}
	
	
	@RequestMapping("/teacher/saveQuestion")
	public String saveQuestion(HttpServletRequest request,HttpServletResponse response) {
		String chooseNum=request.getParameter("chooseNum");
		String judgmentNum=request.getParameter("judgmentNum");
		String subjectNum=request.getParameter("subjectNum");
		String note = request.getParameter("note");
		String title = request.getParameter("title");
		//插入题库
		LQuestion lQuestion=new LQuestion();
		lQuestion.setCreateTime(new Date());
		lQuestion.setIsUse("1");
		lQuestion.setNote(note);
		lQuestion.setTitle(title);
		String token = CookieUtils.getCookieValue(request, "TOKEN");
		int id = teacherService.insertQuestion(lQuestion,token);
		if (Integer.parseInt(chooseNum)>0) {
			//插入选择题
			for(int i=0;i<Integer.parseInt(chooseNum);i++) {
				LChoose lChoose=new LChoose();
				String xz_title = request.getParameter("xz_title"+i);
				String xz_A = request.getParameter("xz_A"+i);
				String xz_B = request.getParameter("xz_B"+i);
				String xz_C = request.getParameter("xz_C"+i);
				String xz_D = request.getParameter("xz_D"+i);
				String xz_current = request.getParameter("xz_current"+i);
				lChoose.setqId(id);
				lChoose.setXzTitle(xz_title);
				lChoose.setXzA(xz_A);
				lChoose.setXzB(xz_B);
				lChoose.setXzC(xz_C);
				lChoose.setXzD(xz_D);
				lChoose.setXzCurrent(xz_current);
				teacherService.insertXz(lChoose);
			}
		}
		//插入判断题
		if (Integer.parseInt(judgmentNum)>0) {
			for(int i=0;i<Integer.parseInt(judgmentNum);i++) {
				LJudgment lJudgment=new LJudgment();
				String pd_title = request.getParameter("pd_title"+i);
				String pd_A = request.getParameter("pd_A"+i);
				String pd_B = request.getParameter("pd_B"+i);
				String pd_current = request.getParameter("pd_current"+i);
				lJudgment.setPdTitle(pd_title);
				lJudgment.setPdA(pd_A);
				lJudgment.setPdB(pd_B);
				lJudgment.setPdCurrent(pd_current);
				lJudgment.setqId(id);
				teacherService.insertPd(lJudgment);
			}
		}
		//插入主观题
		if(Integer.parseInt(subjectNum)>0) {
			for(int i=0;i<Integer.parseInt(subjectNum);i++) {
				LSubject lSubject=new LSubject();
				String zg_title = request.getParameter("zg_title"+i);
				lSubject.setqId(id);
				lSubject.setZgTitle(zg_title);
				teacherService.insertZg(lSubject);
			}
		}
		return "redirect:/teacher"; 
	}
	
	@RequestMapping("/teacher/sendHomeWork")
	@ResponseBody
	public LearnResult sendHomeWork(String gradeAndClass,String id,String title) {
		LearnResult result = teacherService.sendHomeWork(gradeAndClass, id, title);
		return result;
	}
	
	
	@RequestMapping("/teacher/correctHomeWork")
	public String toUpdate(HttpServletRequest request) {
		String qId = request.getParameter("qId");
		String hId = request.getParameter("hId");
		String sId = request.getParameter("sId");
		LHomework key = lHomeworkMapper.selectByPrimaryKey(Integer.parseInt(hId));
		request.setAttribute("Qtitle", key.getqTitle());
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
		request.setAttribute("sId", sId);
		return "teacher-correct";
	}
	
	//审批完成
	@RequestMapping("/teacher/correct")
	public String correct(HttpServletRequest request,HttpServletResponse response) {
		//保存学生答案
		String hId = request.getParameter("hId");
		String sId = request.getParameter("sId");
		String scope = request.getParameter("scope");
		//作业状态变为2 已审批
		studentService.updateType("2",Integer.parseInt(hId));
		//更新作业分数
		teacherService.markScope(scope, hId);
		CookieUtils.setCookie(request, response, "msg", "审批完成", true);
		return "redirect:/teacher/teacher-worklist?sId="+sId;
	}
	
	@RequestMapping("/teacher/correctdetail")
	public String toCorrectDetail(HttpServletRequest request) {
		String qId = request.getParameter("qId");
		String hId = request.getParameter("hId");
		//根据hId取到分数
		LHomework key = lHomeworkMapper.selectByPrimaryKey(Integer.parseInt(hId));
		request.setAttribute("scope",key.getsScope());
		request.setAttribute("Qtitle", key.getqTitle());
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
		return "teacher-detail";
	}
	
}
