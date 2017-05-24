package cn.cslg.Online_examination_system.Action.Teacher.CourseManage;

import cn.cslg.Online_examination_system.ActionForm.Teacher.CourseManage.AddCourseActionForm;
import cn.cslg.Online_examination_system.ToolBean.Teacher;
import cn.cslg.Online_examination_system.ToolBean.Course;

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
public class AddCourseAction extends Action {
    private void prepareBack(HttpServletRequest request, AddCourseActionForm courseActionForm) {
        request.setAttribute("type", courseActionForm.getType());
        request.setAttribute("courseID", courseActionForm.getCourseID());
        request.setAttribute("courseName", courseActionForm.getCourseName());
        request.setAttribute("courseInformation", courseActionForm.getCourseInformation());
    }

    /**
     * Programmar : leafspace
     * Edit time : 2017-5-25
     * function 添加一个课程
     *      1.验证课程名不能为空
     *      2.验证课程名不能有重复
     *      3.调用教师方法添加一个课程
     * */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        AddCourseActionForm addCourseActionForm = (AddCourseActionForm) form;
        ArrayList<Course> courses = teacher.queryAllCourse();

        if(addCourseActionForm.getCourseName().equals("")) {
            request.setAttribute("error", "课程名不能为空");
            this.prepareBack(request, addCourseActionForm);
            return mapping.findForward("error");
        }

        for(Course i : courses) {
            if(i.getCourseName().equals(addCourseActionForm.getCourseName())) {
                request.setAttribute("error", "您已有相同的课程名");
                this.prepareBack(request, addCourseActionForm);
                return mapping.findForward("error");
            }
        }

        String courseName = addCourseActionForm.getCourseName();
        String courseInformation = addCourseActionForm.getCourseInformation();
        int courseID = teacher.addCourse(courseName, courseInformation);
        if(courseID < 0) {
            request.setAttribute("error", "添加课程出现了错误，请重试");
            this.prepareBack(request, addCourseActionForm);
            return mapping.findForward("error");
        }

        return mapping.findForward("courseIndex");
    }
}
