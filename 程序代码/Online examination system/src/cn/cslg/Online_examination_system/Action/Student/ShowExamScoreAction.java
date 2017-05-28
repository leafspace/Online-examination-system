package cn.cslg.Online_examination_system.Action.Student;

import cn.cslg.Online_examination_system.ToolBean.Exam;
import cn.cslg.Online_examination_system.ToolBean.Student;
import cn.cslg.Online_examination_system.ToolBean.StudentScore;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/28.
 * LastEdit: 2017-5-28
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowExamScoreAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Student student = (Student) request.getSession().getAttribute("user");
        ArrayList<Exam> exams = student.queryAllExam();
        ArrayList<Exam> noAttendExams = new ArrayList<>();
        ArrayList<StudentScore> studentScores = new ArrayList<>();

        int isRemoved = 0;
        noAttendExams.addAll(exams);
        for(int i = 0; i < exams.size(); ++i) {
            Exam exam = exams.get(i);
            StudentScore studentScore = student.queryStudentScore(exam.examID);
            if(studentScore != null) {
                studentScores.add(studentScore);
                noAttendExams.remove(i - isRemoved);
                isRemoved++;
            }
        }

        request.setAttribute("exams", exams);
        request.setAttribute("noAttendExams", noAttendExams);
        request.setAttribute("studentScores", studentScores);
        return mapping.findForward("studentInformation");
    }
}
