package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage.QuestionManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.QuestionManage.DeleteQuestionActionForm;
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
public class DeleteQuestionAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        DeleteQuestionActionForm deleteQuestionActionForm = (DeleteQuestionActionForm) form;

        int questionID = Integer.parseInt(deleteQuestionActionForm.getQuestionID());
        int questionBankID = teacher.queryQuestionQuestionBankID(questionID);
        teacher.deleteQuestion(questionID);

        QuestionBank questionBank = teacher.queryQuestionBank(questionBankID);
        ArrayList<Question> questions = teacher.queryAllQuestion(questionBankID);
        request.setAttribute("questionBank", questionBank);
        request.setAttribute("questions", questions);

        return mapping.findForward("questionBankInformation");
    }
}
