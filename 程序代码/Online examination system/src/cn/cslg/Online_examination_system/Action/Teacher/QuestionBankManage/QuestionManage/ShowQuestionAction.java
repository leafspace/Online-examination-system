package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage.QuestionManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.QuestionManage.ShowQuestionActionForm;
import cn.cslg.Online_examination_system.ToolBean.Question;
import cn.cslg.Online_examination_system.ToolBean.Teacher;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowQuestionAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ShowQuestionActionForm showQuestionActionForm = (ShowQuestionActionForm) form;

        int questionID = Integer.parseInt(showQuestionActionForm.getQuestionID());
        Question question = teacher.queryQuestion(questionID);
        request.setAttribute("question", question);
        return mapping.findForward("questionInformation");
    }
}
