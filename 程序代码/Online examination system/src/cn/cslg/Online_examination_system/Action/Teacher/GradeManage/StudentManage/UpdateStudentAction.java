package cn.cslg.Online_examination_system.Action.Teacher.GradeManage.StudentManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage.StudentManage.UpdateStudentActionForm;
import cn.cslg.Online_examination_system.ToolBean.Grade;
import cn.cslg.Online_examination_system.ToolBean.Student;
import cn.cslg.Online_examination_system.ToolBean.Teacher;
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
public class UpdateStudentAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        UpdateStudentActionForm updateStudentActionForm = (UpdateStudentActionForm) form;

        int userID = Integer.parseInt(updateStudentActionForm.getUserID());
        String type = updateStudentActionForm.getType();
        String password = updateStudentActionForm.getPassword();

        Student student = teacher.queryStudent(userID);
        int gradeID = student.getGradeID();
        Grade grade = teacher.queryGrade(gradeID);
        ArrayList<Student> students = teacher.queryAllStudent(gradeID);

        request.setAttribute("students", students);
        request.setAttribute("grade", grade);
        request.setAttribute("type", type);

        return mapping.findForward("gradeInformation");
    }
}
