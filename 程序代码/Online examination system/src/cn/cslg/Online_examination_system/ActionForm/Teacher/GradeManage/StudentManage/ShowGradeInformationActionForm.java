package cn.cslg.Online_examination_system.ActionForm.Teacher.GradeManage.StudentManage;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/26.
 * LastEdit: 2017-5-26
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class ShowGradeInformationActionForm extends ActionForm {
    private String gradeID;
    private String type;

    public String getGradeID() {
        return gradeID;
    }

    public String getType() {
        return type;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }
}
