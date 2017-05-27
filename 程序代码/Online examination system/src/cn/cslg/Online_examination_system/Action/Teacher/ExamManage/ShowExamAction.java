package cn.cslg.Online_examination_system.Action.Teacher.ExamManage;

import cn.cslg.Online_examination_system.ToolBean.Exam;
import cn.cslg.Online_examination_system.ToolBean.Teacher;
import cn.cslg.Online_examination_system.ToolBean.StudentScore;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-27
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowExamAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ArrayList<Exam> exams = teacher.queryAllExam();
        List<ArrayList<StudentScore>> studentScoreList = new ArrayList<ArrayList<StudentScore>>();
        for(Exam exam : exams) {
            studentScoreList.add(teacher.queryStudentScoreList(exam.examID));
        }
        request.setAttribute("exams", exams);
        request.setAttribute("studentScoreList", studentScoreList);
        return mapping.findForward("examIndex");
    }
}
