package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.ShowQuestionBankInformationActionForm;
import cn.cslg.Online_examination_system.ToolBean.QuestionBank;
import cn.cslg.Online_examination_system.ToolBean.Question;
import cn.cslg.Online_examination_system.ToolBean.Teacher;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/24.
 * LastEdit: 2017-5-24
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowQuestionBankInformationAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ShowQuestionBankInformationActionForm showQuestionBankInformationActionForm = (ShowQuestionBankInformationActionForm) form;

        String type = showQuestionBankInformationActionForm.getType();

        if(!type.equals("add")) {
            int questionBankID = Integer.parseInt(showQuestionBankInformationActionForm.getQuestionBankID());
            QuestionBank questionBank = teacher.queryQuestionBank(questionBankID);
            ArrayList<Question> questions = teacher.queryAllQuestion(questionBankID);
            request.setAttribute("questionBank", questionBank);
            request.setAttribute("questions", questions);
        }
        request.setAttribute("type", type);
        switch (type)
        {
            case "show" : return mapping.findForward("questionBankInformation");
            case "edit" : return mapping.findForward("editQuestionBankInformation");
            case "add"  : return mapping.findForward("editQuestionBankInformation");
        }
        return null;
    }
}
