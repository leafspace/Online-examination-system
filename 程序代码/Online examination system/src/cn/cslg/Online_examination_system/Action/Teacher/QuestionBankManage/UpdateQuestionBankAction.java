package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.UpdateQuestionBankActionForm;
import cn.cslg.Online_examination_system.ToolBean.Question;
import cn.cslg.Online_examination_system.ToolBean.QuestionBank;
import cn.cslg.Online_examination_system.ToolBean.Teacher;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 * Created by Administrator on 2017/5/24.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UpdateQuestionBankAction extends Action {
    private void prepareBack(HttpServletRequest request, ArrayList<Question> questions, QuestionBank questionBank) {
        request.setAttribute("questions", questions);
        request.setAttribute("questionBank", questionBank);
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        UpdateQuestionBankActionForm updateQuestionBankActionForm = (UpdateQuestionBankActionForm) form;
        int questionBankID = Integer.parseInt(updateQuestionBankActionForm.getQuestionBankID());
        int courseID = teacher.queryQuestionBankCourseID(questionBankID);
        String questionBankName = updateQuestionBankActionForm.getQuestionBankName();
        ArrayList<QuestionBank> questionBanks = teacher.queryAllQuestionBank(courseID);
        if(questionBankName.equals("")) {
            request.setAttribute("error", "课程名不能为空");
            this.prepareBack(request, teacher.queryAllQuestion(questionBankID), teacher.queryQuestionBank(questionBankID));
            return mapping.findForward("error");
        }

        for(QuestionBank questionBank : questionBanks) {
            if(questionBank.getQuestionBankID() == questionBankID) {
                continue;
            }

            if(questionBank.getQuestionBankName().equals(questionBankName)) {
                request.setAttribute("error", "您已有相同名字的题库");
                this.prepareBack(request, teacher.queryAllQuestion(questionBankID), teacher.queryQuestionBank(questionBankID));
                return mapping.findForward("error");
            }
        }

        teacher.updateQuestionBank(new QuestionBank(questionBankID, questionBankName));
        request.setAttribute("courseID", courseID);
        return mapping.findForward("questionBankIndex");
    }
}
