package cn.cslg.Online_examination_system.ActionForm.Teacher.CourseManage;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/24.
 * LastEdit: 2017-5-24
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class UpdateCourseActionForm extends ActionForm {
    private String type;
    private String courseID;
    private String courseName;
    private String courseInformation;

    public String getType() {
        return this.type;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCourseInformation() {
        return this.courseInformation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseInformation(String courseInformation) {
        this.courseInformation = courseInformation;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        if(this.courseName == null) {
            this.courseName = "";
        }

        if(this.courseInformation == null) {
            this.courseInformation = "";
        }

        this.courseName.trim();
        this.courseInformation.trim();
        return null;
    }
}
