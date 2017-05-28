package cn.cslg.Online_examination_system.Action.Student;

import cn.cslg.Online_examination_system.ToolBean.Exam;
import cn.cslg.Online_examination_system.ToolBean.Student;
import cn.cslg.Online_examination_system.ToolBean.Question;

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
public class SendPaparAction extends Action {
    private boolean checkAnswer(String studentAnswer, String answer) {
        studentAnswer.trim();
        answer.trim();

        if(studentAnswer.equals(answer)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkAnswer(String[] studentAnswer, String answer) {
        if(studentAnswer.length != answer.length()) {
            return false;
        }

        for(int i = 0; i < studentAnswer.length; ++i) {
            if(answer.indexOf(studentAnswer[i]) < 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if(request.getSession().getAttribute("sendPaparToken") != null) {
            return mapping.findForward("examScoreInformation");
        }

        Exam exam = (Exam) request.getSession().getAttribute("exam");
        Student student = (Student) request.getSession().getAttribute("user");
        ArrayList<Question> oneChoicePapar = (ArrayList<Question>) request.getSession().getAttribute("oneChoicePapar");
        ArrayList<Question> moreChoicePapar = (ArrayList<Question>) request.getSession().getAttribute("moreChoicePapar");
        ArrayList<Question> judgePapar = (ArrayList<Question>) request.getSession().getAttribute("judgePapar");

        double studentScore = 0;
        for(Question question : oneChoicePapar) {
            String answer = request.getParameter("oneChoice" + question.getQuestionID());
            if(answer == null) {
                continue;
            }
            if(this.checkAnswer(answer, question.answer)) {
                studentScore += exam.onechoiceScore;
            }
        }

        for(Question question : moreChoicePapar) {
            String[] answer = request.getParameterValues("moreChoice" + question.getQuestionID());
            if(answer == null) {
                continue;
            }
            if(this.checkAnswer(answer, question.answer)) {
                studentScore += exam.morechoiceScore;
            }
        }

        for(Question question : judgePapar) {
            String answer = request.getParameter("judge" + question.getQuestionID());
            if(answer == null) {
                continue;
            }
            if(this.checkAnswer(answer, question.answer)) {
                studentScore += exam.judgeScore;
            }
        }

        student.addScore(exam.examID, studentScore);
        request.getSession().setAttribute("sendPaparToken", true);
        return mapping.findForward("examScoreInformation");
    }
}
