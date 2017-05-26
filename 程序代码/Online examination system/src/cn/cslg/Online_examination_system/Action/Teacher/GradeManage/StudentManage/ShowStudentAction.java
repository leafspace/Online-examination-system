package cn.cslg.Online_examination_system.Action.Teacher.GradeManage.StudentManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage.StudentManage.ShowStudentActionForm;
import cn.cslg.Online_examination_system.ToolBean.Student;
import cn.cslg.Online_examination_system.ToolBean.Teacher;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowStudentAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ShowStudentActionForm showStudentActionForm = (ShowStudentActionForm) form;

        int userID = Integer.parseInt(showStudentActionForm.getUserID());
        Student student = teacher.queryStudent(userID);
        String type = showStudentActionForm.getType();

        request.setAttribute("student", student);
        request.setAttribute("type", type);
        return mapping.findForward("studentInformation");
    }
}
