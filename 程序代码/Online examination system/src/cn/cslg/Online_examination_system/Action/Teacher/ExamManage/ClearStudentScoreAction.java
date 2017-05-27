package cn.cslg.Online_examination_system.Action.Teacher.ExamManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.ExamManage.ClearStudentScoreActionForm;
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
public class ClearStudentScoreAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ClearStudentScoreActionForm clearStudentScoreActionForm = (ClearStudentScoreActionForm) form;

        int examID = Integer.parseInt(clearStudentScoreActionForm.getExamID());
        int userID = Integer.parseInt(clearStudentScoreActionForm.getUserID());
        teacher.clearStudentScore(examID, userID);
        return mapping.findForward("examIndex");
    }
}
