package cn.cslg.Online_examination_system.Action.Teacher.GradeManage.StudentManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage.StudentManage.ShowGradeInformationActionForm;
import cn.cslg.Online_examination_system.ToolBean.Student;
import cn.cslg.Online_examination_system.ToolBean.Teacher;
import cn.cslg.Online_examination_system.ToolBean.Grade;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowGradeInformationAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        ShowGradeInformationActionForm showGradeInformationActionForm = (ShowGradeInformationActionForm) form;

        int gradeID = Integer.parseInt(showGradeInformationActionForm.getGradeID());
        String type = showGradeInformationActionForm.getType();
        Grade grade = teacher.queryGrade(gradeID);
        ArrayList<Student> students = teacher.queryAllStudent(gradeID);

        request.setAttribute("grade", grade);
        request.setAttribute("type", type);
        request.setAttribute("students", students);
        return mapping.findForward("gradeInformation");
    }
}
