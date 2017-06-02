package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage.QuestionManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.QuestionManage.UpdateQuestionActionForm;
import cn.cslg.Online_examination_system.ToolBean.QuestionBank;
import cn.cslg.Online_examination_system.ToolBean.Question;
import cn.cslg.Online_examination_system.ToolBean.Teacher;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UpdateQuestionAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        UpdateQuestionActionForm updateQuestionActionForm = (UpdateQuestionActionForm) form;

        int questionID = Integer.parseInt(updateQuestionActionForm.getQuestionID());
        String questionStr = updateQuestionActionForm.getQuestion();
        String questionType = updateQuestionActionForm.getQuestionType();
        String A = request.getParameter("choiceA");
        String B = request.getParameter("choiceB");
        String C = request.getParameter("choiceC");
        String D = request.getParameter("choiceD");
        String E = request.getParameter("choiceE");
        String answer = updateQuestionActionForm.getAnswer();

        Question question = new Question(questionID, questionType, questionStr, A, B, C, D, E, answer);
        teacher.updateQuestion(question);

        int questionBankID = teacher.queryQuestionQuestionBankID(questionID);
        QuestionBank questionBank = teacher.queryQuestionBank(questionBankID);
        ArrayList<Question> questions = teacher.queryAllQuestion(questionBankID);

        request.setAttribute("type", "edit");
        request.setAttribute("questions", questions);
        request.setAttribute("questionBank", questionBank);
        return mapping.findForward("questionBankInformation");
    }
}
