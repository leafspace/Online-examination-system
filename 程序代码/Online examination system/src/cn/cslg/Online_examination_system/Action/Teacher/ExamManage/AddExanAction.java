package cn.cslg.Online_examination_system.Action.Teacher.ExamManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.ExamManage.AddExamActionForm;
import cn.cslg.Online_examination_system.ToolBean.Exam;
import cn.cslg.Online_examination_system.ToolBean.Teacher;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-27
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class AddExanAction extends Action {
    private String formatDate(String examDate, String examTime) {
        String[] str = examDate.split("/");
        String day = str[0];
        String month = str[1];
        String year = str[2];
        String date = day + "-" + month + "-" + day + " " + examTime;
        return date;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        AddExamActionForm addExamActionForm = (AddExamActionForm) form;

        String examName = addExamActionForm.getExamName();
        int questionBankID = Integer.parseInt(addExamActionForm.getQuestionBankID());
        String[] gradeIDs = addExamActionForm.getGradeIDs();
        String examDate = addExamActionForm.getExamDate();
        String examTime = addExamActionForm.getExamTime();
        int examMinutes = Integer.parseInt(addExamActionForm.getExamMinutes());
        int examStratMinutes = Integer.parseInt(addExamActionForm.getExamStratMinutes());
        int oneChoiceNumber = Integer.parseInt(addExamActionForm.getOneChoiceNumber());
        double oneChoiceScore = Double.parseDouble(addExamActionForm.getOneChoiceScore());
        int judgeNumber = Integer.parseInt(addExamActionForm.getJudgeNumber());
        double judgeScore = Double.parseDouble(addExamActionForm.getJudgeScore());
        int moreChoiceNumber = Integer.parseInt(addExamActionForm.getMoreChoiceNumber());
        double moreChoiceScore = Double.parseDouble(addExamActionForm.getMoreChoiceScore());

        for(int i = 0; i < gradeIDs.length; ++i) {
            teacher.addExam(new Exam(Integer.parseInt(gradeIDs[i]), questionBankID, examName,
                    this.formatDate(examDate, examTime), examMinutes, examStratMinutes, judgeNumber,
                    moreChoiceNumber, oneChoiceNumber, judgeScore, moreChoiceScore, oneChoiceScore));
        }

        return mapping.findForward("examIndex");
    }
}
