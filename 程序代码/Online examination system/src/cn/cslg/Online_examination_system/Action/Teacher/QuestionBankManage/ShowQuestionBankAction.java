package cn.cslg.Online_examination_system.Action.Teacher.QuestionBankManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.QuestionBankManage.ShowQuestionBankActionForm;
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
 * LastEdit: 2017-5-24
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowQuestionBankAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ShowQuestionBankActionForm showQuestionBankActionForm = (ShowQuestionBankActionForm) form;

        int courseID;
        String courseIDStr = showQuestionBankActionForm.getCourseID();
        if(courseIDStr == null) {
            courseID = (int) request.getAttribute("courseID");
        } else {
            courseID = Integer.parseInt(courseIDStr);
        }
        ArrayList<QuestionBank> questionBankArrayList = teacher.queryAllQuestionBank(courseID);
        request.setAttribute("questionBanks", questionBankArrayList);
        return mapping.findForward("questionBankIndex");
    }
}
