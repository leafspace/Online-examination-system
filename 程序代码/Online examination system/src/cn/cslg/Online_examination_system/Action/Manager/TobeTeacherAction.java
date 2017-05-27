package cn.cslg.Online_examination_system.Action.Manager;

import cn.cslg.Online_examination_system.ActionForm.Manager.TobeTeacherActionForm;
import cn.cslg.Online_examination_system.ToolBean.Manager;
import cn.cslg.Online_examination_system.ToolBean.Teacher;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/27.
 * LastEdit: 2017-5-27
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class TobeTeacherAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Manager manager = (Manager) request.getSession().getAttribute("user");
        TobeTeacherActionForm tobeTeacherActionForm = (TobeTeacherActionForm) form;
        int userID = Integer.parseInt(tobeTeacherActionForm.getUserID());
        Teacher teacher = manager.queryTeacher(userID);
        request.getSession().setAttribute("user", teacher);
        return mapping.findForward("teacherIndex");
    }
}
